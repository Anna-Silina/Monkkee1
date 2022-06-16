package test;

import io.qameta.allure.Description;
import model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.RegisterPageService;
import utils.StringConstants;

public class RegisterPageTest extends BasePageTest {
    private RegisterPageService registerPageService;

    @BeforeTest
    public void setUp() {
        registerPageService = new RegisterPageService();
    }

    @Test(description = "Login")
    @Description("Create new Account")
    public void regTest() throws InterruptedException { // Исправить
        User user = new User("ulianakolosovich@gmail.com", StringConstants.PASSWORD, StringConstants.REMINDER, true, true); //заполни
        registerPageService.register(user); // изменить новый логин, новую почту
        String expectedURL = "https://my.monkkee.com/account/registered";
        String actualURL = driver.getCurrentUrl();
        //driver.wait(150000);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL, "Account is not registered");
    }

    @Test(description = "Login")
    @Description("Create Account with old parameters")
    public void negativeRegTest() {
        User user = new User(StringConstants.EMAIL, StringConstants.PASSWORD, StringConstants.REMINDER, true, true); //заполни
        registerPageService.register(user);
        String expectedURL = "https://my.monkkee.com/account/registration";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Account is registered");
    }
}