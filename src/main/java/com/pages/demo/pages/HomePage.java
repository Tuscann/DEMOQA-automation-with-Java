package com.pages.demo.pages;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.pages.demo.pages.staticvariables.StaticVariables.HOME_MENU_ITEMS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    private final By elementsCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private final By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private final By alertsFrameWindowsCard = By.xpath("//div[@id='app']//h5[contains(text(),'Alerts')]");
    private final By widgetsCard = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private final By interactionsCard = By.xpath("//div[@id='app']//h5[text()='Interactions']");
    private final By bookStoreApplicationCard = By.xpath("//div[@id='app']//h5[text()='Book Store Application']");

    private final By clickHomePageItem = By.xpath("(//div[@class='card-up'])");
    private final By footer = By.xpath("//span[contains(.,'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]");

    public String getElementsText() {
        return find(elementsCard).getText();
    }

    public String getFormsText() {
        return find(formsCard).getText();
    }

    public String getAlertsText() {
        return find(alertsFrameWindowsCard).getText();
    }

    public String getWidgetsText() {
        return find(widgetsCard).getText();
    }

    public String getInteractionsText() {
        return find(interactionsCard).getText();
    }

    public String getBookStoreApplicationText() {
        return find(bookStoreApplicationCard).getText();
    }

    public String getFooterText() {
        return find(footer).getText();
    }

    public void goToForms() {
        scrollToElementJS(formsCard);
        click(formsCard);
    }

    public void goToInteractions() {
        scrollToElementJS(interactionsCard);
        click(interactionsCard);
    }

    public void goToBooks() {
        scrollToElementJS(bookStoreApplicationCard);
        click(bookStoreApplicationCard);
    }

    public void chooseHomePageMenu(String homeMenu) {

        int indexOfElement = HOME_MENU_ITEMS.indexOf(homeMenu);
        scrollToElementJS(clickHomePageItem);

        List<WebElement> elements = driver.findElements(clickHomePageItem);

        for (int i = 0; i < 3 && i < elements.size(); i++) {

            if (i == indexOfElement) {
                elements.get(i).click();
            }
        }
    }

    public void goToElements() {
        scrollToElementJS(elementsCard);
        click(elementsCard);
    }

    public void goToWidgets() {
        scrollToElementJS(widgetsCard);
        click(widgetsCard);
    }

    public void goToAlertsFramesWindowsCard() {
        scrollToElementJS(alertsFrameWindowsCard);
        click(alertsFrameWindowsCard);
    }

    public void navigateBack() {
        driver.navigate().back();
    }
}
