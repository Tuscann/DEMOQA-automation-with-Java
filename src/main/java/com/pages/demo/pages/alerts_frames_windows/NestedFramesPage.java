package com.pages.demo.pages.alerts_frames_windows;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage extends BasePage {

    private final By frame1 = By.id("frame1");

    private final By childIframe = By.xpath("//p[contains(.,'Child Iframe')]");

    private final By text = By.id("framesWrapper");

    public String getText() {
        return find(text).getText();
    }

    public void switchToParentIFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToChildIFrame() {
        driver.switchTo().parentFrame();
    }

    public void selectParentIframe() {

        WebElement firstFrame = driver.findElement(frame1);
        WebDriver firstHeadingWebElement = driver.switchTo().frame(firstFrame);

        String x = firstHeadingWebElement.getTitle();


    }
}
