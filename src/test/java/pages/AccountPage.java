package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private By editButtonLocator = By.xpath("//a[contains(@href, 'm=edit')]");
    private By displayNameElement = By.xpath("//input[@name='displayname']");
    private By saveButtonLocator = By.xpath("//button[@name=\"_save\"]");
    private By textareaLocator = By.xpath("//textarea");
    private By textareaPreviewLocator = By.xpath("//div[@id='wmd-preview-0']//p");

    public AccountPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://openlibrary.org/account");
    }    

    // Function to find and click the edit button
    public void clickEditButton() {
        waitVisibiiltyAndFindElement(editButtonLocator).click();
    }

    // Function to find and return the display name
    public String getDisplayname() {
        return waitVisibiiltyAndFindElement(displayNameElement).getAttribute("value");
    }

    // Function to find the display name element and type the new username
    public void typeNewName(String newUserName) {
        waitVisibiiltyAndFindElement(displayNameElement).clear();
        waitVisibiiltyAndFindElement(displayNameElement).sendKeys(newUserName);
    }

    // Function to find the save button and click it
    public void saveNewName() {
        driver.findElement(saveButtonLocator).click();
    }

    // Function to find the textarea and type into it
    public void fillTextareaContent(String text) {
        waitVisibiiltyAndFindElement(textareaLocator).sendKeys(text);
    }

    // Function to check if the text was successfully entered or not
    public Boolean checkWrittenTextExists() {
        return (waitVisibiiltyAndFindElement(textareaPreviewLocator).getText().replace("\n", " "))
               .equals(driver.findElement(textareaLocator).getAttribute("value"));
    }
    
}