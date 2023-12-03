import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    private WebDriver driver;
    String webSiteURL = "https://the-internet.herokuapp.com/";
    private File filePath;

    ///Test Cases///
    @Test
    public void VerifyTakeScreenShot() throws IOException {
        takeScreenShot();
        verifyImageExists();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        navigateToWebsite();
        filePath = new File("./image.png");

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    public void navigateToWebsite(){
        driver.get(webSiteURL);
    }
    public void takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, filePath);
    }
    public void verifyImageExists(){
        Assert.assertTrue(filePath.length() > 0, "Screenshot file is empty");
    }

}