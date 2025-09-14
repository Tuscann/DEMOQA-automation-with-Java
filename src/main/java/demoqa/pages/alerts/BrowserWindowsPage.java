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
import java.util.Set;

public class BrowserWindowsPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Browser Windows')]")
    WebElement header;
    @FindBy(id = "tabButton")
    WebElement newTabButton;
    @FindBy(id = "windowButton")
    WebElement newWindowButton;
    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessageButton;
    @FindBy(xpath = "/html/body")
    WebElement header1;

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
        // Step 1: Store the parent (main) window
        String parentWindow = driver.getWindowHandle();

        // Step 2: Wait until a new (child) window appears
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        // Step 3: Identify the child window
        Set<String> allWindows = driver.getWindowHandles();
        String childWindow = allWindows.stream()
                .filter(handle -> !handle.equals(parentWindow))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Child window not found"));

        // Step 4: Switch to the child window
        driver.switchTo().window(childWindow);

        String message = header1.getText();
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

    public String getNewWindowBackgroundColor() {
        return newWindowButton.getCssValue("background-color");
    }

    public String getNewTabBackgroundColor() {
        return newTabButton.getCssValue("background-color");
    }

    public String getNewWindowMessageBackgroundColor() {
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
