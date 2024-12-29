package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WidgetsPage extends BasePage {
    private final By selectAccordion = By.xpath("//li[@id='item-0']/span[text()='Accordian']");
    private final By selectAutoComplete = By.xpath("//li[@id='item-1']/span[text()='Auto Complete']");
    private final By datePickerMenuItem = By.xpath("//li[@id='item-2']/span[text()='Date Picker']");
    private final By sliderMenuItem = By.xpath("//li[@id='item-3']/span[text()='Slider']");
    private final By progressBarMenuItem = By.xpath("//li[@id='item-4']/span[text()='Progress Bar']");
    private final By selectTabs = By.xpath("//li[@id='item-5']/span[text()='Tabs']");
    private final By selectToolTips = By.xpath("//li[@id='item-6']/span[text()='Tool Tips']");
    private final By selectMenu = By.xpath("//li[@id='item-7']/span[text()='Menu']");
    private final By selectSelectMenu = By.xpath("//li[@id='item-8']/span[text()='Select Menu']");

    public void clickAccordion() {
        scrollToElementJS(selectAccordion);
        click(selectAccordion);
    }

    public void clickAutoComplete() {
        scrollToElementJS(selectAutoComplete);
        click(selectAutoComplete);
    }

    public void clickDatePicker() {
        scrollToElementJS(datePickerMenuItem);
        click(datePickerMenuItem);
    }

    public void clickSlider() {
        scrollToElementJS(sliderMenuItem);
        click(sliderMenuItem);
    }

    public void clickProgressBar() {
        scrollToElementJS(progressBarMenuItem);
        click(progressBarMenuItem);
    }

    public void clickTabs() {
        scrollToElementJS(selectTabs);
        click(selectTabs);
    }

    public void clickToolTips() {
        scrollToElementJS(selectToolTips);
        click(selectToolTips);
    }

    public void clickMenu() {
        scrollToElementJS(selectMenu);
        click(selectMenu);
    }

    public void clickSelectMenu() {
        scrollToElementJS(selectSelectMenu);
        click(selectSelectMenu);
    }
}
