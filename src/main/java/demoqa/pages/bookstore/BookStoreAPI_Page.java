package demoqa.pages.bookstore;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BookStoreAPI_Page extends BasePage {

    public BookStoreAPI_Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
