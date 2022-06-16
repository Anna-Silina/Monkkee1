package page;

import driver.DriverSingleton;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href, '#/settings/email')]")
    private WebElement emailButton;

    @Step("Click button email")
    public void clickEmailButton() {
        emailButton.click();
    }

    @FindBy(xpath = "//a[contains(@href, '#/settings/delete_account')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//select[@name='selectLocale']")
    private WebElement languageSelect;

    @FindBy(xpath = "//select[contains(@class,'btn-primary')]")
    private WebElement okButton;

    @Step("Click button language")
    public void clickLanguageSelect() {
        Select select = new Select(languageSelect);
        select.selectByValue("Deutsch");
    }

    @Step("Click button language")
    public void clickOkButton() {
        okButton.click();
    }

    @Step("Click button delete")
    public void clickDeleteButton() {
        deleteButton.click();
    }
}
