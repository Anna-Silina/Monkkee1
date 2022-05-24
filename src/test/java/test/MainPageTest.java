package test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AuthorizationPage;
import page.MainPage;
import service.MainPageService;

public class MainPageTest extends BasePageTest {
    private MainPageService mainPageS;

    public MainPageTest() {
    }

    @BeforeTest
    public void setUp() {
        this.mainPageS = new MainPageService();
    }

    @Test(
            description = "Login"
    )
    @Description("Fill all fields on main page and login")
    public void loginTest() {
        AuthorizationPage authorizationPage = this.mainPageS.authorization();
        String expectedURL = "#/entries";
        String actualURL = authorizationPage.clickLogoButton();
        Assert.assertEquals(actualURL, expectedURL, "U didn`t log in");
    }
}

