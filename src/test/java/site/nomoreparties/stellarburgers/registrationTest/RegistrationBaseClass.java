package site.nomoreparties.stellarburgers.registrationTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.driverSetup.DriverSetup;
import site.nomoreparties.stellarburgers.testData.TestData;

public abstract class RegistrationBaseClass {
    protected TestData testData = new TestData();
    static DriverSetup setup = new DriverSetup();
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = setup.driverSetUp(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
