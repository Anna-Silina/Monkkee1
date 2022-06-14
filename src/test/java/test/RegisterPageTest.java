package test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.RegisterPageService;

public class RegisterPageTest extends BasePageTest {
    private RegisterPageService registerPageService;

    @BeforeTest
    public void setUp() {
        registerPageService = new RegisterPageService();
    }

    @Test(description = "Login")
    @Description("Create new Account")
    public void regTest() {
        registerPageService.register();
        String expectedURL = "/account/registered";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL), "Account is not registered");
    }

    @Test(description = "Login")
    @Description("Create Account with old parameters")
    public void negativeRegTest() {
        registerPageService.register();
        String expectedURL = "https://my.monkkee.com/account/registration";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Account is registered");
    }

    @Test(description = "Research")
    @Description("Research with null result")
    public void researchNotFoundTest() {
        registerPageService.register();
        String expectedURL = "https://my.monkkee.com/account/registration";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Account is registered");
    }
}