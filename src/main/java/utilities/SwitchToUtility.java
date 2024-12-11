package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwitchToUtility extends Utility {


    private static WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public static String getAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

                }
            }
        }

        return az;

    }

    public static void setAlertText(String text) {
        switchTo().alert().sendKeys(text);
    }

    public static void acceptAlert() {
        switchTo().alert().accept();
    }

    public static void dismissAlert() {
        // Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        switchTo().alert().dismiss();
    }

    public static void switchToFrameString(String value) {
        switchTo().frame(value);
    }

    public static void switchToDefaultContent() {
        switchTo().defaultContent();
    }

    public static void switchToFrameIndex(int index) {
        switchTo().frame(index);
    }

    public static void switchToFrameElement(WebElement element) {
        switchTo().frame(element);
    }

    public static void switchToWindow(String handle) {
        switchTo().window(handle);
    }
}
