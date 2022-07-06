package test;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.AuthorizedPageService;
import service.MainPageService;
import service.SettingPageService;
import utils.StringConstants;

public class AuthorizedPageTest extends BasePageTest {
    private AuthorizedPageService authorizedPageService;
    private SettingPageService settingPageService;
    private MainPageService mainPageService;

    @BeforeTest
    public void setUp() {
        mainPageService = new MainPageService(); // создаём объект
        authorizedPageService = new AuthorizedPageService();
        settingPageService = new SettingPageService();

        mainPageService.authorization();
    }

    @Test(description = "Search")
    @Description("Search") // тестовое описание
    public void searchTest() {
        // mainPageService.authorization();
        authorizedPageService.search(StringConstants.FOR_SEARCH_FIELD);
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '#/entries/2835129')]")));
        String text = driver.findElement(By.xpath("//a[contains(@href, '#/entries/2835129')]")).getText();
        Assert.assertEquals(text, "Welcome to monkkee!\n" +
                "We wish you a great time with monkkee! If you need help, use the link to the support page or the FAQs at the bottom of the page. Regards Your monkkee team");
    }

    @Test(description = "Search")
    @Description("Wrong Search")
    public void searchNotFoundTest() {
        // mainPageService.authorization();
        authorizedPageService.search(StringConstants.WRONG_FOR_SEARCH_FIELD);
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'none centered')]")));
        String text = driver.findElement(By.xpath("//div[contains(@class,'none centered')]")).getText();
        Assert.assertEquals(text, "No entries found");
    }

    @Test(description = "Change language")
    @Description("Change language on Deutsch")
    public void changeLanguageTest() {
        settingPageService.clickChangeLanguage("Deutsch");
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
        String text = driver.findElement(By.xpath("//div[contains(@class,'alert-success')]")).getText();
        Assert.assertEquals(text, "Deine Spracheinstellung wurde erfolgreich geändert");
        settingPageService.clickChangeLanguage("English");
        settingPageService.clickHome();
    }

   /* @Test(description = "Add")
    @Description("Add")
    public void addTest() {
        // mainPageService.authorization();
        authorizedPageService.add(StringConstants.FOR_ADD_FIELD);
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class, 'entry')]")));
        String text = driver.findElements(By.xpath("//a[contains(@class, 'entry')]")).get(0).getText();
        Assert.assertEquals(text, StringConstants.FOR_ADD_FIELD);
    }

    // досмотреть
   /* @Test(description = "Delete record")
    @Description("Delete record test")
    public void deleteRecordTest() {
        //mainPageService.authorization();
        authorizedPageService.add(StringConstants.FOR_DELETE_FIELD);
        authorizedPageService.deleteRecord();
        authorizedPageService.search(StringConstants.FOR_DELETE_FIELD);
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'none centered')]")));
        String text = driver.findElement(By.xpath("//div[contains(@class,'none centered')]")).getText();
        Assert.assertEquals(text, "No entries found");
    }*/
}