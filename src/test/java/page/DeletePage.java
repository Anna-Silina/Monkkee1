package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

public class DeletePage extends BasePage {
    @FindBy(xpath = "//button[contains(@class, 'btn-danger')]")
    private WebElement deleteButton;

    @Step("Click button delete")
    public void clickDeleteButton() {
        Waiter.waitVisibilityOfElement(driver, deleteButton);
        deleteButton.click();
    }
}