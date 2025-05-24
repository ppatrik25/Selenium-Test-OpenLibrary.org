package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class FileUploadHandler extends BasePage {

    private By uploadButtonLocator = By.name("csv");
    private By saveButtonLocator = By.xpath("//input[@value=\"Load Books\"]");
    private By importedFilesLocator = By.xpath("//table[@class=\"import-table\"]");
    private String uploadFilePath = "/home/selenium/tests/big_assignment/src/test/resources/books_example.csv";;
    private String isbnNumber = "545791421";;
    private WebElement uploadElement;
    private By isbnNumberLocator = By.xpath("//tr[@isbn='" + isbnNumber + "']");

    public FileUploadHandler(WebDriver driver) {
        super(driver);
        this.driver.get("https://openlibrary.org/account/import");
    }    

    // Function to find the upload button and select the file
    public void selectFileByPath() {
        uploadElement = waitVisibiiltyAndFindElement(uploadButtonLocator);
        ((RemoteWebElement) uploadElement).setFileDetector(new LocalFileDetector());
        uploadElement.sendKeys(uploadFilePath);
    }
    
    // Function to click the save button to finalize the upload
    public void uploadSelectedFile() {
        waitVisibiiltyAndFindElement(saveButtonLocator).click();
    }

    // Function to verify the uploaded file's content is visible in the table
    public Boolean checkUploadedFileSuccess() {
        return waitVisibiiltyAndFindElement(importedFilesLocator).findElement(isbnNumberLocator).isDisplayed();
    }

}