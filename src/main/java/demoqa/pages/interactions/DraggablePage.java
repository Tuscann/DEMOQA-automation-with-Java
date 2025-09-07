package demoqa.pages.interactions;

import demoqa.base.BasePage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.time.Duration;

public class DraggablePage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Dragabble')]")
    private WebElement pageTitle;
    @FindBy(id = "draggableExample-tab-simple")
    private WebElement simpleTabTitle;
    @FindBy(id = "dragBox")
    private WebElement simpleDragMe;
    @FindBy(id = "draggableExample-tab-axisRestriction")
    private WebElement axisRestrictedTab;
    @FindBy(id = "restrictedX")
    private WebElement axisRestrictedOnlyX;
    @FindBy(id = "restrictedY")
    private WebElement axisRestrictedOnlyY;
    @FindBy(id = "draggableExample-tab-containerRestriction")
    private WebElement containerRestrictedTab;
    @FindBy(xpath = "//div[contains(@class,'draggable ui-widget-content ui-draggable ui-draggable-handle')]")
    private WebElement containerRestrictedFirstText;
    @FindBy(xpath = "//span[contains(@class,'ui-widget-header ui-draggable ui-draggable-handle')]")
    private WebElement containerRestrictedSecondText;
    @FindBy(id = "draggableExample-tab-cursorStyle")
    private WebElement cursorStyleTab;
    @FindBy(id = "cursorCenter")
    private WebElement cursorStyleFirstText;
    @FindBy(id = "cursorTopLeft")
    private WebElement cursorStyleSecondText;
    @FindBy(id = "cursorBottom")
    private WebElement cursorStyleThirdText;

    public DraggablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getSimpleTabTitle() {
        return simpleTabTitle.getText();
    }

    public String getSimpleDragMe() {
        return simpleDragMe.getText();
    }

    public String getAxisRestrictedTab() {
        return axisRestrictedTab.getText();
    }

    public String getAxisRestrictedOnlyY() {
        return axisRestrictedOnlyY.getText();
    }

    public String getContainerRestrictedTab() {
        return containerRestrictedTab.getText();
    }

    public String getContainerRestrictedFirstText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(containerRestrictedFirstText));

        return containerRestrictedFirstText.getText();
    }

    public String getContainerRestrictedSecondText() {
        return containerRestrictedSecondText.getText();
    }

    public String getCursorStyleTab() {
        return cursorStyleTab.getText();
    }

    public String getCursorStyleSecondText() {
        return cursorStyleSecondText.getText();
    }

    public String getCursorStyleThirdText() {
        return cursorStyleThirdText.getText();
    }

    public Point getInitLocationFirstText() {
        return cursorStyleFirstText.getLocation();
    }

    public Point getInitLocationSecondText() {
        delay(300); //TODO
        return cursorStyleSecondText.getLocation();
    }

    public Point getInitLocationThirdText() {
        delay(300); //TODO
        return cursorStyleThirdText.getLocation();
    }

    public String getCursorStyleFirstText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(cursorStyleFirstText));
        return cursorStyleFirstText.getText();
    }

    public String getAxisRestrictedOnlyX() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(axisRestrictedOnlyX));
        return axisRestrictedOnlyX.getText();
    }

    public void clickSimpleTab() {
        simpleTabTitle.click();
    }

    public void clickAxisRestrictedTab() {
        axisRestrictedTab.click();
    }

    public void clickContainerRestrictedTab() {
        containerRestrictedTab.click();
    }

    public void clickCursorStyleTab() {
        cursorStyleTab.click();
    }

    public Point getInitLocation() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return simpleDragMe.getLocation();
    }

    public void dragAndDropByOnPositionDragMe(int xOffset, int yOffset) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(simpleDragMe, xOffset, yOffset).perform();
    }

    public Point getInitLocationOnlyX() {
        return axisRestrictedOnlyX.getLocation();
    }

    public Point getInitLocationOnlyY() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return axisRestrictedOnlyY.getLocation();
    }

    public void dragAndDropByOnPositionOnlyX(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(axisRestrictedOnlyX, xOffset, yOffset).perform();
    }

    public void dragAndDropByOnPositionOnlyY(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(axisRestrictedOnlyY, xOffset, yOffset).perform();
    }

    public Point getInitLocationContainedInBox() {
        return containerRestrictedFirstText.getLocation();
    }

    public void dragAndDropByOnPositionContainedBox(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(containerRestrictedFirstText, xOffset, yOffset).perform();
    }

    public Point getInitLocationContainedInParent() {
        javaScriptUtility.scrollToElementJS(containerRestrictedSecondText);
        return containerRestrictedSecondText.getLocation();
    }

    public void dragAndDropByOnPositionContainedParent(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(containerRestrictedSecondText, xOffset, yOffset).perform();
    }

    public void dragAndDropInCursorStyleFirstText(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(cursorStyleFirstText, xOffset, yOffset).perform();
    }

    public void dragAndDropInCursorStyleSecondText(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(cursorStyleSecondText, xOffset, yOffset).perform();
    }

    public void dragAndDropInCursorStyleThirdText(int xOffset, int yOffset) {
        Actions actions = new Actions(driver);
        javaScriptUtility.scrollToElementJS(cursorStyleThirdText);
        actions.dragAndDropBy(cursorStyleThirdText, xOffset, yOffset).build().perform();
    }
}
