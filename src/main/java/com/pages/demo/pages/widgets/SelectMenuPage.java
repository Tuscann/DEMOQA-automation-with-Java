package com.pages.demo.pages.widgets;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import java.util.List;

import static utilities.DropDownUtility.*;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class SelectMenuPage extends BasePage {

    private final By selectValue = By.id("react-select-2-input");
    private final By selectOne = By.id("react-select-3-input");
    private final By oldStyle = By.id("oldSelectMenu");
    private final By standardMultiSelect = By.id("cars");
    private final By dropDown = By.id("react-select-4-input");

    public void selectStandardMultiByText(String text) {
        scrollToElementJS(standardMultiSelect);
        selectByVisibleText(standardMultiSelect, text);
    }

    public void selectStandardMultiByIndex(int index) {
        scrollToElementJS(standardMultiSelect);
        selectByIndex(standardMultiSelect, index);
    }

    public void deselectStandardMulti(String value) {
        scrollToElementJS(standardMultiSelect);
        deselectByValue(standardMultiSelect, value);
    }

    public List<String> getAllSelectedStandardMultiOptions() {
        return getAllSelectedOptions(standardMultiSelect);
    }


}
