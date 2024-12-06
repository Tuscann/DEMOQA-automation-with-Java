package com.pages.demo.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
    }

    public void clickTwoHeading() {
        click(sectionTwoHeading);
    }

    public void clickThreeHeading() {
        click(sectionThreeHeading);
    }

    public String getSectionOneText() {
        WebElement firstAccordionContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("section1Content")));
        return firstAccordionContent.getText();
    }

    public String getSectionTwoText() {
        WebElement secondAccordionContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("section2Content")));
        return secondAccordionContent.getText();
    }

    public String getSectionThreeText() {
        WebElement ThirdAccordionContent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("section3Content")));
        return ThirdAccordionContent.getText();
    }
}
