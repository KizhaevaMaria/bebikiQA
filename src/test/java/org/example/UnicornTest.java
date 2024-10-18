package org.example;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.CheckUnicorn;
import org.example.api.UnicornRequests;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class UnicornTest {
    @BeforeClass
    public static void setupTest(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/7f7441bfa3b64c5cb3213209aad04eed";
    }

    //создание единорога
    @Test
    public void userShouldBeAbleCreateUnicorn (){

        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Клевый Единорог\",\n" +
                "  \"tail\": \"Розовый\"\n" +
                "}");

        CheckUnicorn.checkUnicornOk(id);
    }

    //удаление единорога
    @Test
    public void userShouldBeAbleDeleteExistingUnicorn(){

        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Супер-пупер Единорог\",\n" +
                "  \"tail\": \"Сиреневый\"\n" +
                "}");

        UnicornRequests.deleteUnicorn(id);

        CheckUnicorn.checkUnicornNotFound(id);
    }

    //изменение цвета хвоста единорога
    @Test
    public void userShouldBeAbleUpdateTailColor(){
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Единорог\",\n" +
                "  \"tail\": \"Белый\"\n" +
                "}");

        UnicornRequests.updateUnicorn(id,"{\n" +
                "  \"name\": \"Единорог\",\n" +
                "  \"tail\": \"Золотой\"\n" +
                "}");

        CheckUnicorn.checkUnicornOk(id);
    }
}
