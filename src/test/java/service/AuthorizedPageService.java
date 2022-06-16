package service;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AuthorizationPage;
import page.EditorsPage;
import page.SettingPage;
import utils.StringConstants;
import utils.Waiter;

public class AuthorizedPageService {
    private final AuthorizationPage authorizedPage = new AuthorizationPage();
    private final EditorsPage editorsPage = new EditorsPage();

    @Step("Search field")
    public void search(String textForSearch) {
        authorizedPage.fillSearchField(textForSearch)
                .clickSearchButton();
    }

    @Step("Add")
    public void add(String textForAdd) {
        authorizedPage.clickEditButton();
        editorsPage.fillEditField(textForAdd);
        editorsPage.clickSaveButton();
        editorsPage.clickHomeButton();
    }

    @Step("Delete")
    public void deleteRecord() {
        authorizedPage.clickSelectForDelete();
        authorizedPage.clickDeleteButton();
    }
}
