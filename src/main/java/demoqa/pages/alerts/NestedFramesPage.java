package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;

public class NestedFramesPage extends BasePage {

    private final By parentIframe = By.id("frame1");
    private final By parentIframeText = By.xpath("//*[text()=\"Parent frame\"]");
    private final By childIframeText = By.xpath("//body/p");

    private final By mainText = By.xpath("//*[contains(text(),\"Sample\")]");

    public String getMainText() {
        return find(mainText).getText();
    }

    public String getChildIframeText() {
        return find(childIframeText).getText();
    }

    public String getParentIframeText() {
        return find(parentIframeText).getText();
    }

    public void selectParentIframe() {
        driver.switchTo().frame(find(parentIframe));
    }

    public void selectChildIframe() {
        driver.switchTo().frame(driver.findElement(parentIframe)).switchTo().frame(0);
    }
}
