package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {

    private final WebDriver driver;

    public ActionUtility(WebDriver driver) {
        this.driver = driver;
    }

    private Actions act() {
        return new Actions(driver);
    }

    public void dragAndDropBy(WebElement source, int x, int y) {
        act().dragAndDropBy(source, x, y).perform();
    }

    public void sendKeys(WebElement source, CharSequence keys) {
        act().sendKeys(source, keys).perform();
    }

    public void MoveToElementSelenium(By keys) {
        WebElement element = driver.findElement(keys);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void MoveToElementSelenium(WebElement keys) {
        Actions actions = new Actions(driver);
        actions.moveToElement(keys);
        actions.perform();
    }
}
