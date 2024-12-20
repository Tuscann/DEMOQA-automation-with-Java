package com.pages.demo.pages.alerts_frames_windows;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class NestedFramesPage extends BasePage {

    private final By parentIframe = By.id("frame1");
    private final By parentText = By.xpath("//*[text()=\"Parent frame\"]");
    private final By childIframe = By.xpath("//p[contains(.,'Child Iframe')]");
    private final By childIframeText = By.xpath("//body/p");

    private final By mainText = By.xpath("//*[contains(text(),\"Sample\")]");

    public String getMainText() {
        return find(mainText).getText();
    }

    public String getChildText() {
        return find(childIframeText).getText();
    }

    public String getParentText() {
        return find(parentText).getText();
    }

    public void switchToParentIFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToChildIFrame() {
        driver.switchTo().parentFrame();
    }

    public void selectParentIframe() {

        driver.switchTo().frame(find(parentIframe));
    }

    public void selectChildIframe() {

        driver.switchTo().frame(find(parentIframe));
        driver.switchTo().frame(find(childIframe));
        driver.switchTo().frame(0);

    }
}
