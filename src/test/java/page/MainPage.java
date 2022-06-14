package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureUtils;
import utils.StringConstants;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href,'/account/registration')]")
    private WebElement register;


    @Step("Click button register")
    public void clickRegisterButton() {
        register.click();
    }

    @FindBy(xpath = "//a[contains(@href,'/account/password_reminder')]")
    private WebElement sendPasswordReminder;


    @Step("Click button send password reminder")
    public void clickSendPasswordReminderButton() {
        sendPasswordReminder.click();
    }

    @FindBy(xpath = "//a[contains(@href,'https://www.monkkee.com/en/support-us-with-a-donation/')]")
    private WebElement sendFeedMonkkee;

    @Step("Click button send password reminder")
    public void clickFeedMonkkeeButton() {
        sendFeedMonkkee.click();
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

    // тоже 2 метода, как сверху, меняются параметры
    @FindBy(className = "btn-primary") // TODO: поискать, как писать
    private WebElement login;


    @Step("Click button login")
    public void clickLoginButton() {
        login.click();
    }

    @Step("Open register page")
    public MainPage openMain() {
        driver.get(StringConstants.BASE_URL);
        return this;
    }
}
