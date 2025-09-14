package demoqa.pages.forms;

import demoqa.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.JavaScriptUtility;

import java.io.File;
import java.time.Duration;

public class PracticeFormPage extends BasePage {

    private final JavaScriptUtility javaScriptUtility;
    @FindBy(className = "react-datepicker__month-select")
    public WebElement select_month;
    @FindBy(className = "react-datepicker__year-select")
    public WebElement select_year;
    @FindBy(className = "react-datepicker__day--027")
    public WebElement select_date;
    @FindBy(id = "hobbies-checkbox-2")
    private WebElement readingHobbyCheckbox;
    @FindBy(id = "hobbies-checkbox-3")
    private WebElement musicHobbyCheckbox;
    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;
    @FindBy(id = "currentAddress")
    private WebElement currentAddressArea;
    @FindBy(id = "react-select-3-input")
    private WebElement selectStates;
    @FindBy(id = "react-select-4-input")
    private WebElement cities;
    @FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select State')]")
    private WebElement selectState;
    @FindBy(xpath = "//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select City')]")
    private WebElement selectCity;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(xpath = "//th[contains(.,'Label')]")
    private WebElement labelForm;
    @FindBy(xpath = "//th[contains(.,'Label')]/following-sibling::*[1]")
    private WebElement valuesForm;
    @FindBy(xpath = "//td[contains(.,'Student Name')]")
    private WebElement studentNameLabel;
    @FindBy(xpath = "//td[contains(.,'Student Name')]/following-sibling::*[1]")
    private WebElement studentNameForm;
    @FindBy(xpath = "//td[contains(.,'Student Email')]")
    private WebElement emailLabelForm;
    @FindBy(xpath = "//td[contains(.,'Student Email')]/following-sibling::*[1]")
    private WebElement emailForm;
    @FindBy(xpath = "//td[contains(.,'Gender')]")
    private WebElement genderLabelForm;
    @FindBy(xpath = "//td[contains(.,'Gender')]/following-sibling::*[1]")
    private WebElement genderForm;
    @FindBy(xpath = "//td[contains(.,'Mobile')]")
    private WebElement mobileLabelForm;
    @FindBy(xpath = "//td[contains(.,'Mobile')]/following-sibling::*[1]")
    private WebElement mobileForm;
    @FindBy(xpath = "//td[contains(.,'Date of Birth')]")
    private WebElement dateOfBirthLabelForm;
    @FindBy(xpath = "//td[contains(.,'Date of Birth')]/following-sibling::*[1]")
    private WebElement dateOfBirthForm;
    @FindBy(xpath = "//td[contains(.,'Subjects')]")
    private WebElement subjectsLabelForm;
    @FindBy(xpath = "//td[contains(.,'Subjects')]/following-sibling::*[1]")
    private WebElement subjectsForm;
    @FindBy(xpath = "//td[contains(.,'Hobbies')]")
    private WebElement hobbiesLabelForm;
    @FindBy(xpath = "//td[contains(.,'Hobbies')]/following-sibling::*[1]")
    private WebElement hobbiesForm;
    @FindBy(xpath = "//td[contains(.,'Picture')]")
    private WebElement pictureLabelForm;
    @FindBy(xpath = "//td[contains(.,'Picture')]/following-sibling::*[1]")
    private WebElement pictureForm;
    @FindBy(xpath = "//td[contains(.,'Address')]")
    private WebElement addressLabelForm;
    @FindBy(xpath = "//td[contains(.,'Address')]/following-sibling::*[1]")
    private WebElement addressForm;
    @FindBy(xpath = "//td[contains(.,'State')]")
    private WebElement stateAndCityLabelForm;
    @FindBy(xpath = "//td[contains(.,'State')]/following-sibling::*[1]")
    private WebElement stateAndCityForm;
    @FindBy(xpath = "//label[@class='form-label'][contains(.,'Hobbies')]")
    private WebElement hobbiesLabel;
    @FindBy(xpath = "//label[@class='form-label'][contains(.,'Picture')]")
    private WebElement pictureLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1'][contains(.,'Sports')]")
    private WebElement sportsLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2'][contains(.,'Reading')]")
    private WebElement readingLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3'][contains(.,'Music')]")
    private WebElement musicLabel;
    @FindBy(xpath = "//label[@for='uploadPicture'][contains(.,'Select picture')]")
    private WebElement selectPictureLabel;
    @FindBy(id = "currentAddress-label")
    private WebElement currentAddressLabel;
    @FindBy(id = "stateCity-label")
    private WebElement stateAndCityLabel;
    @FindBy(id = "firstName")
    private WebElement firstName;
    @FindBy(id = "lastName")
    private WebElement lastName;
    @FindBy(id = "userEmail")
    private WebElement email;
    @FindBy(id = "gender-radio-1")
    private WebElement maleRadioButton;
    @FindBy(id = "gender-radio-2")
    private WebElement femaleRadioButton;
    @FindBy(id = "gender-radio-3")
    private WebElement otherRadioButton;
    @FindBy(id = "userNumber")
    private WebElement mobile;
    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirth;
    @FindBy(id = "subjectsInput")
    private WebElement subjects;
    @FindBy(id = "hobbies-checkbox-1")
    private WebElement sportHobbyCheckbox;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Practice Form')]")
    private WebElement practiceFormLabel;
    @FindBy(xpath = "//h5[contains(.,'Student Registration Form')]")
    private WebElement studentRegistrationFormLabel;
    @FindBy(id = "userName-label")
    private WebElement nameLabel;
    @FindBy(id = "userEmail-label")
    private WebElement userEmailLabel;
    @FindBy(xpath = "(//div[contains(.,'Gender')])[8]")
    private WebElement genderLabel;
    @FindBy(xpath = "//label[@for='gender-radio-1'][contains(.,'Male')]")
    private WebElement maleRadioButtonLabel;
    @FindBy(xpath = "//label[@for='gender-radio-2'][contains(.,'Female')]")
    private WebElement femaleRadioButtonLabel;
    @FindBy(xpath = "//label[@for='gender-radio-3'][contains(.,'Other')]")
    private WebElement otherRadioButtonLabel;
    @FindBy(id = "dateOfBirth-label")
    private WebElement dateOfBirthLabel;
    @FindBy(id = "userNumber-label")
    private WebElement mobileNumberLabel;
    @FindBy(id = "subjects-label")
    private WebElement subjectsLabel;
    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement header;
    @FindBy(id = "closeLargeModal")
    private WebElement closeLargeModal;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.javaScriptUtility = new JavaScriptUtility(driver);
    }

    public String getStudentNameValueFromModal() {
        return studentNameForm.getText();
    }

    public String getEmailFromModal() {
        return emailForm.getText();
    }

    public String getLabelTextFromModal() {
        return labelForm.getText();
    }

    public String getValuesTextFromModal() {
        return valuesForm.getText();
    }

    public String getFirstNamePlaceholderText() {
        return firstName.getDomAttribute("placeholder");
    }

    public String getLastNamePlaceholderText() {
        return lastName.getDomAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return email.getDomAttribute("placeholder");
    }

    public String getMobileNumberPlaceholderText() {
        return mobile.getDomAttribute("placeholder");
    }

    public String getDateOfBirthPlaceholder() {
        return dateOfBirth.getDomAttribute("value");
    }

    public String getCurrentAddressPlaceholder() {
        return currentAddressArea.getDomAttribute("placeholder");
    }

    public String getSelectStatePlaceholder() {
        return selectState.getText();
    }

    public String getCityPlaceholder() {
        return selectCity.getText();
    }

    public String getPlaceholderSubjects() {
        return subjects.getDomAttribute("placeholder");
    }

    public String getEmailLLabel() {
        return userEmailLabel.getText();
    }

    public String getDateOfBirthLabel() {
        return dateOfBirthLabel.getText();
    }

    public String getSubjectLabel() {
        return subjectsLabel.getText();
    }

    public String getHobbySportText() {
        return sportsLabel.getText();
    }

    public String getCurrentAddressLabel() {
        return currentAddressLabel.getText();
    }

    public String getStateAndCityLabel() {
        return stateAndCityLabel.getText();
    }

    public String getStateAndCityValueFromModal() {
        return stateAndCityForm.getText();
    }

    public String getGenderFromModal() {
        return genderForm.getText();
    }

    public String getMobileFromModal() {
        return mobileForm.getText();
    }

    public String getMaleGenderColor() {
        return maleRadioButtonLabel.getCssValue("color");
    }

    public String getFemaleGenderColor() {
        return femaleRadioButtonLabel.getCssValue("color");
    }

    public String getOtherGenderColor() {
        return otherRadioButtonLabel.getCssValue("color");
    }

    public String getBorderColorOfDateOfBirth() {
        return dateOfBirth.getCssValue("border-color");
    }

    public String getHobbiesReadingColor() {
        return readingLabel.getCssValue("color");
    }

    public String getHobbiesSportColor() {
        return sportsLabel.getCssValue("color");
    }

    public String getHobbiesMusicColor() {
        return musicLabel.getCssValue("color");
    }

    public String getBorderColorCurrentAddress() {
        return currentAddressArea.getCssValue("border-color");
    }

    public String getPracticeFormLabel() {
        return practiceFormLabel.getText();
    }

    public String getStudentRegistrationFormLabel() {
        return studentRegistrationFormLabel.getText();
    }

    public String getNameLabel() {
        return nameLabel.getText();
    }

    public String getGenderLabel() {
        return genderLabel.getText();
    }

    public String getMobileNumberLabel() {
        return mobileNumberLabel.getText();
    }

    public String getMaleGenderText() {
        return maleRadioButtonLabel.getText();
    }

    public String getFemaleGenderText() {
        return femaleRadioButtonLabel.getText();
    }

    public String getOtherRadioButtonGenderText() {
        return otherRadioButtonLabel.getText();
    }

    public String getHobbiesLabel() {
        return hobbiesLabel.getText();
    }

    public String getPictureLabel() {
        return pictureLabel.getText();
    }

    public String getReadingLabel() {
        return readingLabel.getText();
    }

    public String getMusicLabel() {
        return musicLabel.getText();
    }

    public String getSelectPictureLabel() {
        return selectPictureLabel.getText();
    }

    public String getSubmitButtonBackgroundColor() {
        return submitButton.getCssValue("background-color");
    }

    public String getSubmitButtonText() {
        return submitButton.getText();
    }

    public String getPictureFromModal() {
        return pictureForm.getText();
    }

    public String getStudentNameLabelFromModal() {
        return studentNameLabel.getText();
    }

    public String getStudentEmailLabelFromModal() {
        return emailLabelForm.getText();
    }

    public String getGenderLabelFromModal() {
        return genderLabelForm.getText();
    }

    public String getMobileLabelFromModal() {
        return mobileLabelForm.getText();
    }

    public String getDateOfBirthLabelFromModal() {
        return dateOfBirthLabelForm.getText();
    }

    public String getSubjectsLabelFromModal() {
        return subjectsLabelForm.getText();
    }

    public String getHobbiesLabelFromModal() {
        return hobbiesLabelForm.getText();
    }

    public String getPictureLabelFromModal() {
        return pictureLabelForm.getText();
    }

    public String getAddressLabelFromModal() {
        return addressLabelForm.getText();
    }

    public String getStateAndCityLabelFromModal() {
        return stateAndCityLabelForm.getText();
    }

    public String getCloseButtonBackgroundColor() {
        return closeLargeModal.getCssValue("background-color");
    }

    public boolean isFemaleRadioButtonSelected() {
        return femaleRadioButton.isSelected();
    }

    public boolean isOtherRadioButtonSelected() {
        return otherRadioButton.isSelected();
    }

    public boolean isMaleRadioButtonSelected() {
        return maleRadioButton.isSelected();
    }

    public String getHobbiesFromModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(this.hobbiesForm));
        return hobbiesForm.getText();
    }

    public String getAddressFromModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(this.addressForm));
        return addressForm.getText();
    }

    public String getDateOfBirthFromModal() {
        javaScriptUtility.scrollToElementJS(dateOfBirthForm);
        return dateOfBirthForm.getText();
    }

    public String getSubjectsFromModal() {
        javaScriptUtility.scrollToElementJS(subjectsForm);
        return subjectsForm.getText();
    }

    public void setSubject(String subject) {
        subjects.sendKeys(subject);
        subjects.sendKeys("" + Keys.ENTER);
        delay(300);
    }

    public void setFirstName(String firstName) {
        this.firstName.click();
        set(this.firstName, firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.click();
        set(this.lastName, lastName);
    }

    public void setEmail(String email) {
        javaScriptUtility.scrollToElementJS(this.email);
        this.email.click();
        set(this.email, email);
    }

    public void setMobile(String mobile) {
        this.mobile.click();
        set(this.mobile, mobile);
    }

    public void setCurrentAddress(String currentAddress) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.currentAddressArea));
        javaScriptUtility.scrollToElementJS(currentAddressArea);
        currentAddressArea.click();
        set(this.currentAddressArea, currentAddress);
    }

    public void clickGenderRadioButton(String gender) {
        switch (gender) {
            case "Male" -> javaScriptUtility.clickJS(maleRadioButton);
            case "Female" -> javaScriptUtility.clickJS(femaleRadioButton);
            case "Other" -> javaScriptUtility.clickJS(otherRadioButton);
        }
    }

    public void setDateOfBirth(String month, String year, String day) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateOfBirthInput = wait.until(ExpectedConditions.visibilityOf(this.dateOfBirth));
        javaScriptUtility.scrollToElementJS(dateOfBirth);
        javaScriptUtility.clickJS(dateOfBirthInput);

        WebElement monthSelectElement = wait.until(ExpectedConditions.visibilityOf(select_month));
        Select monthSelect = new Select(monthSelectElement);
        monthSelect.selectByVisibleText(month);

        WebElement yearSelectElement = wait.until(ExpectedConditions.visibilityOf(select_year));
        Select yearSelect = new Select(yearSelectElement);
        javaScriptUtility.clickJS(yearSelectElement);
        yearSelect.selectByVisibleText(year);

        WebElement dateSelectElement = wait.until(ExpectedConditions.visibilityOf(select_date));
        javaScriptUtility.clickJS(dateSelectElement);
    }

    public void clickSportHobbyCheckbox() {
        if (!sportHobbyCheckbox.isSelected()) {
            javaScriptUtility.scrollToElementJS(sportHobbyCheckbox);
            javaScriptUtility.clickJS(sportHobbyCheckbox);
        }
    }

    public void clickReadingHobbyCheckbox() {
        if (!readingHobbyCheckbox.isSelected()) {
            javaScriptUtility.scrollToElementJS(readingHobbyCheckbox);
            javaScriptUtility.clickJS(readingHobbyCheckbox);
        }
    }

    public void clickMusicHobbyCheckbox() {
        if (!musicHobbyCheckbox.isSelected()) {
            javaScriptUtility.scrollToElementJS(musicHobbyCheckbox);
            javaScriptUtility.clickJS(musicHobbyCheckbox);
        }
    }

    public void clickSubmitButton() {
        javaScriptUtility.scrollToElementJS(submitButton);
        submitButton.click();
        delay(300);
    }

    public void clickSubmitButton2() {
        javaScriptUtility.scrollToElementJS(submitButton);
        submitButton.click();
    }

    public String getFilePathFromResources(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/resources/screenshots/" + fileName);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public void uploadFile(String pathOfFile) {
        uploadPicture.sendKeys(pathOfFile);
    }

    public void setState(String expectedState) {
        selectStates.sendKeys(expectedState);
        selectStates.sendKeys("" + Keys.ENTER);
    }

    public void setCity(String expectedCity) {
        cities.sendKeys(expectedCity);
        cities.sendKeys("" + Keys.ENTER);
    }

    public String getBorderColorOfFirstName(String expectedColor) {
        javaScriptUtility.scrollToElementJS(practiceFormLabel);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(lastName, "border-color", expectedColor));
        return firstName.getCssValue("border-color");
    }

    public String getBorderColorOfLastName(String expectedColor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(lastName, "border-color", expectedColor));

        return lastName.getCssValue("border-color");
    }

    public String getBorderColorOfEmail(String expectedColor) {
        javaScriptUtility.scrollToElementJS(email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(email, "border-color", expectedColor));
        return email.getCssValue("border-color");
    }

    public String getBorderColorOfMobile(String expectedColor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(mobile, "border-color", expectedColor));
        return mobile.getCssValue("border-color");
    }

    public String getHeaderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(this.header));
        return header.getText();
    }

    public String getCloseButtonText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(this.closeLargeModal));
        return closeLargeModal.getText();
    }
}