package demoqa.pages.widgets;


import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolTipsPage extends BasePage {

    private final By practiceToolTipsText = By.xpath("//*[@id='buttonToolTopContainer']/p");
    private final By hoverMeToSeeButton = By.id("toolTipButton");
    private final By hoverMeTextField = By.id("toolTipTextField");
    private final By text = By.xpath("//*[@id='texToolTopContainer']");

    public String getText() {
        return find(text).getText();
    }

    public String getPracticeToolTipsText() {
        return find(text).getText();
    }

    public String hoverMeToSeeButtonText() {
        return find(hoverMeToSeeButton).getText();
    }

    public String hoverMeTextFieldText() {
        return find(hoverMeTextField).getText();
    }

    public String hoverOnHoverMeToSeeButton() {
        return find(hoverMeToSeeButton).getText();
    }

    public String getHoverButtonText() {

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(hoverMeToSeeButton)).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(driver.findElement(hoverMeToSeeButton).getDomAttribute("aria-describedby"))));

        WebElement tooltipElement = driver.findElement(By.id(driver.findElement(hoverMeToSeeButton).getDomAttribute("aria-describedby")));

        return tooltipElement.getText();
    }
}
