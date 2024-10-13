package org.example.api;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.example.api.models.Student;
import org.example.api.utilis.JsonMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {

    public static Student createStudent(Student student) {

        String studentJson = JsonMapper.toJson(student);
        return given()
                        .header("Content-Type", "application/json")
                        .body(studentJson)
                .when()
                        .post(RestAssured.baseURI + "/student")
                .then()
                        .assertThat().statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("_id"))
                        .extract().as(Student.class, ObjectMapperType.GSON);  // Если нужно вернуть ответ как строку
    }

    public static void deleteStudent(String id) {
        given()
                        .delete("/student/" + id)
                .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK);
    }
}

