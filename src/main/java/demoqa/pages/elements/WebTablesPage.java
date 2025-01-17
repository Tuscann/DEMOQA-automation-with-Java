package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WebTablesPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Web Tables')]")
    private WebElement header;

    @FindBy(xpath = "//div[@id='registration-form-modal']")
    private WebElement registrationFormText;

    @FindBy(id = "firstName-label")
    private WebElement registrationFirstNameLabel;

    @FindBy(id = "firstName")
    private WebElement registrationFirstNameField;

    @FindBy(id = "lastName-label")
    private WebElement registrationLastNameLabel;

    @FindBy(id = "lastName")
    private WebElement registrationLastNameField;

    @FindBy(id = "userEmail-label")
    private WebElement registrationEmailLabel;

    @FindBy(id = "userEmail")
    private WebElement registrationEmailField;

    @FindBy(id = "age-label")
    private WebElement registrationAgeLabel;

    @FindBy(id = "age")
    private WebElement registrationAgeField;

    @FindBy(id = "salary-label")
    private WebElement registrationSalaryLabel;

    @FindBy(id = "salary")
    private WebElement registrationSalaryField;

    @FindBy(id = "department-label")
    private WebElement registrationDepartmentLabel;

    @FindBy(id = "department")
    private WebElement registrationDepartmentField;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "addNewRecordButton")
    private WebElement addNewRecordButton;

    @FindBy(id = "searchBox")
    private WebElement searchBox;

    @FindBy(xpath = "//button[contains(.,'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//button[contains(.,'Previous')]")
    private WebElement previousButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[3]")
    private WebElement noRowsFound;

    @FindBy(xpath = "//select[@aria-label='rows per page']")
    private WebElement rowsPerPage;

    @FindBy(className = "rt-tr-group")
    private List<WebElement> lineCounts;

    @FindBy(className = "-pageInfo")
    private WebElement pageInfo;

    @FindBy(xpath = "//input[@aria-label='jump to page']")
    private WebElement pageJump;

    @FindBy(className = "rt-thead")
    private WebElement tableHeader;

    @FindBy(className = "rt-tr-group")
    private List<WebElement> tableInformation;

    public WebTablesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSearchBoxPlaceholder() {
        return searchBox.getDomProperty("placeholder");
    }

    public String getRegistrationFirstNameLabel() {
        return registrationFirstNameLabel.getText();
    }

    public String getRegistrationLastNameLabel() {
        return registrationLastNameLabel.getText();
    }

    public String getRegistrationEmailLabel() {
        return registrationEmailLabel.getText();
    }

    public String getRegistrationAgeLabel() {
        return registrationAgeLabel.getText();
    }

    public String getRegistrationSalaryLabel() {
        return registrationSalaryLabel.getText();
    }

    public String getDepartmentLabel() {
        return registrationDepartmentLabel.getText();
    }

    public String getPlaceholderFirstName() {
        return registrationFirstNameField.getDomProperty("placeholder");
    }

    public String getPlaceholderLastName() {
        return registrationLastNameField.getDomProperty("placeholder");
    }

    public String getPlaceholderUserEmail() {
        return registrationEmailField.getDomProperty("placeholder");
    }

    public String getAgePlaceholder() {
        return registrationAgeField.getDomProperty("placeholder");
    }

    public String getSalaryPlaceholder() {
        return registrationSalaryField.getDomProperty("placeholder");
    }

    public String getNoRowsFound() {
        return noRowsFound.getText();
    }

    public String getLastNameBorderColor() {
        return registrationLastNameField.getCssValue("border");
    }

    public String getEmailBorderColor() {
        return registrationEmailField.getCssValue("border");
    }

    public String getAgeBorderColor() {
        return registrationAgeField.getCssValue("border");
    }

    public String getSalaryBorderColor() {
        return registrationSalaryField.getCssValue("border");
    }

    public String getDepartmentBorderColor() {
        return registrationDepartmentField.getCssValue("border");
    }

    public String getPageInfo() {
        return pageInfo.getText();
    }

    public String getPageJump() {
        return pageJump.getDomProperty("value");
    }

    public String getButtonAddText() {
        return addNewRecordButton.getText();
    }

    public String getButtonNextText() {
        return nextButton.getText();
    }

    public String getButtonPreviousText() {
        return previousButton.getText();
    }

    public String getTableHeader() {
        return tableHeader.getText();
    }

    public String getHeader() {
        return header.getText();
    }

    public String getSubmitButtonText() {
        return submitButton.getText();
    }

    public int getCountOfLines() {
        return lineCounts.size();
    }

    public String getFirstNameBorderColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(registrationFirstNameField, "border-color", "rgb(220, 53, 69)"));
        return registrationFirstNameField.getCssValue("border");
    }

    public String getRegistrationFormText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(registrationFormText));
        return registrationFormText.getText();
    }

    public String getTableData() {
        return tableInformation.stream()
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .map(String::trim)
                .toList()
                .toString();
    }

    public void setAge(String age) {
        registrationAgeField.clear();
        registrationAgeField.sendKeys(age);
    }

    public void setFirstName(String name) {
        registrationFirstNameField.clear();
        registrationFirstNameField.sendKeys(name);
    }

    public void setEmail(String email) {
        registrationEmailField.clear();
        registrationEmailField.sendKeys(email);
    }

    public void setSalary(String salary) {
        registrationSalaryField.clear();
        registrationSalaryField.sendKeys(salary);
    }

    public void setDepartment(String department) {
        registrationDepartmentField.clear();
        registrationDepartmentField.sendKeys(department);
    }

    public void setLastName(String name) {
        registrationLastNameField.clear();
        registrationLastNameField.sendKeys(name);
    }

    public void clickAddButton() {
        addNewRecordButton.click();
    }

    public void searchWithWord(String word) {
        searchBox.clear();
        searchBox.sendKeys(word);
    }

    public String getDepartmentPlaceholder() {
        return registrationDepartmentField.getDomAttribute("placeholder");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickEdit(String email) {
        WebElement editButton = driver.findElement(By.xpath("//div[text()='" + email + "']//following::span[@title='Edit']"));
        scrollToElementJS(editButton);
        editButton.click();
    }

    public void clickDeleteByEmail(String email) {
        WebElement deleteButton = driver.findElement(By.xpath("//div[text()='" + email + "']//following::span[@title='Delete']"));
        scrollToElementJS(deleteButton);
        deleteButton.click();
    }

    public String getTableAge(String email) {
        WebElement ageCell = driver.findElement(By.xpath("//div[text()='" + email + "']//preceding::div[1]"));
        return ageCell.getText();
    }

    public String getTableFirstName(String email) {
        WebElement firstNameCell = driver.findElement(By.xpath("//div[text()='" + email + "']//preceding::div[3]"));
        return firstNameCell.getText();
    }

    public String getTableLastName(String email) {
        WebElement lastNameCell = driver.findElement(By.xpath("//div[text()='" + email + "']//preceding::div[2]"));
        return lastNameCell.getText();
    }

    public String getTableEmail(String email) {
        WebElement emailCell = driver.findElement(By.xpath("//div[@class='rt-td'][contains(., '" + email + "')]"));
        return emailCell.getText();
    }

    public String getTableSalary(String email) {
        WebElement salaryCell = driver.findElement(By.xpath("//div[text()='" + email + "']//following-sibling::div[1]"));
        return salaryCell.getText();
    }

    public String getTableDepartment(String email) {
        WebElement departmentCell = driver.findElement(By.xpath("//div[text()='" + email + "']//following-sibling::div[2]"));
        return departmentCell.getText();
    }

    public boolean checkPreviousButtonIsActive() {
        scrollToElementJS(previousButton);
        return previousButton.isEnabled();
    }

    public boolean checkNextButtonIsActive() {
        scrollToElementJS(previousButton);
        return nextButton.isEnabled();
    }

    public boolean isAllBordersRed(String color) {
        delay(500); //TODO

        WebElement[] fields = {
                registrationFirstNameField,
                registrationLastNameField,
                registrationEmailField,
                registrationAgeField,
                registrationSalaryField,
                registrationDepartmentField
        };

        for (WebElement field : fields) {
            if (!field.getCssValue("border").equals(color)) {
                return false;
            }
        }
        return true;
    }

    public void clickNexButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
    }

    public boolean isFirstNameBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationFirstNameField, "border", color));
        return registrationFirstNameField.getCssValue("border").equals(color);
    }

    public boolean isLastNameBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationLastNameField, "border", color));
        return registrationLastNameField.getCssValue("border").equals(color);
    }

    public boolean isEmailBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationEmailField, "border", color));
        return registrationEmailField.getCssValue("border").equals(color);
    }

    public boolean isAgeBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationAgeField, "border", color));
        return registrationAgeField.getCssValue("border").equals(color);
    }

    public boolean isSalaryBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationSalaryField, "border", color));
        return registrationSalaryField.getCssValue("border").equals(color);
    }

    public boolean isDepartmentBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationDepartmentField, "border", color));
        return registrationDepartmentField.getCssValue("border").equals(color);
    }

    public void clickRowPerPage(String row) {
        Select dropdown = new Select(rowsPerPage);
        dropdown.selectByVisibleText(row);
    }
}
