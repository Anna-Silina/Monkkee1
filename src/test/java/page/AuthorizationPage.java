package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorizationPage extends BasePage {
    @FindBy(
            xpath = "//a[contains(@href, '/javascript:void(0)')]"
    )
    private WebElement edit;
    @FindBy(
            xpath = "//a[contains(@href, '#/settings/locale')]"
    )
    private WebElement setting;
    @FindBy(
            xpath = "//class[contains(@href, '#/entries')]"
    )
    private WebElement logo;

    public AuthorizationPage() {
    }

    @Step("Click button edit")
    public void clickEditButton() {
        this.edit.click();
    }

    @Step("Click button edit")
    public void clickSettingButton() {
        this.setting.click();
    }

    @Step("Click button logo")
    public String clickLogoButton() {
        return this.logo.getAttribute("href");
    }
}
