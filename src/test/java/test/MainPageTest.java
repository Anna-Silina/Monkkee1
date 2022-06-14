package test;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AuthorizationPage;
import service.MainPageService;

public class MainPageTest extends BasePageTest {
    private MainPageService mainPageS;

    @BeforeTest
    public void setUp() {
        mainPageS = new MainPageService();
    }

    @Test(description = "Login")
    @Description ("Fill all fields on main page and login with correct parameters")
    public void loginTest() {
        AuthorizationPage authorizationPage = mainPageS.authorization();
        String expectedURL = "https://my.monkkee.com/#/entries";
        String actualURL = authorizationPage.clickLogoButton();
        Assert.assertEquals(actualURL, expectedURL, "U didn`t log in");
    }

    @Test(description = "Login")
    @Description ("Fill all fields on main page and login with incorrect parameters")
    public void negativeLoginTest() {
        mainPageS.negativeAuthorization();
        String expectedURL = "https://my.monkkee.com/#/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "U log in with incorrect parameters");
    }
}

// Создать класс, который наследуется от basePageTest
// В нём будет метод, метод поиска с неправильным
// вызываешь метод из авторизованный сервис (1 сверху)
// дальше смотришь, есть такой текст или нет