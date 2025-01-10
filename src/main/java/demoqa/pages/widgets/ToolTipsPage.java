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
    private final By buttonTooltip = By.id("buttonToolTip");
    private final By hoverMeTextField = By.id("toolTipTextField");
    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Tool Tips')]");
    private final By mainText = By.id("texToolTopContainer");

    private final By contrary = By.xpath("//a[@href='javascript:void(0)'][contains(.,'Contrary')]");
    private final By section = By.xpath("//a[@href='javascript:void(0)'][contains(.,'1.10.32')]");

    private final By buttonToolTip = By.xpath("//*[@id=\"buttonToolTip\"]/div[2]");
    private final By practiceTextFieldToolTip = By.xpath("//*[@id=\"textFieldToolTip\"]/div[2]");
    private final By contraryToolTip = By.xpath("//*[@id=\"contraryTexToolTip\"]/div[2]");
    private final By sectionToolTip = By.xpath("//*[@id=\"sectionToolTip\"]/div[2]");

    public String getHoverOverHoverMeToSeeButtonReturnToolTipText() {
        Actions actions = new Actions(driver);
        WebElement tooltipElement = driver.findElement(hoverMeToSeeButton);

        actions.moveToElement(tooltipElement).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(buttonToolTip));

        return find(buttonToolTip).getText();
    }

    public String getHoverOverHoverMeToSeeTextFieldReturnToolTipText() {
        Actions actions = new Actions(driver);
        WebElement tooltipElement = driver.findElement(hoverMeTextField);

        actions.moveToElement(tooltipElement).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(practiceTextFieldToolTip));

        return find(practiceTextFieldToolTip).getText();
    }

    public String getHoverOverContraryReturnToolTipText() {
        Actions actions = new Actions(driver);
        WebElement tooltipElement = driver.findElement(contrary);

        actions.moveToElement(tooltipElement).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(contraryToolTip));

        return find(contraryToolTip).getText();
    }

    public String getHoverOverSectionText() {
        Actions actions = new Actions(driver);
        WebElement tooltipElement = driver.findElement(section);

        actions.moveToElement(tooltipElement).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(sectionToolTip));

        return find(sectionToolTip).getText();
    }

    public String getHeaderText() {
        return find(header).getText();
    }

    public String getPracticeToolTips() {
        return find(practiceToolTipsText).getText();
    }

    public String getHoverMeButtonButton() {
        return find(hoverMeToSeeButton).getText();
    }

    public String getHoverMeToSeeButtonPlaceholder() {
        return find(hoverMeTextField).getDomAttribute("placeholder");
    }

    public String getMainText() {
        return find(mainText).getText();
    }
}
