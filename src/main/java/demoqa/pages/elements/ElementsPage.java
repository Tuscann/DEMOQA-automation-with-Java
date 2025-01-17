package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class ElementsPage extends BasePage {

    @FindBy(xpath = "//li[@id='item-0']/span[text()='Text Box']")
    private WebElement textBox;

    @FindBy(xpath = "//li[@id='item-1']/span[text()='Check Box']")
    private WebElement checkBox;

    @FindBy(xpath = "//li[@id='item-2']/span[text()='Radio Button']")
    private WebElement radioButton;

    @FindBy(xpath = "//li[@id='item-3']/span[text()='Web Tables']")
    private WebElement webTables;

    @FindBy(xpath = "//li[@id='item-4']/span[text()='Buttons']")
    private WebElement buttons;

    @FindBy(xpath = "//li[@id='item-5']/span[text()='Links']")
    private WebElement links;

    @FindBy(xpath = "//li[@id='item-6']/span[text()='Broken Links - Images']")
    private WebElement brokenLinksImages;

    @FindBy(xpath = "//li[@id='item-7']/span[text()='Upload and Download']")
    private WebElement uploadAndDownload;

    @FindBy(xpath = "//li[@id='item-8']/span[text()='Dynamic Properties']")
    private WebElement dynamicPropertiesMenuItem;

    @FindBy(xpath = "(//div[contains(.,'Please select an item from left to start practice.')])[5]")
    private WebElement text;

    @FindBy(xpath = "(//div[@class='header-wrapper'][contains(.,'Elements')])")
    private WebElement elements;

    @FindBy(xpath = "//div[contains(@class,'element-list collapse')]")
    private WebElement collapseDiv;

    public ElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getText() {
        return text.getText();
    }

    public void clickTextBox() {
        textBox.click();
    }

    public void clickCheckBox() {
        checkBox.click();
    }

    public void clickRadioButton() {
        radioButton.click();
    }

    public void clickWebTables() {
        webTables.click();
    }

    public void clickButtons() {
        buttons.click();
    }

    public void clickBrokenLinksImages() {
        brokenLinksImages.click();
    }

    public void clickUploadAndDownload() {
        uploadAndDownload.click();
    }

    public void clickDynamicProperties() {
        dynamicPropertiesMenuItem.click();
    }

    public void clickLinks() {
        scrollToElementJS(links);
        links.click();
    }

    public boolean verifyTextBoxIsVisible() {
        return textBox.isDisplayed();
    }

    public void clickElements() {
        elements.click();
    }

    public boolean verifyTextBoxIsNotVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.invisibilityOf(textBox));

        String classAttribute = collapseDiv.getDomAttribute("class");
        return classAttribute.equals("element-list collapse show");
    }
}
