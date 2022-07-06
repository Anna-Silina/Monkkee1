package service;

import model.User;
import page.*;
import utils.StringConstants;

public class MainPageService {
    private final MainPage mainPage = new MainPage();

    public AuthorizationPage authorization() {
        User user = new User(StringConstants.EMAIL, StringConstants.PASSWORD, StringConstants.REMINDER);
        mainPage.openMain()
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();

        return mainPage.openNewPageAuth();
    }

    public void negativeAuthorization() {
        User user = new User(StringConstants.NEG_EMAIL, StringConstants.NEG_PASSWORD, StringConstants.REMINDER);
        mainPage.openMain()
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();

        mainPage.openMain();
    }
}
