package service;

import driver.DriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AuthorizationPage;
import page.DeletePage;
import page.SettingPage;

public class SettingPageService {
    private final SettingPage settingPage = new SettingPage();
    private final DeletePage deletePage = new DeletePage();
    private final MainPageService mainPageService = new MainPageService();
    private final AuthorizationPage authorizedPage = new AuthorizationPage();
    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 15);

    @Step("Open delete page")
    public void clickDeleteLink() {
        authorizedPage.clickSettingButton();
        settingPage.clickDeleteButton();
    }

    @Step("Delete page")
    public void clickDelete() {
        deletePage.clickDeleteButton();
    }

    @Step("Change language")
    public void clickChangeLanguage() {
        mainPageService.authorization();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '#/settings/locale')]"))).click();

        authorizedPage.clickSettingButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='selectLocale']"))).click();

        settingPage.clickLanguageSelect();
        settingPage.clickOkButton();
    }
}