package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.example.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/00ef3def9b7a4acca3b358a93c028fa3";
    }

    @Test
    public void userShouldBeAbleToCreateStudent() {
        // given - when - then BDD

        // сериализация из JSON в объект и наоборот
        Student student1 = Student.builder()
                        .name("Helen Carter")
                                .grade(8).build();

        StudentRequests.createStudent(student1);
    }

    @Test
    public void userShouldBeAbleToDeleteExistingStudent() {

        // принципы разработки api-тестов:
        // 1. АТОМАРНОСТЬ (проверяет 1 штуку);
        // 2. ТЕСТ САМ СЕБЕ ГОТОВИТ ДАННЫЕ
        // 3. FAIL FIRST

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        // ШАГ 1: СОЗДАНИЕ СТУДЕНТА
        Student student2 = Student.builder().name("Lola Pomidoro").grade(11).build();
        Student createdStudent = StudentRequests.createStudent(student2);


        // ШАГ 2: УДАЛЕНИЕ СТУДЕНТА
        StudentRequests.deleteStudent(createdStudent.getId());

        // ШАГ 3: ПРОВЕРИТЬ, ЧТО СТУДЕНТ БОЛЬШЕ НЕДОСТУПЕН
        given()
                .get("/student" + createdStudent.getId())
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}

