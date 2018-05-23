package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.java.After;
 import cucumber.api.java.Before;
 import cucumber.api.java.en.*;



import java.net.URL;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertTrue;

//
//TODO: update this class to extend class 'Base' and remove implements Config...
//Comment the @Before and @After annotations here so the system uses those in the base class instead
//result = nullpointer
//if commenting out just the @After, the driver fails to quit
//I have temporarily moved the decision for browser into this setUp method and you can set the browser to be
//firefox or chrome using the argument -Dbrowser=chrome or -Dbrowser=firefox for the time being
//

public class SearchTestDefinitions  {
    private WebDriver driver;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\mchappid\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless","window-size=1024,768","--no-sandbox");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.DAYS.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
   @ Given("^navigate to url$") public void toUrl(){
        // Write code here that turns the phrase above into concrete actions
	   driver.get("https://www.google.com/");
    }

    @When("^search for word$")public void word() {
        // Write code here that turns the phrase above into concrete actions
    	driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys("maps");
    	driver.findElement(By.xpath("//*[@id=\"lst-ib\"]")).sendKeys(Keys.RETURN);
    	
    }

   @ Then("^results appear$")public void appars()  {
        // Write code here that turns the phrase above into concrete actions
	   boolean condition = driver.findElement(By.xpath("//*[@id=\"resultStats\"]")).isDisplayed();
	   Assert.assertTrue(condition);
    }
}
