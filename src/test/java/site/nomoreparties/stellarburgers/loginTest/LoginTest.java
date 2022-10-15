package site.nomoreparties.stellarburgers.loginTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends LoginBaseClass {

    @Test
    @DisplayName("Логин пользователя с главной страницы")
    public void loginFromMainPage() {
        HomePage homePage = new HomePage(driver);

        String name = homePage.clickEnterButton()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();

        assertEquals(testData.getNAME_REAL(), name);
    }

    @Test
    @DisplayName("Логин пользователя со страницы личного кабинета")
    public void loginFromAccountPage() {
        HomePage homePage = new HomePage(driver);

        String name = homePage.clickAccountLink()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();

        assertEquals(testData.getNAME_REAL(), name);
    }

    @Test
    @DisplayName("Логин пользователя со страницы регистрации")
    public void loginFromRegistrationPage() {
        HomePage homePage = new HomePage(driver);

        String name = homePage.clickAccountLink()
                .registerLinkClick()
                .clickLoginButton()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();

        assertEquals(testData.getNAME_REAL(), name);
    }

    @Test
    @DisplayName("Логин пользователя со страницы восстановления пароля")
    public void loginFromRecoverPasswordPage() {
        HomePage homePage = new HomePage(driver);

        String name = homePage.clickAccountLink()
                .recoverPasswordLinkClick()
                .enterLinkClick()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick()
                .clickAccountLinkAfterLogin()
                .getNameValue();

        assertEquals(testData.getNAME_REAL(), name);
    }

}
