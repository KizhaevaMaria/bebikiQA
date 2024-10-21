package org.example.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
    //поля
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));
    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));
    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));
    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));
    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));
    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));
    private SelenideElement phoneNumberInput = element(Selectors.byId("customer.phoneNumber"));
    private SelenideElement usernameInput = element(Selectors.byId("customer.username"));
    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));
    private SelenideElement repeatedPasswordInput = element(Selectors.byId("repeatedPassword"));

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    //поля ошибок
    private SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));
    private SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));
    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
    private SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
    private SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
    private SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
    private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
    private SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
    private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
    private SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));

    private SelenideElement welcomeMessage = element(Selectors.byXpath("//div[@id='rightPanel']//h1[@class='title']"));

    private SelenideElement messageSuccess = element(Selectors.byXpath("//div[@id='rightPanel']//p"));

    public void open(){
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount){
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        addressInput.sendKeys(bankAccount.getAddress());
        cityInput.sendKeys(bankAccount.getCity());
        stateInput.sendKeys(bankAccount.getState());
        zipCodeInput.sendKeys(bankAccount.getZipCode());
        ssnInput.sendKeys(bankAccount.getSsn());
        phoneNumberInput.sendKeys(bankAccount.getSsn());
        usernameInput.sendKeys(bankAccount.getUsername());
        passwordInput.sendKeys(bankAccount.getPassword());
        repeatedPasswordInput.sendKeys(bankAccount.getRepeatedPassword());


        registerButton.click();
    }
}
