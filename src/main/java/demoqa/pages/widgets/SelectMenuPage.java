package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.JavaScriptUtility;

import java.util.List;
import java.util.stream.Collectors;

public class SelectMenuPage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(id = "react-select-2-input")
    private WebElement selectValue;
    @FindBy(id = "react-select-3-input")
    private WebElement selectOne;
    @FindBy(id = "oldSelectMenu")
    private WebElement oldStyle;
    @FindBy(id = "cars")
    private WebElement standardMultiSelect;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Select Menu')]")
    private WebElement selectMenuLabel;
    @FindBy(xpath = "//div[@class='col-md-6 col-sm-12'][contains(.,'Select Value')]")
    private WebElement selectedValueLabel;
    @FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select Option')]")
    private WebElement selectedValuePlaceholder;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    private WebElement selectDropDown;
    @FindBy(xpath = "(//div[contains(@class,' css-1wa3eu0-placeholder')])[3]")
    private WebElement multiSelectDropDown;
    @FindBy(xpath = "//div[contains(@class,' css-2b097c-container')]")
    private WebElement multiSelectDropDown2;
    @FindBy(xpath = "(//div[contains(@class,' css-1hwfws3')])[2]")
    private WebElement selectedOne;
    @FindBy(xpath = "(//div[contains(@class,' css-1hwfws3')])[3]")
    private WebElement selectedResults;
    @FindBy(xpath = "(//div[contains(@class,' css-1uccc91-singleValue')])[1]")
    private WebElement selectedValue;
    @FindBy(xpath = "//div[@class='col-md-6 col-sm-12'][contains(.,'Select One')]")
    private WebElement selectTitleLabel;
    @FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select Title')]")
    private WebElement expectedSelectTitlePlaceholder;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[3]")
    private WebElement closeAllDropDown;
    @FindBy(xpath = "//div[@class='col-md-6 col-sm-12'][contains(.,'Old Style Select Menu')]")
    private WebElement oldStyleSelectMenuLabel;
    @FindBy(xpath = "//*[@id='oldSelectMenu']/option[1]")
    private WebElement oldStyleSelectMenuPlaceholder;
    @FindBy(xpath = "//b[contains(.,'Multiselect drop down')]")
    private WebElement expectedMultiselectDropdownLabel;
    @FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select...')]")
    private WebElement expectedMultiselectDropdownPlaceholder;
    @FindBy(xpath = "//b[contains(.,'Standard multi select')]")
    private WebElement expectedStandardMultiSelectLabel;
    @FindBy(xpath = "//div[@class='css-xb97g8']")
    private List<WebElement> multiDropDownAllSelected;
    @FindBy(xpath = "//div[@class=' css-1gl4k7y']")
    private WebElement noOptionsSelected;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[4]")
    private WebElement selectedOptions;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[3]")
    private WebElement closAll;

    public SelectMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getSelectedValue() {
        return selectedValue.getText();
    }

    public String getSelectedSelectOne() {
        return selectedOne.getText();
    }

    public String getSelectMenuText() {
        return selectMenuLabel.getText();
    }

    public String getSelectedValueLabelText() {
        return selectedValueLabel.getText();
    }

    public String getSelectedValuePlaceholderText() {
        return selectedValuePlaceholder.getText();
    }

    public String getSelectOneTitleText() {
        return selectTitleLabel.getText();
    }

    public String getSelectTitlePlaceholderText() {
        return expectedSelectTitlePlaceholder.getText();
    }

    public String getOldStyleSelectMenuLabel() {
        return oldStyleSelectMenuLabel.getText();
    }

    public String getOldStyleSelectMenuPlaceholder() {
        return oldStyleSelectMenuPlaceholder.getText();
    }

    public String getMultiselectDropdownLabelText() {
        return expectedMultiselectDropdownLabel.getText();
    }

    public String getMultiselectDropdownPlaceholderText() {
        return expectedMultiselectDropdownPlaceholder.getText();
    }

    public String getStandardMultiSelectLabelText() {
        return expectedStandardMultiSelectLabel.getText();
    }

    public String getStandardMultiSelect() {
        return standardMultiSelect.getText();
    }

    public List<String> getAllSelectedStandardMultiOptions() {
        Select select = new Select(standardMultiSelect);
        return select.getAllSelectedOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void selectSelectOne(String option) {
        selectOne.sendKeys(option);
        selectOne.sendKeys(Keys.ENTER);
    }

    public void multiSelectOne(String color) {
        Actions actions = new Actions(driver);
        actions.click(selectDropDown) // ensure focus
                .sendKeys(color)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void selectSelectValue(String option) {
        selectValue.sendKeys(option);
        selectValue.sendKeys(Keys.ENTER);
    }

    public void selectOldStyleSelectMenuByText(String text) {
        Select dropdown = new Select(oldStyle);
        dropdown.selectByVisibleText(text);
    }

    public String getOldStyleSelectMenuSelectedValue() {
        Select dropdown = new Select(oldStyle);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void selectStandardMultiByText(String text) {
        javaScriptUtility.scrollToElementJS(standardMultiSelect);
        Select select = new Select(standardMultiSelect);
        select.selectByVisibleText(text);
    }

    public void selectStandardMultiByIndex(int index) {
        javaScriptUtility.scrollToElementJS(standardMultiSelect);
        Select select = new Select(standardMultiSelect);
        select.selectByIndex(index);
    }

    public void deselectStandardMulti(String value) {
        javaScriptUtility.scrollToElementJS(standardMultiSelect);
        Select select = new Select(standardMultiSelect);
        select.deselectByValue(value);
    }

    public String getMultiSelectDropdownValue() {
        delay(300); //TODO
        return selectedResults.getText();
    }

    public void closeAllMultiSelectDropdown() {
        oldStyle.click();
        javaScriptUtility.scrollToElementJS(closAll);
        closAll.click();
    }

    public void closeMultiSelectDropDown() throws InterruptedException {
        this.multiDropDownAllSelected.getFirst().click();
        delay(300); //TODO
    }

    public String selectNoOptionsText() {
        delay(200); //TODO
        oldStyle.click();
        selectedOptions.click();
        return noOptionsSelected.getText();
    }
}
