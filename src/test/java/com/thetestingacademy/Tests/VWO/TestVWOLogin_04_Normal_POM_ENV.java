package com.thetestingacademy.Tests.VWO;
import com.thetestingacademy.Pages.PageObjectModel.VWO.NormalPOM.DashBoardPage;
import com.thetestingacademy.Pages.PageObjectModel.VWO.NormalPOM.LoginPage;
import com.thetestingacademy.Utils.EnvUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestVWOLogin_04_Normal_POM_ENV {
    // D
    // L
    // V
    @Owner("DARSHTS")
    @Description("Verify that with valid email, pass,logins and open Dashboard page.")
    @Test
    public void test_positive_vwo_login() {
        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        //Save the ID of the original login tab
        String originalTab = driver.getWindowHandle();
        // Page Class Code (POM Code) - 2 - L
        //LoginPage
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToVWOValidCreds(EnvUtil.getUsername(),EnvUtil.getPassword());
        //THE SWITCH: Tell the driver to find the new tab and switch to it
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalTab.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break; // Stop looking once we find and switch to the new tab
            }
        }
        //DashBoardPage
        DashBoardPage dashboardPage = new DashBoardPage(driver);
        String userNameLoggedIn = dashboardPage.loggedInUserName();
// Assertions - 3 - V
        Assert.assertEquals(userNameLoggedIn,"Kishore J");
    }
}