package service;

import driver.DriverSingleton;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.DeletePage;
import page.EmailPage;
import page.MainPage;
import page.SettingPage;

public class SettingPageService {
    private SettingPage settingPage = new SettingPage();
    private DeletePage deletePage = new DeletePage();
    private MainPageService mainPageService = new MainPageService();
    private AuthorizedPageService authorizedPageService = new AuthorizedPageService();
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 15);

    @Step("Open setting page")
    public EmailPage clickEmailLink() {
        settingPage.clickEmailButton();
        return new EmailPage();
    }

    @Step("Open delete page")
    public DeletePage clickDeleteLink() {
        settingPage.clickDeleteButton();
        return new DeletePage();
    }

    @Step("Delete page")
    public void clickDelete() {
        deletePage.clickDeleteButton();
    }

    @Step("Change language")
    public void clickChangeLanguage() {
        mainPageService.authorization();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='selectLocale']"))).click();

        authorizedPageService.clickSettingLink();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='selectLocale']"))).click();

        settingPage.clickLanguageSelect();
        settingPage.clickOkButton();
    }
}