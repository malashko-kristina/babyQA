package org.example.api;

import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.example.api.models.Unicorn;
import org.example.api.utilis.JsonMapper;

import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static Unicorn createUnicorn(Unicorn unicorn) {

        String unicornJson = JsonMapper.toJson(unicorn);
        return RestAssured
                .given()
                        .header("Content-Type", "application/json")
                        .body(unicornJson)
                .when()
                        .post(RestAssured.baseURI + "/unicorn")
                .then()
                        .assertThat().statusCode(HttpStatus.SC_CREATED)
                        .body("$", hasKey("_id")) // Проверяем наличие поля _id
                        .extract().as(Unicorn.class, ObjectMapperType.GSON);
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

    public static void updateCreatedUnicorn(Unicorn unicorn, String unicornId) {
        String unicornJson = JsonMapper.toJson(unicorn);
        RestAssured
                .given()
                        .header("Content-Type", "application/json")
                        .body(unicornJson)
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