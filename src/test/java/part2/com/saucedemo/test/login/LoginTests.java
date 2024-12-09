package part2.com.saucedemo.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void LoginWithValidPasswordAndUsername() {
        String username = "visual_user";
        String password = "secret_sauce";

        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualProducts = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span"))).getText();
        String expectedProducts = "Products";
        Assert.assertEquals(actualProducts, expectedProducts);
    }

    @Test
    public void checkTextOfLoginErrorMessage() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("karma");
        loginPage.clickLoginButton();

        String actualMessage = loginPage.getErrorMessage();

        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
}