package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class BrokenLinksImagesPage extends BasePage {

    private final By headerText = By.xpath("//h1[@class='text-center'][contains(.,'Broken Links - Images')] ");
    private final By validImageText = By.xpath("//p[contains(.,'Valid image')]");
    private final By brokenImageText = By.xpath("//p[contains(.,'Broken image')]");
    private final By validLinkText = By.xpath("//p[contains(.,'Valid Link')]");
    private final By brokenLinkText = By.xpath("//p[contains(.,'Broken Link')]");
    private final By clickHereValidLinkText = By.xpath("//a[contains(.,'Click Here for Valid Link')]");
    private final By clickHereBrokenLinkText = By.xpath("//a[contains(.,'Click Here for Broken Link')]");

    public String getHeaderText() {
        return find(headerText).getText();
    }

    public String getValidImageText() {
        return find(validImageText).getText();
    }

    public String getBrokenImageText() {
        return find(brokenImageText).getText();
    }

    public String getValidLinkText() {
        return find(validLinkText).getText();
    }

    public String getBrokenLinkText() {
        return find(brokenLinkText).getText();
    }

    public String getClickHereValidLinkText() {
        return find(clickHereValidLinkText).getText();
    }

    public String getClickHereBrokenLinkText() {
        return find(clickHereBrokenLinkText).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void ClickOnClickHereValidLink() {
        click(clickHereValidLinkText);
    }

    public void ClickOnClickHereBrokenLink() {
        click(clickHereBrokenLinkText);
    }
}
