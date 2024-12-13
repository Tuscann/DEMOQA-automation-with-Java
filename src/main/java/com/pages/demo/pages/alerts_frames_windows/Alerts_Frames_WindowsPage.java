package com.pages.demo.pages.alerts_frames_windows;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class Alerts_Frames_WindowsPage extends BasePage {

    private final By browserWindowsMenuItem = By.xpath("//li[@id='item-0']/span[text()='Browser Windows']");
    private final By alertsMenuItem = By.xpath("//li[@id='item-1']/span[text()='Alerts']");
    private final By framesMenuItem = By.xpath("//li[@id='item-2']/span[text()='Frames']");
    private final By nestedFramesItem = By.xpath("//li[@id='item-3']/span[text()='Nested Frames']");
    private final By modalDialogsMenuItem = By.xpath("//li[@id='item-4']/span[text()='Modal Dialogs']");
    private final By text = By.xpath("(//div[contains(.,'Please select an item from left to start practice.')])[5]");

    private String getMainText() {
        return find(text).getText();
    }

    public void clickBrowserWindows() {
        scrollToElementJS(browserWindowsMenuItem);
        click(browserWindowsMenuItem);
    }

    public void clickAlerts() {
        scrollToElementJS(alertsMenuItem);
        click(alertsMenuItem);
    }

    public void clickNestedFrames() {
        scrollToElementJS(nestedFramesItem);
        click(nestedFramesItem);
    }

    public void clickFrames() {
        scrollToElementJS(framesMenuItem);
        click(framesMenuItem);
    }

    public void clickModalDialogs() {
        scrollToElementJS(modalDialogsMenuItem);
        click(modalDialogsMenuItem);
    }
}
