package com.thetestingacademy.Pages.PageObjectModel.VWO;
import com.thetestingacademy.Utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DashBoardPage {
    WebDriver driver;
    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
    }
    //page locator
    private By Dashboard = By.xpath("//a[@aria-label='View dashboard']");
    private By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");
    // Page Actions
    public String loggedInUserName() {
        WaitHelpers.checkVisibility(driver, Dashboard, 15);
        driver.findElement(Dashboard).click();
        WaitHelpers.checkVisibility(driver, userNameOnDashboard, 10);
        return driver.findElement(userNameOnDashboard).getText();
    }
}
