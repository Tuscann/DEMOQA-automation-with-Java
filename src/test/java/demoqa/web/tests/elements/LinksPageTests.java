package demoqa.web.tests.elements;

import demoqa.pages.elements.LinksPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_LINKS_HEADER = "Links";
    private static final String EXPECTED_FOLLOWING_LINKS_NEW_TAB_TEXT = "Following links will open new tab";
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
    private static final String RESPONSE_CREATED =
            "Link has responded with staus 201 and status text Created";

    private static final String RESPONSE_NO_CONTENT =
            "Link has responded with staus 204 and status text No Content";

    private static final String RESPONSE_MOVED =
            "Link has responded with staus 301 and status text Moved Permanently";

    private static final String BAD_REQUEST_RESPONSE =
            "Link has responded with staus 400 and status text Bad Request";

    private static final String UNAUTHORIZED_REQUEST_RESPONSE =
            "Link has responded with staus 401 and status text Unauthorized";

    private static final String FORBIDDEN_REQUEST_RESPONSE =
            "Link has responded with staus 403 and status text Forbidden";

    private static final String NOT_FOUND_REQUEST_RESPONSE =
            "Link has responded with staus 404 and status text Not Found";

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
    private static final String NEW_TAB_DYNAMIC_URL_MISMATCH = "New tab URL mismatch";
    private static final String CREATED_LINK_RESPONSE_ERROR = "Created link response error";
    private static final String NO_CONTENT_LINK_RESPONSE_ERROR = "No content link response error";
    private static final String MOVED_LINK_RESPONSE_ERROR = "Moved link response error";
    private static final String BAD_REQUEST_LINK_RESPONSE_ERROR = "Bad request link response error";
    private static final String UNAUTHORIZED_LINK_RESPONSE_ERROR = "Unauthorized link response error";
    private static final String FORBIDDEN_LINK_RESPONSE_ERROR = "Forbidden link response error";
    private static final String NOT_FOUND_LINK_RESPONSE_ERROR = "Not found link response error";
    private static final String LINKS_URL = "links";
    private LinksPage linksPage;

    @BeforeMethod
    public void goToLinksPage() {
        navigateToUrl(LINKS_URL);
        linksPage = new LinksPage(driver);
    }

    @Test(enabled = true, description = "Verify all text elements on the links page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String actualLinksHeader = linksPage.getLinksText();
        String actualFollowingLinksWillOpenNewTabText = linksPage.getNewTabText();
        String actualHomeSimpleLinkText = linksPage.getSimpleLinkText();
        int actualHomeDynamicLinkTextLength = linksPage.getDynamicLinkTextLength();
        String actualFollowingLinksWillSendAnApiCallText = linksPage.getApiCallText();
        String actualCreatedText = linksPage.getCreatedRequestLinkText();
        String actualNoContentText = linksPage.getNoContentRequestLinkText();
        String actualMovedText = linksPage.getMovedRequestLinkText();
        String actualBadRequestText = linksPage.getBadRequestLinkText();
        String actualUnauthorizedText = linksPage.getUnauthorizedRequestLinkText();
        String actualForbiddenText = linksPage.getForbiddenRequestLinkText();
        String actualNotFoundText = linksPage.getNotFoundRequestLinkText();

        // Assert
        softAssert.assertEquals(actualLinksHeader, EXPECTED_LINKS_HEADER, HEADER_TEXT_MISMATCH);
        softAssert.assertEquals(actualFollowingLinksWillOpenNewTabText, EXPECTED_FOLLOWING_LINKS_NEW_TAB_TEXT, NEW_TAB_TEXT_MISMATCH);
        softAssert.assertEquals(actualHomeSimpleLinkText, EXPECTED_HOME_TEXT, HOME_TEXT_MISMATCH);
        softAssert.assertEquals(actualHomeDynamicLinkTextLength, 9, HOME_TEXT_MISMATCH);
        softAssert.assertEquals(actualFollowingLinksWillSendAnApiCallText, EXPECTED_FOLLOWING_LINKS_API_CALL, API_CALL_TEXT_MISMATCH);
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
    public void clickHomeLink() {
        // Arrange & Act
        linksPage.clickSimpleLinkHome();

        // Assert
        softAssert.assertEquals(linksPage.getCurrentUrl(), DEMO_QA_URL, NEW_TAB_URL_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Open new tab from dynamic link and verify URL")
    public void clickDynamicHome() {
        // Arrange & Act
        linksPage.clickDynamicLinkHome();

        // Assert
        softAssert.assertEquals(linksPage.getCurrentUrl(), DEMO_QA_URL, NEW_TAB_DYNAMIC_URL_MISMATCH);
        softAssert.assertAll();
    }


    @Test(enabled = true, description = "Click on various links and verify the response")
    public void clickOnLinkAndVerifyResponse() {
        // Define the link names and expected responses in arrays
        String[] linkNames = {
                "createdLink", "noContentLink",
                "movedLink", "badRequestLink",
                "unauthorizedLink", "forbiddenLink", "notFoundLink"
        };

        String[] expectedResponses = {
                RESPONSE_CREATED, RESPONSE_NO_CONTENT, RESPONSE_MOVED,
                BAD_REQUEST_RESPONSE, UNAUTHORIZED_REQUEST_RESPONSE,
                FORBIDDEN_REQUEST_RESPONSE, NOT_FOUND_REQUEST_RESPONSE
        };

        String[] errorMessages = {
                CREATED_LINK_RESPONSE_ERROR, NO_CONTENT_LINK_RESPONSE_ERROR,
                MOVED_LINK_RESPONSE_ERROR, BAD_REQUEST_LINK_RESPONSE_ERROR,
                UNAUTHORIZED_LINK_RESPONSE_ERROR,
                FORBIDDEN_LINK_RESPONSE_ERROR,
                NOT_FOUND_LINK_RESPONSE_ERROR
        };

        // Loop through all the links and verify the response
        for (int i = 0; i < linkNames.length; i++) {
            // Arrange & Act: Click the appropriate link based on the link name
            switch (linkNames[i]) {
                case "createdLink":
                    linksPage.clickCreatedLink();
                    break;
                case "noContentLink":
                    linksPage.clickNoContentRequestLink();
                    break;
                case "movedLink":
                    linksPage.clickMovedLink();
                    break;
                case "badRequestLink":
                    linksPage.clickBadRequestLink();
                    break;
                case "unauthorizedLink":
                    linksPage.clickUnauthorizedLink();
                    break;
                case "forbiddenLink":
                    linksPage.clickForbiddenLink();
                    break;
                case "notFoundLink":
                    linksPage.clickNotFoundLink();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown link name: " + linkNames[i]);
            }
            // Assert: Verify the response
            String actualResponse = linksPage.getResponse();
            softAssert.assertEquals(actualResponse, expectedResponses[i], errorMessages[i]);
        }
        softAssert.assertAll();
    }
}
