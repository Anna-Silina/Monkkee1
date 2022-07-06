package page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AllureUtils;
import utils.Waiter;

// страница редактирования, добавление записей
public class EditorsPage extends BasePage {
    @FindBy(xpath = "//div[@id='editable']")
    private WebElement editInput;

    @FindBy(xpath = "//a[@id='back-to-overview']")
    private WebElement homeButton;

    @FindBy(xpath = "//a[contains(@class, 'cke_button__savetoggle')]")
    private WebElement saveButton;

    @Step("Click button home")
    public void clickHomeButton() {
        String text;
        do {
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'cke_savetoggle_text')]")));
            text = driver.findElement(By.xpath("//span[contains(@class,'cke_savetoggle_text')]")).getText();
        } while (text.equals("unsaved"));
        Waiter.waitVisibilityOfElement(driver, homeButton);
        homeButton.click();
    }

    @Step("Click button save")
    public void clickSaveButton() {
        Waiter.waitVisibilityOfElement(driver, saveButton);
        saveButton.click();
    }

    @Step("Fill edit")
    public EditorsPage fillEditField(String textForSearch) {
        Waiter.waitVisibilityOfElement(driver, editInput);
        editInput.sendKeys(textForSearch);
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}