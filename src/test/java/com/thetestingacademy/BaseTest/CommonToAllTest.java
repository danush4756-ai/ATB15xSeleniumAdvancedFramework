package com.thetestingacademy.BaseTest;
import com.thetestingacademy.driver.DriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class CommonToAllTest {
    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }
    @AfterMethod//these methods get executed automatically, because of the BeforeMethod and AfterMethod annotations used.
    public void tearDown(ITestResult result){
        WebDriver driver = DriverManager.getDriver();
        // If test failed, capture screenshot and attach to Allure
        if (result.getStatus() == ITestResult.FAILURE && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on Failure", "image/png",
                    new ByteArrayInputStream(screenshot), "png");
        }

        DriverManager.down();
    }
}
