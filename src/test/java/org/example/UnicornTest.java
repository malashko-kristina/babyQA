package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnicornTest {

    @BeforeAll
    public static void setupTest() {
        RestAssured.baseURI = "https://crudcrud.com/api/6168e64dfc494752b0341d244f558c7f";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {

        // Step 1. Create a unicorn
        // сериализация из JSON в объект и наоборот
        Unicorn unicorn1 = Unicorn.builder().name("Lola").colour("pink").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn1);
        String unicornId = createdUnicorn.getId();

        // Step 2. Check if the unicorn was created
        System.out.println(unicornId);
        UnicornRequests.getCreatedUnicorn(unicornId);
    }
    @Test
    public void userShouldBeAbleToChangeUnicornTailColour () {

        // Step 1. Create a unicorn
        Unicorn unicorn1 = Unicorn.builder().name("Lola").colour("pink").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn1);
        String unicornId = createdUnicorn.getId();

        // Step 2. Check if the unicorn was created
        UnicornRequests.getCreatedUnicorn(unicornId);

        // Step 3. Change unicorn tail's colour
        Unicorn unicorn2 = Unicorn.builder().name("Lola").colour("blue").build();
        UnicornRequests.updateCreatedUnicorn(unicorn2, unicornId);

        // Step 4. Check the tail's colour was changed
        String actualColour = UnicornRequests.getCreatedUnicornColour(unicornId);
        assertEquals("blue", actualColour);
    }
    @Test
    public void userShouldBeAbleToDeleteUnicorn () {
        // Step 1. Create a unicorn
        Unicorn unicorn1 = Unicorn.builder().name("Lola").colour("pink").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn1);
        String unicornId = createdUnicorn.getId();

        // Step 2. Check if the unicorn was created
        UnicornRequests.getCreatedUnicorn(unicornId);

        // Step 3. Delete unicorn
        UnicornRequests.deleteCreatedUnicorn(unicornId);

        // Step 4. Check if the unicorn was deleted
        UnicornRequests.checkAfterDeletionUnicorn(unicornId);
    }
}
