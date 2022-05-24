package service;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.User;
import page.*;
import utils.StringConstants;

public class MainPageService {
    private MainPage mainPage = new MainPage();
    private AuthorizationPage authorizationPage = new AuthorizationPage();

    public MainPageService() {
    }

    @Step("Open register page")
    public RegisterPage clickYourRegisterLink() {
        this.mainPage.clickRegisterButton();
        return new RegisterPage();
    }

    @Step("Open sendPasswordReminder page")
    public SendPasswordReminderPage clickYourSendPasswordReminderLink() {
        this.mainPage.clickSendPasswordReminderButton();
        return new SendPasswordReminderPage();
    }

    @Step("Open feedTheMonkkee page")
    public FeedTheMonkkeePage clickYourFeedTheMonkkeeLink() {
        this.mainPage.clickFeedMonkkeeButton();
        return new FeedTheMonkkeePage();
    }

    public AuthorizationPage authorization() {
        User user = new User("sol11.06.91@gmail.com", "Anna@110691", "Anna@110691", true, true);
        this.mainPage.openMain().fillEmailField(user.getEmail()).fillPasswordField(user.getPassword()).clickLoginButton();
        return this.mainPage.openNewPageAuth();
    }
}
