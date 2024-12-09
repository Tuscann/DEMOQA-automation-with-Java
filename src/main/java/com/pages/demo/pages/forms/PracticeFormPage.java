package com.pages.demo.pages.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.JavaScriptUtility.clickJS;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class PracticeFormPage extends FormsPage {
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
    private final By currentAddressArea = By.id("currentAddress");
    private final By selectState = By.id("state");
    private final By selectCity = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select City')]");
    private final By submitButton = By.id("submit");

    private final By label = By.xpath("//th[contains(.,'Label')]");
    private final By values = By.xpath("//th[contains(.,'Label')]/following-sibling::*[1]");
    private final By StudentNameForm = By.xpath("//td[contains(.,'Student Name')]/following-sibling::*[1]");
    private final By emailForm = By.xpath("//td[contains(.,'Student Email')]/following-sibling::*[1]");
    private final By genderForm = By.xpath("//td[contains(.,'Gender')]/following-sibling::*[1]");
    private final By mobileForm = By.xpath("//td[contains(.,'Mobile')]/following-sibling::*[1]");
    private final By dateOfBirthForm = By.xpath("//td[contains(.,'Date of Birth')]/following-sibling::*[1]");
    private final By subjectsForm = By.xpath("//td[contains(.,'Subjects')]/following-sibling::*[1]");
    private final By hobbiesForm = By.xpath("//td[contains(.,'Hobbies')]/following-sibling::*[1]");
    private final By pictureForm = By.xpath("//td[contains(.,'Picture')]/following-sibling::*[1]");
    private final By addressForm = By.xpath("//td[contains(.,'Address')]/following-sibling::*[1]");
    private final By stateAndCityForm = By.xpath("//td[contains(.,'State')]/following-sibling::*[1]");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public String getStudentNameFromModal() {
        delay(1500);
        return find(StudentNameForm).getText();
    }

    public String getEmailFromModal() {
        return find(emailForm).getText();
    }

    public String getLabelFromModal() {
        return find(label).getText();
    }

    public String getValuesFromModal() {
        return find(values).getText();
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

    public String getPlaceholderFullName() {
        return find(firstName).getAttribute("placeholder");
    }

    public String getPlaceholderLastName() {
        return find(lastName).getAttribute("placeholder");
    }

    public String getPlaceholderEmail() {
        return find(email).getAttribute("placeholder");
    }

    public String getPlaceholderMobile() {
        return find(mobile).getAttribute("placeholder");
    }

    public String getPlaceholderDateOfBirth() {
        return find(dateOfBirth).getAttribute("placeholder");
    }

    public String getPlaceholderCurrentAddress() {
        return find(currentAddressArea).getAttribute("placeholder");
    }

    public String getPlaceholderState() {
        return find(selectState).getAttribute("placeholder");
    }

    public String getPlaceholderCity() {
        return find(selectCity).getAttribute("placeholder");
    }

    public String getPlaceholderSubjects() {
        return find(subjects).getAttribute("placeholder");
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.dateOfBirth))
                .sendKeys(Keys.chord(Keys.CONTROL, "a"), dateOfBirth, Keys.chord(Keys.ENTER));


    }

    public boolean isFemaleRadioButtonSelected() {
        return find(femaleRadioButton).isSelected();
    }

    public boolean isOtherRadioButtonSelected() {
        return find(otherRadioButton).isSelected();
    }

    public boolean isМaleRadioButtonSelected() {
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

    public void setDropDown(String expectedState) {
        click(selectState);
        //  find(selectState).sendKeys("" + Keys.DOWN);

    }
}
