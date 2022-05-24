package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingPage extends BasePage {
    @FindBy(
            xpath = "//a[contains(@href, '#/settings/email')]"
    )
    private WebElement email;
    @FindBy(
            xpath = "//a[contains(@href, '#/settings/delete_account')]"
    )
    private WebElement delete;

    public SettingPage() {
    }

    @Step("Click button email")
    public void clickEmailButton() {
        this.email.click();
    }

    @Step("Click button delete")
    public void clickDeleteButton() {
        this.delete.click();
    }
}
