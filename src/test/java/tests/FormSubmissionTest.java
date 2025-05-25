package tests;

import pages.AccountPage;
import org.junit.Assert;
import org.junit.Test;

public class FormSubmissionTest extends TestSetup {

    String oldName;

    // Test for form submission and history
    @Test
    public void testEditDisplayName() {

        // Log in to access tested functionality
        login();
        
        AccountPage accountPage = new AccountPage(driver);

        // Navigate to the account editing page 
        accountPage.clickEditButton();

        // Save the old username for later comparison
        oldName = accountPage.getDisplayname();

        // Type in the new username
        accountPage.typeNewName(accountPage.getDisplayname() + "!");

        // Save the new username
        accountPage.saveNewName();

        // Navigate back to the account page
        accountPage.goBack();

        // Assert that the new username is displayed for the account
        Assert.assertEquals("Editing the display name was unsuccessful.", oldName + "!", accountPage.getDisplayname());
    }
}