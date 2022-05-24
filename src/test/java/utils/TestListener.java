package utils;

import driver.DriverSingleton;
import io.qameta.allure.Attachment;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import page.BasePage;

import java.util.concurrent.TimeUnit;

public class TestListener extends BasePage implements ITestListener {
    public TestListener() {
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println(String.format("======================================== STARTING TEST %s ========================================", iTestResult.getName()));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(String.format("======================================== FINISHED TEST %s Duration: %ss ========================================", iTestResult.getName(), this.getExecutionTime(iTestResult)));
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(String.format("======================================== FAILED TEST %s Duration: %ss ========================================", iTestResult.getName(), this.getExecutionTime(iTestResult)));
        this.takeScreenshot(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(String.format("======================================== SKIPPING TEST %s ========================================", iTestResult.getName()));
        this.takeScreenshot(iTestResult);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println(String.format("======================================== SKIPPING TEST %s ========================================", iTestResult.getName()));
        this.takeScreenshot(iTestResult);
    }

    public void onTestFailedWithTimeout(ITestResult iTestResult) {
        System.out.println(String.format("======================================== SKIPPING TEST %s ========================================", iTestResult.getName()));
        this.takeScreenshot(iTestResult);
    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }

    @Attachment(
            value = "Last screen state",
            type = "image/png"
    )
    private byte[] takeScreenshot(ITestResult iTestResult) {
        ITestContext var2 = iTestResult.getTestContext();

        try {
            this.driver = DriverSingleton.getDriver();
            return this.driver != null ? (byte[])((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES) : new byte[0];
        } catch (IllegalStateException | NoSuchSessionException var4) {
            return new byte[0];
        }
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
