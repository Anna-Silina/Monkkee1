package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletePage {
    @FindBy(xpath = "//a[contains(@class, 'btn-danger')]") // пересмотреть
    private WebElement deleteButton;

    @Step("Click button delete")
    public void clickDeleteButton() {
        deleteButton.click();
    }
}
