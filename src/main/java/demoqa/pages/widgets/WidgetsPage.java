package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaScriptUtility;

public class WidgetsPage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//li[@id='item-1']/span[text()='Auto Complete']")
    private WebElement selectAutoComplete;
    @FindBy(xpath = "//li[@id='item-2']/span[text()='Date Picker']")
    private WebElement datePickerMenuItem;
    @FindBy(xpath = "//li[@id='item-3']/span[text()='Slider']")
    private WebElement sliderMenuItem;
    @FindBy(xpath = "//li[@id='item-4']/span[text()='Progress Bar']")
    private WebElement progressBarMenuItem;
    @FindBy(xpath = "//li[@id='item-5']/span[text()='Tabs']")
    private WebElement selectTabs;
    @FindBy(xpath = "//li[@id='item-6']/span[text()='Tool Tips']")
    private WebElement selectToolTips;
    @FindBy(xpath = "//li[@id='item-7']/span[text()='Menu']")
    private WebElement selectMenu;
    @FindBy(xpath = "//li[@id='item-8']/span[text()='Select Menu']")
    private WebElement selectSelectMenu;
    @FindBy(xpath = "//li[@id='item-0']/span[text()='Accordian']")
    private WebElement selectAccordion;
    @FindBy(xpath = "//div[@class='header-text'][contains(.,'Widgets')]")
    private WebElement widgets;
    @FindBy(xpath = "//div[@class='col-12 mt-4 col-md-6'][contains(.,'Please select an item from left to start practice.')]")
    private WebElement text;

    public WidgetsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public void clickAccordion() {
        javaScriptUtility.scrollToElementJS(selectAccordion);
        selectAccordion.click();
    }

    public void clickAutoComplete() {
        javaScriptUtility.scrollToElementJS(selectAutoComplete);
        selectAutoComplete.click();
    }

    public void clickDatePicker() {
        javaScriptUtility.scrollToElementJS(datePickerMenuItem);
        datePickerMenuItem.click();
    }

    public void clickSlider() {
        javaScriptUtility.scrollToElementJS(sliderMenuItem);
        sliderMenuItem.click();
    }

    public void clickProgressBar() {
        javaScriptUtility.scrollToElementJS(progressBarMenuItem);
        progressBarMenuItem.click();
    }

    public void clickTabs() {
        javaScriptUtility.scrollToElementJS(selectTabs);
        selectTabs.click();
    }

    public void clickToolTips() {
        javaScriptUtility.scrollToElementJS(selectToolTips);
        selectToolTips.click();
    }

    public void clickMenu() {
        javaScriptUtility.scrollToElementJS(selectMenu);
        selectMenu.click();
    }

    public void clickSelectMenu() {
        javaScriptUtility.scrollToElementJS(selectSelectMenu);
        selectSelectMenu.click();
    }

    public String getMainText() {
        return text.getText();
    }

    public boolean verifyAccordionIsVisible() {
        return selectAccordion.isDisplayed();
    }

    public boolean verifyAccordionIsNotVisible() {
        return !selectAccordion.isDisplayed();
    }

    public void clickWidgetsWindows() {
        widgets.click();
    }
}
