package site.nomoreparties.stellarburgers.accountTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountTest extends AccountBaseClass {
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Проверка отображения личного кабинета, если пользователь залогинен")
    public void checkAccountIsDisplayedTest() {
        assertTrue(homePage.clickAccountLinkAfterLogin()
                .profileLinkIsDisplayed());
    }

    @Test
    @DisplayName("Проверка отображения правильного имени в личном кабинете")
    public void checkNameMatchesRealNameTest() {
        String name = homePage.clickAccountLinkAfterLogin()
                .getNameValue();

        assertEquals(testData.getNAME_REAL(), name);
    }

    @Test
    @DisplayName("Проверка отображения правильного емейла в личном кабинете")
    public void checkEmailMatchesRealEmailTest() {
        String email = homePage.clickAccountLinkAfterLogin()
                .getEmailValue();

        assertEquals(testData.getEMAIL_REAL(), email);
    }
}
