package com.pages.demo.pages.widgets;

import com.pages.demo.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WidgetsPage extends HomePage {
    private final By selectAccordian = By.xpath("//li[@id='item-0']/span[text()='Accordian']");
    private final By selectAutoComplete = By.xpath("//li[@id='item-1']/span[text()='Auto Complete']");
    private final By datePickerMenuItem = By.xpath("//li[@id='item-2']/span[text()='Date Picker']");
    private final By sliderMenuItem = By.xpath("//li[@id='item-3']/span[text()='Slider']");
    private final By progressBarMenuItem = By.xpath("//li[@id='item-4']/span[text()='Progress Bar']");
    private final By selectTabs = By.xpath("//li[@id='item-5']/span[text()='Tabs']");
    private final By selectToolTips = By.xpath("//li[@id='item-6']/span[text()='Tool Tips']");
    private final By selectMenu = By.xpath("//li[@id='item-7']/span[text()='Menu']");
    private final By selectSelectMenu = By.xpath("//li[@id='item-8']/span[text()='Select Menu']");


    public AccordianPage clickAccordian() {
        scrollToElementJS(selectAccordian);
        click(selectAccordian);
        return new AccordianPage();
    }

    public SliderPage clickSlider() {
        scrollToElementJS(sliderMenuItem);
        click(sliderMenuItem);
        return new SliderPage();
    }

    public ProgressBarPage clickProgressBar() {
        scrollToElementJS(progressBarMenuItem);
        click(progressBarMenuItem);
        return new ProgressBarPage();
    }

    public SelectMenuPage clickSelectMenu() {
        scrollToElementJS(selectSelectMenu);
        click(selectSelectMenu);
        return new SelectMenuPage();
    }

    public DatePickerMenuPage clickDatePicker() {
        scrollToElementJS(datePickerMenuItem);
        click(datePickerMenuItem);
        return new DatePickerMenuPage();
    }
}
