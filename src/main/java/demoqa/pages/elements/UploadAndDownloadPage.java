package demoqa.pages.elements;

import demoqa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.nio.file.Paths;

public class UploadAndDownloadPage extends BasePage {

    @FindBy(id = "downloadButton")
    private WebElement downloadButton;

    @FindBy(id = "uploadFile")
    private WebElement chooseFileButton;

    @FindBy(id = "uploadedFilePath")
    private WebElement uploadFilePath;

    @FindBy(xpath = "//label[@for='uploadFile'][contains(.,'Select a file')]")
    private WebElement selectAFileLabel;

    @FindBy(xpath = "//h1[@class='text-center'][contains(.,'Upload and Download')]")
    private WebElement uploadAndDownloadLabel;

    public UploadAndDownloadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getUploadFilePath() {
        return uploadFilePath.getText();
    }

    public String getDownloadButtonText() {
        return downloadButton.getText();
    }

    public String getUploadAndDownloadText() {
        return uploadAndDownloadLabel.getText();
    }

    public String getSelectAFileText() {
        return selectAFileLabel.getText();
    }

    public void clickDownloadButton() {
        downloadButton.click();
    }

    public String getFilePathFromResources(String fileName) {
        File file = new File(System.getProperty("user.dir") + "/resources/screenshots/" + fileName);
        if (file.exists()) {
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }

    public void uploadFile(String pathOfFile) {
        chooseFileButton.sendKeys(pathOfFile);
    }

    public boolean checkIfFileExists(String fileName) {
        String downloadDir = Paths.get(System.getProperty("user.home"), "Downloads").toString();
        File downloadedFile = new File(downloadDir + File.separator + fileName);

        return downloadedFile.exists();
    }

    public String getButtonDownloadBackgroundColor() {
        return downloadButton.getCssValue("background-color");
    }
}
