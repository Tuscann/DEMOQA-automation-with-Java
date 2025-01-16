package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class LinksPage extends BasePage {

    private final By linksText = By.xpath("//h1[@class='text-center'][contains(.,'Links')]");
    private final By newTab = By.xpath("//strong[contains(.,'Following links will open new tab')]");
    private final By simpleLink = By.id("simpleLink");
    private final By dynamicLink = By.id("dynamicLink");
    private final By apiCallText = By.xpath("//strong[contains(.,'Following links will send an api call')]");
    private final By createdRequestLink = By.id("created");
    private final By noContentRequestLink = By.id("no-content");
    private final By movedRequestLink = By.id("moved");
    private final By badRequestLink = By.id("bad-request");
    private final By unauthorizedRequestLink = By.id("unauthorized");
    private final By forbiddenRequestLink = By.id("forbidden");
    private final By notFoundRequestLink = By.id("invalid-url");
    private final By responseLink = By.id("linkResponse");

    public LinksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLinksText() {
        return find(linksText).getText();
    }

    public String getNewTabText() {
        return find(newTab).getText();
    }

    public String getSimpleLinkText() {
        return find(simpleLink).getText();
    }

    public String getApiCallText() {
        return find(apiCallText).getText();
    }

    public String getCreatedRequestLinkText() {
        return find(createdRequestLink).getText();
    }

    public String getNoContentRequestLinkText() {
        return find(noContentRequestLink).getText();
    }

    public String getMovedRequestLinkText() {
        return find(movedRequestLink).getText();
    }

    public String getBadRequestLinkText() {
        return find(badRequestLink).getText();
    }

    public String getUnauthorizedRequestLinkText() {
        return find(unauthorizedRequestLink).getText();
    }

    public String getForbiddenRequestLinkText() {
        return find(forbiddenRequestLink).getText();
    }

    public String getNotFoundRequestLinkText() {
        return find(notFoundRequestLink).getText();
    }

    public void clickSimpleTab() {
        click(simpleLink);
    }

    public void clickDynamicLink() {
        click(dynamicLink);
    }

    public void clickBadRequestLink() {
        scrollToElementJS(badRequestLink);
        click(badRequestLink);
    }

    public void clickCreatedRequestLink() {
        scrollToElementJS(createdRequestLink);
        click(createdRequestLink);
    }

    public void clickMovedRequestLink() {
        scrollToElementJS(movedRequestLink);
        click(movedRequestLink);
    }

    public void clickNoContentRequestLink() {
        scrollToElementJS(noContentRequestLink);
        click(noContentRequestLink);
    }

    public void clickForbiddenRequestLink() {
        scrollToElementJS(forbiddenRequestLink);
        click(forbiddenRequestLink);
    }

    public void clickNotFoundRequestLink() {
        scrollToElementJS(notFoundRequestLink);
        click(notFoundRequestLink);
    }

    public void clickUnauthorizedRequestLink() {
        scrollToElementJS(unauthorizedRequestLink);
        click(unauthorizedRequestLink);
    }

    public String getResponse() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(responseLink));

        return find(responseLink).getText();
    }

    public String getUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }
}
