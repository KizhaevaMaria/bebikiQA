package org.example;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.example.api.CheckUnicorn;
import org.example.api.UnicornRequests;
import org.example.api.models.Unicorn;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class UnicornTest {
    @BeforeClass
    public static void setupTest(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/025898e300164193942cd04b0495d3a6";
    }

    //создание единорога
    @Test
    public void userShouldBeAbleCreateUnicorn (){

        Unicorn unicorn = Unicorn.builder().name("Единорог1").tail("Розовый").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        CheckUnicorn.checkUnicornOk(createdUnicorn.getId());
    }

    //удаление единорога
    @Test
    public void userShouldBeAbleDeleteExistingUnicorn(){

        Unicorn unicorn = Unicorn.builder()
                .name("Единорог2")
                .tail("Белый").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        UnicornRequests.deleteUnicorn(createdUnicorn.getId());

        CheckUnicorn.checkUnicornNotFound(createdUnicorn.getId());
    }

    //изменение цвета хвоста единорога
    @Test
    public void userShouldBeAbleUpdateTailColor(){
        Unicorn unicorn = Unicorn.builder()
                .name("Единорог3")
                .tail("Красный").build();
        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        //обновление цвета хвоста единорога
        UnicornRequests.updateTailColorUnicorn(createdUnicorn,"Зеленый");

        CheckUnicorn.checkUnicornOk(createdUnicorn.getId());
    }
}
