package test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AuthorizationPage;
import page.MainPage;
import page.RegisteredPage;
import service.MainPageService;
import service.RegisterPageService;

public class RegisterPageTest extends BasePageTest {
    private RegisterPageService registerPageService;

    public RegisterPageTest() {
    }

    @BeforeTest
    public void setUp() {
        this.registerPageService = new RegisterPageService();
    }

    @Test(
            description = "Login"
    )
    @Description("Create new Account")
    public void regTest() {
        this.registerPageService.register();
        String expectedURL = "/account/registered";
        String actualURL = this.driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL), "Account is not registered");
    }
}