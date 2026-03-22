package com.thetestingacademy.Pages.PageObjectModel.VWO.ImprovedPOM;
import com.thetestingacademy.Utils.WaitHelpers;
import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class DashBoardPageImproved extends CommonToAllPage {
    WebDriver driver;
    public DashBoardPageImproved(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    private By Dashboard = By.xpath("//a[@aria-label='View dashboard']");
    private By userNameOnDashboard = By.xpath("//span[@data-qa='lufexuloga']");
    // Page Actions
    public String loggedInUserName() {
        WaitHelpers.visibilityOfElement(Dashboard);
        clickElement(Dashboard);
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return fetchText(userNameOnDashboard);
    }
}
