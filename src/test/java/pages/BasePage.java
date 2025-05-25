package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class BasePage {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }
    
    // Function to wait for a WebElement to appear and return it
    public WebElement waitVisibiiltyAndFindElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    
    // Function to wait for the body to appear and return the contained text
    public String getBodyText() {
        WebElement bodyElement = this.waitVisibiiltyAndFindElement(By.tagName("body"));
        return bodyElement.getText();
    }

    // Function to navigate back in the browser
    public void goBack() {
        getBodyText();
        driver.navigate().back();
    }

}