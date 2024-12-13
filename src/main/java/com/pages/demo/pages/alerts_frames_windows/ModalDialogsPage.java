package com.pages.demo.pages.alerts_frames_windows;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class ModalDialogsPage extends BasePage {

    private final By smallModalButton = By.id("showSmallModal");
    private final By largeModalButton = By.id("showLargeModal");
    private final By smallModalText = By.xpath("//div[contains(text(),'small modal')]");
    private final By largeModalText = By.xpath("//button[@id='showLargeModal']");
    private final By closeSmallButton = By.id("closeSmallModal");
    private final By closeLargeButton = By.id("closeLargeModal");
    private final By closeButton = By.xpath("//button[@type='button'][contains(.,'×Close')]");

    private final By modalDialogsText = By.xpath("//h1[@class='text-center'][contains(.,'Modal Dialogs')]");
    private final By clickText = By.xpath("(//div[contains(.,'Click on button to see modal')])[8]");
    private final By smallText = By.id("showSmallModal");
    private final By largeText = By.id("showLargeModal");

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

    public String getModalDialogsText() {
        return find(modalDialogsText).getText();
    }

    public String getClickText() {
        return find(clickText).getText();
    }

    public String getSmallText() {
        return find(smallText).getText();
    }

    public String getLargeText() {
        return find(largeText).getText();
    }
}
