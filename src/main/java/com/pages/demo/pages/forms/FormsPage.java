package com.pages.demo.pages.forms;

import com.pages.demo.pages.HomePage;
import org.openqa.selenium.By;

public class FormsPage extends HomePage {

    private final By practiceFormMenuItem = By.xpath("//li[@id='item-0']/span[text()='Practice Form']");

    public PracticeFormPage clickPracticeForm() {
        // scrollToElementJS(practiceFormMenuItem);
        click(practiceFormMenuItem);
        return new PracticeFormPage();
    }
}