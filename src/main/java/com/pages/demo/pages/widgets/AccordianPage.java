package com.pages.demo.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class AccordianPage extends WidgetsPage {
    private final By sectionOneHeading = By.id("section1Heading");
    private final By sectionTwoHeading = By.id("section2Heading");
    private final By sectionThreeHeading = By.id("section3Heading");
    private final By sectionOneContent = By.id("section1Content");
    private final By sectionTwoContent = By.id("section2Content");
    private final By sectionThreeContent = By.id("section3Content");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

    public void clickOneHeading() {
        click(sectionOneHeading);
        click(sectionOneHeading);
    }

    public void clickTwoHeading() {
        scrollToElementJS(sectionTwoHeading);
        click(sectionTwoHeading);
    }

    public void clickThreeHeading() {
        scrollToElementJS(sectionTwoHeading);
        click(sectionThreeHeading);
    }

    public String getSectionOneText() {
        wait.until(ExpectedConditions.invisibilityOf(By.id("section2Content").findElement(driver)));
        wait.until(ExpectedConditions.invisibilityOf(By.id("section3Content").findElement(driver)));
        WebElement firstAccordionContent = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionOneContent));
        return firstAccordionContent.getText();
    }

    public String getSectionTwoText() {
        wait.until(ExpectedConditions.invisibilityOf(By.id("section1Content").findElement(driver)));
        wait.until(ExpectedConditions.invisibilityOf(By.id("section3Content").findElement(driver)));
        WebElement secondAccordionContent = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionTwoContent));
        return secondAccordionContent.getText();
    }

    public String getSectionThreeText() {
        wait.until(ExpectedConditions.invisibilityOf(By.id("section1Content").findElement(driver)));
        wait.until(ExpectedConditions.invisibilityOf(By.id("section2Content").findElement(driver)));
        WebElement ThirdAccordionContent = wait.until(ExpectedConditions.visibilityOfElementLocated(sectionThreeContent));
        return ThirdAccordionContent.getText();
    }
}
