package part2.com.saucedemo.test.products;

import com.pages.saucedemo.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class ProductTests extends BaseTest {
    @Test
    public void testProductHeaderIsDisplayed() {
        String username = "standard_user";
        String password = "secret_sauce";

        ProductsPage productsPage = loginPage.loginIntoApplication(username, password);
        Assert.assertTrue(productsPage.isProductsHeaderDisplayed());
    }
}
