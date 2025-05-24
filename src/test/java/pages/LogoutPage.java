package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage extends BasePage {
    
    private By hamburgerLocator = By.xpath("//img[@class=\"hamburger__icon logged\"]");
    private By logoutLocator = By.xpath("//button[@data-ol-link-track=\"Hamburger|Logout\"]");
    private By authLocator = By.xpath("//ul[@class=\"auth-component\"]");

    public LogoutPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://openlibrary.org/");
    }

    // Function to click on hamburger menu button
    public void clickMenuButton() {
        waitVisibiiltyAndFindElement(hamburgerLocator).click();
    }

    // Function to click the logout button
    public void clickLogoutButton() {
        waitVisibiiltyAndFindElement(logoutLocator).click();
    }

    // Function to verify successful logout by checking if the login button is visible
    public Boolean validateLogoutSuccess() {
        return waitVisibiiltyAndFindElement(authLocator).isDisplayed();
    }
    
}