package service;

import model.User;
import page.RegisterPage;
import page.RegisteredPage;
import utils.StringConstants;

public class RegisterPageService {
    private RegisterPage registerPage = new RegisterPage();

    public RegisterPageService() {
    }

    public RegisteredPage register() {
        User user = new User("sol11.06.91@gmail.com", "Anna@110691", "Anna@110691", true, true);
        this.registerPage.openRegPage().fillEmailField(user.getEmail()).fillPasswordField(user.getPassword()).fillConfirmField(user.getPassword()).fillHintField(user.getPasswordHint()).fillCheckBoxField().fillCheckBox2Field().clickOkButton();
        return this.registerPage.openNewPage();
    }
}
