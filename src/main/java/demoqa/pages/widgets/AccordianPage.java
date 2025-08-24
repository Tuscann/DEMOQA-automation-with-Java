package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.time.Duration;

public class AccordianPage extends BasePage {
    @FindBy(id = "section1Heading")
    private WebElement sectionOneHeading;

    @FindBy(id = "section2Heading")
    private WebElement sectionTwoHeading;

    @FindBy(id = "section3Heading")
    private WebElement sectionThreeHeading;

    @FindBy(id = "section1Content")
    private WebElement sectionOneContent;

    @FindBy(id = "section2Content")
    private WebElement sectionTwoContent;

    @FindBy(id = "section3Content")
    private WebElement sectionThreeContent;

    @FindBy(xpath = "//h1[contains(.,'Accordian')]")
    private WebElement heading;

    private final JavaScriptUtility javaScriptUtility;

    public AccordianPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getHeading() {
        return heading.getText();
    }

    public String getFirstSectionHeadingText() {
        return sectionOneHeading.getText();
    }

    public String getSecondSectionHeadingText() {
        return sectionTwoHeading.getText();
    }

    public String getThirdSectionHeadingText() {
        return sectionThreeHeading.getText();
    }

    public String getFirstSectionText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(sectionTwoContent));
        wait.until(ExpectedConditions.invisibilityOf(sectionThreeContent));
        return sectionOneContent.getText();
    }

    public String getSecondSectionText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(sectionOneContent));
        wait.until(ExpectedConditions.invisibilityOf(sectionThreeContent));
        return sectionTwoContent.getText();
    }

    public String getThirdSectionText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(sectionOneContent));
        wait.until(ExpectedConditions.invisibilityOf(sectionTwoContent));
        return sectionThreeContent.getText();
    }

    public void clickFirstHeading() {
        sectionOneHeading.click();
        sectionOneHeading.click();
    }

    public void clickTwoHeading() {
        javaScriptUtility.scrollToElementJS(sectionTwoHeading);
        sectionTwoHeading.click();
    }

    public void clickThrirdHeading() {
        javaScriptUtility.scrollToElementJS(sectionTwoHeading);
        sectionThreeHeading.click();
    }
}
