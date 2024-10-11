package org.example.api;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {
    public static String createStudent(String body) {
        return given()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .post(RestAssured.baseURI + "/student")
                .then()
                        .assertThat().statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("_id"))
                        .extract().body().asString();  // Если нужно вернуть ответ как строку
    }

    public static void deleteStudent(String id) {
        given()
                        .delete("/student/" + id)
                .then()
                        .assertThat()
                        .statusCode(HttpStatus.SC_OK);
    }
}

