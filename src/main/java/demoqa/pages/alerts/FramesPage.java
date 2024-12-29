package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class FramesPage extends BasePage {

    private final By newTabButton = By.xpath("//h1[contains(.,'Frames')]");
    private final By text = By.xpath("(//div[contains(.,'Sample Iframe page There are 2 Iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame, which is this window, and the two frames below')])[7]");

    private final By frame1 = By.id("frame1");
    private final By frame2 = By.id("frame2");
    private final By firstHeading = By.id("sampleHeading");
    private final By secondHeading = By.id("sampleHeading");

    private final By frame1wrapper = By.id("frame1Wrapper");
    private final By frame2wrapper = By.id("frame2Wrapper");

    public String getHeadingTextInFirstIframe() {
        scrollToElementJS(frame1wrapper);
        WebElement firstFrame = driver.findElement(frame1);
        WebElement firstHeadingWebElement = driver.switchTo().frame(firstFrame).findElement(firstHeading);
        return firstHeadingWebElement.getText();
    }

    public String getHeadingTextInSecondIframe() {
        scrollToElementJS(frame2wrapper);
        WebElement secondFrame = driver.findElement(frame2);
        WebElement secondHeadingWebElement = driver.switchTo().frame(secondFrame).findElement(secondHeading);
        return secondHeadingWebElement.getText();
    }

    public String getFramesHeadingText() {
        return find(newTabButton).getText();
    }

    public String getText() {
        return find(text).getText();
    }
}
