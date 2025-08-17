package demoqa.web.tests.elements;

import demoqa.pages.elements.UploadAndDownloadPage;
import demoqa.web.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadAndDownloadPageTests extends BaseTest {

    public static final String UPLOAD_DOWNLOAD_URL = "upload-download";
    private UploadAndDownloadPage uploadAndDownloadPage;

    @BeforeMethod
    public void goToUploadDownloadPage() {
        navigateToUrl(UPLOAD_DOWNLOAD_URL);
        uploadAndDownloadPage = new UploadAndDownloadPage(driver);
    }

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        // Arrange
        String expectedUploadAndDownloadText = "Upload and Download";
        String expectedDownloadButtonText = "Download";
        String expectedSelectAFileText = "Select a file";

        String uploadAndDownloadText = uploadAndDownloadPage.getUploadAndDownloadText();
        String downloadButtonText = uploadAndDownloadPage.getDownloadButtonText();
        String selectAFileText = uploadAndDownloadPage.getSelectAFileText();

        // Assert
        softAssert.assertEquals(uploadAndDownloadText, expectedUploadAndDownloadText, "\nUpload and Download text mismatch.\n");
        softAssert.assertEquals(downloadButtonText, expectedDownloadButtonText, "\nDownload button mismatch.\n");
        softAssert.assertEquals(selectAFileText, expectedSelectAFileText, "\nSelect a file mismatch.\n");
        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Upload file and verify image name")
    public void UploadFileVerifyImageName() {
        // Arrange
        String pictureName = "zhivko.jpg";

        String filePathOnOperationSystem = uploadAndDownloadPage.getFilePathFromResources(pictureName);
        uploadAndDownloadPage.uploadFile(filePathOnOperationSystem);

        String actualFakeUploadFolder = uploadAndDownloadPage.getUploadFilePath();
        String expectedFakeUploadFolder = "C:\\fakepath\\" + pictureName;

        // Assert
        Assert.assertEquals(actualFakeUploadFolder, expectedFakeUploadFolder, "\nDifferent upload name.\n");
    }

    @Test(enabled = true, testName = "Click download button and verify is download file")
    public void ClickDownloadButtonAndVerifyIsDownloadFile() {
        // Arrange
        uploadAndDownloadPage.clickDownloadButton();

        String expectedFileName = "sampleFile.jpeg";

        boolean fileExists = uploadAndDownloadPage.checkIfFileExists(expectedFileName);

        // Assert
        Assert.assertTrue(fileExists, "\nFile '" + expectedFileName + "' was not downloaded.\n");
    }
}