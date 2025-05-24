package tests;

import pages.LogoutPage;
import org.junit.Assert;
import org.junit.Test;

public class LogoutPageTest extends TestSetup {

    // Test for logging out
    @Test
    public void testLogout() {
        LogoutPage logoutPage = new LogoutPage(driver);

        // Log in to access tested functionality
        login();

        // Click the menu button
        logoutPage.clickMenuButton();

        // Click the logout button
        logoutPage.clickLogoutButton();

        // Assert that the logout was successful
        Assert.assertTrue("Logging out was unsuccessful.", logoutPage.validateLogoutSuccess());
    }
}