package service;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import model.User;
import page.*;
import utils.StringConstants;

public class MainPageService {

    private MainPage mainPage = new MainPage();


    @Step("Open register page")
    public RegisterPage clickYourRegisterLink() {
        mainPage.clickRegisterButton();
        return new RegisterPage();
    }

    // тут будет ещё 2 кнопки (sendPasswordReminder и FeedTheMonkkee)
    // они по логике такие же, как сверху код, только меняется возвращаемая страница и вызываемый метод
    @Step("Open sendPasswordReminder page")
    public SendPasswordReminderPage clickYourSendPasswordReminderLink() {
        mainPage.clickSendPasswordReminderButton();
        return new SendPasswordReminderPage();


    }

    @Step("Open feedTheMonkkee page")
    public FeedTheMonkkeePage clickYourFeedTheMonkkeeLink() {
        mainPage.clickFeedMonkkeeButton();
        return new FeedTheMonkkeePage();
    }

    private AuthorizationPage authorizationPage = new AuthorizationPage();

    public AuthorizationPage authorization() {
        User user = new User(StringConstants.EMAIL, StringConstants.PASSWORD, StringConstants.REMINDER, true, true); //заполни
        mainPage.openMain()
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();

        return mainPage.openNewPageAuth();
    }

    public MainPage negativeAuthorization() {
        User user = new User(StringConstants.NEG_EMAIL, StringConstants.NEG_PASSWORD, StringConstants.REMINDER, true, true); //заполни
        mainPage.openMain()
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();

        return mainPage.openMain();
    }
}
