package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabsPage extends BasePage {

    private final By whatTab = By.id("demo-tab-what");
    private final By originTab = By.id("demo-tab-origin");
    private final By useTab = By.id("demo-tab-use");
    private final By moreTab = By.id("demo-tab-more");

    private final By whatTabInternalText = By.id("demo-tabpane-what");
    private final By originTabInternalText = By.id("demo-tabpane-origin");
    private final By useTabInternalText = By.id("demo-tabpane-use");

    private final By underTitle = By.xpath("//*[contains(text(),\"Details about\")]");
    private final By tabsText = By.xpath("//h1[contains(.,'Tabs')]");

    public String getTabsText() {
        return find(tabsText).getText();
    }

    public String getUnderTitleText() {
        return find(underTitle).getText();
    }

    public String getWhatTabText() {
        return find(whatTab).getText();
    }

    public String getOriginTabText() {
        return find(originTab).getText();
    }

    public String getUseTabText() {
        return find(useTab).getText();
    }

    public String getMoreTabText() {
        return find(moreTab).getText();
    }

    public String getWhatTabInternalText() {
        return find(whatTabInternalText).getText();
    }

    public String getOriginTabInternalText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(originTabInternalText));

        return find(originTabInternalText).getText();
    }

    public String getUseTabInternalText() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(useTabInternalText));

        return find(useTabInternalText).getText();
    }

    public void clickWhatTab() {
        find(whatTab).click();
    }

    public void clickOriginTab() {
        find(originTab).click();
    }

    public void clickUseTab() {
        find(useTab).click();
    }

}
