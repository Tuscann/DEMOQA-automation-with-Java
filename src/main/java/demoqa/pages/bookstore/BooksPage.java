package demoqa.pages.bookstore;

import demoqa.base.BasePage;
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

public class BooksPage extends BasePage {
    @FindBy(xpath = "//button[contains(.,'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//button[contains(.,'Previous')]")
    private WebElement previousButton;

    @FindBy(className = "rt-noData")
    private WebElement noRowsFound;

    @FindBy(xpath = "//div[@class='header-text'][contains(.,'Book Store Application')]")
    private WebElement bookStoreApplication;

    @FindBy(xpath = "//div[contains(@class,'element-list collapse')]")
    private WebElement collapseDiv;

    @FindBy(xpath = "(//div[contains(@class,'rt-resizable-header-content')])[2]")
    private WebElement title;

    @FindBy(xpath = "(//div[contains(@class,'rt-resizable-header-content')])[3]")
    private WebElement author;

    @FindBy(xpath = "//span[@class='text'][contains(.,'Login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//span[@class='text'][contains(.,'Book Store')]")
    private WebElement bookStoreLink;

    @FindBy(xpath = "//span[@class='text'][contains(.,'Profile')]")
    private WebElement profileLink;

    @FindBy(xpath = "//span[contains(.,'Book Store API')]")
    private WebElement bookStoreAPILink;

    @FindBy(id = "searchBox")
    private WebElement searchBox;

    @FindBy(id = "basic-addon2")
    private WebElement searchIcon;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(className = "rt-tr")
    private WebElement topRowTable;

    @FindBy(className = "rt-tr-group")
    private List<WebElement> allRows;

    @FindBy(xpath = "//select")
    private WebElement rowPerPage;

    @FindBy(xpath = "(//div[contains(@class,'rt-resizable-header-content')])[4]")
    private WebElement publisher;

    public BooksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickTitle() {
        title.click();
    }

    public void clickAuthor() {
        author.click();
    }

    public void clickPublisher() {
        publisher.click();
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public void clickPreviousButton() {
        previousButton.click();
    }

    public boolean checkPreviousButtonIsActive() {
        scrollToElementJS(previousButton);
        return previousButton.isEnabled();
    }

    public boolean checkNextButtonIsActive() {
        scrollToElementJS(nextButton);
        return nextButton.isEnabled();
    }

    public void chooseBooksPerPage(String booksPerPage) {
        Select dropdown = new Select(rowPerPage);
        dropdown.selectByVisibleText(booksPerPage);
    }

    public String getTopRowTable() {
        return topRowTable.getText();
    }

    public void clickLoginLink() {
        scrollToElementJS(loginLink);
        loginLink.click();
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickBookStoreApplicationLink() {
        scrollToElementJS(bookStoreApplication);
        bookStoreApplication.click();
    }

    public void clickProfileLink() {
        profileLink.click();
    }

    public void clickBookStoreAPILink() {
        scrollToElementJS(bookStoreAPILink);
        bookStoreAPILink.click();
    }

    public int getCountOfAllRows() {
        return allRows.size();
    }

    public int getCountFoundBooks() {
        int count = 0;
        for (WebElement element : allRows) {
            if (!element.getText().trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public String getFoundBooks() {
        StringBuilder all = new StringBuilder();
        for (WebElement element : allRows) {
            String text = element.getText().trim();
            if (!text.isEmpty()) {
                all.append(text).append("\n");
            }
        }
        return all.toString();
    }

    public String getAllFoundBooks() {
        return allRows.getFirst().getText();
    }

    public void searchBooksWithWord(String searchedBook) {
        searchBox.clear();
        searchBox.sendKeys(searchedBook);
    }

    public String noRowsFound() {
        return noRowsFound.getText();
    }

    public boolean verifyLoginIsNotVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.invisibilityOf(profileLink));

        String classAttribute = collapseDiv.getDomAttribute("class");

        return classAttribute.equals("element-list collapse show");
    }

    public boolean verifyLoginIsVisible() {
        return bookStoreApplication.isDisplayed();
    }

    public void clickBookStoreLink() {
        bookStoreLink.click();
    }
}
