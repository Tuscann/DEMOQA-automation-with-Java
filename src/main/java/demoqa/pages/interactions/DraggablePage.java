package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DraggablePage extends BasePage {

    private final By pageTitle = By.xpath("//h1[@class='text-center'][contains(.,'Dragabble')]");
    private final By simpleTabTitle = By.id("draggableExample-tab-simple");
    private final By simpleDragMe = By.id("dragBox");
    private final By axisRestrictedTab = By.id("draggableExample-tab-axisRestriction");
    private final By axisRestrictedOnlyX = By.id("restrictedX");
    private final By axisRestrictedOnlyY = By.id("restrictedY");
    private final By containerRestrictedTab = By.id("draggableExample-tab-containerRestriction");
    private final By containerRestrictedFirstText = By.xpath("//div[contains(@class,'draggable ui-widget-content ui-draggable ui-draggable-handle')]");
    private final By containerRestrictedSecondText = By.xpath("//span[contains(@class,'ui-widget-header ui-draggable ui-draggable-handle')]");
    private final By cursorStyleTab = By.id("draggableExample-tab-cursorStyle");
    private final By cursorStyleFirstText = By.id("cursorCenter");
    private final By cursorStyleSecondText = By.id("cursorTopLeft");
    private final By cursorStyleThirdText = By.id("cursorBottom");

    public DraggablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return find(pageTitle).getText();
    }

    public String getSimpleTabTitle() {
        return find(simpleTabTitle).getText();
    }

    public String getSimpleDragMe() {
        return find(simpleDragMe).getText();
    }

    public String getAxisRestrictedTab() {
        return find(axisRestrictedTab).getText();
    }

    public String getAxisRestrictedOnlyY() {
        return find(axisRestrictedOnlyY).getText();
    }

    public String getContainerRestrictedTab() {
        return find(containerRestrictedTab).getText();
    }

    public String getContainerRestrictedFirstText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(containerRestrictedFirstText));

        return find(containerRestrictedFirstText).getText();
    }

    public String getContainerRestrictedSecondText() {
        return find(containerRestrictedSecondText).getText();
    }

    public String getCursorStyleTab() {
        return find(cursorStyleTab).getText();
    }

    public String getCursorStyleSecondText() {
        return find(cursorStyleSecondText).getText();
    }

    public String getCursorStyleThirdText() {
        return find(cursorStyleThirdText).getText();
    }

    public Point getInitLocationFirstText() {
        return driver.findElement(cursorStyleFirstText).getLocation();
    }

    public Point getInitLocationSecondText() {
        return driver.findElement(cursorStyleSecondText).getLocation();
    }

    public Point getInitLocationThirdText() {
        delay(300); //TODO
        return driver.findElement(cursorStyleThirdText).getLocation();
    }

    public String getCursorStyleFirstText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(cursorStyleFirstText));
        return find(cursorStyleFirstText).getText();
    }

    public String getAxisRestrictedOnlyX() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(axisRestrictedOnlyX));
        return find(axisRestrictedOnlyX).getText();
    }

    public void clickSimpleTab() {
        click(simpleTabTitle);
    }

    public void clickAxisRestrictedTab() {
        click(axisRestrictedTab);
    }

    public void clickContainerRestrictedTab() {
        click(containerRestrictedTab);
    }

    public void clickCursorStyleTab() {
        click(cursorStyleTab);
    }

    public Point getInitLocation() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement draggable = driver.findElement(simpleDragMe);

        return draggable.getLocation();
    }

    public void dragAndDropByOnPositionDragMe(int xOffset, int yOffset) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement draggable = driver.findElement(simpleDragMe);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public Point getInitLocationOnlyX() {
        WebElement draggable = driver.findElement(axisRestrictedOnlyX);

        return draggable.getLocation();
    }

    public Point getInitLocationOnlyY() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement draggable = driver.findElement(axisRestrictedOnlyY);

        return draggable.getLocation();
    }

    public void dragAndDropByOnPositionOnlyX(int xOffset, int yOffset) {
        WebElement draggable = driver.findElement(axisRestrictedOnlyX);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public void dragAndDropByOnPositionOnlyY(int xOffset, int yOffset) {
        WebElement draggable = driver.findElement(axisRestrictedOnlyY);
        Actions actions = new Actions(driver);

        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public Point getInitLocationContainedInBox() {
        WebElement draggable = driver.findElement(containerRestrictedFirstText);

        return draggable.getLocation();
    }

    public void dragAndDropByOnPositionContainedBox(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(containerRestrictedFirstText);
        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public Point getInitLocationContainedInParent() {
        WebElement draggable = driver.findElement(containerRestrictedSecondText);

        return draggable.getLocation();
    }

    public void dragAndDropByOnPositionContainedParent(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        WebElement draggable = driver.findElement(containerRestrictedSecondText);
        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public void dragAndDropInCursorStyleFirstText(int xOffset, int yOffset) {
        WebElement draggable = driver.findElement(cursorStyleFirstText);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public void dragAndDropInCursorStyleSecondText(int xOffset, int yOffset) {
        WebElement draggable = driver.findElement(cursorStyleSecondText);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public void dragAndDropInCursorStyleThirdText(int xOffset, int yOffset) {
        WebElement draggable = driver.findElement(cursorStyleThirdText);

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(draggable, xOffset, yOffset).build().perform();
    }
}
