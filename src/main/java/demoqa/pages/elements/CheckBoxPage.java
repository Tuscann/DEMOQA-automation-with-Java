package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class CheckBoxPage extends BasePage {

    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Check Box')]");
    private final By home = By.xpath("(//span[contains(.,'Home')])[2]");
    private final By desktop = By.xpath("(//span[contains(.,'Desktop')])[2]");
    private final By notes = By.xpath("(//span[contains(.,'Notes')])[2]");
    private final By commands = By.xpath("(//span[contains(.,'Commands')])[2]");
    private final By documents = By.xpath("(//span[contains(.,'Documents')])[2]");
    private final By workSpace = By.xpath("(//span[contains(.,'WorkSpace')])[2]");
    private final By react = By.xpath("(//span[contains(.,'React')])[2]");
    private final By angular = By.xpath("(//span[contains(.,'Angular')])[2]");
    private final By veu = By.xpath("(//span[contains(.,'Veu')])[2]");
    private final By office = By.xpath("(//span[contains(.,'Office')])[2]");
    private final By officePublic = By.xpath("(//span[contains(.,'Public')])[2]");
    private final By officePrivate = By.xpath("(//span[contains(.,'Private')])[2]");
    private final By classified = By.xpath("(//span[contains(.,'Classified')])[2]");
    private final By general = By.xpath("(//span[contains(.,'General')])[2]");
    private final By downloads = By.xpath("(//span[contains(.,'Downloads')])[2]");
    private final By wordFileDoc = By.xpath("(//span[contains(.,'Word File.doc')])[2]");
    private final By excelFileDoc = By.xpath("(//span[contains(.,'Excel File.doc')])[2]");

    private final By expandAll = By.cssSelector(".rct-option.rct-option-expand-all");
    private final By collapseAll = By.cssSelector(".rct-option.rct-option-collapse-all");
    private final By resultMessage = By.id("result");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isResultMessageShown() {
        return driver.findElements(By.id("result")).isEmpty();
    }

    public String getResultMessage() {
        return find(resultMessage).getText();
    }

    public String getHeader() {
        return find(header).getText();
    }

    public void clickExpandAll() {
        click(expandAll);
    }

    public void clickCollapseAll() {
        click(collapseAll);
    }

    public void clickDesktop() {
        click(desktop);
    }

    public void clickDocuments() {
        click(documents);
    }

    public void clickVeu() {
        click(veu);
    }

    public void clickOffice() {
        click(office);
    }

    public void clickOfficePublic() {
        click(officePublic);
    }

    public void clickWorkSpace() {
        click(workSpace);
    }

    public void clickReact() {
        scrollToElementJS(react);
        click(react);
    }

    public void clickAngular() {
        click(angular);
    }

    public void clickDownloads() {
        scrollToElementJS(downloads);
        click(downloads);
    }

    public void clickWordFileDoc() {
        click(wordFileDoc);
    }

    public void clickExcelFileDoc() {
        click(excelFileDoc);
    }

    public void clickClassified() {
        click(classified);
    }

    public void clickGeneral() {
        click(general);
    }

    public void clickHome() {
        click(home);
    }

    public void clickPrivateOffice() {
        click(officePrivate);
    }

    public void clickNotes() {
        scrollToElementJS(notes);
        click(notes);
    }

    public void clickCommands() {
        scrollToElementJS(commands);
        click(commands);
    }

    public boolean verifyResultMessageIsMissing() {
        List<WebElement> elements = driver.findElements(resultMessage);

        return elements.isEmpty();
    }
}