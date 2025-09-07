package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Menu')]")
    private WebElement header;
    @FindBy(xpath = "//a[@href='#'][contains(.,'Main Item 1')]")
    private WebElement mainItem1;
    @FindBy(xpath = "//a[@href='#'][contains(.,'Main Item 2')]")
    private WebElement mainItem2;
    @FindBy(xpath = "//a[@href='#'][contains(.,'Main Item 3')]")
    private WebElement mainItem3;
    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[1]")
    private WebElement mainItem2SubItem1;
    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[2]")
    private WebElement mainItem2SubItem2;
    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]/a")
    private WebElement mainItem2SubItem3;
    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]/ul/li[1]")
    private WebElement mainItem2SubSubListSubSubItem1;
    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]/ul/li[2]")
    private WebElement mainItem2SubSubListSubSubItem2;
    @FindBy(xpath = "//*[@id='nav']/li[1]")
    private WebElement mainItemFirstLi;
    @FindBy(xpath = "//*[@id='nav']/li[2]")
    private WebElement mainItemSecondLi;
    @FindBy(xpath = "//*[@id='nav']/li[3]")
    private WebElement mainItemThirdLi;
    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]")
    private WebElement subSub;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectMainItem1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem1).perform();
    }

    public void selectMainItem2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
    }

    public void selectMainItem2SubSubList() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        actions.moveToElement(subSub).perform();
    }

    public String takeBackgroundColorMainItem1() {
        return mainItemFirstLi.getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2() {
        return mainItemSecondLi.getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubSubsLIst() {
        return subSub.getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubSubsLIstSubSubItem1() {
        return mainItem2SubSubListSubSubItem1.getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubSubsLIstSubSubItem2() {
        return mainItem2SubSubListSubSubItem2.getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem3() {
        return mainItemThirdLi.getCssValue("background-color");
    }

    public void selectMainItem3() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem3).perform();
    }

    public void selectMainItem2SubSubsLIstSubSubItem1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        actions.moveToElement(subSub).perform();
        actions.moveToElement(mainItem2SubSubListSubSubItem1).perform();
    }

    public void selectMainItem2SubSubsLIstSubSubItem2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        actions.moveToElement(subSub).perform();
        actions.moveToElement(mainItem2SubSubListSubSubItem2).perform();
    }

    public String takeBackgroundColorMainItem2SubItem1() {
        return mainItem2SubItem1.getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubItem2() {
        return mainItem2SubItem2.getCssValue("background-color");
    }

    public void selectMainItem2SubItem1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        actions.moveToElement(mainItem2SubItem1).perform();
    }

    public void selectMainItem2SubItem2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform();
        actions.moveToElement(mainItem2SubItem2).perform();
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getMainItem1() {
        return mainItem1.getText();
    }

    public String getMainItem2() {
        return mainItem2.getText();
    }

    public String getMainItem3() {
        return mainItem3.getText();
    }

    public String getMainItem2SubItem1() {
        return mainItem2SubItem1.getText();
    }

    public String getMainItem2SubItem2() {
        return mainItem2SubItem2.getText();
    }

    public String getMainItem2SubSubList() {
        return mainItem2SubItem3.getText();
    }

    public String getMainItem2SubSubListSubItem1() {
        return mainItem2SubSubListSubSubItem1.getText();
    }

    public String getMainItem2SubSubListSubItem2() {
        return mainItem2SubSubListSubSubItem2.getText();
    }
}
