package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.users.UserConfiguration;
import site.nomoreparties.stellarburgers.constants.Browser;
import site.nomoreparties.stellarburgers.page_objects.AccountPage;
import site.nomoreparties.stellarburgers.page_objects.LoginPage;
import site.nomoreparties.stellarburgers.page_objects.MainPage;
import site.nomoreparties.stellarburgers.pojos.SignInRequest;
import site.nomoreparties.stellarburgers.pojos.SuccessSignInSignUpResponse;
import site.nomoreparties.stellarburgers.pojos.UserRequest;
import site.nomoreparties.stellarburgers.utils.ConfigFileReader;
import site.nomoreparties.stellarburgers.utils.DriverInitializer;
import site.nomoreparties.stellarburgers.utils.UsersUtils;

import java.time.Duration;

@RunWith(Parameterized.class)
public class GoToAccountTest {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    AccountPage accountPage;
    Browser browserEnum;
    ConfigFileReader configFileReader = new ConfigFileReader();

    public GoToAccountTest(Browser browserEnum) {
        this.browserEnum = browserEnum;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {Browser.CHROME},
                {Browser.YANDEX}
        };
    }

    @Before
    public void init() {
        driver = DriverInitializer.getDriver(browserEnum);
        driver.get(configFileReader.getApplicationUrl());
        mainPage = new MainPage(driver);
        accountPage = new AccountPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void shutdown() {
        driver.quit();
    }

    @Test
    @DisplayName("Успешный переход по клику на «Личный кабинет»")
    public void goToAccountWithAccountButtonSuccess() {
        UserRequest user = UsersUtils.getUniqueUser();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        String accessToken = UserConfiguration.createUniqueUser(user)
                .then()
                .statusCode(200)
                .extract()
                .as(SuccessSignInSignUpResponse.class)
                .getAccessToken();

        mainPage.clickAccountButton();
        loginPage.loginWithCredentials(new SignInRequest(user.getEmail(), user.getPassword()));
        mainPage.clickAccountButton();

        boolean displayed = accountPage.getProfileButton().isDisplayed();
        Assert.assertTrue("Личный кабинет не был открыт", displayed);

        UserConfiguration.deleteUser(accessToken);
    }
}