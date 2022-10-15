package site.nomoreparties.stellarburgers.driverSetup;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.testData.TestData;

import java.time.Duration;

public class DriverSetup {
    private static String getDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            return "src/main/resources/webdriver/yandexdriver";
        } else {
            return "src/main/resources/webdriver/chromedriver";
        }
    }
    private static String getOS() {
        String os = System.getProperty("os.name");
        if (os.toLowerCase().contains("mac")) return "_mac";
        if (os.toLowerCase().contains("windows")) return ".exe";
        else return "_linux";
    }
    public WebDriver driverSetUp(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", getDriver() + getOS());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }
    @Step("Login")
    public void login(HomePage homePage, TestData testData) {
        homePage.clickEnterButton()
                .inputEmail(testData.getEMAIL_REAL())
                .inputPassword(testData.getPASSWORD_REAL())
                .enterButtonClick();
    }

}
