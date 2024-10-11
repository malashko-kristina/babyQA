package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/00ef3def9b7a4acca3b358a93c028fa3";
    }

    @Test
    public void userShouldBeAbleToCreateStudent() {
        // given - when - then BDD
        StudentRequests.createStudent("{\n" + "  \"name\": \"Alex Pshe\",\n" + "  \"grade\": 11\n" + "}");
    }

    @Test
    public void userShouldBeAbleToDeleteExistingStudent() {

        // принципы разработки api-тестов:
        // 1. АТОМАРНОСТЬ (проверяет 1 штуку);
        // 2. ТЕСТ САМ СЕБЕ ГОТОВИТ ДАННЫЕ
        // 3. FAIL FIRST

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        // ШАГ 1: СОЗДАНИЕ СТУДЕНТА
        String id = StudentRequests.createStudent("{\n" + "  \"name\": \"Alex Pshe\",\n" + "  \"grade\": 11\n" + "}");


        // ШАГ 2: УДАЛЕНИЕ СТУДЕНТА
        StudentRequests.deleteStudent(id);

        // ШАГ 3: ПРОВЕРИТЬ, ЧТО СТУДЕНТ БОЛЬШЕ НЕДОСТУПЕН
        given()
                .get("/student" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}

