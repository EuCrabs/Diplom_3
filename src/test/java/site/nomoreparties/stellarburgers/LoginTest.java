package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.users.UserConfiguration;
import site.nomoreparties.stellarburgers.constants.Browser;
import site.nomoreparties.stellarburgers.page_objects.*;
import site.nomoreparties.stellarburgers.pojos.SignInRequest;
import site.nomoreparties.stellarburgers.pojos.SuccessSignInSignUpResponse;
import site.nomoreparties.stellarburgers.pojos.UserRequest;
import site.nomoreparties.stellarburgers.utils.ConfigFileReader;
import site.nomoreparties.stellarburgers.utils.DriverInitializer;
import site.nomoreparties.stellarburgers.utils.UsersUtils;

import java.time.Duration;

@RunWith(Parameterized.class)
public class LoginTest {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    Browser browserEnum;
    ConfigFileReader configFileReader = new ConfigFileReader();

    UserRequest testUser;
    String accessToken;
    SignInRequest signInRequest;

    public LoginTest(Browser browserEnum) {
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
        testUser = UsersUtils.getUniqueUser();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        SuccessSignInSignUpResponse signUpResponse = UserConfiguration.createUniqueUser(testUser)
                .then()
                .statusCode(200)
                .extract()
                .as(SuccessSignInSignUpResponse.class);
        accessToken = signUpResponse.getAccessToken();

        signInRequest = new SignInRequest(testUser.getEmail(), testUser.getPassword());

        this.driver = DriverInitializer.getDriver(browserEnum);

        driver.get(configFileReader.getApplicationUrl());
        this.mainPage = new MainPage(driver);
        this.loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }


    @After
    public void closeDriver() {
        driver.quit();
        UserConfiguration.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void signInWithValidDataWithSignInButtonSuccess() {
        mainPage.clickSignInButton();
        loginPage.loginWithCredentials(signInRequest);
        mainPage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);

        boolean displayed = accountPage.getProfileButton().isDisplayed();
        Assert.assertTrue("Вход в личный кабинет не был выполнен", displayed);
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void signInWithValidDataWithAccountButtonSuccess() {
        mainPage.clickAccountButton();
        loginPage.loginWithCredentials(signInRequest);
        mainPage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);

        boolean displayed = accountPage.getProfileButton().isDisplayed();
        Assert.assertTrue("Вход в личный кабинет не был выполнен", displayed);
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void signInWithValidDataFromSignUpFormSuccess() {
        mainPage.clickSignInButton();
        loginPage.clickSignUpButton();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickSignInButton();
        loginPage.loginWithCredentials(signInRequest);
        mainPage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);

        boolean displayed = accountPage.getProfileButton().isDisplayed();
        Assert.assertTrue("Вход в личный кабинет не был выполнен", displayed);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void signInWithValidDataFromPasswordRecoverFormSuccess() {
        mainPage.clickSignInButton();
        loginPage.clickRecoverPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickSignInButton();
        loginPage.loginWithCredentials(signInRequest);
        mainPage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);

        boolean displayed = accountPage.getProfileButton().isDisplayed();
        Assert.assertTrue("Вход в личный кабинет не был выполнен", displayed);
    }
}