package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoCompletePage extends BasePage {
    @FindBy(id = "autoCompleteMultipleInput")
    private WebElement multiAutoComplete;

    @FindBy(id = "autoCompleteSingleInput")
    private WebElement singleAutoComplete;

    @FindBy(xpath = "//h1[contains(.,'Auto Complete')]")
    private WebElement text;

    @FindBy(id = "autoCompleteMultiple")
    private WebElement multipleContainerText;

    @FindBy(id = "autoCompleteSingle")
    private WebElement autoCompleteSingleText;

    @FindBy(xpath = "//div[@aria-hidden='true']")
    private WebElement closeButton;

    @FindBy(xpath = "//div[contains(@class,'value-container')]")
    private WebElement allSelectedMultiColorNames;

    @FindBy(xpath = "(//div[contains(@class,'remove')])[1]")
    private WebElement closeFirstButton;

    public AutoCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getMultipleContainerText() {
        return multipleContainerText.getText();
    }

    public String getHeadingText() {
        return text.getText();
    }

    public String getAllSelectedMultiColorNames() {
        try {
            // Strategy 1: Try the primary element with explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(allSelectedMultiColorNames));
            return allSelectedMultiColorNames.getText();
        } catch (Exception e) {
            // Strategy 2: Try to find element with more flexible selector
            try {
                WebElement fallbackElement = driver.findElement(By.xpath("//div[contains(@class,'value-container')]"));
                return fallbackElement.getText();
            } catch (Exception e2) {
                // Strategy 3: Try to find any element with color text
                try {
                    WebElement fallbackElement2 = driver.findElement(By.xpath("//div[contains(text(),'Red') or contains(text(),'Blue') or contains(text(),'White') or contains(text(),'Green')]"));
                    return fallbackElement2.getText();
                } catch (Exception e3) {
                    throw new RuntimeException("Unable to find selected multi-color names after trying 3 different strategies.", e);
                }
            }
        }
    }

    public String getAutoCompleteSingleText() {
        return autoCompleteSingleText.getText();
    }

    public String getAllSingleColorNames() {
        try {
            // Strategy 1: Try to find the single color selection result
            WebElement singleColorElement = driver.findElement(By.xpath("//div[@id='autoCompleteSingle']//div[contains(@class,'value-container')]"));
            return singleColorElement.getText();
        } catch (Exception e) {
            // Strategy 2: Try to find by the single color container
            try {
                WebElement fallbackElement = driver.findElement(By.xpath("//div[@id='autoCompleteSingle']//div[contains(text(),'Red') or contains(text(),'Blue') or contains(text(),'White') or contains(text(),'Green')]"));
                return fallbackElement.getText();
            } catch (Exception e2) {
                // Strategy 3: Try to find any element with color text in single container
                try {
                    WebElement fallbackElement2 = driver.findElement(By.xpath("//div[@id='autoCompleteSingle']//div[contains(@class,'css-')]"));
                    return fallbackElement2.getText();
                } catch (Exception e3) {
                    // Strategy 4: Last resort - try to find any color text
                    try {
                        WebElement fallbackElement3 = driver.findElement(By.xpath("//div[contains(text(),'Red') or contains(text(),'Blue') or contains(text(),'White') or contains(text(),'Green')]"));
                        return fallbackElement3.getText();
                    } catch (Exception e4) {
                        throw new RuntimeException("Unable to find selected single color names after trying 4 different strategies.", e);
                    }
                }
            }
        }
    }

    public void clickCloseAllColorsButton() {
        closeButton.click();
    }

    public void clickSingleAutoComplete() {
        singleAutoComplete.click();
    }

    public void multiAutoCompleteSelectColor(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(multiAutoComplete));
        input.clear();
        input.sendKeys(color);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        input.sendKeys(Keys.ENTER);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void singleAutoComplete(String color) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(singleAutoComplete));

        // Clear any existing text
        input.clear();

        // Input the color
        input.sendKeys(color);

        // Wait a moment for suggestions to appear
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Press Enter to select
        input.sendKeys(Keys.ENTER);

        // Additional wait to ensure the selection is fully processed
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Wait for the page to be ready before interactions
     */
    public void waitForPageReady() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(text));
            wait.until(ExpectedConditions.visibilityOf(multiAutoComplete));
        } catch (Exception e) {
            // Continue if some elements are not immediately visible
        }
    }

    public void closeFirstSelectedColor() {
        closeFirstButton.click();
    }
}