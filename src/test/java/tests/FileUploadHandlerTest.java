package tests;

import pages.FileUploadHandler;
import org.junit.Assert;
import org.junit.Test;

public class FileUploadHandlerTest extends TestSetup {

    // Test for file upload
    @Test
    public void testFileUpload() {

        // Log in to access tested functionality
        login();
        
        FileUploadHandler fileUploadHandler = new FileUploadHandler(driver);

        // Pass the file path to the input element
        fileUploadHandler.selectFileByPath();

        // Upload the file by pressing the upload button
        fileUploadHandler.uploadSelectedFile();

        // Assert that the file has been uploaded successfully
        Assert.assertTrue("The file upload was unsuccessful.", fileUploadHandler.checkUploadedFileSuccess());
    }
}