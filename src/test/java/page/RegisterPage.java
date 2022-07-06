package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureUtils;
import utils.StringConstants;
import utils.Waiter;

public class RegisterPage extends BasePage {
    @FindBy(id = "registration_email")
    private WebElement emailInput;

    @FindBy(id = "registration_password")
    private WebElement passwordInput;

    @FindBy(id ="registration_password_confirmation")
    private WebElement passwordConfirmInput;

    @FindBy(id = "registration_password_hint")
    private WebElement passwordHintInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    @FindBy(id = "registration_terms_of_use")
    private WebElement checkBox1;

    @FindBy(id = "registration_lost_password_warning_registered")
    private WebElement checkBox2;

    @Step("Click button ok")
    public void clickOkButton() {
        registerButton.click();
    }

    @Step("Fill email")
    public RegisterPage fillEmailField(String email) {
        Waiter.waitVisibilityOfElement(driver, emailInput);
        emailInput.sendKeys(email);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Fill password")
    public RegisterPage fillPasswordField(String password) {
        passwordInput.sendKeys(password);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Fill password confirmed")
    public RegisterPage fillConfirmField(String confirm) {
        passwordConfirmInput.sendKeys(confirm);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Fill password hint")
    public RegisterPage fillHintField(String hint) {
        passwordHintInput.sendKeys(hint);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Select Terms of use checkbox")
    public RegisterPage fillCheckBoxField() {
        checkBox1.click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Select I'm aware checkbox")
    public RegisterPage fillCheckBox2Field() {
        checkBox2.click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Open register page")
    public RegisterPage openRegPage() {
        driver.get(StringConstants.CREATE_NEW_ACCOUNT_URL);
        return this;
    }
}