package com.pages.demo.pages;

import com.pages.base.BasePage;
import com.pages.demo.pages.alerts_frames_windows.Alerts_Frames_WindowsPage;
import com.pages.demo.pages.bookStoreApplication.BooksPage;
import com.pages.demo.pages.elements.ElementsPage;
import com.pages.demo.pages.forms.FormsPage;
import com.pages.demo.pages.widgets.WidgetsPage;
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


    public FormsPage goToForms() {
        scrollToElementJS(widgetsCard);
        click(formsCard);
        return new FormsPage();
    }

    public BooksPage goToBooks() {
        scrollToElementJS(bookStoreApplicationCard);
        click(bookStoreApplicationCard);
        return new BooksPage();
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
        var xddd = 12;


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

    public Alerts_Frames_WindowsPage goToAlertsFramesWindowsCard() {
        scrollToElementJS(alertsFrameWindowsCard);
        click(alertsFrameWindowsCard);
        return new Alerts_Frames_WindowsPage();
    }
}
