package com.pages.demo.pages.Interactions;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

public class DraggablePage extends BasePage {

    private final By pageTitle = By.xpath("//h1[@class='text-center'][contains(.,'Dragabble')]");
    private final By simpleTabTitle = By.id("draggableExample-tab-simple");
    private final By simpleDragMe = By.id("dragBox");
    private final By axisRestrictedTab = By.id("draggableExample-tab-axisRestriction");
    private final By axisRestrictedOnlyX = By.id("restrictedX");
    private final By axisRestrictedOnlyY = By.id("restrictedY");
    private final By containerRestrictedTab = By.id("draggableExample-tab-containerRestriction");
    private final By containerRestrictedFirstText = By.xpath("//div[contains(@class,'draggable ui-widget-content ui-draggable ui-draggable-handle')]");
    private final By containerRestrictedSecondText = By.xpath("//span[contains(@class,'ui-widget-header ui-draggable ui-draggable-handle')]");
    private final By cursorStyleTab = By.id("draggableExample-tab-cursorStyle");
    private final By cursorStyleFirstText = By.id("cursorCenter");
    private final By cursorStyleSecondText = By.id("cursorTopLeft");
    private final By cursorStyleThirdText = By.id("cursorBottom");

    public String getPageTitle() {
        return find(pageTitle).getText();
    }

    public String getSimpleTabTitle() {
        return find(simpleTabTitle).getText();
    }

    public String getSimpleDragMe() {
        return find(simpleDragMe).getText();
    }

    public String getAxisRestrictedTab() {
        return find(axisRestrictedTab).getText();
    }

    public String getAxisRestrictedOnlyY() {
        return find(axisRestrictedOnlyY).getText();
    }

    public String getContainerRestrictedTab() {
        return find(containerRestrictedTab).getText();
    }

    public String getContainerRestrictedFirstText() {
        return find(containerRestrictedFirstText).getText();
    }

    public String getContainerRestrictedSecondText() {
        return find(containerRestrictedSecondText).getText();
    }

    public String getCursorStyleTab() {
        return find(cursorStyleTab).getText();
    }

    public String getCursorStyleFirstText() {
        return find(cursorStyleFirstText).getText();
    }

    public String getCursorStyleSecondText() {
        return find(cursorStyleSecondText).getText();
    }

    public String getCursorStyleThirdText() {
        return find(cursorStyleThirdText).getText();
    }

    public String getAxisRestrictedOnlyX() {
        delay(100); //TODO
        return find(axisRestrictedOnlyX).getText();
    }

    public void clickSimpleTab() {
        click(simpleTabTitle);
    }

    public void clickAxisRestrictedTab() {
        click(axisRestrictedTab);
    }

    public void clickRestrictedTab() {
        click(containerRestrictedTab);
    }

    public void clickCursorStyleTab() {
        click(cursorStyleTab);
    }
}
