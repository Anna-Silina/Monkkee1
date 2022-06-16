package test;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AuthorizationPage;
import service.AuthorizedPageService;
import service.MainPageService;
import service.SettingPageService;

public class MainPageTest extends BasePageTest {
    private MainPageService mainPageService;
    private SettingPageService settingPageService;
    private AuthorizedPageService authorizedPageService;

    @BeforeTest
    public void setUp() {
        mainPageService = new MainPageService();
        authorizedPageService = new AuthorizedPageService();
        settingPageService = new SettingPageService();
    }

    @Test(description = "Login")
    @Description("Fill all fields on main page and login with correct parameters")
    public void loginTest() {
        AuthorizationPage authorizationPage = mainPageService.authorization();
        String expectedURL = "https://my.monkkee.com/#/entries";
        String actualURL = authorizationPage.clickLogoButton();
        Assert.assertEquals(actualURL, expectedURL, "U didn`t log in");
    }

    @Test(description = "Login")
    @Description("Fill all fields on main page and login with incorrect parameters")
    public void negativeLoginTest() {
        mainPageService.negativeAuthorization();
        String expectedURL = "https://my.monkkee.com/#/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "U log in with incorrect parameters");
    }

    @Test(description = "Login")
    @Description("Delete test")
    public void deleteTest() {
        mainPageService.authorization();
        settingPageService.clickDeleteLink();
        settingPageService.clickDelete();
        driver.switchTo().alert().accept();
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
        String text = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
        Assert.assertEquals(text, "You will receive an email with a confirmation link. Please follow the instructions in this email. Please also check your Spam folder!");
    }
}