package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class Alerts_Frames_WindowsPage extends BasePage {

    @FindBy(xpath = "//div[@class='header-text'][contains(.,'Alerts, Frame & Windows')]")
    WebElement alertsFramesWindows;
    @FindBy(xpath = "//li[@id='item-0']/span[text()='Browser Windows']")
    WebElement browserWindowsMenuItem;
    @FindBy(xpath = "//li[@id='item-1']/span[text()='Alerts']")
    WebElement alertsMenuItem;
    @FindBy(xpath = "//li[@id='item-2']/span[text()='Frames']")
    WebElement framesMenuItem;
    @FindBy(xpath = "//li[@id='item-3']/span[text()='Nested Frames']")
    WebElement nestedFramesItem;
    @FindBy(xpath = "//li[@id='item-4']/span[text()='Modal Dialogs']")
    WebElement modalDialogsMenuItem;
    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6'][contains(.,'Please select an item from left to start practice.')]")
    WebElement text;
    @FindBy(xpath = "//div[contains(@class,'element-list collapse')]")
    WebElement collapseDiv;

    public Alerts_Frames_WindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMainText() {
        return text.getText();
    }

    public void clickBrowserWindows() {
        //  scrollToElementJS(browserWindowsMenuItem);
        browserWindowsMenuItem.click();
    }

    public void clickAlerts() {
        scrollToElementJS(alertsMenuItem);
        alertsMenuItem.click();
    }

    public void clickNestedFrames() {
        scrollToElementJS(nestedFramesItem);
        nestedFramesItem.click();
    }

    public void clickFrames() {
        scrollToElementJS(framesMenuItem);
        framesMenuItem.click();
    }

    public void clickModalDialogs() {
        scrollToElementJS(modalDialogsMenuItem);
        modalDialogsMenuItem.click();
    }

    public void clickAlertFramesWindows() {
        alertsFramesWindows.click();
    }

    public boolean verifyFramesIsVisible() {
        return framesMenuItem.isDisplayed();
    }

    public boolean verifyFramesIsNotVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.invisibilityOf(framesMenuItem));

        String classAttribute = collapseDiv.getDomAttribute("class");

        return classAttribute.equals("element-list collapse show");
    }
}
