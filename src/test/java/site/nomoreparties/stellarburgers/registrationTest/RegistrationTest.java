package site.nomoreparties.stellarburgers.registrationTest;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class RegistrationTest extends RegistrationBaseClass {
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Успешная регистрация")
    public void successfulRegistrationTest() {
        assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(testData.generateRandomLengthString(10))
                .inputEmail(testData.getEMAIL_FAKE())
                .inputPassword(testData.getPASSWORD_FAKE())
                .registerButtonClickSuccess()
                .enterHeadingIsVisible());
    }

    @Test
    @DisplayName("Пароль 5 символов")
    public void unsuccessfulRegistrationTestPasswordFiveSymbols() {
        assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(testData.generateRandomLengthString(10))
                .inputEmail(testData.getEMAIL_FAKE())
                .inputPassword(testData.generateRandomLengthString(5))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }

    @Test
    @Description("Пароль 1 символ")
    public void unsuccessfulRegistrationTestPasswordOneSymbol() {
        assertTrue(homePage.clickAccountLink()
                .registerLinkClick()
                .inputName(testData.generateRandomLengthString(10))
                .inputEmail(testData.getEMAIL_FAKE())
                .inputPassword(testData.generateRandomLengthString(1))
                .registerButtonClickFailure()
                .passwordErrorIsVisible());
    }
}
