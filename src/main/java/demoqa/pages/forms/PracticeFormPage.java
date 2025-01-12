package demoqa.pages.forms;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends BasePage {
    private final By practiceFormLabel = By.xpath("//h1[@class='text-center'][contains(.,'Practice Form')]");
    private final By studentRegistrationFormLabel = By.xpath("//h5[contains(.,'Student Registration Form')]");
    private final By nameLabel = By.id("userName-label");
    private final By userEmailLabel = By.id("userEmail-label");
    private final By genderLabel = By.xpath("(//div[contains(.,'Gender')])[8]");
    private final By maleRadioButtonLabel = By.xpath("//label[@for='gender-radio-1'][contains(.,'Male')]");
    private final By femaleRadioButtonLabel = By.xpath(" //label[@for='gender-radio-2'][contains(.,'Female')]");
    private final By otherRadioButtonLabel = By.xpath("//label[@for='gender-radio-3'][contains(.,'Other')]");
    private final By dateOfBirthLabel = By.id("dateOfBirth-label");
    private final By mobileNumberLabel = By.id("userNumber-label");
    private final By subjectsLabel = By.id("subjects-label");
    private final By hobbiesLabel = By.xpath("//label[@class='form-label'][contains(.,'Hobbies')]");
    private final By pictureLabel = By.xpath("//label[@class='form-label'][contains(.,'Picture')]");
    private final By sportsLabel = By.xpath("//label[@for='hobbies-checkbox-1'][contains(.,'Sports')]");
    private final By readingLabel = By.xpath("//label[@for='hobbies-checkbox-2'][contains(.,'Reading')]");
    private final By musicLabel = By.xpath("//label[@for='hobbies-checkbox-3'][contains(.,'Music')]");
    private final By selectPictureLabel = By.xpath("//label[@for='uploadPicture'][contains(.,'Select picture')]");
    private final By currentAddressLabel = By.id("currentAddress-label");
    private final By stateAndCityLabel = By.id("stateCity-label");

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By maleRadioButton = By.id("gender-radio-1");
    private final By femaleRadioButton = By.id("gender-radio-2");
    private final By otherRadioButton = By.id("gender-radio-3");
    private final By mobile = By.id("userNumber");
    private final By dateOfBirth = By.id("dateOfBirthInput");
    private final By subjects = By.id("subjectsInput");
    private final By sportHobbyCheckbox = By.id("hobbies-checkbox-1");
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

    public String getSelectPictureLabel() {
        return find(selectPictureLabel).getText();
    }

    public String getHobbiesLabel() {
        return find(hobbiesLabel).getText();
    }

    public String getPictureLabel() {
        return find(pictureLabel).getText();
    }

    public String getReadingLabel() {
        return find(readingLabel).getText();
    }

    public String getMusicLabel() {
        return find(musicLabel).getText();
    }

    public String getMobileNumberLabel() {
        return find(mobileNumberLabel).getText();
    }

    public String getMaleGenderText() {
        return find(maleRadioButtonLabel).getText();
    }

    public String getFemaleGenderText() {
        return find(femaleRadioButtonLabel).getText();
    }

    public String getOtherRadioButtonGenderText() {
        return find(otherRadioButtonLabel).getText();
    }

    public String getGenderLabel() {
        return find(genderLabel).getText();
    }

    public String getNameLabel() {
        return find(nameLabel).getText();
    }

    public String getPracticeFormLabel() {
        return find(practiceFormLabel).getText();
    }

    public String getStudentRegistrationFormLabel() {
        return find(studentRegistrationFormLabel).getText();
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
        return find(firstName).getDomAttribute("placeholder");
    }

    public String getLastNamePlaceholderText() {
        return find(lastName).getDomAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return find(email).getDomAttribute("placeholder");
    }

    public String getMobileNumberPlaceholderText() {
        return find(mobile).getDomAttribute("placeholder");
    }

    public String getDateOfBirthPlaceholder() {
        return find(dateOfBirth).getDomAttribute("value");
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
        return find(subjects).getDomAttribute("placeholder");
    }

    public void setSubject(String subject) {
        find(subjects).sendKeys(subject);
        find(subjects).sendKeys("" + Keys.ENTER);
    }

    public void setFirstName(String firstName) {
        click(this.firstName);
        set(this.firstName, firstName);
    }

    public void setLastName(String lastName) {
        click(this.lastName);
        set(this.lastName, lastName);
    }

    public void setEmail(String email) {
        scrollToElementJS(this.email);
        click(this.email);
        set(this.email, email);
    }

    public void setMobile(String mobile) {
        click(this.mobile);
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

    public void setDateOfBirth(String dateOfBirth) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.dateOfBirth))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), dateOfBirth, Keys.chord(Keys.ENTER));
    }

    public boolean isFemaleRadioButtonSelected() {
        return find(femaleRadioButton).isSelected();
    }

    public boolean isOtherRadioButtonSelected() {
        return find(otherRadioButton).isSelected();
    }

    public boolean isMaleRadioButtonSelected() {
        return find(maleRadioButton).isSelected();
    }

    public void clickSportHobbyCheckbox() {
        if (!find(sportHobbyCheckbox).isSelected()) {
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
        return find(sportHobbyCheckbox).isSelected();
    }

    public String getEmailLLabel() {
        return find(userEmailLabel).getText();
    }

    public String getDateOfBirthLabel() {
        return find(dateOfBirthLabel).getText();
    }

    public String getSubjectLabel() {
        return find(subjectsLabel).getText();
    }

    public String getHobbySportText() {
        return find(sportsLabel).getText();
    }

    public String getCurrentAddressLabel() {
        return find(currentAddressLabel).getText();
    }

    public String getStateAndCityLabel() {
        return find(stateAndCityLabel).getText();
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

        WebElement webElement = driver.findElement(firstName);

        return webElement.getCssValue("border-color");
    }

    public String getColorOfLastNameBorder(String expectedColor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(lastName, "border-color", expectedColor));

        return driver.findElement(lastName).getCssValue("border-color");
    }

    public String getColorOfEmail() {
        return driver.findElement(email).getCssValue("border-color");
    }

    public String getMaleGenderColor() {
        return driver.findElement(maleRadioButtonLabel).getCssValue("color");
    }

    public String getFemaleGenderColor() {
        return driver.findElement(femaleRadioButtonLabel).getCssValue("color");
    }

    public String getOtherGenderColor() {
        return driver.findElement(otherRadioButtonLabel).getCssValue("color");
    }

    public String getColorOfMobile(String expectedColor) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(mobile, "border-color", expectedColor));
        return driver.findElement(mobile).getCssValue("border-color");
    }

    public String getColorOfDateOfBirth() {
        return driver.findElement(dateOfBirth).getCssValue("border-color");
    }

    public String getHobbiesReadingColor() {
        return driver.findElement(readingLabel).getCssValue("color");
    }

    public String getHobbiesSportColor() {
        return driver.findElement(sportsLabel).getCssValue("color");
    }

    public String getHobbiesMusicColor() {
        return driver.findElement(musicLabel).getCssValue("color");
    }

    public String getCurrentAddressColor() {
        return driver.findElement(currentAddressArea).getCssValue("border-color");
    }
}
