package demoqa.pages.alerts;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ModalDialogsPage extends BasePage {

    private final By smallModalButton = By.id("showSmallModal");
    private final By largeModalButton = By.id("showLargeModal");
    private final By smallModalTextHeader = By.id("example-modal-sizes-title-sm");
    private final By smallModalText = By.xpath("//div[contains(text(),'small modal')]");
    private final By largeModalText = By.xpath("/html/body/div[4]/div/div/div[2]/p");
    private final By largeModalHeaderText = By.id("example-modal-sizes-title-lg");


    private final By smallCloseButton = By.id("closeSmallModal");
    private final By largeCloseButton = By.id("closeLargeModal");
    private final By closeButton = By.xpath("(//button[@type='button'][contains(.,'Close')])[2]");

    private final By modalDialogsText = By.xpath("//h1[@class='text-center'][contains(.,'Modal Dialogs')]");
    private final By clickText = By.xpath("(//div[contains(.,'Click on button to see modal')])[8]");
    private final By smallText = By.id("showSmallModal");
    private final By largeText = By.id("showLargeModal");

    public void clickSmallModalButton() {
        click(smallModalButton);
    }

    public void clickLargeModalButton() {
        click(largeModalButton);
    }

    public String getClickText() {
        return find(clickText).getText();
    }

    public String getSmallText() {
        return find(smallText).getText();
    }

    public String getLargeText() {
        return find(largeText).getText();
    }

    public String getModalDialogsText() {
        return find(modalDialogsText).getText();
    }

    public String getSmallModalText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.smallModalText));
        return find(smallModalText).getText();
    }

    public String getLargeModalText() {
        return find(largeModalText).getText();
    }

    public String getLargeModalHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.largeModalHeaderText));
        return find(largeModalHeaderText).getText();
    }

    public void clickCloseButton() {
        click(closeButton);
    }

    public String getLargeCloseButtonText() {
        return find(largeCloseButton).getText();
    }

    public String getSmallCloseButtonText() {
        return find(smallCloseButton).getText();
    }

    public String getSmallModalHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.smallModalTextHeader));
        return find(smallModalTextHeader).getText();
    }
}
