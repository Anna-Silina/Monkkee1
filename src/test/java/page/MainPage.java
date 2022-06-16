package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureUtils;
import utils.StringConstants;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href,'/account/registration')]")
    private WebElement registerButton;


    @Step("Click button register")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @FindBy(xpath = "//a[contains(@href,'/account/password_reminder')]")
    private WebElement sendPasswordReminderButton;


    @Step("Click button send password reminder")
    public void clickSendPasswordReminderButton() {
        sendPasswordReminderButton.click();
    }

    @FindBy(xpath = "//a[contains(@href,'https://www.monkkee.com/en/support-us-with-a-donation/')]")
    private WebElement sendFeedMonkkeeButton;

    @Step("Click button send password reminder")
    public void clickFeedMonkkeeButton() {
        sendFeedMonkkeeButton.click();
    }

    @Step("Opening page auth Page")
    public AuthorizationPage openNewPageAuth() {
        driver.get(StringConstants.AUTHORIZED_URL);
        AllureUtils.takeScreenshot(driver);
        return new AuthorizationPage();
    }

    @FindBy(xpath = "//input[@id='login']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;


    @Step("Fill email")
    public MainPage fillEmailField(String email) {
        emailInput.sendKeys(email);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Fill password")
    public MainPage fillPasswordField(String password) {
        passwordInput.sendKeys(password);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @FindBy(className = "btn-primary") // TODO: поискать, как писать
    private WebElement loginButton;


    @Step("Click button login")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Open register page")
    public MainPage openMain() {
        driver.get(StringConstants.BASE_URL);
        return this;
    }
}
