package service;

import io.qameta.allure.Step;
import page.AuthorizationPage;
import page.EditorsPage;
import page.FeedTheMonkkeePage;
import page.SettingPage;

public class AuthorizedPageService {
    private AuthorizationPage authorizedPage = new AuthorizationPage();
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

    // метод: 1. вызвать метод авторизации
    // 2. если не перейдёт на страницу, то открытие страницы, но должен сам
    // 3. вызвать метод из registeredPage заполнение инпута поиска
    // 4. из registeredPage метод нажатие кнопки поиск
}
