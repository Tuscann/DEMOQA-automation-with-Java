package demoqa.web.tests.elements;

import demoqa.pages.elements.LinksPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_LINKS_HEADER = "Links";
    private static final String EXPECTED_FOLLOWING_LINKS_NEW_TAB = "Following links will open new tab";
    private static final String EXPECTED_HOME_TEXT = "Home";
    private static final String EXPECTED_FOLLOWING_LINKS_API_CALL = "Following links will send an api call";
    private static final String EXPECTED_CREATED_TEXT = "Created";
    private static final String EXPECTED_NO_CONTENT_TEXT = "No Content";
    private static final String EXPECTED_MOVED_TEXT = "Moved";
    private static final String EXPECTED_BAD_REQUEST_TEXT = "Bad Request";
    private static final String EXPECTED_UNAUTHORIZED_TEXT = "Unauthorized";
    private static final String EXPECTED_FORBIDDEN_TEXT = "Forbidden";
    private static final String EXPECTED_NOT_FOUND_TEXT = "Not Found";

    // HTTP Status Constants
    private static final String EXPECTED_CREATED_STATUS = "201";
    private static final String EXPECTED_CREATED_STATUS_TEXT = "Created";
    private static final String EXPECTED_NO_CONTENT_STATUS = "204";
    private static final String EXPECTED_NO_CONTENT_STATUS_TEXT = "No Content";
    private static final String EXPECTED_MOVED_STATUS = "301";
    private static final String EXPECTED_MOVED_STATUS_TEXT = "Moved Permanently";
    private static final String EXPECTED_BAD_REQUEST_STATUS = "400";
    private static final String EXPECTED_BAD_REQUEST_STATUS_TEXT = "Bad Request";
    private static final String EXPECTED_UNAUTHORIZED_STATUS = "401";
    private static final String EXPECTED_UNAUTHORIZED_STATUS_TEXT = "Unauthorized";
    private static final String EXPECTED_FORBIDDEN_STATUS = "403";
    private static final String EXPECTED_FORBIDDEN_STATUS_TEXT = "Forbidden";
    private static final String EXPECTED_NOT_FOUND_STATUS = "404";
    private static final String EXPECTED_NOT_FOUND_STATUS_TEXT = "Not Found";

    // Error Message Constants
    private static final String HEADER_TEXT_MISMATCH = "Links header text mismatch";
    private static final String NEW_TAB_TEXT_MISMATCH = "New tab text mismatch";
    private static final String HOME_TEXT_MISMATCH = "Home text mismatch";
    private static final String API_CALL_TEXT_MISMATCH = "API call text mismatch";
    private static final String CREATED_TEXT_MISMATCH = "Created text mismatch";
    private static final String NO_CONTENT_TEXT_MISMATCH = "No content text mismatch";
    private static final String MOVED_TEXT_MISMATCH = "Moved text mismatch";
    private static final String BAD_REQUEST_TEXT_MISMATCH = "Bad request text mismatch";
    private static final String UNAUTHORIZED_TEXT_MISMATCH = "Unauthorized text mismatch";
    private static final String FORBIDDEN_TEXT_MISMATCH = "Forbidden text mismatch";
    private static final String NOT_FOUND_TEXT_MISMATCH = "Not found text mismatch";
    private static final String NEW_TAB_URL_MISMATCH = "New tab URL mismatch";
    private static final String CREATED_LINK_RESPONSE_ERROR = "Created link response error";
    private static final String NO_CONTENT_LINK_RESPONSE_ERROR = "No content link response error";
    private static final String MOVED_LINK_RESPONSE_ERROR = "Moved link response error";
    private static final String BAD_REQUEST_LINK_RESPONSE_ERROR = "Bad request link response error";
    private static final String UNAUTHORIZED_LINK_RESPONSE_ERROR = "Unauthorized link response error";
    private static final String FORBIDDEN_LINK_RESPONSE_ERROR = "Forbidden link response error";
    private static final String NOT_FOUND_LINK_RESPONSE_ERROR = "Not found link response error";

    private LinksPage linksPage;
    private static final String LINKS_URL = "links";

    @BeforeMethod
    public void goToLinksPage() {
        navigateToUrl(LINKS_URL);
        linksPage = new LinksPage(driver);
    }

    @Test(enabled = true, description = "Verify all text elements on the links page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualLinksHeader = linksPage.getLinksText();
        String actualFollowingLinksWillOpenNewTab = linksPage.getNewTabText();
        String actualHomeText = linksPage.getSimpleLinkText();
        String actualFollowingLinksWillSendAnApiCall = linksPage.getApiCallText();
        String actualCreatedText = linksPage.getCreatedRequestLinkText();
        String actualNoContentText = linksPage.getNoContentRequestLinkText();
        String actualMovedText = linksPage.getMovedRequestLinkText();
        String actualBadRequestText = linksPage.getBadRequestLinkText();
        String actualUnauthorizedText = linksPage.getUnauthorizedRequestLinkText();
        String actualForbiddenText = linksPage.getForbiddenRequestLinkText();
        String actualNotFoundText = linksPage.getNotFoundRequestLinkText();

        // Assert
        softAssert.assertEquals(actualLinksHeader, EXPECTED_LINKS_HEADER, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(actualFollowingLinksWillOpenNewTab, EXPECTED_FOLLOWING_LINKS_NEW_TAB, NEW_TAB_TEXT_MISMATCH);
        softAssert.assertEquals(actualHomeText, EXPECTED_HOME_TEXT, HOME_TEXT_MISMATCH);
        softAssert.assertEquals(actualFollowingLinksWillSendAnApiCall, EXPECTED_FOLLOWING_LINKS_API_CALL, API_CALL_TEXT_MISMATCH);
        softAssert.assertEquals(actualCreatedText, EXPECTED_CREATED_TEXT, CREATED_TEXT_MISMATCH);
        softAssert.assertEquals(actualNoContentText, EXPECTED_NO_CONTENT_TEXT, NO_CONTENT_TEXT_MISMATCH);
        softAssert.assertEquals(actualMovedText, EXPECTED_MOVED_TEXT, MOVED_TEXT_MISMATCH);
        softAssert.assertEquals(actualBadRequestText, EXPECTED_BAD_REQUEST_TEXT, BAD_REQUEST_TEXT_MISMATCH);
        softAssert.assertEquals(actualUnauthorizedText, EXPECTED_UNAUTHORIZED_TEXT, UNAUTHORIZED_TEXT_MISMATCH);
        softAssert.assertEquals(actualForbiddenText, EXPECTED_FORBIDDEN_TEXT, FORBIDDEN_TEXT_MISMATCH);
        softAssert.assertEquals(actualNotFoundText, EXPECTED_NOT_FOUND_TEXT, NOT_FOUND_TEXT_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Open new tab from simple link and verify URL")
    public void openNewTabFromSimpleLink() {
        // Arrange & Act
        linksPage.clickSimpleTab();

        // Assert
        softAssert.assertEquals(linksPage.getCurrentUrl(), DEMO_QA_URL, NEW_TAB_URL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Open new tab from dynamic link and verify URL")
    public void openNewTabFromDynamicLink() {
        // Arrange & Act
        linksPage.clickDynamicTab();

        // Assert
        softAssert.assertEquals(linksPage.getCurrentUrl(), DEMO_QA_URL, NEW_TAB_URL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on created link and verify response")
    public void clickOnCreatedLink() {
        // Arrange & Act
        linksPage.clickCreatedLink();
        String actualResponseText = linksPage.getResponse();

        // Assert
        softAssert.assertTrue(actualResponseText.contains(EXPECTED_CREATED_STATUS)
                        && actualResponseText.contains(EXPECTED_CREATED_STATUS_TEXT),
                CREATED_LINK_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on no content link and verify response")
    public void clickOnNoContentLink() {
        // Arrange & Act
        linksPage.clickNoContentRequestLink();
        String actualResponse = linksPage.getResponse();

        // Assert
        softAssert.assertTrue(actualResponse.contains(EXPECTED_NO_CONTENT_STATUS)
                        && actualResponse.contains(EXPECTED_NO_CONTENT_STATUS_TEXT),
                NO_CONTENT_LINK_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on moved link and verify response")
    public void clickOnMovedLink() {
        // Arrange & Act
        linksPage.clickMovedLink();
        String actualResponse = linksPage.getResponse();

        // Assert
        softAssert.assertTrue(actualResponse.contains(EXPECTED_MOVED_STATUS)
                        && actualResponse.contains(EXPECTED_MOVED_STATUS_TEXT),
                MOVED_LINK_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on bad request link and verify response")
    public void clickOnBadRequestLink() {
        // Arrange & Act
        linksPage.clickBadRequestLink();
        String actualResponse = linksPage.getResponse();

        // Assert
        softAssert.assertTrue(actualResponse.contains(EXPECTED_BAD_REQUEST_STATUS)
                        && actualResponse.contains(EXPECTED_BAD_REQUEST_STATUS_TEXT),
                BAD_REQUEST_LINK_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on unauthorized link and verify response")
    public void clickOnUnauthorizedLink() {
        // Arrange & Act
        linksPage.clickUnauthorizedLink();
        String actualResponse = linksPage.getResponse();

        // Assert
        softAssert.assertTrue(actualResponse.contains(EXPECTED_UNAUTHORIZED_STATUS)
                        && actualResponse.contains(EXPECTED_UNAUTHORIZED_STATUS_TEXT),
                UNAUTHORIZED_LINK_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on forbidden link and verify response")
    public void clickOnForbiddenLink() {
        // Arrange & Act
        linksPage.clickForbiddenLink();
        String actualResponse = linksPage.getResponse();

        // Assert
        softAssert.assertTrue(actualResponse.contains(EXPECTED_FORBIDDEN_STATUS)
                        && actualResponse.contains(EXPECTED_FORBIDDEN_STATUS_TEXT),
                FORBIDDEN_LINK_RESPONSE_ERROR);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click on not found link and verify response")
    public void clickOnNotFoundLink() {
        // Arrange & Act
        linksPage.clickNotFoundLink();
        String actualResponse = linksPage.getResponse();

        // Assert
        softAssert.assertTrue(actualResponse.contains(EXPECTED_NOT_FOUND_STATUS)
                        && actualResponse.contains(EXPECTED_NOT_FOUND_STATUS_TEXT),
                NOT_FOUND_LINK_RESPONSE_ERROR);
        softAssert.assertAll();
    }
}
