package elements;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

public class DropDown extends BasePage {
    private static final String DROP_DOWN_XPATH = "//div[@id='%s']";
    private static final String SELECT_OPTION_XPATH = "//select[@class='form-control']//option[contains(text(),'%s')]";
    private final String label;

    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 15);

    public DropDown(String label) {
        this.label = label;
    }

    public void selectOption(String option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(DROP_DOWN_XPATH, label)))).click();
        driver.findElement(By.xpath(String.format(SELECT_OPTION_XPATH, option))).click();
    }
}
