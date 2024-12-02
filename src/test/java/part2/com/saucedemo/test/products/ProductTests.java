package part2.com.saucedemo.test.products;

import com.pages.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class ProductTests extends BaseTest {
    @Test
    public void testProductHeaderIsDisplayed() {
        ProductsPage productsPage = loginPage.loginIntoApplication("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isProductsHeaderDispplayed());
    }
}
