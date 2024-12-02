package part2.com.saucedemo.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

import java.time.Duration;
import java.util.concurrent.BrokenBarrierException;

public class LoginTests extends BaseTest {


    @Test
    public void testLogin() throws InterruptedException, BrokenBarrierException {
        loginPage.setUsername("visual_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String actualResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header_container\"]/div[2]/span"))).getText();
        String expectedResult = "Products";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLoginErrorMessage() throws InterruptedException, BrokenBarrierException {

        loginPage.setUsername("standard_user");
        loginPage.setPassword("karma");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Thread.sleep(3000);
        Assert.assertTrue(actualMessage.contains("Epic sadface"));
    }
}
