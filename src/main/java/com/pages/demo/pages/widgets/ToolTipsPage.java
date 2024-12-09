package com.pages.demo.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolTipsPage extends WidgetsPage {

    private final By practiceToolTipsText = By.xpath("//*[@id='buttonToolTopContainer']/p");
    private final By hoverMeToSeeButton = By.id("toolTipButton");
    private final By hoverMeTextField = By.id("toolTipTextField");
    private final By text = By.xpath("//*[@id='texToolTopContainer']");

    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    public void hoverMeToSeeButton() {

        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated((hoverMeToSeeButton)))).perform();
    }

    public void hoverMeToSeeTextField() {
        // moveToElement(hoverTextField);
    }


    public String assertionHoverButtonText() {
        return find(hoverMeToSeeButton).getText();
        //aria-describedby
    }
}
