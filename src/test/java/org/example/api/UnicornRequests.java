package org.example.api;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.http.HttpStatus;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static String createUnicorn(String body) {
        return RestAssured
                .given()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .post(RestAssured.baseURI + "/unicorn")
                .then()
                        .assertThat().statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("_id")) // Проверяем наличие поля _id
                        .extract().jsonPath().getString("_id"); // Извлекаем значение поля _id
    }
    public static void getCreatedUnicorn(String unicornId) {
        RestAssured
                .given()
                        .header("Content-Type", "application/json")
                .when()
                        .get("/unicorn/" + unicornId)
                .then()
                        .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public static String getCreatedUnicornColour(String unicornId) {
        return RestAssured
                .given()
                        .header("Content-Type", "application/json")
                .when()
                        .get("/unicorn/" + unicornId)
                .then()
                        .assertThat().statusCode(HttpStatus.SC_OK)
                        .body("$", hasKey("colour")) // Проверка наличия поля colour
                        .extract().jsonPath().getString("colour");
            }

    public static void deleteCreatedUnicorn(String unicornId) {
        RestAssured
                .given()
                        .header("Content-Type", "application/json")
                .when()
                        .delete(RestAssured.baseURI + "/unicorn/" + unicornId)
                .then()
                        .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public static void updateCreatedUnicorn(String body, String unicornId) {
        RestAssured
                .given()
                        .header("Content-Type", "application/json")
                        .body(body)
                .when()
                        .put("/unicorn/" + unicornId)
                .then()
                        .assertThat().statusCode(HttpStatus.SC_OK);
    }

    public static void checkAfterDeletionUnicorn(String unicornId) {
        RestAssured
                .given()
                        .header("Content-Type", "application/json")
                .when()
                        .get(RestAssured.baseURI + "/unicorn/" + unicornId)
                .then()
                        .assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }
}