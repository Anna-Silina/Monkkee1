package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureUtils;
import utils.StringConstants;

public class RegisterPage extends BasePage {
    @FindBy(
            id = "registration_email"
    )
    private WebElement emailInput;
    @FindBy(
            id = "registration_password"
    )
    private WebElement passwordInput;
    @FindBy(
            id = "registration_password_confirmation"
    )
    private WebElement passwordConfirmInput;
    @FindBy(
            id = "registration_password_hint"
    )
    private WebElement passwordHintInput;
    @FindBy(
            xpath = "//button[@type='submit']"
    )
    private WebElement registerButton;
    @FindBy(
            id = "registration_terms_of_use"
    )
    private WebElement checkBox1;
    @FindBy(
            id = "registration_lost_password_warning_registered"
    )
    private WebElement checkBox2;

    public RegisterPage() {
    }

    @Step("Click button ok")
    public void clickOkButton() {
        this.registerButton.click();
    }

    @Step("Fill email")
    public RegisterPage fillEmailField(String email) {
        this.emailInput.sendKeys(new CharSequence[]{email});
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Fill password")
    public RegisterPage fillPasswordField(String password) {
        this.passwordInput.sendKeys(new CharSequence[]{password});
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Fill password confirmed")
    public RegisterPage fillConfirmField(String confirm) {
        this.passwordConfirmInput.sendKeys(new CharSequence[]{confirm});
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Fill password hint")
    public RegisterPage fillHintField(String hint) {
        this.passwordHintInput.sendKeys(new CharSequence[]{hint});
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Select Terms of use checkbox")
    public RegisterPage fillCheckBoxField() {
        this.checkBox1.isSelected();
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Select I'm aware checkbox")
    public RegisterPage fillCheckBox2Field() {
        this.checkBox2.isSelected();
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Open new page")
    public RegisteredPage openNewPage() {
        this.driver.get("https://my.monkkee.com/account/registered");
        AllureUtils.takeScreenshot(this.driver);
        return new RegisteredPage();
    }

    @Step("Open register page")
    public RegisterPage openRegPage() {
        this.driver.get("https://my.monkkee.com/account/registration");
        return this;
    }
}
