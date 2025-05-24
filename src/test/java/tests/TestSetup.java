package tests;

import pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class TestSetup {
    protected WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized", "--disable-translate");
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
    }

    public void login() {
        try{
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loadConfigFile();
            loginPage.enterUsername(loginPage.getUsername());
            loginPage.enterPassword(loginPage.getPassword());
            loginPage.clickLogin();
            Assert.assertTrue(loginPage.loginSuccess());
        }
        catch(Exception e){
            System.out.println("Error while logging in: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}