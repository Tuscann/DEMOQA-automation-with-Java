package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadAndDownloadPageTests extends BaseTest {

    @Test(enabled = true, testName = "Verify all text on page")
    public void VerifyAllTextOnPage() {
        navigateToUrl("upload-download");

        String expectedUploadAndDownloadText = "Upload and Download";
        String expectedDownloadButtonText = "Download";
        String expectedSelectAFileText = "Select a file";

        String uploadAndDownloadText = uploadAndDownloadPage.getUploadAndDownloadText();
        String downloadButtonText = uploadAndDownloadPage.getDownloadButtonText();
        String selectAFileText = uploadAndDownloadPage.getSelectAFileText();

        softAssert.assertEquals(uploadAndDownloadText, expectedUploadAndDownloadText, "\nUpload and Download text mismatch.\n");
        softAssert.assertEquals(downloadButtonText, expectedDownloadButtonText, "\nDownload button mismatch.\n");
        softAssert.assertEquals(selectAFileText, expectedSelectAFileText, "\nSelect a file mismatch.\n");

        softAssert.assertAll();
    }

    @Test(enabled = true, testName = "Upload file and verify image name")
    public void UploadFileVerifyImageName() {
        navigateToUrl("upload-download");

        String pictureName = "zhivko.jpg";

        String filePathOnOperationSystem = uploadAndDownloadPage.getFilePathFromResources(pictureName);
        uploadAndDownloadPage.uploadFile(filePathOnOperationSystem);

        String actualFakeUploadFolder = uploadAndDownloadPage.getUploadFilePath();
        String expectedFakeUploadFolder = "C:\\fakepath\\" + pictureName;

        Assert.assertEquals(actualFakeUploadFolder, expectedFakeUploadFolder, "\nDifferent upload name.\n");
    }

    @Test(enabled = true, testName = "Click download button and verify is download file")
    public void ClickDownloadButtonAndVerifyIsDownloadFile() {
        navigateToUrl("upload-download");

        uploadAndDownloadPage.clickDownloadButton();

        String expectedFileName = "sampleFile.jpeg";

        boolean fileExists = uploadAndDownloadPage.checkIfFileExists(expectedFileName);

        Assert.assertTrue(fileExists, "\nFile '" + expectedFileName + "' was not downloaded.\n");
    }
}