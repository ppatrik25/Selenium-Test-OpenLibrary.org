package pages;

import org.openqa.selenium.*;

public class CookieHandler extends BasePage {

    private static Cookie donationCookie = new Cookie.Builder("donation", "x").domain(".openlibrary.org").path("/").build();;
    private static JavascriptExecutor js;
    private Long childCount;

    public CookieHandler(WebDriver driver) {
        super(driver);
        this.driver.get("https://openlibrary.org/");
        js = (JavascriptExecutor) driver;
    }    

    // Function to remove a specific cookie if it exists
    public void cookieRemover() {
        try{
            driver.manage().deleteCookieNamed("donation");
        }
        catch (Exception e) {
            System.out.println("No cookies were removed.");
        }
    }

    // Function to check if a popup element contains child elements (check if it appears or not)
    // This element does not show up in the test environment, only while regularly browsing
    public Long getChildCount() {
        childCount = (Long) js.executeScript("return document.getElementById('donato').childElementCount;");
        return childCount;    
    }
    
    // Function to add a cookie 
    public void addPopupDisablerCookie() {
        driver.manage().addCookie(donationCookie);
    }

    // Function to refresh the page for the cookie to work
    public void refreshPage() {
        driver.navigate().refresh();
    }   

}