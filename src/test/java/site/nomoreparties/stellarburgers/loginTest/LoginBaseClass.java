package site.nomoreparties.stellarburgers.loginTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.driverSetup.DriverSetup;
import site.nomoreparties.stellarburgers.testData.TestData;

public abstract class LoginBaseClass {
    protected TestData testData = new TestData();
    DriverSetup setup = new DriverSetup();
    static WebDriver driver;

    @Before
    public void setUp(){
        driver = setup.driverSetUp(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
