package test;

import io.qameta.allure.Description;
import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

   /* @Test(description = "Register")
    @Description("Create new Account")
    public void regTest() {
        User user = new User("ulianakolosovich@gmail.com", StringConstants.PASSWORD, StringConstants.REMINDER); //заполни
        registerPageService.register(user); // изменить новый логин, новую почту
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'User registered')]")));
        String text = driver.findElement(By.xpath("//h1[contains(text(),'User registered')]")).getText();
        Assert.assertEquals(text, "User registered");
    }

    @Test(description = "Negative register")
    @Description("Create Account with old parameters")
    public void negativeRegTest() {
        User user = new User(StringConstants.EMAIL, StringConstants.PASSWORD, StringConstants.REMINDER); //заполни
        registerPageService.register(user);
        String expectedURL = "https://my.monkkee.com/account/registration";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Account is registered");
    }*/
}