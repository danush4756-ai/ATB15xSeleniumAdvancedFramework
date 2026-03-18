package com.thetestingacademy.Pages.PageObjectModel.VWO;

import com.thetestingacademy.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Page Class
public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
        // Page locator
        private By username = By.id("login-username");
        private By password = By.id("login-password");
        private By signButton = By.id("js-login-btn");
        private By error_message = By.id("js-notification-box-msg");
        // Page Actions
        public String loginToVWOInvalidCreds (String usr, String pwd){
            driver.findElement(username).sendKeys(usr);
            driver.findElement(password).sendKeys(pwd);
            driver.findElement(signButton).click();
            WaitHelpers.checkVisibility(driver, error_message);
            String error_message_text = driver.findElement(error_message).getText();
            return error_message_text;
        }
    public void loginToVWOValidCreds(String usr, String pwd) {
        driver.findElement(username).sendKeys(usr);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
    }
}
