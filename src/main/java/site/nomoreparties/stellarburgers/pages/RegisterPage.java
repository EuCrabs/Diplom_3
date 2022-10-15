package site.nomoreparties.stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = ".//label[text()='Имя']//following-sibling::input")
    private WebElement nameInput;
    @FindBy(xpath = ".//label[text()='Email']//following-sibling::input")
    private WebElement emailInput;
    @FindBy(xpath = ".//label[text()='Пароль']//following-sibling::input")
    private WebElement passwordInput;
    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement registerButton;
    @FindBy(xpath = ".//a[text()='Войти']")
    private WebElement loginButton;
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement incorrectPasswordErrorText;

    @Step("Имя")
    public RegisterPage inputName(String text) {
        nameInput.sendKeys(text);
        return this;
    }

    @Step("Email")
    public RegisterPage inputEmail(String text) {
        emailInput.sendKeys(text);
        return this;
    }

    @Step("Пароль")
    public RegisterPage inputPassword(String text) {
        passwordInput.sendKeys(text);
        return this;
    }

    @Step("Клик по Зарегистрироваться с корректными данными")
    public LoginPage registerButtonClickSuccess() {
        registerButton.click();
        return new LoginPage(driver);
    }

    @Step("Клик по Зарегистрироваться с некорректными данными")
    public RegisterPage registerButtonClickFailure() {
        registerButton.click();
        return this;
    }

    @Step("Ошибка отображается на экране")
    public boolean passwordErrorIsVisible() {
        return incorrectPasswordErrorText.isDisplayed();
    }

    @Step("Клик по Войти")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }
}
