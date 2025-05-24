package pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class StaticPagesArray extends BasePage {
    
    private Boolean falseCheck;
    private List<String> staticPages = Arrays.asList(
        "https://openlibrary.org/search",
        "https://openlibrary.org/help",
        "https://openlibrary.org/contact"
    );

    public StaticPagesArray(WebDriver driver) {
        super(driver);
        this.driver.get("https://openlibrary.org/");
    }

    // Function to check if the static pages are found and working
    public Boolean validateStaticPages() {
        for (String url : staticPages) {
            driver.get(url);
            falseCheck = (driver.getTitle() != null && !driver.getTitle().contains("is not found") && driver.getTitle().contains("Open Library"));
            if (falseCheck == false) {
                return falseCheck;
            }
        }
        return falseCheck;
    }
    
}