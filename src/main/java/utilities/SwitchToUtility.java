package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwitchToUtility {

    private final WebDriver driver;

    public SwitchToUtility(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public String getAlertText() {
        Alert alert;
        String az = "";

        while (true) {
            try {
                alert = driver.switchTo().alert();
                az = alert.getText();
                alert.accept();
                break;
            } catch (org.openqa.selenium.NoAlertPresentException e) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        return az;
    }

    public void setAlertText(String text) {    
        switchTo().alert().sendKeys(text);
    }

    public void acceptAlert() {
        switchTo().alert().accept();
    }

    public void dismissAlert() {
        switchTo().alert().dismiss();
    }

    public void switchToFrameString(String value) {
        switchTo().frame(value);
    }

    public void switchToDefaultContent() {
        switchTo().defaultContent();
    }

    public void switchToFrameIndex(int index) {
        switchTo().frame(index);
    }

    public void switchToFrameElement(WebElement element) {
        switchTo().frame(element);
    }

    public void switchToWindow(String handle) {
        switchTo().window(handle);
    }
}
