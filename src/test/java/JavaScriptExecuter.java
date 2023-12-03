import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuter {
    private WebDriver driver;
    JavascriptExecutor js;

    String checkboxPageURL = "https://the-internet.herokuapp.com/checkboxes";
    String forgotPasswordPageURL = "https://the-internet.herokuapp.com/forgot_password";

    private final By forgotPasswordMsg = By.xpath("//h1");

////Test Cases////
    @Test
    public void verifyCheckboxScript(){
        navigateToCheckboxURL();
        runCheckboxScript();
    }
    @Test
    public void verifyForgotPasswordScript(){
        navigateToForgotPasswordURL();
        runForgotPasswordScript();
        assertForgotPasswordMessageAfterClick("Internal Server Error");
    }


    ////Actions///
    public void navigateToCheckboxURL(){
        driver.navigate().to(checkboxPageURL);
    }
    public void navigateToForgotPasswordURL(){
        driver.navigate().to(forgotPasswordPageURL);
    }
    public void runCheckboxScript(){
        js.executeScript("document.querySelector(\"input[type='checkbox']\").checked=true;");
    }
    public void runForgotPasswordScript(){
        js.executeScript("document.querySelector(\"input[type='text']\").value=\"ne867224@gmail.com\";");
        js.executeScript("document.querySelector(\"button[id='form_submit']\").click();");

    }
    public void assertForgotPasswordMessageAfterClick(String expectedValue){
        Assert.assertEquals(driver.findElement(forgotPasswordMsg).getText(), expectedValue);
    }

    ////Configurations////
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
