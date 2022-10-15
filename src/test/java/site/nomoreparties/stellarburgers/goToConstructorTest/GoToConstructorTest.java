package site.nomoreparties.stellarburgers.goToConstructorTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertTrue;

public class GoToConstructorTest extends goToConstructorBaseClass {
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Проверка ссылки Конструктор")
    public void constructorLinkClickTest() {
        assertTrue(homePage.clickAccountLinkAfterLogin()
                .constructorLinkClick()
                .constructorHeaderIsVisible());
    }

    @Test
    @DisplayName("После клика по лого попадаем на страницу бургера")
    public void mainLogoLinkClickTest() {
        assertTrue(homePage.clickAccountLinkAfterLogin()
                .mainLogoClick()
                .constructorHeaderIsVisible());
    }
}
