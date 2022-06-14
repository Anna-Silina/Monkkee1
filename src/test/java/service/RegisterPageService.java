package service;

import model.User;
import page.RegisterPage;
import page.RegisteredPage;
import utils.StringConstants;

public class RegisterPageService {
    private RegisterPage registerPage = new RegisterPage();

    public void register(){
        User user = new User(StringConstants.EMAIL, StringConstants.PASSWORD, StringConstants.REMINDER, true, true); //заполни

        registerPage.openRegPage()
                .fillEmailField(user.getEmail())
                .fillPasswordField(user.getPassword())
                .fillConfirmField(user.getPassword())
                .fillHintField(user.getPasswordHint())
                .fillCheckBoxField()
                .fillCheckBox2Field()
                .clickOkButton();
    }
}
