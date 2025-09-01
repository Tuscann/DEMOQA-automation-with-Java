package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.JavaScriptUtility;

public class BrokenLinksImagesPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Broken Links - Images')]")
    WebElement headerText;
    @FindBy(xpath = "//p[contains(.,'Valid image')]")
    WebElement validImageText;
    @FindBy(xpath = "//p[contains(.,'Broken image')]")
    WebElement brokenImageText;
    @FindBy(xpath = "//p[contains(.,'Valid Link')]")
    WebElement validLinkText;
    @FindBy(xpath = "//p[contains(.,'Broken Link')]")
    WebElement brokenLinkText;
    @FindBy(xpath = "//a[contains(.,'Click Here for Valid Link')]")
    WebElement clickHereValidLinkText;
    @FindBy(xpath = "//a[contains(.,'Click Here for Broken Link')]")
    WebElement clickHereBrokenLinkText;

    private final JavaScriptUtility javaScriptUtility;

    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getHeaderText() {
        return headerText.getText();
    }

    public String getValidImageText() {
        return validImageText.getText();
    }

    public String getBrokenImageText() {
        return brokenImageText.getText();
    }

    public String getValidLinkText() {
        return validLinkText.getText();
    }

    public String getBrokenLinkText() {
        return brokenLinkText.getText();
    }

    public String getClickHereValidLinkText() {
        return clickHereValidLinkText.getText();
    }

    public String getClickHereBrokenLinkText() {
        return clickHereBrokenLinkText.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickOnClickHereForValidLink() {
        javaScriptUtility.scrollToElementJS(clickHereValidLinkText);
        clickHereValidLinkText.click();
    }

    public void clickOnClickHereForBrokenLink() {
        javaScriptUtility.scrollToElementJS(clickHereBrokenLinkText);
        clickHereBrokenLinkText.click();
    }
}
