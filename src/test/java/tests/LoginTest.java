package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isTitleIsDisplayed(), "Заголовок не виден");
        assertEquals(productsPage.getTitle(), "Products", "Не верный заголовок");
    }

    @Test
    public void incorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.",
                "Не верный текст сообщения об ошибке");
    }

    @Test
    public void emptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed(), "Нет сообщения об ошибке");
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required",
                "Не верный текст сообщения об ошибке");
    }
}
