package site.nomoreparties.stellarburgers.exitAccountTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class ExitAccountTest extends ExitAccountBaseClass {
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Проверка корректного выхода из аккаунта")
    public void exitAccountTest() {
        assertTrue(homePage.clickAccountLinkAfterLogin()
                .exitButtonClick()
                .enterButtonIsVisible());
    }
}
