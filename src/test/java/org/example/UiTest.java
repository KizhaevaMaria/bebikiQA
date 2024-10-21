package org.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.BeforeClass;
import org.junit.Test;
import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.element;

public class UiTest {
    @BeforeClass
    public static void setupUiTests(){
        Configuration.baseUrl = "https://parabank.parasoft.com";
    }
    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly (){
        //Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();
        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address("")
                .city("")
                .state("")
                .zipCode("")
                .ssn("")
                .phoneNumber("")
                .username("")
                .password("")
                .repeatedPassword("")
                .build();

        //Шаги теста
        registerAccountPage.register(bankAccount);

        //Проверка ожидаемого результата
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userCanNotCreateAccountWithoutNameandSurname (){
        //Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Генерация случайного пароля
        String randomPassword = RandomData.randomPassword();
        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName("")
                .lastName("")
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomZipCode())
                .ssn(RandomData.randomSSN())
                .phoneNumber(RandomData.randomPhoneNumber())
                .username(RandomData.randomUsername())
                .password(randomPassword)
                .repeatedPassword(randomPassword)
                .build();

        //Шаги теста
        registerAccountPage.register(bankAccount);

        //Проверка ожидаемого результата
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
    }
    @Test
    public void userShouldBeAbleToCreateAccountWithAllValidData (){
        //Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Генерация случайного пароля
        String randomPassword = RandomData.randomPassword();
        String username = RandomData.randomUsername();
        //Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomZipCode())
                .ssn(RandomData.randomSSN())
                .phoneNumber(RandomData.randomPhoneNumber())
                .username(username)
                .password(randomPassword)
                .repeatedPassword(randomPassword)
                .build();

        //Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getWelcomeMessage().shouldHave(Condition.exactText("Welcome " + username));
        registerAccountPage.getMessageSuccess().shouldHave(Condition
                .exactText("Your account was created successfully. You are now logged in."));
    }
}
