package com.pages.demo.pages.widgets;

import org.openqa.selenium.By;


public class TabsPage extends WidgetsPage {

    private final By tabs = By.xpath("//*[contains(@href,\"#\")]");
    private final By underTitle = By.xpath("//*[contains(text(),\"Details about\")]");
    private final By assertText = By.className("mt-3");

    public String getUnderTitle() {
        return find(underTitle).getText();
    }


}
