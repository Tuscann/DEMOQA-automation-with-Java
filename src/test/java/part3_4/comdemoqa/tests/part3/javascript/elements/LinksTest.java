package part3_4.comdemoqa.tests.part3.javascript.elements;

import org.testng.Assert;
import org.testng.annotations.Test;
import part3_4.comdemoqa.base.BaseTest;

public class LinksTest extends BaseTest {
    @Test
    public void ClickLinkBadRequest() {
        var webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickBadRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("400")
                        && actualResponse.contains("Bad Request"),
                "\n Actual Response (" + actualResponse +
                        ")\n Does Not Contain '400' and 'Bad Request' \n");
    }

    @Test
    public void ClickLinkCreatedRequest() {
        var webTablePage = homePage.goToElements().clickLinks();
        webTablePage.clickCreatedRequestLink();
        String actualResponse = webTablePage.getResponse();

        Assert.assertTrue(actualResponse.contains("201")
                        && actualResponse.contains("Created"),
                "\n Link has responded with staus" + actualResponse +
                        ")\n and status text Created \n");
    }
}
