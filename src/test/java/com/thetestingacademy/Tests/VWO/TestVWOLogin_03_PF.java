package com.thetestingacademy.Tests.VWO;
import com.thetestingacademy.BaseTest.CommonToAllTest;
import com.thetestingacademy.Pages.PageFactory.VWO.LogInPagePF;
import com.thetestingacademy.Utils.PropertiesReader;
import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class TestVWOLogin_03_PF extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_03_PF.class);
    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Page factory testcases!!");
        LogInPagePF loginPage_pf = new LogInPagePF(getDriver());
        String error_msg = loginPage_pf.loginToVWOInvalidCreds();
        logger.info("Finished the Testcases Page Factory");
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
    }
}
