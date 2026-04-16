package tests;

import org.testng.annotations.Test;

import java.util.List;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class TestProducts extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Onesie", "Sauce Labs Fleece Jacket");

    @Test
    public void checkGoodsAdded() {
        System.out.println("ProductsTest.correct !!!!! in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.loginUser(withAdminPermission());
        assertTrue(productsPage.isTitleIsDisplayed());
        assertEquals(productsPage.checkTitleName(), PRODUCTS.getDisplayName());

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

   /*     for (int i = 0; i < goodsList.size(); i++) {
            productsPage.addGoodsToCart(goodsList.get(i));
        }*/

        productsPage.addGoodsToCart(2);

        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}
