package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[text()='Зарегистрироваться']")
    private WebElement registerLink;
    @FindBy(xpath = ".//h2[text()='Вход']")
    private WebElement enterHeading;
    @FindBy(xpath = ".//label[text()='Email']//following-sibling::input")
    private WebElement emailInput;
    @FindBy(xpath = ".//label[text()='Пароль']//following-sibling::input")
    private WebElement passwordInput;
    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement enterButton;
    @FindBy(xpath = ".//a[text()='Восстановить пароль']")
    private WebElement recoverPasswordLink;


    @Step("Зарегистрироваться")
    public RegisterPage registerLinkClick() {
        registerLink.click();
        return new RegisterPage(driver);
    }

    @Step("Кнопка Вход отображается на экране")
    public boolean enterHeadingIsVisible() {
        return enterHeading.isDisplayed();
    }

    @Step("Поле email")
    public LoginPage inputEmail(String text) {
        emailInput.sendKeys(text);
        return this;
    }

    @Step("Поле password")
    public LoginPage inputPassword(String text) {
        passwordInput.sendKeys(text);
        return this;
    }

    @Step("Вход клик по кнопке")
    public HomePage enterButtonClick() {
        enterButton.click();
        return new HomePage(driver).placeOrderButtonIsDisplayed();
    }

    @Step("Кнопка Войти отображается на экране")
    public boolean enterButtonIsVisible() {
        enterButton.click();
        return enterButton.isDisplayed();
    }

    @Step("Восстановить пароль отображается")
    public ForgotPasswordPage recoverPasswordLinkClick() {
        recoverPasswordLink.click();
        return new ForgotPasswordPage(driver);
    }
}
