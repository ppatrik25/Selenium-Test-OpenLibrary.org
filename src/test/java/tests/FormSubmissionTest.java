package tests;

import pages.AccountPage;
import org.junit.Assert;
import org.junit.Test;

public class FormSubmissionTest extends TestSetup {

    // Test for form submission and history
    @Test
    public void testEditDisplayName() {
        AccountPage accountPage = new AccountPage(driver);

        // Log in to access tested functionality
        login();

        // Navigate to the account editing page 
        accountPage.clickEditButton();

        // Type in the new username
        accountPage.typeNewName("newName");

        // Save the new username
        accountPage.saveNewName();

        // Navigate back to the account page
        accountPage.goBack();

        // Assert that the new username is displayed for the account
        Assert.assertEquals("Editing the display name was unsuccessful.", "newName", accountPage.getDisplayname());
    }
}