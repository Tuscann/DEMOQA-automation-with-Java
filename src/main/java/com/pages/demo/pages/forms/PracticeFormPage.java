package com.pages.demo.pages.forms;

import org.openqa.selenium.By;

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
    private final By subjects = By.id("subjectsContainer");
    private final By sportHobbyCheckbox = By.id("hobbies-checkbox-1");
    private final By readingHobbyCheckbox = By.id("hobbies-checkbox-2");
    private final By musicHobbyCheckbox = By.id("hobbies-checkbox-3");
    private final By currentAddressArea = By.id("currentAddress");
    private final By selectState = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select State')]");
    private final By selectCity = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select City')]");
    private final By submitButton = By.id("submit");

    public void clickFemaleRadioButton() {
        scrollToElementJS(femaleRadioButton);
        clickJS(femaleRadioButton);
    }

    public void clickMaleRadioButton() {
        scrollToElementJS(maleRadioButton);
        clickJS(maleRadioButton);
    }

    public void clickOtherRadioButton() {
        scrollToElementJS(otherRadioButton);
        clickJS(otherRadioButton);
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
        click(submitButton);
    }
}
