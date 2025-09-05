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
        String result = "";

        while (true) {
            try {
                alert = driver.switchTo().alert();
                result = alert.getText();
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

        return result;
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

    public void ClickOKButton() {
        Alert alert;

        while (true) {
            try {
                alert = driver.switchTo().alert();
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


    }
}
