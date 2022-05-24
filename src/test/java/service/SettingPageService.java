package service;

import io.qameta.allure.Step;
import page.DeletePage;
import page.EmailPage;
import page.SettingPage;

public class SettingPageService {
    private SettingPage settingPage = new SettingPage();

    public SettingPageService() {
    }

    @Step("Open setting page")
    public EmailPage clickEmailLink() {
        this.settingPage.clickEmailButton();
        return new EmailPage();
    }

    @Step("Open delete page")
    public DeletePage clickDeleteLink() {
        this.settingPage.clickDeleteButton();
        return new DeletePage();
    }
}