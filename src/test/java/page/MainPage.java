package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureUtils;
import utils.StringConstants;
import utils.Waiter;

public class MainPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href,'/account/registration')]")
    private WebElement registerButton;

    @FindBy(className = "btn-primary")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @Step("Click button register")
    public void clickRegisterButton() {
        registerButton.click();
    }

    @Step("Opening page auth Page")
    public AuthorizationPage openNewPageAuth() {
        driver.get(StringConstants.AUTHORIZED_URL);
        AllureUtils.takeScreenshot(driver);
        return new AuthorizationPage();
    }

    @Step("Fill email")
    public MainPage fillEmailField(String email) {
        Waiter.waitVisibilityOfElement(driver, emailInput);
        emailInput.sendKeys(email);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

    @Step("Fill password")
    public MainPage fillPasswordField(String password) {
        Waiter.waitVisibilityOfElement(driver, passwordInput);
        passwordInput.sendKeys(password);
        AllureUtils.takeScreenshot(driver);
        return this;
    }

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
