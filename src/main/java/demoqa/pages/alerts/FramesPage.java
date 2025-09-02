package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaScriptUtility;

public class FramesPage extends BasePage {

    private final By firstHeading = By.id("sampleHeading");
    private final By secondHeading = By.id("sampleHeading");
    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//h1[contains(.,'Frames')]")
    WebElement newTabButton;
    @FindBy(xpath = "(//div[contains(.,'Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below')])[7]")
    WebElement firstFrame;
    @FindBy(id = "frame1")
    WebElement frame1;
    @FindBy(id = "frame2")
    WebElement frame2;
    @FindBy(id = "frame1Wrapper")
    WebElement frame1wrapper;
    @FindBy(id = "frame2Wrapper")
    WebElement frame2wrapper;

    public FramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getFramesHeadingText() {
        return newTabButton.getText();
    }

    public String getFirstFrame() {
        return firstFrame.getText();
    }

    public String getHeadingTextInFirstIframe() {
        javaScriptUtility.scrollToElementJS(frame1wrapper);
        WebElement firstHeadingWebElement = driver.switchTo().frame(frame1).findElement(firstHeading);
        return firstHeadingWebElement.getText();
    }

    public String getHeadingTextInSecondIframe() {
        javaScriptUtility.scrollToElementJS(frame2wrapper);
        WebElement secondHeadingWebElement = driver.switchTo().frame(frame2).findElement(secondHeading);
        return secondHeadingWebElement.getText();
    }

    public String getFirstIFrameBackgroundColor() {
        WebElement firstHeadingWebElement = driver.findElement(By.tagName("body"));
        return firstHeadingWebElement.getCssValue("background-color");
    }

    public String getSecondIFrameBackgroundColor() {
        WebElement firstHeadingWebElement = driver.findElement(By.tagName("body"));
        return firstHeadingWebElement.getCssValue("background-color");
    }
}