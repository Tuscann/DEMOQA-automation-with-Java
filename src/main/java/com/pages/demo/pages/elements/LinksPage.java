package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class LinksPage extends BasePage {

    private final By newTabHome = By.id("simpleLink");
    private final By createdRequestLink = By.id("created");
    private final By noContentRequestLink = By.id("no-content");
    private final By movedRequestLink = By.id("moved");
    private final By badRequestLink = By.id("bad-request");
    private final By unauthorizedRequestLink = By.id("unauthorized");
    private final By forbiddenRequestLink = By.id("forbidden");
    private final By notFoundRequestLink = By.id("invalid-url");
    private final By responseLink = By.id("linkResponse");

    public void clickNewHomeTab() {
        click(newTabHome);
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
        delay(500); //TODO
        return find(responseLink).getText();
    }

    public String getUrl() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return driver.getCurrentUrl();
    }
}
