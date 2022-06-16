package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Waiter;

public class SettingPage extends BasePage {
    @FindBy(xpath = "//a[contains(@href, '#/settings/delete_account')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//select[@name='selectLocale']")
    private WebElement languageSelect;

    @FindBy(xpath = "//button[contains(@class,'btn-primary')]")
    private WebElement okButton;

    @Step("Click button language")
    public void clickLanguageSelect() {
        Select select = new Select(languageSelect);
        select.selectByVisibleText("Deutsch");
    }

    @Step("Click button language")
    public void clickOkButton() {
        okButton.click();
    }

    @Step("Click button delete")
    public void clickDeleteButton() {
        Waiter.waitVisibilityOfElement(driver, deleteButton);
        deleteButton.click();
    }
}
