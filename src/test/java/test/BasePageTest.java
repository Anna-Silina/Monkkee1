package test;


import driver.DriverSingleton;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TestListener;

@Listeners({TestListener.class})
public class BasePageTest {
    protected WebDriver driver;

    public BasePageTest() {
    }

    @BeforeTest
    public void startBrowser() {
        this.driver = DriverSingleton.getDriver();
        BasicConfigurator.configure();
    }

    @AfterTest
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}