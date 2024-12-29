package demoqa.web.test.elements;

import demoqa.web.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadAndDownloadPageTests extends BaseTest {

    @Test
    public void VerifyAllTextOnPage() {
        navigateToUrl("upload-download");

        String expectedUploadAndDownloadText = "Upload and Download";
        String expectedDownloadButtonText = "Download";
        String expectedSelectAFileText = "Select a file";

        String uploadAndDownloadText = uploadAndDownloadPage.getUploadAndDownloadText();
        String downloadButtonText = uploadAndDownloadPage.getDownloadButtonText();
        String selectAFileText = uploadAndDownloadPage.getSelectAFileText();

        Assert.assertEquals(uploadAndDownloadText, expectedUploadAndDownloadText, "Upload and Download text mismatch");
        Assert.assertEquals(downloadButtonText, expectedDownloadButtonText, "Download button mismatch");
        Assert.assertEquals(selectAFileText, expectedSelectAFileText, "Select a file mismatch");
    }

    @Test(enabled = true)
    public void UploadFileVerifyImageName() {
        navigateToUrl("upload-download");

        String pictureName = "zhivko.jpg";

        String filePathOnOperationSystem = uploadAndDownloadPage.getFilePathFromResources(pictureName);
        uploadAndDownloadPage.uploadFile(filePathOnOperationSystem);

        String actualFakeUploadFolder = uploadAndDownloadPage.getUploadFilePath();
        String expectedFakeUploadFolder = "C:\\fakepath\\" + pictureName;

        Assert.assertEquals(actualFakeUploadFolder, expectedFakeUploadFolder, "Different upload name");
    }

    @Test(enabled = true)
    public void ClickDownloadButtonAndVerifyIsDownloadFile() {
        navigateToUrl("upload-download");

        uploadAndDownloadPage.clickDownloadButton();

        String expectedFileName = "sampleFile.jpeg";

        boolean fileExists = uploadAndDownloadPage.checkIfFileExists(expectedFileName);

        Assert.assertTrue(fileExists, "File '" + expectedFileName + "' was not downloaded.");
    }
}