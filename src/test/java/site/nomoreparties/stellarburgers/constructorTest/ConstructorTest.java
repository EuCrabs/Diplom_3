package site.nomoreparties.stellarburgers.constructorTest;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pages.HomePage;

import static org.junit.Assert.assertEquals;

public class ConstructorTest extends ConstructorBaseClass{
    HomePage homePage = new HomePage(driver);

    @Test
    @DisplayName("Проверка активности вкладки Булочка по умолчанию")
    public void bunsTest() {
        assertEquals(testData.getBUNS(), homePage.getCurrentConstructorGroupText());
    }

    @Test
    @DisplayName("Проверка активности вкладки Соус после нажатия")
    public void souseTest() {
        assertEquals(testData.getSOUSE(), homePage.clickSouseLink().getCurrentConstructorGroupText());
    }

    @Test
    @DisplayName("Проверка активности вкладки Начинка после нажатия")
    public void fillingTest() {
        assertEquals(testData.getFILLING(), homePage.clickFillingLink().getCurrentConstructorGroupText());
    }
}
