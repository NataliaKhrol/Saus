package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AllureUtils;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {
    @Test(invocationCount = 1, priority = 2, enabled = true)
    public void correctLogin() {
        System.out.println("LoginTest.correct !!!!! in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.loginUser(withAdminPermission());

        assertTrue(productsPage.isTitleIsDisplayed(), "Заголовок не виден");
        assertEquals(productsPage.checkTitleName(), PRODUCTS.getDisplayName(), "Не верный заголовок");
    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", password, "Epic sadface: Sorry, this jyyytuser has been locked out."}/*,
                {"", password, "Epic sadfffface: Username is required"}
                {user, "", "Epic sadface: Password is required"},
                {"Standard_user", password, "Epic sadface: Username and password do not match any user in this service"}
        */};
    }

    @Epic("Тестированиие интернет-площадки")
    @Feature("Проверка расчета скидки")
    @Story("GGGGGGg")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Natalia Khrol nat@gmaul.com")
    @TmsLink("Saus")
    @Issue("Tutorial4")
    @Test(dataProvider = "incorrectLoginData", description = "тест проверяет авторизацию заблокированного пользователя", invocationCount = 1, priority = 3)
    public void incorrectLogin(String user, String password, String errorMsg) {
        System.out.println("LoginTest.incorrect !!!!! in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(), errorMsg,
                "Не верный текст сообщения об ошибке");
    }
}
