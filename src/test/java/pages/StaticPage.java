package pages;

import org.openqa.selenium.WebDriver;

public class StaticPage extends BasePage {
    
    public String content = "Partner With Open Library";

    public StaticPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://openlibrary.org/partner-with-us");
    }

    // Function to check if static content is present
    public boolean isContentPresent() {
        return driver.getPageSource().contains(content);
    }
    
}