package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class AccordianPage extends BasePage {
    private final By sectionOneHeading = By.id("section1Heading");
    private final By sectionTwoHeading = By.id("section2Heading");
    private final By sectionThreeHeading = By.id("section3Heading");
    private final By sectionOneContent = By.id("section1Content");
    private final By sectionTwoContent = By.id("section2Content");
    private final By sectionThreeContent = By.id("section3Content");
    private final By heading = By.xpath("//h1[contains(.,'Accordian')]");

    public String getHeading() {
        return find(heading).getText();
    }

    public String getSectionOneHeadingText() {
        return find(sectionOneHeading).getText();
    }

    public String getSectionTwoHeadingText() {
        return find(sectionTwoHeading).getText();
    }

    public String getSectionThreeHeadingText() {
        return find(sectionThreeHeading).getText();
    }

    public String getSectionOneText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(sectionTwoContent.findElement(driver)));
        wait.until(ExpectedConditions.invisibilityOf(sectionThreeContent.findElement(driver)));
        return find(sectionOneContent).getText();
    }

    public String getSectionTwoText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(sectionOneContent.findElement(driver)));
        wait.until(ExpectedConditions.invisibilityOf(sectionThreeContent.findElement(driver)));
        return find(sectionTwoContent).getText();
    }

    public String getSectionThreeText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(sectionOneContent.findElement(driver)));
        wait.until(ExpectedConditions.invisibilityOf(sectionTwoContent.findElement(driver)));
        return find(sectionThreeContent).getText();
    }

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
}
