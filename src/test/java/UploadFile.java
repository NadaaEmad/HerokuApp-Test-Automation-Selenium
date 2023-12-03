import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadFile {
    private WebDriver driver;
    String pageURL = "https://the-internet.herokuapp.com/upload";

    ///Element Locators////
    private final By fileInput = By.cssSelector("input[type=file]");
    private final By submitButton = By.id("file-submit");
    private final By fileUploadedText = By.xpath("//h3");

///Test Cases///
    @Test
    public void verifyFileUploaded(){
        uploadFile();
        assertFileUploaded("File Uploaded!");
    }

    ///Actions///
    public void navigateToPage(){
        driver.navigate().to(pageURL);
    }
    public void uploadFile(){
        driver.findElement(fileInput).sendKeys("C:/Users/nada.emad/IdeaProjects/HerokuAppAutomation/image.png");
        driver.findElement(submitButton).click();
    }
    public void assertFileUploaded(String expectedResult){
        Assert.assertEquals(driver.findElement(fileUploadedText).getText(), expectedResult);
    }

////Configurations////
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        navigateToPage();
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
