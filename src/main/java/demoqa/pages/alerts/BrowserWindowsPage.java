package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickNewTabButton() {
        newTabButton.click();
    }

    public void clickNewWindowButton() {
        newWindowButton.click();
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
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);

                WebElement textElement = driver.findElement(By.xpath("/html/body/text()"));
                actualMessage = textElement.getText();

                break;
            }
        }

        return actualMessage;
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
}
