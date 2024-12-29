package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserWindowsPage extends BasePage {

    public static WebDriver driver2;
    private final By header = By.xpath(" //h1[@class='text-center'][contains(.,'Browser Windows')]");
    private final By newTabButton = By.id("tabButton");
    private final By newWindowButton = By.id("windowButton");
    private final By newWindowMessageButton = By.id("messageWindowButton");

    public void clickNewTabButton() {
        click(newTabButton);
    }

    public void clickNewWindowButton() {
        click(newWindowButton);
    }

    public void clickNewWindowMessageButton() {
        click(newWindowMessageButton);
    }

    public String getNewTabUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }

    public String getNewWindowUrl() {

        String originalWindow = driver.getWindowHandle();

        String actualWindowUrl = "";
        Set<String> allWindows = driver.getWindowHandles();
        for (String currentWindowHandle : allWindows) {
            if (!currentWindowHandle.equals(originalWindow)) {
                driver.switchTo().window(currentWindowHandle);
                actualWindowUrl = driver.getCurrentUrl();
                break;
            }
        }
        return actualWindowUrl;
    }

    public String getBrowserMessage() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        String actualMessage = "";
        String newWindow = null;
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                newWindow = window;
                //driver.switchTo().window(newWindow);
                driver.switchTo().window(window);

                WebElement messageElement = driver2.findElement(By.xpath("/html/body/text()"));
                actualMessage = messageElement.getText().trim();
                break;
            }
        }

        return actualMessage;
    }

    public String getNewTabText() {
        return find(newTabButton).getText();
    }

    public String getNewWindowText() {
        return find(newWindowButton).getText();
    }

    public String getNewWindowMessageText() {
        return find(newWindowMessageButton).getText();
    }

    public String getBrowserWindowsText() {
        return find(header).getText();
    }

    public String getNewWindowMessage() {
        String originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();

        String message = "";
        String newWindow = null;
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                newWindow = handle;
                driver.switchTo().window(newWindow);
                message = driver.findElement(By.tagName("body")).getText();
                break;
            }
        }
        return message;
    }
}
