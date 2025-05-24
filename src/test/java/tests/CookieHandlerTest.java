package tests;

import pages.CookieHandler;
import org.junit.Assert;
import org.junit.Test;

public class CookieHandlerTest extends TestSetup {

    // Test for cookie manipulation
    @Test
    public void testCookieManipulation() {
        CookieHandler cookieHandler = new CookieHandler(driver);

        // Remove the popup disabler cookie if exists
        cookieHandler.cookieRemover();

        // Assert that the popup element appeared
        Assert.assertTrue("The popup element did not appear.", cookieHandler.getChildCount() > 0);

        // Add the popup disabler cookie
        cookieHandler.addPopupDisablerCookie();

        // Refresh the page to activate the cookie
        cookieHandler.refreshPage();

        // Assert that the popup element disappeared
        Assert.assertTrue("The popup element did not disappear.", cookieHandler.getChildCount() == 0);
    }
}