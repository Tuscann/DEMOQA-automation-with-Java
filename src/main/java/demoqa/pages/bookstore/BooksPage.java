package demoqa.pages.bookstore;

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

public class BooksPage extends BasePage {
    private final By nextButton = By.xpath("//button[contains(.,'Next')]");
    private final By previousButton = By.xpath("//button[contains(.,'Previous')]");
    private final By noRowsFound = By.className("rt-noData");
    private final By bookStoreApplication = By.xpath("//div[@class='header-text'][contains(.,'Book Store Application')]");
    private final By collapseDiv = By.xpath("//div[contains(@class,'element-list collapse')]");
    private final By title = By.xpath("(//div[contains(@class,'rt-resizable-header-content')])[2]");
    private final By author = By.xpath("(//div[contains(@class,'rt-resizable-header-content')])[3]");
    @FindBy(xpath = "//span[@class='text'][contains(.,'Login')]")
    WebElement loginLink;
    @FindBy(xpath = "//span[@class='text'][contains(.,'Book Store')]")
    WebElement bookStoreLink;
    @FindBy(xpath = "//span[@class='text'][contains(.,'Profile')]")
    WebElement profileLink;
    @FindBy(xpath = "//span[contains(.,'Book Store API')]")
    WebElement BookStoreAPILink;
    @FindBy(id = "searchBox")
    WebElement searchBox;
    @FindBy(id = "basic-addon2")
    WebElement searchIcon;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(className = "rt-tr")
    WebElement topRowTable;
    @FindBy(className = "rt-tr-group")
    List<WebElement> allRows;
    @FindBy(xpath = "//select")
    WebElement rowPerPage;
    @FindBy(xpath = "(//div[contains(@class,'rt-resizable-header-content')])[4]")
    WebElement publisher;

    public BooksPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickTitle() {
        click(title);
    }

    public void clickAuthor() {
        click(author);
    }

    public void clickPublisher() {
        publisher.click();
    }

    public void clickNextButton() {
        click(nextButton);
    }

    public void clickPreviousButton() {
        click(previousButton);
    }

    public boolean checkPreviousButtonIsActive() {
        scrollToElementJS(previousButton);
        return find(previousButton).isEnabled();
    }

    public boolean checkNextButtonIsActive() {
        scrollToElementJS(previousButton);
        return find(nextButton).isEnabled();
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
        click(bookStoreApplication);
    }

    public void clickProfileLink() {
        profileLink.click();
    }

    public void clickBookStoreAPILink() {
        BookStoreAPILink.click();
    }


    public int getCountOfAllRows() {

        return allRows.size();
    }

    public int getCountFoundBooks() {
        int count = 0;
        for (WebElement element : allRows) {
            var x = element.getText();
            if (!element.getText().equals("    ")) {
                count++;
            }
        }

        return count;
    }

    public String getFoundBooks() {
        StringBuilder all = new StringBuilder();
        for (WebElement element : allRows) {
            String x = element.getText();
            if (!element.getText().equals("    ")) {
                all.append(x).append("\n");
            }
        }
        return all.toString();
    }

    public String getAllFoundBooks() {
        return allRows.getFirst().getText();
    }

    public void searchBooksWithWord(String searchedBook) {
        set(searchBox, searchedBook);
    }

    public String noRowsFound() {
        return find(noRowsFound).getText();
    }

    public boolean verifyLoginIsNotVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.invisibilityOf(profileLink));

        String classAttribute = find(collapseDiv).getDomAttribute("class");

        return classAttribute.equals("element-list collapse show");
    }

    public boolean verifyLoginIsVisible() {
        return find(bookStoreApplication).isDisplayed();
    }

    public void clickBookStoreLink() {
        bookStoreLink.click();
    }
}
