package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureUtils;
import utils.StringConstants;

public class MainPage extends BasePage {
    @FindBy(
            xpath = "//a[contains(@href,'/account/registration')]"
    )
    private WebElement register;
    @FindBy(
            xpath = "//a[contains(@href,'/account/password_reminder')]"
    )
    private WebElement sendPasswordReminder;
    @FindBy(
            xpath = "//a[contains(@href,'https://www.monkkee.com/en/support-us-with-a-donation/')]"
    )
    private WebElement sendFeedMonkkee;
    @FindBy(
            xpath = "//input[@name='login' and @id='login']"
    )
    private WebElement emailInput;
    @FindBy(
            xpath = "//input[@name='password' and @id='password']"
    )
    private WebElement passwordInput;
    @FindBy(
            xpath = "//class[contains('/btn-text-content')]"
    )
    private WebElement login;

    public MainPage() {
    }

    @Step("Click button register")
    public void clickRegisterButton() {
        this.register.click();
    }

    @Step("Click button send password reminder")
    public void clickSendPasswordReminderButton() {
        this.sendPasswordReminder.click();
    }

    @Step("Click button send password reminder")
    public void clickFeedMonkkeeButton() {
        this.sendFeedMonkkee.click();
    }

    @Step("Opening page auth Page")
    public AuthorizationPage openNewPageAuth() {
        this.driver.get("  https://my.monkkee.com/#/entries");
        AllureUtils.takeScreenshot(this.driver);
        return new AuthorizationPage();
    }

    @Step("Fill email")
    public MainPage fillEmailField(String email) {
        this.emailInput.sendKeys(new CharSequence[]{email});
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Fill password")
    public MainPage fillPasswordField(String password) {
        this.passwordInput.sendKeys(new CharSequence[]{password});
        AllureUtils.takeScreenshot(this.driver);
        return this;
    }

    @Step("Click button login")
    public void clickLoginButton() {
        this.login.click();
    }

    @Step("Open register page")
    public MainPage openMain() {
        this.driver.get("https://my.monkkee.com/#/");
        return this;
    }
}
