package demoqa.pages.forms;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.JavaScriptUtility;

public class FormsPage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//li[@id='item-0']/span[text()='Practice Form']")
    WebElement practiceFormMenuItem;
    @FindBy(xpath = "(//div[contains(.,'Please select an item from left to start practice.')])[5]")
    WebElement text;

    public FormsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getText() {
        return text.getText();
    }

    public void clickPracticeFormLink() {
        javaScriptUtility.scrollToElementJS(practiceFormMenuItem);
        practiceFormMenuItem.click();
    }
}