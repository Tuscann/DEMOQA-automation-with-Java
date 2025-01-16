package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WebTablesPage extends BasePage {

    private final By header = By.xpath("//h1[@class='text-center'][contains(.,'Web Tables')]");
    private final By registrationFormText = By.xpath("//div[@id='registration-form-modal']");
    private final By registrationFirstNameLabel = By.id("firstName-label");
    private final By registrationFirstNameField = By.id("firstName");
    private final By registrationLastNameLabel = By.id("lastName-label");
    private final By registrationLastNameField = By.id("lastName");
    private final By registrationEmailLabel = By.id("userEmail-label");
    private final By registrationEmailField = By.id("userEmail");
    private final By registrationAgeLabel = By.id("age-label");
    private final By registrationAgeField = By.id("age");
    private final By registrationSalaryLabel = By.id("salary-label");
    private final By registrationSalaryField = By.id("salary");
    private final By registrationDepartmentLabel = By.id("department-label");
    private final By registrationDepartmentField = By.id("department");
    private final By submitButton = By.id("submit");
    private final By addNewRecordButton = By.id("addNewRecordButton");
    private final By searchBox = By.id("searchBox");
    private final By nextButton = By.xpath("//button[contains(.,'Next')]");
    private final By previousButton = By.xpath("//button[contains(.,'Previous')]");
    private final By noRowsFound = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[3]");

    private final By rowsPerPage = By.xpath("//select[@aria-label='rows per page']");
    private final By lineCounts = By.className("rt-tr-group");
    private final By pageInfo = By.className("-pageInfo");
    private final By pageJump = By.xpath("//input[@aria-label='jump to page']");
    private final By tableHeader = By.className("rt-thead");
    private final By tableInformation = By.className("rt-tr-group");

    public WebTablesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSearchBoxPlaceholder() {
        return find(searchBox).getDomAttribute("placeholder");
    }


    public String getRegistrationFirstNameLabel() {
        return find(registrationFirstNameLabel).getText();
    }

    public String getRegistrationLastNameLabel() {
        return find(registrationLastNameLabel).getText();
    }

    public String getRegistrationEmailLabel() {
        return find(registrationEmailLabel).getText();
    }

    public String getRegistrationAgeLabel() {
        return find(registrationAgeLabel).getText();
    }

    public String getRegistrationSalaryLabel() {
        return find(registrationSalaryLabel).getText();
    }

    public String getDepartmentLabel() {
        return find(registrationDepartmentLabel).getText();
    }

    public String getPlaceholderFirstName() {
        return find(registrationFirstNameField).getDomAttribute("placeholder");
    }

    public String getPlaceholderLastName() {
        return find(registrationLastNameField).getDomAttribute("placeholder");
    }

    public String getPlaceholderUserEmail() {
        return find(registrationEmailField).getDomAttribute("placeholder");
    }

    public String getAgePlaceholder() {
        return find(registrationAgeField).getDomAttribute("placeholder");
    }

    public String getSalaryPlaceholder() {
        return find(registrationSalaryField).getDomAttribute("placeholder");
    }

    public String getNoRowsFound() {
        return find(noRowsFound).getText();
    }

    public String getLastNameBorderColor() {
        return find(registrationLastNameField).getCssValue("border");
    }

    public String getEmailBorderColor() {
        return find(registrationEmailField).getCssValue("border");
    }

    public String getAgeBorderColor() {
        return find(registrationAgeField).getCssValue("border");
    }

    public String getSalaryBorderColor() {
        return find(registrationSalaryField).getCssValue("border");
    }

    public String getDepartmentBorderColor() {
        return find(registrationDepartmentField).getCssValue("border");
    }

    public String getPageInfo() {
        return find(pageInfo).getText();
    }

    public String getPageJump() {
        return find(pageJump).getDomAttribute("value");
    }

    public String getButtonAddText() {
        return find(addNewRecordButton).getText();
    }

    public String getButtonNextText() {
        return find(nextButton).getText();
    }

    public String getButtonPreviousText() {
        return find(previousButton).getText();
    }

    public String getTableHeader() {
        return find(tableHeader).getText();
    }

    public String getHeader() {
        return find(header).getText();
    }

    public String getSubmitButtonText() {
        return find(submitButton).getText();
    }

    public int getCountOfLines() {
        List<WebElement> webElements = driver.findElements(lineCounts);

        return webElements.size();
    }

    public String getFirstNameBorderColor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(registrationFirstNameField, "border-color", "rgb(220, 53, 69)"));
        return find(registrationFirstNameField).getCssValue("border");
    }

    public String getRegistrationFormText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOf(find(registrationFormText)));

        return find(registrationFormText).getText();
    }

    public String getTableData() {
        List<WebElement> webElements = driver.findElements(tableInformation);

        List<String> allText = webElements.stream()
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .map(String::trim)
                .toList();

        return allText.toString();
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }

    public void setFirstName(String name) {
        set(registrationFirstNameField, name);
    }

    public void setEmail(String email) {
        set(registrationEmailField, email);
    }

    public void setSalary(String salary) {
        set(registrationSalaryField, salary);
    }

    public void setDepartment(String department) {
        set(registrationDepartmentField, department);
    }

    public void setLastName(String name) {
        set(registrationLastNameField, name);
    }

    public void clickAddButton() {
        click(addNewRecordButton);
    }

    public void searchWithWord(String word) {
        set(searchBox, word);
    }

    public String getDepartmentPlaceholder() {
        return find(registrationDepartmentField).getDomAttribute("placeholder");
    }

    public void clickSubmitButton() {
        click(submitButton);
    }

    public void clickEdit(String email) {
        By edit = By.xpath("//div[text()='" + email + "']//following::span[@title='Edit']");
        scrollToElementJS(edit);
        click(edit);
    }

    public void clickDeleteByEmail(String email) {
        By delete = By.xpath("//div[text()='" + email + "']//following::span[@title='Delete']");
        scrollToElementJS(delete);
        click(delete);
    }

    public String getTableAge(String email) {
        By tableAge = By.xpath("//div[text()='" + email + "']//preceding::div[1]");
        return find(tableAge).getText();
    }

    public String getTableFirstName(String email) {
        By tableFirstName = By.xpath("//div[text()='" + email + "']//preceding::div[3]");
        return find(tableFirstName).getText();
    }

    public String getTableLastName(String email) {
        By tableLastName = By.xpath("//div[text()='" + email + "']//preceding::div[2]");
        return find(tableLastName).getText();
    }

    public String getTableEmail(String email) {
        By tableEmail = By.xpath("//div[@class='rt-td'][contains(., '" + email + "')]");
        return find(tableEmail).getText();
    }

    public String getTableSalary(String email) {
        By tableSalary = By.xpath("//div[text()='" + email + "']//following-sibling::div[1]");
        return find(tableSalary).getText();
    }

    public String getTableDepartment(String email) {
        By tableDepartment = By.xpath("//div[text()='" + email + "']//following-sibling::div[2]");
        return find(tableDepartment).getText();
    }

    public boolean checkPreviousButtonIsActive() {
        scrollToElementJS(previousButton);
        return find(previousButton).isEnabled();
    }

    public boolean checkNextButtonIsActive() {
        scrollToElementJS(previousButton);
        return find(nextButton).isEnabled();
    }

    public boolean isAllBordersRed(String color) {
        delay(500); //TODO

        boolean bordersRed = false;

        for (int i = 0; i < 6; i++) {
            String endColor;

            if (i == 0) {
                endColor = find(registrationFirstNameField).getCssValue("border");
            } else if (i == 1) {
                endColor = find(registrationLastNameField).getCssValue("border");
            } else if (i == 2) {
                endColor = find(registrationEmailField).getCssValue("border");
            } else if (i == 3) {
                endColor = find(registrationAgeField).getCssValue("border");
            } else if (i == 4) {
                endColor = find(registrationSalaryField).getCssValue("border");
            } else {
                endColor = find(registrationDepartmentField).getCssValue("border");
            }
            if (endColor.equals(color)) {
                bordersRed = true;
            } else {
                bordersRed = false;
                break;
            }
        }
        return bordersRed;
    }

    public void clickNexButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));

        click(nextButton);
    }

    public boolean isFirstNameBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationFirstNameField, "border", color));

        return find(registrationFirstNameField).getCssValue("border").equals(color);
    }

    public boolean isLastNameBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationLastNameField, "border", color));

        return find(registrationLastNameField).getCssValue("border").equals(color);
    }

    public boolean isEmailBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationEmailField, "border", color));

        return find(registrationEmailField).getCssValue("border").equals(color);
    }

    public boolean isAgeBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationAgeField, "border", color));

        return find(registrationAgeField).getCssValue("border").equals(color);
    }

    public boolean isSalaryBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationSalaryField, "border", color));

        return find(registrationSalaryField).getCssValue("border").equals(color);
    }

    public boolean isDepartmentBorderColorGreen(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.attributeContains(registrationDepartmentField, "border", color));

        return find(registrationDepartmentField).getCssValue("border").equals(color);
    }

    public void clickRowPerPage(String row) {
        WebElement dropdownElement = driver.findElement(rowsPerPage);

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(row);
    }
}
