package tests;

import pages.AccountPage;
import org.junit.Assert;
import org.junit.Test;

public class FillTextareaTest extends TestSetup {

    // Test for filling text area
    @Test
    public void testFillTextarea() {
        AccountPage accountPage = new AccountPage(driver);

        // Log in to access tested functionality
        login();

        // Navigate to the account editing page 
        accountPage.clickEditButton();

        // Fill the text area with text
        accountPage.fillTextareaContent("Filling the textarea...");

        // Assert that the text area was filled with the text
        Assert.assertTrue("Filling the text area was unsuccessful.", accountPage.checkWrittenTextExists());
    }
}