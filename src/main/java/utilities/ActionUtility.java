package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility extends Utility {

    private static Actions act() {
        return new Actions(driver);
    }

    public static void dragAndDropBy(WebElement source, int x, int y) {
        act().dragAndDropBy(source, x, y).perform();
    }

    public static void sendKeys(WebElement source, CharSequence keys) {
        act().sendKeys(source, keys).perform();
    }

    public static void MoveToElementSelenium(By keys) {

        WebElement element = driver.findElement(keys);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }

    public static void MoveToElementSelenium(WebElement keys) {

        Actions actions = new Actions(driver);
        actions.moveToElement(keys);
        actions.perform();

    }
}
