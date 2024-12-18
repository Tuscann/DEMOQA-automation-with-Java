package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPage extends BasePage {

    private final By textBox = By.xpath("//li[@id='item-0']/span[text()='Text Box']");
    private final By checkBox = By.xpath("//li[@id='item-1']/span[text()='Check Box']");
    private final By radioButton = By.xpath("//li[@id='item-2']/span[text()='Radio Button']");
    private final By webTables = By.xpath("//li[@id='item-3']/span[text()='Web Tables']");
    private final By Buttons = By.xpath("//li[@id='item-4']/span[text()='Buttons']");
    private final By links = By.xpath("//li[@id='item-5']/span[text()='Links']");
    private final By brokenLinksImages = By.xpath("//li[@id='item-6']/span[text()='Broken Links - Images']");
    private final By uploadAndDownload = By.xpath("//li[@id='item-7']/span[text()='Upload and Download']");
    private final By dynamicPropertiesMenuItem = By.xpath("//li[@id='item-8']/span[text()='Dynamic Properties']");
    private final By text = By.xpath("(//div[contains(.,'Please select an item from left to start practice.')])[5]");

    public void clickTextBox() {
        click(textBox);
    }

    public void clickCheckBox() {
        click(checkBox);
    }

    public void clickRadioButton() {
        click(radioButton);
    }

    public void clickWebTables() {
        click(webTables);
    }

    public void clickButtons() {
        click(Buttons);
    }

    public void clickLinks() {
        scrollToElementJS(links);
        click(links);
    }

    public void clickBrokenLinksImages() {
        click(brokenLinksImages);
    }

    public void clickUploadAndDownload() {
        click(uploadAndDownload);
    }

    public void clickDynamicProperties() {
        click(dynamicPropertiesMenuItem);
    }

    public String getText() {
        return find(text).getText();
    }
}
