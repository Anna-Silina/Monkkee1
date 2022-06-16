package service;

import model.User;
import page.RegisterPage;

public class RegisterPageService {
    private final RegisterPage registerPage = new RegisterPage();

    public void register(User user){
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
