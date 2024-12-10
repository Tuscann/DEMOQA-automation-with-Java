package com.pages.demo.pages.forms;

import com.pages.demo.pages.HomePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class FormsPage extends HomePage {

    private final By practiceFormMenuItem = By.xpath("//li[@id='item-0']/span[text()='Practice Form']");

    private final By text = By.xpath("(//div[contains(.,'Please select an item from left to start practice.')])[5]");

    // homePage.goToCard("Forms");

    public PracticeFormPage clickPracticeForm() {
        scrollToElementJS(practiceFormMenuItem);
        click(practiceFormMenuItem);
        return new PracticeFormPage();
    }

    public String getText() {
        return find(text).getText();
    }
}