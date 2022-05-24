package service;

import io.qameta.allure.Step;
import page.AuthorizationPage;
import page.EditorsPage;
import page.FeedTheMonkkeePage;
import page.SettingPage;

public class AuthorizedPageService {
    private AuthorizationPage authorizedPage = new AuthorizationPage();

    public AuthorizedPageService() {
    }

    @Step("Open edit page")
    public EditorsPage clickEditLink() {
        this.authorizedPage.clickEditButton();
        return new EditorsPage();
    }

    @Step("Open setting page")
    public SettingPage clickSettingLink() {
        this.authorizedPage.clickSettingButton();
        return new SettingPage();
    }
}