package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends BasePage {

    private final By header = By.xpath(" //h1[@class='text-center'][contains(.,'Menu')]");
    private final By mainItem1 = By.xpath("//a[@href='#'][contains(.,'Main Item 1')]");
    private final By mainItem2 = By.xpath("//a[@href='#'][contains(.,'Main Item 2')]");
    private final By mainItem3 = By.xpath("//a[@href='#'][contains(.,'Main Item 3')]");

    private final By mainItem2SubItem1 = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[1]");
    private final By mainItem2SubItem2 = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[2]");
    private final By mainItem2SubItem3 = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/a");

    private final By mainItem2SubSubListSubSubItem1 = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[1]");
    private final By mainItem2SubSubListSubSubItem2 = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]/ul/li[2]");

    private final By mainItemFirstLi = By.xpath("//*[@id=\"nav\"]/li[1]");
    private final By mainItemSecondLi = By.xpath("//*[@id=\"nav\"]/li[2]");
    private final By mainItemThirdLi = By.xpath("//*[@id=\"nav\"]/li[3]");
    private final By subSub = By.xpath("//*[@id=\"nav\"]/li[2]/ul/li[3]");


    public void selectMainItem1() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem1 = driver.findElement(mainItem1);
        actions.moveToElement(selectedMainItem1).perform();
    }

    public void selectMainItem2() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem2 = driver.findElement(mainItem2);
        actions.moveToElement(selectedMainItem2).perform();
    }

    public void selectMainItem2SubSubList() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem2 = driver.findElement(mainItem2);
        actions.moveToElement(selectedMainItem2).perform();

        WebElement subSubList2Item = driver.findElement(subSub);
        actions.moveToElement(subSubList2Item).perform();
    }

    public String takeBackgroundColorMainItem1() {
        return find(mainItemFirstLi).getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2() {
        return find(mainItemSecondLi).getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubSubsLIst() {
        return find(subSub).getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubSubsLIstSubSubItem1() {
        return find(mainItem2SubSubListSubSubItem1).getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubSubsLIstSubSubItem2() {
        return find(mainItem2SubSubListSubSubItem2).getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem3() {
        return find(mainItemThirdLi).getCssValue("background-color");
    }

    public void selectMainItem3() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem3 = driver.findElement(mainItem3);
        actions.moveToElement(selectedMainItem3).perform();
    }

    public void selectMainItem2SubSubsLIstSubSubItem1() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem2 = driver.findElement(mainItem2);
        actions.moveToElement(selectedMainItem2).perform();

        WebElement subSubList2Item = driver.findElement(subSub);
        actions.moveToElement(subSubList2Item).perform();

        WebElement subSubList2ItemSubSubItem1 = driver.findElement(mainItem2SubSubListSubSubItem1);
        actions.moveToElement(subSubList2ItemSubSubItem1).perform();
    }


    public void selectMainItem2SubSubsLIstSubSubItem2() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem2 = driver.findElement(mainItem2);
        actions.moveToElement(selectedMainItem2).perform();

        WebElement subSubList2Item = driver.findElement(subSub);
        actions.moveToElement(subSubList2Item).perform();

        WebElement subSubList2ItemSubSubItem1 = driver.findElement(mainItem2SubSubListSubSubItem2);
        actions.moveToElement(subSubList2ItemSubSubItem1).perform();
    }

    public String takeBackgroundColorMainItem2SubItem1() {
        return find(mainItem2SubItem1).getCssValue("background-color");
    }

    public String takeBackgroundColorMainItem2SubItem2() {
        return find(mainItem2SubItem2).getCssValue("background-color");
    }

    public void selectMainItem2SubItem1() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem2 = driver.findElement(mainItem2);
        actions.moveToElement(selectedMainItem2).perform();

        WebElement mainItem2SubItem1Element = driver.findElement(mainItem2SubItem1);
        actions.moveToElement(mainItem2SubItem1Element).perform();
    }

    public void selectMainItem2SubItem2() {
        Actions actions = new Actions(driver);

        WebElement selectedMainItem2 = driver.findElement(mainItem2);
        actions.moveToElement(selectedMainItem2).perform();

        WebElement mainItem2SubItem2Element = driver.findElement(mainItem2SubItem2);
        actions.moveToElement(mainItem2SubItem2Element).perform();
    }

    public String getHeaderText() {
        return find(header).getText();
    }

    public String getMainItem1() {
        return find(mainItem1).getText();
    }

    public String getMainItem2() {
        return find(mainItem2).getText();
    }

    public String getMainItem3() {
        return find(mainItem3).getText();
    }

    public String getMainItem2SubItem1() {
        return find(mainItem2SubItem1).getText();
    }

    public String getMainItem2SubItem2() {
        return find(mainItem2SubItem2).getText();
    }

    public String getMainItem2SubSubList() {
        return find(mainItem2SubItem3).getText();
    }

    public String getMainItem2SubSubListSubItem1() {
        return find(mainItem2SubSubListSubSubItem1).getText();
    }

    public String getMainItem2SubSubListSubItem2() {
        return find(mainItem2SubSubListSubSubItem2).getText();
    }
}
