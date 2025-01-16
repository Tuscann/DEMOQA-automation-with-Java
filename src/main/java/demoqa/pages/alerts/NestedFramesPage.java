package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage extends BasePage {

    @FindBy(id = "frame1")
    WebElement parentIframe;
    @FindBy(xpath = "//*[text()=\"Parent frame\"]")
    WebElement parentIframeText;
    @FindBy(xpath = "//body/p")
    WebElement childIframeText;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Nested Frames')]")
    WebElement headingText;
    @FindBy(xpath = "//*[contains(text(),\"Sample\")]")
    WebElement mainText;

    public NestedFramesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMainText() {
        return mainText.getText();
    }

    public String getChildIframeText() {
        return childIframeText.getText();
    }

    public String getParentIframeText() {
        return parentIframeText.getText();
    }

    public String getHeadingText() {
        return headingText.getText();
    }

    public void selectParentIframe() {
        driver.switchTo().frame(parentIframe);
    }

    public void selectChildIframe() {
        driver.switchTo().frame(parentIframe).switchTo().frame(0);
    }
}
