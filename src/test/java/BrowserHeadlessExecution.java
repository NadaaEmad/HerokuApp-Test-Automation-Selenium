import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserHeadlessExecution {
    private WebDriver driver;
    String webSiteURL = "https://the-internet.herokuapp.com/";
    private final By header = By.xpath("//h1");

   ///Test Cases///
    @Test
    public void verifyBrowserHeadlessExecution(){
        headlessNavigation();
        assertHeaderText("Welcome to the-internet");
    }

    ////Actions///
    public void headlessNavigation(){
        driver.get(webSiteURL);
    }

    public void assertHeaderText(String expectedValue){
        Assert.assertEquals(driver.findElement(header).getText(), expectedValue);
    }

    ///Configurations///
    @BeforeMethod
    public void beforeMethod(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        driver = new ChromeDriver(options);
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


}
