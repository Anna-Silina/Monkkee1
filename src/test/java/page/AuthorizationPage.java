package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.AllureUtils;

public class AuthorizationPage extends BasePage{
    @FindBy(xpath = "//a[contains(@href, '/javascript:void(0)')]")
    private WebElement editButton;

    @Step("Click button edit")
    public void clickEditButton() {
        editButton.click();
    }

    @FindBy(xpath = "//a[contains(@href, '#/settings/locale')]")
    private WebElement settingButton;

    @Step("Click button edit")
    public void clickSettingButton() {
        settingButton.click();
    }

    @FindBy(xpath = "//a[contains(@href, '#/entries')]")
    private WebElement logotip;

    @Step("Click button logo")
    public String clickLogoButton() {
        return logotip.getAttribute("href");
    }


    @FindBy(xpath = "//ya-tr-span[@data-value='No entries found']")
    private WebElement elementNotFound;

    @FindBy(xpath = "//input[@id='appendedInputButton']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@title='Search'")
    private WebElement searchButton;

    @Step("Click button send password reminder")
    public void clickSearchButton() {
        searchButton.click();
    }

    @Step("Fill email")
    public AuthorizationPage fillSearchField(String textForSearch) {
        searchInput.sendKeys(textForSearch);
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
