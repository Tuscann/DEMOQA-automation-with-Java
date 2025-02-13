package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabsPage extends BasePage {

    @FindBy(id = "demo-tab-what")
    private WebElement whatTab;

    @FindBy(id = "demo-tab-origin")
    private WebElement originTab;

    @FindBy(id = "demo-tab-use")
    private WebElement useTab;

    @FindBy(id = "demo-tab-more")
    private WebElement moreTab;

    @FindBy(id = "demo-tabpane-what")
    private WebElement whatTabInternalText;

    @FindBy(id = "demo-tabpane-origin")
    private WebElement originTabInternalText;

    @FindBy(id = "demo-tabpane-use")
    private WebElement useTabInternalText;

    @FindBy(xpath = "//*[contains(text(),\"Details about\")]")
    private WebElement underTitle;

    @FindBy(xpath = "//h1[contains(.,'Tabs')]")
    private WebElement tabsText;

    public TabsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTabsText() {
        return tabsText.getText();
    }

    public String getUnderTitleText() {
        return underTitle.getText();
    }

    public String getWhatTabText() {
        return whatTab.getText();
    }

    public String getOriginTabText() {
        return originTab.getText();
    }

    public String getUseTabText() {
        return useTab.getText();
    }

    public String getMoreTabText() {
        return moreTab.getText();
    }

    public String getWhatTabInternalText() {
        return whatTabInternalText.getText();
    }

    public String getOriginTabInternalText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(originTabInternalText));

        return originTabInternalText.getText();
    }

    public String getUseTabInternalText() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(useTabInternalText));

        return useTabInternalText.getText();
    }

    public void clickWhatTab() {
        whatTab.click();
    }

    public void clickOriginTab() {
        originTab.click();
    }

    public void clickUseTab() {
        useTab.click();
    }
}
