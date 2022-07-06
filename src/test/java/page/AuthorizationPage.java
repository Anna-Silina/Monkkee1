package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.AllureUtils;
import utils.Waiter;

public class AuthorizationPage extends BasePage{ // взоимодействие элементов со страницами
    @FindBy(xpath = "//a[@id='create-entry']")
    private WebElement editButton;

    @FindBy(xpath = "//a[contains(@href, '#/settings/locale')]")
    private WebElement settingButton;

    @FindBy(xpath = "//a[contains(@href, '#/entries')]")
    private WebElement logotip;

    @FindBy(xpath = "//input[@id='appendedInputButton']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@title='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[contains(@class, 'ng-valid')]")
    private WebElement selectElementForDelete;

    @FindBy(xpath = "//a[@id='delete-entries']")
    private WebElement deleteRecordButton;

    @Step("Click button delete")
    public void clickDeleteButton() {
        Waiter.waitVisibilityOfElement(driver, deleteRecordButton);
        deleteRecordButton.click();
    }

    @Step("Select element for delete")
    public void clickSelectForDelete() {
        Select select = new Select(selectElementForDelete);
        select.selectByIndex(1);
    }

    @Step("Click button send password reminder")
    public void clickSearchButton() {
        searchButton.click();
    }

    @Step("Fill email")
    public AuthorizationPage fillSearchField(String textForSearch) {
        Waiter.waitVisibilityOfElement(driver, searchInput);
        searchInput.clear();
        searchInput.sendKeys(textForSearch);
        AllureUtils.takeScreenshot(driver); // может убрать
        return this;
    }

    @Step("Click button edit")
    public void clickEditButton() {
        Waiter.waitVisibilityOfElement(driver, editButton);
        editButton.click();
    }

    @Step("Click button edit")
    public void clickSettingButton() {
        Waiter.waitVisibilityOfElement(driver, settingButton);
        settingButton.click();
    }

    @Step("Click button logo")
    public String clickLogoButton() {
        return logotip.getAttribute("href");
    }
}