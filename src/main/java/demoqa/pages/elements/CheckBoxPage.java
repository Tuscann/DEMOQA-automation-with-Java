package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class CheckBoxPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Check Box')]")
    private WebElement header;

    @FindBy(xpath = "(//span[contains(.,'Home')])[2]")
    private WebElement home;

    @FindBy(xpath = "(//span[contains(.,'Desktop')])[2]")
    private WebElement desktop;

    @FindBy(xpath = "(//span[contains(.,'Notes')])[2]")
    private WebElement notes;

    @FindBy(xpath = "(//span[contains(.,'Commands')])[2]")
    private WebElement commands;

    @FindBy(xpath = "(//span[contains(.,'Documents')])[2]")
    private WebElement documents;

    @FindBy(xpath = "(//span[contains(.,'WorkSpace')])[2]")
    private WebElement workSpace;

    @FindBy(xpath = "(//span[contains(.,'React')])[2]")
    private WebElement react;

    @FindBy(xpath = "(//span[contains(.,'Angular')])[2]")
    private WebElement angular;

    @FindBy(xpath = "(//span[contains(.,'Veu')])[2]")
    private WebElement veu;

    @FindBy(xpath = "(//span[contains(.,'Office')])[2]")
    private WebElement office;

    @FindBy(xpath = "(//span[contains(.,'Public')])[2]")
    private WebElement officePublic;

    @FindBy(xpath = "(//span[contains(.,'Private')])[2]")
    private WebElement officePrivate;

    @FindBy(xpath = "(//span[contains(.,'Classified')])[2]")
    private WebElement classified;

    @FindBy(xpath = "(//span[contains(.,'General')])[2]")
    private WebElement general;

    @FindBy(xpath = "(//span[contains(.,'Downloads')])[2]")
    private WebElement downloads;

    @FindBy(xpath = "(//span[contains(.,'Word File.doc')])[2]")
    private WebElement wordFileDoc;

    @FindBy(xpath = "(//span[contains(.,'Excel File.doc')])[2]")
    private WebElement excelFileDoc;

    @FindBy(css = ".rct-option.rct-option-expand-all")
    private WebElement expandAll;

    @FindBy(css = ".rct-option.rct-option-collapse-all")
    private WebElement collapseAll;

    @FindBy(id = "result")
    private WebElement resultMessage;

    @FindBy(id = "result")
    private List<WebElement> resultMessageList;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isResultMessageShown() {
        return resultMessageList.isEmpty();
    }

    public String getResultMessage() {
        return resultMessage.getText();
    }

    public String getHeader() {
        return header.getText();
    }

    public void clickExpandAll() {
        expandAll.click();
    }

    public void clickCollapseAll() {
        collapseAll.click();
    }

    public void clickDesktop() {
        desktop.click();
    }

    public void clickDocuments() {
        documents.click();
    }

    public void clickVeu() {
        veu.click();
    }

    public void clickOffice() {
        office.click();
    }

    public void clickOfficePublic() {
        officePublic.click();
    }

    public void clickWorkSpace() {
        workSpace.click();
    }

    public void clickReact() {
        scrollToElementJS(react);
        react.click();
    }

    public void clickAngular() {
        angular.click();
    }

    public void clickDownloads() {
        scrollToElementJS(downloads);
        downloads.click();
    }

    public void clickWordFileDoc() {
        scrollToElementJS(wordFileDoc);
        wordFileDoc.click();
    }

    public void clickExcelFileDoc() {
        scrollToElementJS(excelFileDoc);
        excelFileDoc.click();
    }

    public void clickHome() {
        home.click();
    }

    public void clickNotes() {
        scrollToElementJS(notes);
        notes.click();
    }

    public void clickCommands() {
        scrollToElementJS(commands);
        commands.click();
    }

    public void clickOfficePrivate() {
        officePrivate.click();
    }

    public void clickClassified() {
        classified.click();
    }

    public void clickGeneral() {
        general.click();
    }

    public boolean verifyResultMessageIsMissing() {
        return resultMessageList.isEmpty();
    }
}