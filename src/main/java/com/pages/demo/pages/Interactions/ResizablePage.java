package com.pages.demo.pages.Interactions;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResizablePage extends BasePage {
    private final By pageTitle = By.xpath("//h1[@class='text-center'][contains(.,'Resizable')]");
    private final By resizableBoxWithRestrictionText = By.xpath("//div[@class='text'][contains(.,'Resizable box, starting at 200x200. Min size is 150x150, max is 500x300.')]");
    private final By resizable = By.xpath("//h1[@class='text-center'][contains(.,'Resizable')]");
    private final By resizableBoxWithRestriction = By.id("resizableBoxWithRestriction");
    private final By resizableWithoutRestriction = By.id("resizable");
    private final By resizeHandle = By.xpath("(//span[contains(@class,'react-resizable-handle react-resizable-handle-se')])[1]");
    private final By resizeHandle2 = By.xpath("(//span[contains(@class,'react-resizable-handle react-resizable-handle-se')])[2]");

    public String getPageTitleText() {
        return find(pageTitle).getText();
    }

    public String getResizableBoxWithRestrictionText() {
        return find(resizableBoxWithRestrictionText).getText();
    }

    public String getResizableText() {
        return find(resizable).getText();
    }

    public void changeSize(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);

        WebElement resizableBoxWeb = driver.findElement(resizeHandle);

        actions.clickAndHold(resizableBoxWeb)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }

    public String getNewSizeBox() {
        WebElement resizableBox = driver.findElement(resizableBoxWithRestriction);
        Dimension initialSize = resizableBox.getSize();

        return initialSize.toString();
    }

    public String getNewSizeBox2() {
        WebElement resizableBox = driver.findElement(resizableWithoutRestriction);
        Dimension initialSize = resizableBox.getSize();

        return initialSize.toString();
    }

    public void changeSizeWithoutLimitations(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);

        WebElement resizableBoxWeb = driver.findElement(resizeHandle2);

        actions.clickAndHold(resizableBoxWeb)
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();
    }
}
