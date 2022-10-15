package site.nomoreparties.stellarburgers.exitAccountTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.driverSetup.DriverSetup;
import site.nomoreparties.stellarburgers.pages.HomePage;
import site.nomoreparties.stellarburgers.testData.TestData;

public abstract class ExitAccountBaseClass {
    protected static TestData testData = new TestData();
    static DriverSetup setup = new DriverSetup();
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = setup.driverSetUp(driver);
        setup.login(new HomePage(driver), testData);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
