package com.pages.demo.pages.bookStoreApplication;

import com.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class BooksPage extends BasePage {
    private final By loginLink = By.xpath("//span[@class='text'][contains(.,'Login')]");
    private final By bookStoreLink = By.xpath("//span[@class='text'][contains(.,'Book Store')]");
    private final By profileLink = By.xpath("//span[@class='text'][contains(.,'Profile')]");
    private final By BookStoreAPILink = By.xpath("//span[contains(.,'Book Store API')]");
    private final By searchBox = By.id("searchBox");
    private final By searchIcon = By.id("basic-addon2");
    private final By loginButton = By.id("login");
    private final By topRowTable = By.className("rt-tr");
    private final By allRows = By.className("rt-tr-group");
    private final By rowPerPage = By.xpath("//select");
    private final By nextButton = By.xpath("//button[contains(.,'Next')]");
    private final By previousButton = By.xpath("//button[contains(.,'Previous')]");
    private final By noRowsFound = By.className("rt-noData");

    private final By title = By.xpath("(//div[contains(@class,'rt-resizable-header-content')])[2]");
    private final By author = By.xpath("(//div[contains(@class,'rt-resizable-header-content')])[3]");
    private final By publisher = By.xpath("(//div[contains(@class,'rt-resizable-header-content')])[4]");

    public void clickTitle() {
        click(title);
    }

    public void clickAuthor() {
        click(author);
    }

    public void clickPublisher() {
        click(publisher);
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
        WebElement dropdownElement = driver.findElement(rowPerPage);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(booksPerPage);
    }

    public String getTopRowTable() {
        return find(topRowTable).getText();
    }

    public void clickLoginLink() {
        scrollToElementJS(loginLink);
        click(loginLink);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void clickBookStoreLink() {
        scrollToElementJS(bookStoreLink);
        click(bookStoreLink);
    }

    public void clickProfileLink() {
        click(profileLink);
    }

    public void clickBookStoreAPILink() {
        click(BookStoreAPILink);
    }


    public int getCountOfAllRows() {
        List<WebElement> elements = driver.findElements(allRows);

        return elements.size();
    }

    public int getCountFoundBooks() {
        List<WebElement> elements = driver.findElements(allRows);

        int count = 0;
        for (WebElement element : elements) {
            var x = element.getText();
            if (!element.getText().equals("    ")) {
                count++;
            }
        }

        return count;
    }

    public String getFoundBooks() {
        List<WebElement> elements = driver.findElements(allRows);

        StringBuilder all = new StringBuilder();
        for (WebElement element : elements) {
            String x = element.getText();
            if (!element.getText().equals("    ")) {
                all.append(x).append("\n");
            }
        }

        return all.toString();
    }

    public String getAllFoundBooks() {
        return find(allRows).getText();
    }

    public void searchBooksWithWord(String searchedBook) {
        set(searchBox, searchedBook);
    }

    public String noRowsFound() {
        return find(noRowsFound).getText();
    }
}
