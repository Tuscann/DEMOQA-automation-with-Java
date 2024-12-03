package part3_4.comdemoqa.tests.part3.javascript.bookstore;

import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class BooksStoreTest extends BaseTest {

    @Test
    public void test() {
        String xddd = homePage.goToBooks().getClass().toString();

        // TODO to be tested
    }
}
