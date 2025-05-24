package pages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    
    private Properties properties = new Properties();
    private String configFilePath = "/home/selenium/tests/big_assignment/src/test/resources/config.properties";;
    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButton = By.xpath("//button[@class='cta-btn cta-btn--primary']");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://openlibrary.org/account/login");
    }

    // Function to load the config file containing the login credentials
    public void loadConfigFile() {
        try{
            properties.load(new FileInputStream(configFilePath));
        }
        catch(Exception IOException){
            System.out.println("Error loading config file");
        }
    }

    // Function to return the username from the config file
    public String getUsername() {
        return properties.getProperty("username");
    }

    // Function to return the password from the config file
    public String getPassword() {
        return properties.getProperty("password");
    }

    // Function to find the username input and enter the username
    public void enterUsername(String username) {
        waitVisibiiltyAndFindElement(usernameLocator).sendKeys(username);
    }

    // Function to find the password input and enter the password
    public void enterPassword(String password) {
        waitVisibiiltyAndFindElement(passwordLocator).sendKeys(password);
    }

    // Function to click the login button
    public void clickLogin() {
        waitVisibiiltyAndFindElement(loginButton).click();
    }
    
    // Function to check if the login was successful
    public Boolean loginSuccess() {
        return waitVisibiiltyAndFindElement(By.xpath("//a[text() = 'Log In']")).isDisplayed();
    }
}