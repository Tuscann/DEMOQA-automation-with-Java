package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class DynamicPropertiesPage extends BasePage {

    private final By dynamicProperties = By.xpath("//h1[@class='text-center'][contains(.,'Dynamic Properties')]");
    private final By textWithRandomId = By.xpath("//p[contains(.,'This text has random Id')]");
    private final By willEnable5SecondsButton = By.id("enableAfter");
    private final By colorChangeButton = By.id("colorChange");
    private final By visibleAfter5SecondsButton = By.id("visibleAfter");

    public String getVisibleAfter5SecondsButtonText() {
        return find(visibleAfter5SecondsButton).getText();
    }

    public String getColorChangeButtonText() {
        return find(colorChangeButton).getText();
    }

    public String getWillEnable5SecondsButtonText() {
        return find(willEnable5SecondsButton).getText();
    }

    public String getTextWithRandomIdText() {
        return find(textWithRandomId).getText();
    }

    public String getDynamicPropertiesText() {
        return find(dynamicProperties).getText();
    }

}
