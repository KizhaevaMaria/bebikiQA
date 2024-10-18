package org.example.api;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class CheckUnicorn {
    public static void checkUnicornOk(String id){
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void checkUnicornNotFound(String id){
        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
