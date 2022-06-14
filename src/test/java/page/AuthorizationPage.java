package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage{
    @FindBy(xpath = "//a[contains(@href, '/javascript:void(0)')]")
    private WebElement edit;

    @Step("Click button edit")
    public void clickEditButton() {
        edit.click();
    }

    @FindBy(xpath = "//a[contains(@href, '#/settings/locale')]")
    private WebElement setting;

    @Step("Click button edit")
    public void clickSettingButton() {
        setting.click();
    }

    @FindBy(xpath = "//a[contains(@href, '#/entries')]")
    private WebElement logo;


    @Step("Click button logo")
    public String clickLogoButton() {
        return logo.getAttribute("href");
    }
}
