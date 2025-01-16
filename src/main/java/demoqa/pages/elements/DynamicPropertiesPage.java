package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertiesPage extends BasePage {

    private final By dynamicProperties = By.xpath("//h1[@class='text-center'][contains(.,'Dynamic Properties')]");
    private final By textWithRandomId = By.xpath("//p[contains(.,'This text has random Id')]");
    private final By willEnable5SecondsButton = By.id("enableAfter");
    private final By colorChangeButton = By.id("colorChange");
    private final By visibleAfter5SecondsButton = By.id("visibleAfter");

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getColorChangeButtonText() {
        return find(colorChangeButton).getText();
    }

    public String getWillEnable5SecondsButtonText() {
        return find(willEnable5SecondsButton).getText();
    }

    public String getTextWithRandomIdText() {
        return find(textWithRandomId).getText();
    }

    public String getDynamicPropertiesText() {
        return find(dynamicProperties).getText();
    }

    public String getColorOfChangeButton() {
        return find(colorChangeButton).getCssValue("color");
    }

    public String getVisibleAfter5SecondsButtonTextAfter5seconds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.visibleAfter5SecondsButton));

        return find(visibleAfter5SecondsButton).getText();
    }

    public boolean checkButtonWillEnable5Seconds() {
        WebElement enableAfterButton = driver.findElement(willEnable5SecondsButton);

        return enableAfterButton.isEnabled();
    }

    public boolean checkButtonVisibleAfter5Seconds() {

        boolean elementExists = true;
        try {
            driver.findElement(visibleAfter5SecondsButton);
        } catch (NoSuchElementException e) {
            elementExists = false;
        }

        return elementExists;
    }
}
