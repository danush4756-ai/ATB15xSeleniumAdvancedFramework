package com.thetestingacademy.Pages.PageFactory.VWO;
import com.thetestingacademy.Utils.PropertiesReader;
import com.thetestingacademy.Utils.WaitHelpers;
import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LogInPagePF extends CommonToAllPage {
    WebDriver driver;
    public LogInPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);/*this loads all elements at once and if element changes it may give
        StaleElementException. For this reason PF is generally not used*/
    }
    // Page Locators
    @FindBy(id="login-username")
    private WebElement username;
    // private By username = By.id("login-username");
    @FindBy(id = "login-password")
    private WebElement password;
    @FindBy(id = "js-login-btn")
    private WebElement signButton;
    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;//changed from WebElement to By so that I can use WaitHelper
    // Page Actions
    public String loginToVWOInvalidCreds() {
        try{
            openVWOUrl();
            enterInput(username, PropertiesReader.readKey("invalid_username"));
            enterInput(password, PropertiesReader.readKey("invalid_password"));
            clickElement(signButton);
            WaitHelpers.visibilityOfElement(error_message);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            // e.printStackTrace(); // it will print the error message with the lines number
        }
        return error_message.getText();
    }
}
