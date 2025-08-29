package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

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
}
