import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass {
    private WebDriver driver;
    String HoverPageURL = "https://the-internet.herokuapp.com/hovers";
    String keyboardPageURL = "https://the-internet.herokuapp.com/key_presses?";

    //Element locators
    private final By userIcon = By.xpath("(//img[@alt='User Avatar'])[1]");
    private final By username = By.xpath("(//h5)[1]");
    private final By result = By.id("result");

    //Creating object of an Actions class
    Actions action;

    ///Test Cases////
    @Test
    public void verifyHoverAction(){
        navigateToHoverPage();
        hoverAction();
        assertElementDisplayedWhenHover();
    }
    @Test
    public void verifyPressEnterAction(){
        navigateToKeyboardPage();
        PressEnter();
        assertPressEnterActionMessage("You entered: ENTER");
    }

    ///Actions///
    public void navigateToHoverPage(){
        driver.navigate().to(HoverPageURL);
    }
    public void navigateToKeyboardPage(){
        driver.navigate().to(keyboardPageURL);
    }
    public void hoverAction(){
        WebElement element = driver.findElement(userIcon);
        action.moveToElement(element).perform();
    }
    public void assertElementDisplayedWhenHover(){
        Assert.assertTrue(driver.findElement(username).isDisplayed());
    }

    public void PressEnter(){
        action.keyDown(Keys.ENTER).perform();
    }

    public void assertPressEnterActionMessage(String expectedResult){
        Assert.assertEquals(driver.findElement(result).getText(), expectedResult);
    }
    ///Configurations////
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        action = new Actions(driver);

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
