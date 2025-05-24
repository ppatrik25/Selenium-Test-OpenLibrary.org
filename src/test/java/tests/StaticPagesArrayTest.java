package tests;

import pages.StaticPagesArray;

import org.junit.Assert;
import org.junit.Test;

public class StaticPagesArrayTest extends TestSetup {

    // Test for static pages from an array
    @Test
    public void testStaticPagesFromArray() {
        StaticPagesArray pagesArray = new StaticPagesArray(driver);

        // Assert that the static pages were visible and working
        Assert.assertTrue("At least one of the pages failed the static page test.", pagesArray.validateStaticPages());
    }
}