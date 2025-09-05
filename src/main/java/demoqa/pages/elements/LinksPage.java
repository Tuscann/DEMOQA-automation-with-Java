package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.time.Duration;
import java.util.ArrayList;

public class LinksPage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Links')]")
    private WebElement linksText;
    @FindBy(xpath = "//strong[contains(.,'Following links will open new tab')]")
    private WebElement newTab;
    @FindBy(id = "simpleLink")
    private WebElement simpleLink;
    @FindBy(id = "dynamicLink")
    private WebElement dynamicLink;
    @FindBy(xpath = "//strong[contains(.,'Following links will send an api call')]")
    private WebElement apiCallText;
    @FindBy(id = "created")
    private WebElement createdRequestLink;
    @FindBy(id = "no-content")
    private WebElement noContentRequestLink;
    @FindBy(id = "moved")
    private WebElement movedRequestLink;
    @FindBy(id = "bad-request")
    private WebElement badRequestLink;
    @FindBy(id = "unauthorized")
    private WebElement unauthorizedRequestLink;
    @FindBy(id = "forbidden")
    private WebElement forbiddenRequestLink;
    @FindBy(id = "invalid-url")
    private WebElement notFoundRequestLink;
    @FindBy(id = "linkResponse")
    private WebElement responseLink;

    public LinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getLinksText() {
        return linksText.getText();
    }

    public String getNewTabText() {
        return newTab.getText();
    }

    public String getSimpleLinkText() {
        return simpleLink.getText();
    }

    public String getApiCallText() {
        return apiCallText.getText();
    }

    public String getCreatedRequestLinkText() {
        return createdRequestLink.getText();
    }

    public String getNoContentRequestLinkText() {
        return noContentRequestLink.getText();
    }

    public String getMovedRequestLinkText() {
        return movedRequestLink.getText();
    }

    public String getBadRequestLinkText() {
        return badRequestLink.getText();
    }

    public String getUnauthorizedRequestLinkText() {
        return unauthorizedRequestLink.getText();
    }

    public String getForbiddenRequestLinkText() {
        return forbiddenRequestLink.getText();
    }

    public String getNotFoundRequestLinkText() {
        return notFoundRequestLink.getText();
    }

    public void clickSimpleLinkHome() {
        javaScriptUtility.scrollToElementJS(simpleLink);
        simpleLink.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void clickDynamicLinkHome() {
        javaScriptUtility.scrollToElementJS(dynamicLink);
        dynamicLink.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void clickCreatedLink() {
        javaScriptUtility.scrollToElementJS(createdRequestLink);
        createdRequestLink.click();
    }

    public void clickNoContentRequestLink() {
        javaScriptUtility.scrollToElementJS(noContentRequestLink);
        noContentRequestLink.click();
    }

    public void clickMovedLink() {
        javaScriptUtility.scrollToElementJS(movedRequestLink);
        movedRequestLink.click();
    }

    public void clickBadRequestLink() {
        javaScriptUtility.scrollToElementJS(badRequestLink);
        badRequestLink.click();
    }

    public void clickUnauthorizedLink() {
        javaScriptUtility.scrollToElementJS(unauthorizedRequestLink);
        unauthorizedRequestLink.click();
    }

    public void clickForbiddenLink() {
        javaScriptUtility.scrollToElementJS(forbiddenRequestLink);
        forbiddenRequestLink.click();
    }

    public void clickNotFoundLink() {
        javaScriptUtility.scrollToElementJS(notFoundRequestLink);
        notFoundRequestLink.click();
    }

    public String getResponse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(responseLink));
        delay(100);
        return responseLink.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public int getDynamicLinkTextLength() {
        return dynamicLink.getText().length();
    }
}
