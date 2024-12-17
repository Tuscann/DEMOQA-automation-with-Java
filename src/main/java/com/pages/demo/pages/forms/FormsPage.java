package com.pages.demo.pages.forms;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class FormsPage extends BasePage {

    private final By practiceFormMenuItem = By.xpath("//li[@id='item-0']/span[text()='Practice Form']");

    private final By text = By.xpath("(//div[contains(.,'Please select an item from left to start practice.')])[5]");

    public void clickPracticeForm() {
        scrollToElementJS(practiceFormMenuItem);
        click(practiceFormMenuItem);
    }

    public String getText() {
        return find(text).getText();
    }

}