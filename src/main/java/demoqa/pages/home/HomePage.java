package demoqa.pages.home;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaScriptUtility;

import java.util.List;

import static utilities.StaticVariables.HOME_MENU_ITEMS;

public class HomePage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/a/img")
    private WebElement joinNow;
    @FindBy(xpath = "//div[@id='app']//h5[text()='Elements']")
    private WebElement elementsCard;
    @FindBy(xpath = "//div[@id='app']//h5[text()='Forms']")
    private WebElement formsCard;
    @FindBy(xpath = "//div[@id='app']//h5[contains(text(),'Alerts')]")
    private WebElement alertsFrameWindowsCard;
    @FindBy(xpath = "//div[@id='app']//h5[text()='Widgets']")
    private WebElement widgetsCard;
    @FindBy(xpath = "//div[@id='app']//h5[text()='Interactions']")
    private WebElement interactionsCard;
    @FindBy(xpath = "//div[@id='app']//h5[text()='Book Store Application']")
    private WebElement bookStoreApplicationCard;
    @FindBy(xpath = "(//div[@class='card-up'])")
    private List<WebElement> clickHomePageItems;
    @FindBy(xpath = "//div[contains(@class,'home-banner')]")
    private WebElement backgroundColor;
    @FindBy(xpath = "//span[contains(.,'© 2013-2020 TOOLSQA.COM | ALL RIGHTS RESERVED.')]")
    private WebElement footer;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public void clickJoinNowButton() {
        javaScriptUtility.scrollToElementJS(joinNow);
        joinNow.click();
    }

    public String getElementsText() {
        return elementsCard.getText();
    }

    public String getFormsText() {
        return formsCard.getText();
    }

    public String getAlertsFramesWindowsText() {
        return alertsFrameWindowsCard.getText();
    }

    public String getWidgetsText() {
        return widgetsCard.getText();
    }

    public String getInteractionsText() {
        return interactionsCard.getText();
    }

    public String getBookStoreApplicationText() {
        return bookStoreApplicationCard.getText();
    }

    public String getFooterText() {
        return footer.getText();
    }

    public void goToForms() {
        javaScriptUtility.scrollToElementJS(formsCard);
        formsCard.click();
    }

    public void goToInteractions() {
        javaScriptUtility.scrollToElementJS(interactionsCard);
        interactionsCard.click();
    }

    public void goToBooks() {
        javaScriptUtility.scrollToElementJS(bookStoreApplicationCard);
        bookStoreApplicationCard.click();
    }

    public void goToElements() {
        javaScriptUtility.scrollToElementJS(elementsCard);
        elementsCard.click();
    }

    public void goToWidgets() {
        javaScriptUtility.scrollToElementJS(widgetsCard);
        widgetsCard.click();
    }

    public void goToAlertsFramesWindowsCard() {
        javaScriptUtility.scrollToElementJS(alertsFrameWindowsCard);
        alertsFrameWindowsCard.click();
    }

    public void chooseHomePageMenu(String homeMenu) {
        int indexOfElement = HOME_MENU_ITEMS.indexOf(homeMenu);
        javaScriptUtility.scrollToElementJS(clickHomePageItems.getFirst());

        for (int i = 0; i < 3 && i < clickHomePageItems.size(); i++) {
            if (i == indexOfElement) {
                clickHomePageItems.get(i).click();
            }
        }
    }

    public String getBackgroundColor() {
        return backgroundColor.getCssValue("background-color");
    }

}