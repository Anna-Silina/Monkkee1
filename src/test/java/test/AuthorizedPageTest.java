package test;

import io.qameta.allure.Description;
import model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.AuthorizedPageService;
import service.RegisterPageService;
import service.SettingPageService;
import utils.StringConstants;

public class AuthorizedPageTest extends BasePageTest {
    private AuthorizedPageService authorizedPageService;
    private SettingPageService settingPageService;

    @BeforeTest
    public void setUp() {
        authorizedPageService = new AuthorizedPageService();
    }

    @Test(description = "Search")
    @Description("Search")
    public void searchTest() {
        authorizedPageService.search(); // проверить
        String text = driver.findElement(By.xpath("//a[contains(@href, '#/entries/2835129')]")).getText();
        Assert.assertEquals(text, "Welcome to monkkee!");
    }

    @Test(description = "Search")
    @Description("Wrong Search")
    public void searchNotFoundTest() {
        authorizedPageService.wrongSearch();
        String text = driver.findElement(By.xpath("//ya-tr-span[@data-value='No entries found']")).getText();
        Assert.assertEquals(text, "No entries found");
    }

    @Test(description = "Change language")
    @Description("Change language on Deutsch")
    public void changeLanguageTest() {
        settingPageService.clickChangeLanguage();
        String text = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
        Assert.assertEquals(text, "Deine Spracheinstellung wurde erfolgreich geändert");
    }
}