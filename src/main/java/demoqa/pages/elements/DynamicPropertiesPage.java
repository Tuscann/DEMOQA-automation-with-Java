package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicPropertiesPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Dynamic Properties')]")
    private WebElement dynamicProperties;

    @FindBy(xpath = "//p[contains(.,'This text has random Id')]")
    private WebElement textWithRandomId;

    @FindBy(id = "enableAfter")
    private WebElement willEnable5SecondsButton;

    @FindBy(id = "colorChange")
    private WebElement colorChangeButton;

    @FindBy(id = "visibleAfter")
    private WebElement visibleAfter5SecondsButton;

    @FindBy(id = "visibleAfter")
    private List<WebElement> visibleAfter5SecondsButtonList;

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getColorChangeButtonText() {
        return colorChangeButton.getText();
    }

    public String getWillEnable5SecondsButtonText() {
        return willEnable5SecondsButton.getText();
    }

    public String getTextWithRandomIdText() {
        return textWithRandomId.getText();
    }

    public String getDynamicPropertiesText() {
        return dynamicProperties.getText();
    }

    public String getColorOfChangeButton() {
        return colorChangeButton.getCssValue("color");
    }

    public String getVisibleAfter5SecondsButtonTextAfter5seconds() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(visibleAfter5SecondsButton));
        return visibleAfter5SecondsButton.getText();
    }

    public boolean checkButtonWillEnable5Seconds() {
        return willEnable5SecondsButton.isEnabled();
    }

    public boolean checkButtonVisibleAfter5Seconds() {
        return !visibleAfter5SecondsButtonList.isEmpty();
    }
}
