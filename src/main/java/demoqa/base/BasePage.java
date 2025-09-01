package demoqa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    protected final WebDriver driver;
    @FindBy(xpath = "//img[@src='/images/Toolsqa.jpg']")
    private WebElement topImageLink;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException exc) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during delay", exc);
        }
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void set(WebElement locator, String text) {
        locator.clear();
        locator.sendKeys(text);
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    public String checkCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickTopImage() {
        topImageLink.click();
    }
}
