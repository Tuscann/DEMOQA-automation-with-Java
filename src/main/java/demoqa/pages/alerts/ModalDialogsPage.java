package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalDialogsPage extends BasePage {

    @FindBy(id = "showSmallModal")
    WebElement smallModalButton;
    @FindBy(id = "showLargeModal")
    WebElement largeModalButton;
    @FindBy(id = "example-modal-sizes-title-sm")
    WebElement smallModalTextHeader;
    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement largeModalHeaderText;
    @FindBy(xpath = "//div[contains(text(),'small modal')]")
    WebElement smallModalText;
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/p")
    WebElement largeModalText;
    @FindBy(id = "closeSmallModal")
    WebElement smallCloseButton;
    @FindBy(id = "closeLargeModal")
    WebElement largeCloseButton;
    @FindBy(xpath = "(//button[@type='button'][contains(.,'Close')])[2]")
    WebElement closeButton;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Modal Dialogs')]")
    WebElement modalDialogsText;
    @FindBy(xpath = "(//div[contains(.,'Click on button to see modal')])[8]")
    WebElement clickText;
    @FindBy(id = "showSmallModal")
    WebElement smallText;
    @FindBy(id = "showLargeModal")
    WebElement largeText;
    @FindBy(xpath = "//span[contains(@aria-hidden,'true')]")
    WebElement clickXCLoseButton;


    public ModalDialogsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getClickText() {
        return clickText.getText();
    }

    public String getSmallModalButtonText() {
        return smallText.getText();
    }

    public String getLargeModalButtonText() {
        return largeText.getText();
    }

    public String getModalDialogsText() {
        return modalDialogsText.getText();
    }

    public String getLargeModalText() {
        return largeModalText.getText();
    }

    public String getLargeCloseButtonText() {
        return largeCloseButton.getText();
    }

    public String getSmallCloseButtonText() {
        return smallCloseButton.getText();
    }

    public void clickSmallModalButton() {
        smallModalButton.click();
    }

    public void clickLargeModalButton() {
        largeModalButton.click();
    }

    public String getSmallModalText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(smallModalText));
        return smallModalText.getText();
    }

    public String getLargeModalHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(largeModalHeaderText));
        return largeModalHeaderText.getText();
    }

    public String getSmallModalHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(smallModalTextHeader));
        return smallModalTextHeader.getText();
    }

    public String getSmallModalDialogsBackgroundColor() {
        return smallModalButton.getCssValue("background-color");
    }

    public String getLargeModalDialogsBackgroundColor() {
        return largeModalButton.getCssValue("background-color");
    }

    public String getLargeModalDialogCloseButtonBackgroundColor() {
        return largeCloseButton.getCssValue("background-color");
    }

    public String getSmallModalDialogCloseButtonBackgroundColor() {
        return smallCloseButton.getCssValue("background-color");
    }

    public void clickXSmallModalCloseButton() {
        clickXCLoseButton.click();
    }

    public void clickSmallModalCloseButton() {
        smallCloseButton.click();
    }

    public void clickLargeCloseButton() {
        largeCloseButton.click();
    }
}
