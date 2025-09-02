package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Browser Windows')]")
    WebElement header;
    @FindBy(id = "tabButton")
    WebElement newTabButton;
    @FindBy(id = "windowButton")
    WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessageButton;

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewTabButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(newTabButton)).click();
    }

    public void clickNewWindowButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(newWindowButton)).click();
    }

    public void clickNewWindowMessageButton() {
        newWindowMessageButton.click();
    }

    public String getNewTabUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }

    public String getNewWindowUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }

    public String getBrowserMessage() {
        String parentWindow = driver.getWindowHandle();

        // Wait for a new window to appear
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        // Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Wait for the body to be visible
        WebElement body = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

        String message = body.getText();

        // (Optional) Close the new window and switch back
        driver.close();
        driver.switchTo().window(parentWindow);

        return message;
    }

    public String getNewTabText() {
        return newTabButton.getText();
    }

    public String getNewWindowText() {
        return newWindowButton.getText();
    }

    public String getNewWindowMessageText() {
        return newWindowMessageButton.getText();
    }

    public String getBrowserWindowsText() {
        return header.getText();
    }

    public String getBrowserWindowsColor() {
        return newTabButton.getCssValue("background-color");
    }

    public String getNewWindowColor() {
        return newWindowButton.getCssValue("background-color");
    }

    public String getNewWindowMessageColor() {
        return newWindowMessageButton.getCssValue("background-color");
    }

    public String getSecondTabH1Text() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.findElement(By.tagName("h1")).getText();
    }

    public String getSecondTabBackgroundColor() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.findElement(By.tagName("body")).getCssValue("background-color");
    }
}
