package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListener;

@Listeners(TestListener.class)
public class BasePageTest {
    protected WebDriver driver;

    @BeforeTest
    public void startBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}