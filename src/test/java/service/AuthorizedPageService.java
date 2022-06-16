package service;

import io.qameta.allure.Step;
import page.AuthorizationPage;
import page.EditorsPage;
import page.FeedTheMonkkeePage;
import page.SettingPage;
import utils.StringConstants;

public class AuthorizedPageService {
    private AuthorizationPage authorizedPage = new AuthorizationPage();
    private MainPageService mainPageService = new MainPageService();

    @Step("Open edit page")
    public EditorsPage clickEditLink() {
        authorizedPage.clickEditButton();
        return new EditorsPage();
    }

    @Step("Open setting page")
    public SettingPage clickSettingLink() {
        authorizedPage.clickSettingButton();
        return new SettingPage();
    }

    @Step("Search field")
    public void search() {
        mainPageService.authorization();
        authorizedPage.fillSearchField(StringConstants.FOR_SEARCH_FIELD)
                .clickSearchButton();
    }

    @Step("Wrong search field")
    public void wrongSearch() {
        mainPageService.authorization();
        authorizedPage.fillSearchField(StringConstants.WRONG_FOR_SEARCH_FIELD)
                .clickSearchButton();
    }
}
