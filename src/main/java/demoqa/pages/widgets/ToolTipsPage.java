package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.time.Duration;

public class ToolTipsPage extends BasePage {
    @FindBy(xpath = "//*[@id='buttonToolTopContainer']/p")
    private WebElement practiceToolTipsText;

    @FindBy(id = "toolTipButton")
    private WebElement hoverMeToSeeButton;

    @FindBy(id = "buttonToolTip")
    private WebElement buttonTooltip;

    @FindBy(id = "toolTipTextField")
    private WebElement hoverMeTextField;

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Tool Tips')]")
    private WebElement header;

    @FindBy(id = "texToolTopContainer")
    private WebElement mainText;

    @FindBy(xpath = "//a[@href='javascript:void(0)'][contains(.,'Contrary')]")
    private WebElement contrary;

    @FindBy(xpath = "//a[@href='javascript:void(0)'][contains(.,'1.10.32')]")
    private WebElement section;

    @FindBy(xpath = "//*[@id=\"buttonToolTip\"]/div[2]")
    private WebElement buttonToolTip;

    @FindBy(xpath = "//*[@id=\"textFieldToolTip\"]/div[2]")
    private WebElement practiceTextFieldToolTip;

    @FindBy(xpath = "//*[@id=\"contraryTexToolTip\"]/div[2]")
    private WebElement contraryToolTip;

    @FindBy(xpath = "//*[@id=\"sectionToolTip\"]/div[2]")
    private WebElement sectionToolTip;

    private final JavaScriptUtility javaScriptUtility;

    public ToolTipsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getHoverOverHoverMeToSeeButtonReturnToolTipText() {
        javaScriptUtility.scrollToElementJS(header);

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMeToSeeButton).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(buttonToolTip));

        return buttonToolTip.getText();
    }

    public String getHoverOverHoverMeToSeeTextFieldReturnToolTipText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverMeTextField).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(practiceTextFieldToolTip));

        return practiceTextFieldToolTip.getText();
    }

    public String getHoverOverContraryReturnToolTipText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(contrary).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(contraryToolTip));

        return contraryToolTip.getText();
    }

    public String getHoverOverSectionText() {
        Actions actions = new Actions(driver);
        actions.moveToElement(section).perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(sectionToolTip));

        return sectionToolTip.getText();
    }

    public String getHeaderText() {
        return header.getText();
    }

    public String getPracticeToolTips() {
        return practiceToolTipsText.getText();
    }

    public String getHoverMeButtonButton() {
        return hoverMeToSeeButton.getText();
    }

    public String getHoverMeToSeeButtonPlaceholder() {
        return hoverMeTextField.getDomAttribute("placeholder");
    }

    public String getMainText() {
        return mainText.getText();
    }
}
