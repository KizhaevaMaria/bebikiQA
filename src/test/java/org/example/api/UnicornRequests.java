package org.example.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {
    public static String createUnicorn(String unicorn){
        return given()
                .body(unicorn)
                .contentType(ContentType.JSON)
        .when()
                .post("/unicorn")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
        .extract()
                .path("_id");
    }

    public static void deleteUnicorn(String id){
        given().delete("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void updateUnicorn(String id, String unicorn){
        given()
                .body(unicorn)
                .contentType(ContentType.JSON)
        .when()
                .put("/unicorn/" + id)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
