package com.thetestingacademy;
import com.thetestingacademy.Pages.PageObjectModel.VWO.DashBoardPage;
import com.thetestingacademy.Pages.PageObjectModel.VWO.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class TestVWOLogin_01_Normal_POM {
    @Owner("DARSHTS")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        // Driver Manager Code - 1 - D
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOInvalidCreds("admin@gmail.com", "1234");
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, "Your email, password, IP address or location did not match");
        driver.quit();
    }
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
        loginPage.loginToVWOValidCreds("cxh04@tempumail.cc","ILoveDrive#08");
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