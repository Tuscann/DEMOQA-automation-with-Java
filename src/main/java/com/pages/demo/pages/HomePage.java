package com.pages.demo.pages;

import com.pages.base.BasePage;
import com.pages.demo.pages.bookStoreApplication.BooksPage;
import com.pages.demo.pages.elements.ElementsPage;
import com.pages.demo.pages.forms.FormsPage;
import com.pages.demo.pages.widgets.WidgetsPage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class HomePage extends BasePage {

    private final By formsCard = By.xpath("//div[@id='app']//h5[text()='Forms']");
    private final By elementsCard = By.xpath("//div[@id='app']//h5[text()='Elements']");
    private final By widgetsCard = By.xpath("//div[@id='app']//h5[text()='Widgets']");
    private final By booksCard = By.xpath("//div[@id='app']//h5[text()='Book Store Application']");
    private final By alertsFrameWindowsCard = By.xpath("//div[@id='app']//h5[contains(text(),'Alerts')]");

    public FormsPage goToForms() {
        scrollToElementJS(widgetsCard);
        click(formsCard);
        return new FormsPage();
    }

    public BooksPage goToBooks() {
        //  scrollToElementJS(booksCard);
        click(booksCard);
        return new BooksPage();
    }

    public ElementsPage goToElements() {
        scrollToElementJS(elementsCard);
        click(elementsCard);
        return new ElementsPage();
    }

    public WidgetsPage goToWidgets() {
        scrollToElementJS(widgetsCard);
        click(widgetsCard);
        return new WidgetsPage();
    }

//    public Alerts_Frames_WindowsPage goToAlertsFramesWindowsCard() {
//        scrollToElementJS(alertsFrameWindowsCard);
//        click(alertsFrameWindowsCard);
//        return new Alerts_Frames_WindowsPage();
//    }
}
