package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoCompletePage extends BasePage {
    @FindBy(id = "autoCompleteMultipleInput")
    private WebElement multiAutoComplete;

    @FindBy(id = "autoCompleteSingleInput")
    private WebElement singleAutoComplete;

    @FindBy(xpath = "//h1[contains(.,'Auto Complete')]")
    private WebElement text;

    @FindBy(id = "autoCompleteMultiple")
    private WebElement multipleContainerText;

    @FindBy(id = "autoCompleteSingle")
    private WebElement autoCompleteSingleText;

    @FindBy(xpath = "//div[@aria-hidden='true']")
    private WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class,'value-container--has-value css-1hwfws3')]")
    private WebElement allSelectedMultiColorNames;

    public AutoCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMultipleContainerText() {
        return multipleContainerText.getText();
    }

    public String getText() {
        return text.getText();
    }

    public String getAllSelectedMultiColorNames() {
        return allSelectedMultiColorNames.getText();
    }

    public String getAutoCompleteSingleText() {
        return autoCompleteSingleText.getText();
    }

    public String getAllSingleColorNames() {
        return allSelectedMultiColorNames.getText();
    }

    public void clickCloseButton() {
        closeButton.click();
    }

    public void clickSingleAutoComplete() {
        singleAutoComplete.click();
    }

    public void multiAutoCompleteSelectColor(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.visibilityOf(multiAutoComplete))
                .sendKeys(color);
        wait.until(ExpectedConditions.visibilityOf(multiAutoComplete))
                .sendKeys(Keys.chord(Keys.ENTER));
    }

    public void singleAutoComplete(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(singleAutoComplete))
                .sendKeys(color);
        wait.until(ExpectedConditions.visibilityOf(singleAutoComplete))
                .sendKeys(Keys.chord("" + Keys.ENTER));
    }
}
