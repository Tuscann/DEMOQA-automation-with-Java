package com.pages.demo.pages.alerts_frames_windows;

import org.openqa.selenium.By;

public class ModalDialogsPage extends Alerts_Frames_WindowsPage {

    private final By smallModalButton = By.id("showSmallModal");
    private final By largeModalButton = By.id("showLargeModal");
    private final By smallModalText = By.xpath("//div[contains(text(),'small modal')]");
    private final By largeModalText = By.xpath("//button[@id='showLargeModal']");
    private final By closeButton = By.id("closeSmallModal");

    public void clickSmallModalButton() {
        click(smallModalButton);
    }

    public void clickLargeModalButton() {
        click(largeModalButton);
    }

    public String getSmallModalText() {
        return find(smallModalText).getText();
    }

    public String getLargeModalText() {
        return find(largeModalText).getText();
    }

    public void clickCloseButton() {
        click(closeButton);
    }
}
