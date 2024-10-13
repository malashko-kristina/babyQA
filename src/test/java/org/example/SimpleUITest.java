package org.example;

import com.codeborne.selenide.*;
import org.example.api.utilis.RandomData;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class SimpleUITest {
    @BeforeAll
    public static void setupUITest() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        // Configuration.browser = "firefox";
        // Configuration.timeout = 10; // неявное ожидание, по умолчанию 4 секунды
    }

    // ПРИНЦИПЫ
    // DRY == Don't repeat yourself
    // Веб-элементы НЕ ИЩУТСЯ в тесте, они ищутся в PAGE OBJECT классе
    // АВТОТЕСТ САМ СОЗДАЕТ РАНДОМИЗИРОВАННЫЕ ДАННЫЕ
    @Test
    public void userShouldNotBeAbleToCreateAccountWithNameAndSurnameOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getPasswordConfirmationError().shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithAddressOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .address(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getPasswordConfirmationError()
                .shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithCityOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .city(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getPasswordConfirmationError()
                .shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithStateOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .state(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getPasswordConfirmationError()
                .shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithZipCodeOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .zipCode(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getPasswordConfirmationError()
                .shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithSSNOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .ssn(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getPasswordConfirmationError()
                .shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithUserNameOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .username(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));

        registerAccountPage.getPasswordConfirmationError()
                .shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithPasswordOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .password(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordConfirmationError()
                .shouldHave(Condition.exactText("Password confirmation is required."));
    }

    @Test
    public void userShouldNotBeAbleToCreateAccountWithPasswordConfirmOnly () {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        BankAccount bankAccount = BankAccount.builder()
                .passwordConfirmation(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));

        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));

        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));

        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));

        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));

        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
    }

    @Test
    public void userShouldBeAbleToCreateAccountWithAllValidData() {
        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных
        String password = RandomData.randomString();
        String username = RandomData.randomString();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomString())
                .ssn(RandomData.randomString())
                .username(username)
                .password(password)
                .passwordConfirmation(password)
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата
        registerAccountPage.getWelcomeMessage().shouldHave(Condition.exactText("Welcome " + username));

        registerAccountPage.getMessageSuccess().shouldHave(Condition
                .exactText("Your account was created successfully. You are now logged in."));
    }
}
