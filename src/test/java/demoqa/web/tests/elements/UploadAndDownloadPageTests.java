package demoqa.web.tests.elements;

import demoqa.pages.elements.UploadAndDownloadPage;
import demoqa.web.base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadAndDownloadPageTests extends BaseTest {
    // Text Constants
    private static final String EXPECTED_UPLOAD_AND_DOWNLOAD_TEXT = "Upload and Download";
    private static final String EXPECTED_DOWNLOAD_BUTTON_TEXT = "Download";
    private static final String EXPECTED_SELECT_A_FILE_TEXT = "Select a file";

    // File Constants
    private static final String PICTURE_NAME = "zhivko.jpg";
    private static final String EXPECTED_DOWNLOAD_FILE_NAME = "sampleFile.jpeg";
    private static final String FAKE_PATH_PREFIX = "C:\\fakepath\\";

    // Error Message Constants
    private static final String UPLOAD_DOWNLOAD_TEXT_MISMATCH = "Upload and Download text mismatch";
    private static final String DOWNLOAD_BUTTON_TEXT_MISMATCH = "Download button text mismatch";
    private static final String SELECT_A_FILE_TEXT_MISMATCH = "Select a file text mismatch";
    private static final String UPLOAD_NAME_MISMATCH = "Upload file name mismatch";
    private static final String FILE_NOT_DOWNLOADED_ERROR = "File was not downloaded";

    private UploadAndDownloadPage uploadAndDownloadPage;
    private static final String UPLOAD_DOWNLOAD_URL = "upload-download";

    @BeforeMethod
    public void goToUploadDownloadPage() {
        navigateToUrl(UPLOAD_DOWNLOAD_URL);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
    }

    @Test(enabled = true, description = "Verify all text elements on the upload and download page")
    public void verifyAllTextOnPage() {
        // Arrange & Act
        String uploadAndDownloadText = uploadAndDownloadPage.getUploadAndDownloadText();
        String downloadButtonText = uploadAndDownloadPage.getDownloadButtonText();
        String selectAFileText = uploadAndDownloadPage.getSelectAFileText();

        // Assert
        softAssert.assertEquals(uploadAndDownloadText, EXPECTED_UPLOAD_AND_DOWNLOAD_TEXT, UPLOAD_DOWNLOAD_TEXT_MISMATCH);
        softAssert.assertEquals(downloadButtonText, EXPECTED_DOWNLOAD_BUTTON_TEXT, DOWNLOAD_BUTTON_TEXT_MISMATCH);
        softAssert.assertEquals(selectAFileText, EXPECTED_SELECT_A_FILE_TEXT, SELECT_A_FILE_TEXT_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Upload file and verify image name")
    public void uploadFileVerifyImageName() {
        // Arrange & Act
        String filePathOnOperationSystem = uploadAndDownloadPage.getFilePathFromResources(PICTURE_NAME);
        uploadAndDownloadPage.uploadFile(filePathOnOperationSystem);

        String actualFakeUploadFolder = uploadAndDownloadPage.getUploadFilePath();
        String expectedFakeUploadFolder = FAKE_PATH_PREFIX + PICTURE_NAME;

        // Assert
        softAssert.assertEquals(actualFakeUploadFolder, expectedFakeUploadFolder, UPLOAD_NAME_MISMATCH);
        softAssert.assertAll();
    }

    @Test(enabled = true, description = "Click download button and verify file download")
    public void clickDownloadButtonAndVerifyIsDownloadFile() {
        // Arrange & Act
        uploadAndDownloadPage.clickDownloadButton();

        boolean fileExists = uploadAndDownloadPage.checkIfFileExists(EXPECTED_DOWNLOAD_FILE_NAME);

        // Assert
        softAssert.assertTrue(fileExists, FILE_NOT_DOWNLOADED_ERROR);
        softAssert.assertAll();
    }
}