package org.example;

import io.restassured.parsing.Parser;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnicornTest {

    @BeforeAll
    public static void setupTest() {
        RestAssured.baseURI = "https://crudcrud.com/api/809e8a1358be439abdffffaab60e34ef";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {

        // Step 1. Create a unicorn
        String unicornId = UnicornRequests.createUnicorn("{\n" +
                "  \"name\":  \"Martha\",\n" +
                "  \"colour\": \"pink\"\n" +
                "}");

        // Step 2. Check if the unicorn was created
        System.out.println(unicornId);
        UnicornRequests.getCreatedUnicorn(unicornId);
    }
    @Test
    public void userShouldBeAbleToChangeUnicornTailColour () {


        // Step 1. Create a unicorn
        String unicornId = UnicornRequests.createUnicorn("{\n" +
                "  \"name\":  \"Martha\",\n" +
                "  \"colour\": \"pink\"\n" +
                "}");

        // Step 2. Check if the unicorn was created
        UnicornRequests.getCreatedUnicorn(unicornId);

        // Step 3. Change unicorn tail's colour
        UnicornRequests.updateCreatedUnicorn("{\n" +
                "  \"name\":  \"Martha\",\n" +
                "  \"colour\": \"blue\"\n" +
                "}",unicornId);

        // Step 4. Check the tail's colour was changed
        String actualColour = UnicornRequests.getCreatedUnicornColour(unicornId);
        assertEquals("blue", actualColour);
    }
    @Test
    public void userShouldBeAbleToDeleteUnicorn () {
        // Step 1. Create a unicorn
        String unicornId = UnicornRequests.createUnicorn("{\n" +
                "  \"name\":  \"Martha\",\n" +
                "  \"colour\": \"pink\"\n" +
                "}");

        // Step 2. Check if the unicorn was created
        UnicornRequests.getCreatedUnicorn(unicornId);

        // Step 3. Delete unicorn
        UnicornRequests.deleteCreatedUnicorn(unicornId);

        // Step 4. Check if the unicorn was deleted
        UnicornRequests.checkAfterDeletionUnicorn(unicornId);
    }
}
