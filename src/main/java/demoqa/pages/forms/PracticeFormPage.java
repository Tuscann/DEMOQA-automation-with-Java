package demoqa.pages.forms;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends BasePage {

    private final By readingHobbyCheckbox = By.id("hobbies-checkbox-2");
    private final By musicHobbyCheckbox = By.id("hobbies-checkbox-3");
    private final By uploadPicture = By.id("uploadPicture");
    private final By currentAddressArea = By.id("currentAddress");
    private final By states22 = By.id("react-select-3-input");
    private final By cities = By.id("react-select-4-input");
    private final By selectState = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select State')]");
    private final By selectCity = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select City')]");
    private final By submitButton = By.id("submit");
    private final By labelForm = By.xpath("//th[contains(.,'Label')]");
    private final By valuesForm = By.xpath("//th[contains(.,'Label')]/following-sibling::*[1]");
    private final By studentNameForm = By.xpath("//td[contains(.,'Student Name')]/following-sibling::*[1]");
    private final By emailForm = By.xpath("//td[contains(.,'Student Email')]/following-sibling::*[1]");
    private final By genderForm = By.xpath("//td[contains(.,'Gender')]/following-sibling::*[1]");
    private final By mobileForm = By.xpath("//td[contains(.,'Mobile')]/following-sibling::*[1]");
    private final By dateOfBirthForm = By.xpath("//td[contains(.,'Date of Birth')]/following-sibling::*[1]");
    private final By subjectsForm = By.xpath("//td[contains(.,'Subjects')]/following-sibling::*[1]");
    private final By hobbiesForm = By.xpath("//td[contains(.,'Hobbies')]/following-sibling::*[1]");
    private final By pictureForm = By.xpath("//td[contains(.,'Picture')]/following-sibling::*[1]");
    private final By addressForm = By.xpath("//td[contains(.,'Address')]/following-sibling::*[1]");
    private final By stateAndCityForm = By.xpath("//td[contains(.,'State')]/following-sibling::*[1]");
    @FindBy(xpath = "/html/body/div[4]/div/div/div[2]/p")
    public WebElement pLoremIpsumSimplyDummy;
    @FindBy(xpath = "//label[@class='form-label'][contains(.,'Hobbies')]")
    WebElement hobbiesLabel;
    @FindBy(xpath = "//label[@class='form-label'][contains(.,'Picture')]")
    WebElement pictureLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1'][contains(.,'Sports')]")
    WebElement sportsLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2'][contains(.,'Reading')]")
    WebElement readingLabel;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3'][contains(.,'Music')]")
    WebElement musicLabel;
    @FindBy(xpath = "//label[@for='uploadPicture'][contains(.,'Select picture')]")
    WebElement selectPictureLabel;
    @FindBy(id = "currentAddress-label")
    WebElement currentAddressLabel;
    @FindBy(id = "stateCity-label")
    WebElement stateAndCityLabel;
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(id = "gender-radio-1")
    WebElement maleRadioButton;
    @FindBy(id = "gender-radio-2")
    WebElement femaleRadioButton;
    @FindBy(id = "gender-radio-3")
    WebElement otherRadioButton;
    @FindBy(id = "userNumber")
    WebElement mobile;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;
    @FindBy(id = "subjectsInput")
    WebElement subjects;
    @FindBy(id = "hobbies-checkbox-1")
    WebElement sportHobbyCheckbox;
    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Practice Form')]")
    WebElement practiceFormLabel;
    @FindBy(xpath = "//h5[contains(.,'Student Registration Form')]")
    WebElement studentRegistrationFormLabel;
    @FindBy(id = "userName-label")
    WebElement nameLabel;
    @FindBy(id = "userEmail-label")
    WebElement userEmailLabel;
    @FindBy(xpath = "(//div[contains(.,'Gender')])[8]")
    WebElement genderLabel;
    @FindBy(xpath = "//label[@for='gender-radio-1'][contains(.,'Male')]")
    WebElement maleRadioButtonLabel;
    @FindBy(xpath = "//label[@for='gender-radio-2'][contains(.,'Female')]")
    WebElement femaleRadioButtonLabel;
    @FindBy(xpath = "//label[@for='gender-radio-3'][contains(.,'Other')]")
    WebElement otherRadioButtonLabel;
    @FindBy(id = "dateOfBirth-label")
    WebElement dateOfBirthLabel;
    @FindBy(id = "userNumber-label")
    WebElement mobileNumberLabel;
    @FindBy(id = "subjects-label")
    WebElement subjectsLabel;


    public PracticeFormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSelectPictureLabel() {
        return selectPictureLabel.getText();
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

    public String getGenderLabel() {
        return genderLabel.getText();
    }

    public String getNameLabel() {
        return nameLabel.getText();
    }

    public String getPracticeFormLabel() {
        return practiceFormLabel.getText();
    }

    public String getStudentRegistrationFormLabel() {
        return studentRegistrationFormLabel.getText();
    }

    public String getStudentNameFromModal() {
        delay(1500);
        return find(studentNameForm).getText();
    }

    public String getEmailFromModal() {
        return find(emailForm).getText();
    }

    public String getLabelFromModal() {
        return find(labelForm).getText();
    }

    public String getValuesFromModal() {
        return find(valuesForm).getText();
    }

    public String getHobbiesFromModal() {
        return find(hobbiesForm).getText();
    }

    public String getPictureFromModal() {
        return find(pictureForm).getText();
    }

    public String getCurrentAddressFromModal() {
        return find(addressForm).getText();
    }

    public String getStateAndCityFromModal() {
        return find(stateAndCityForm).getText();
    }

    public String getGenderFromModal() {
        return find(genderForm).getText();
    }

    public String getMobileFromModal() {
        return find(mobileForm).getText();
    }

    public String getDateOfBirthFromModal() {
        return find(dateOfBirthForm).getText();
    }

    public String getSubjectsFromModal() {
        return find(subjectsForm).getText();
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
        return find(currentAddressArea).getDomAttribute("placeholder");
    }

    public String getSelectStatePlaceholder() {
        return find(selectState).getText();
    }

    public String getCityPlaceholder() {
        return find(selectCity).getText();
    }

    public String getPlaceholderSubjects() {
        return subjects.getDomAttribute("placeholder");
    }

    public void setSubject(String subject) {
        subjects.sendKeys(subject);
        subjects.sendKeys("" + Keys.ENTER);
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
        scrollToElementJS(this.email);
        this.email.click();
        set(this.email, email);
    }

    public void setMobile(String mobile) {
        this.mobile.click();
        set(this.mobile, mobile);
    }

    public void setCurrentAddress(String currentAddress) {
        click(this.currentAddressArea);
        set(this.currentAddressArea, currentAddress);
    }

    public void clickGenderRadioButton(String gender) {
        switch (gender) {
            case "Male" -> clickJS(maleRadioButton);
            case "Female" -> clickJS(femaleRadioButton);
            case "Other" -> clickJS(otherRadioButton);
        }
    }

    public void setDateOfBirth(String expectedDateOfBirth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateOfBirthInput = wait.until(ExpectedConditions.visibilityOf(this.dateOfBirth));


        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        dateOfBirthInput.sendKeys(Keys.BACK_SPACE);
        //dateOfBirthInput.sendKeys(Keys.DELETE);
        // dateOfBirthInput.sendKeys(Keys.BACK_SPACE);

        // dateOfBirthInput.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        dateOfBirthInput.sendKeys(expectedDateOfBirth);        // Enter the new date
        dateOfBirthInput.sendKeys(Keys.ENTER);         // Press Enter (if needed)
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

    public void clickSportHobbyCheckbox() {
        if (!sportHobbyCheckbox.isSelected()) {
            scrollToElementJS(sportHobbyCheckbox);
            clickJS(sportHobbyCheckbox);
        }
    }

    public void clickReadingHobbyCheckbox() {
        if (!find(readingHobbyCheckbox).isSelected()) {
            scrollToElementJS(readingHobbyCheckbox);
            clickJS(readingHobbyCheckbox);
        }
    }

    public void clickMusicHobbyCheckbox() {
        if (!find(musicHobbyCheckbox).isSelected()) {
            scrollToElementJS(musicHobbyCheckbox);
            clickJS(musicHobbyCheckbox);
        }
    }

    public void unClickReadingHobbyCheckbox() {
        if (find(readingHobbyCheckbox).isSelected()) {
            scrollToElementJS(readingHobbyCheckbox);
            clickJS(readingHobbyCheckbox);
        }
    }

    public void clickSubmitButton() {
        scrollToElementJS(submitButton);
        click(submitButton);
    }

    public boolean isReadingCheckBoxSelected() {
        return find(readingHobbyCheckbox).isSelected();
    }

    public boolean isMusicCheckBoxSelected() {
        return find(musicHobbyCheckbox).isSelected();
    }

    public boolean isSportCheckBSelected() {
        return sportHobbyCheckbox.isSelected();
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

    public String getSubmitButtonText() {
        return find(submitButton).getText();
    }

    public String getFilePathFromResources(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/resources/screenshots/" + fileName);
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public void uploadFile(String pathOfFile) {
        WebElement fileInput = driver.findElement(uploadPicture);

        fileInput.sendKeys(pathOfFile);
    }

    public void setState(String expectedState) {
        find(states22).sendKeys(expectedState);
        find(states22).sendKeys("" + Keys.ENTER);
    }

    public void setCity(String expectedCity) {
        find(cities).sendKeys(expectedCity);
        find(cities).sendKeys("" + Keys.ENTER);
    }

    public String getColorOfFirstNameBorder(String expectedColor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(firstName, "border-color", expectedColor));

        return firstName.getCssValue("border-color");
    }

    public String getColorOfLastNameBorder(String expectedColor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(lastName, "border-color", expectedColor));

        return lastName.getCssValue("border-color");
    }

    public String getColorOfEmail() {
        return email.getCssValue("border-color");
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

    public String getColorOfMobile(String expectedColor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(mobile, "border-color", expectedColor));
        return mobile.getCssValue("border-color");
    }

    public String getColorOfDateOfBirth() {
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

    public String getCurrentAddressColor() {
        return driver.findElement(currentAddressArea).getCssValue("border-color");
    }
}
