package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
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

//    public void hoverMeToSeeButton() {
//
//        actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated((hoverMeToSeeButton)))).perform();
//    }

    public void hoverMeToSeeTextField() {
        // moveToElement(hoverTextField);
    }


    public String assertionHoverButtonText() {

        String hoverButtonText = find(hoverMeToSeeButton).getText();

        WebElement hoverButton = driver.findElement(hoverMeToSeeButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();


        String tooltipMessage = driver.findElement(hoverMeToSeeButton).getDomAttribute("aria-describedby");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(tooltipMessage)));

        String actualMessage = tooltipMessage;

        return "dasd";
    }
}
