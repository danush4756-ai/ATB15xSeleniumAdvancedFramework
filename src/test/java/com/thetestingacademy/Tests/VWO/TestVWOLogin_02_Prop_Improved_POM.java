package com.thetestingacademy.Tests.VWO;

import com.thetestingacademy.BaseTest.CommonToAllTest;
import com.thetestingacademy.Pages.PageObjectModel.VWO.ImprovedPOM.LogInPageImproved;
import com.thetestingacademy.Utils.PropertiesReader;
import com.thetestingacademy.driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_Prop_Improved_POM extends CommonToAllTest {
    @Owner("DARSHTS")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() {
        // Page Class Code (POM Code) - 2 - L
        LogInPageImproved loginPage = new LogInPageImproved(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        // Assertions - 3 - V
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
}
}