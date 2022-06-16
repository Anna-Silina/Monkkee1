package test;

import io.qameta.allure.Description;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AuthorizationPage;
import page.SettingPage;
import service.AuthorizedPageService;
import service.MainPageService;
import service.SettingPageService;

public class MainPageTest extends BasePageTest {
    private MainPageService mainPageS;
    private SettingPageService settingPageService;
    private AuthorizedPageService authorizedPageService;

    @BeforeTest
    public void setUp() {
        mainPageS = new MainPageService();
        authorizedPageService = new AuthorizedPageService();
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
    public void negativeLoginTest() { // ссылку изменить
        mainPageS.negativeAuthorization();
        String expectedURL = "https://my.monkkee.com/#/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "U log in with incorrect parameters");
    }

    @Test(description = "Login")
    @Description ("Delete test")
    public void deleteTest() {
        mainPageS.authorization();
        authorizedPageService.clickSettingLink();
        settingPageService.clickDeleteLink();
        settingPageService.clickDelete();
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