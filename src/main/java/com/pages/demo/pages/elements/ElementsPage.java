package com.pages.demo.pages.elements;

import com.pages.demo.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPage extends HomePage {

    private final By textBox = By.xpath("//li[@id='item-0']/span[text()='Text Box']");
    private final By checkBox = By.xpath("//li[@id='item-1']/span[text()='Check Box']");
    private final By radioButton = By.xpath("//li[@id='item-2']/span[text()='Radio Button']");
    private final By webTables = By.xpath("//li[@id='item-3']/span[text()='Web Tables']");
    private final By Buttons = By.xpath("//li[@id='item-4']/span[text()='Buttons']");
    private final By links = By.xpath("//li[@id='item-5']/span[text()='Links']");
    private final By brokenLinksImages = By.xpath("//li[@id='item-6']/span[text()='Broken Links - Images']");
    private final By uploadAndDownload = By.xpath("//li[@id='item-7']/span[text()='Upload and Download']");
    private final By dynamicPropertiesMenuItem = By.xpath("//li[@id='item-8']/span[text()='Dynamic Properties']");

    public TextBoxPage clickTextBox() {
        click(textBox);
        return new TextBoxPage();
    }

    public CheckBoxPage clickCheckBox() {
        click(checkBox);
        return new CheckBoxPage();
    }

    public RadioButtonPage clickRadioButton() {
        click(radioButton);
        return new RadioButtonPage();
    }

    public WebTablesPage clickWebTables() {
        click(webTables);
        return new WebTablesPage();
    }

    public ButtonsPage clickButtons() {
        click(Buttons);
        return new ButtonsPage();
    }

    public LinksPage clickLinks() {
        scrollToElementJS(links);
        click(links);
        return new LinksPage();
    }

    public BrokenLinksImagesPage clickBrokenLinksImages() {
        click(brokenLinksImages);
        return new BrokenLinksImagesPage();
    }

    public UploadAndDownloadPage clickUploadAndDownload() {
        click(uploadAndDownload);
        return new UploadAndDownloadPage();
    }

    public DynamicPropertiesPage clickDynamicProperties() {
        click(dynamicPropertiesMenuItem);
        return new DynamicPropertiesPage();
    }
}
