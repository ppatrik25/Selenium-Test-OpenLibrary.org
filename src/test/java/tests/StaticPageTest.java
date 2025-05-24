package tests;

import pages.StaticPage;
import org.junit.Assert;
import org.junit.Test;

public class StaticPageTest extends TestSetup {

    // Test for static pages
    @Test
    public void testStaticPageContent() {
        StaticPage staticPage = new StaticPage(driver);

        // Assert that the static page content is visible
        Assert.assertTrue("Expected content was not found", staticPage.isContentPresent());
    }
}