package challenge2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesObject.homePage;

public class challenge2 {
    public WebDriver driver;

    @BeforeSuite
    public void startSuite() throws Exception {
    }

    @AfterSuite
    public void stopSuite() throws Exception {
        System.out.println("All done!!!");
    }

    @BeforeClass
    public void startClass() throws Exception{
        System.setProperty("webdriver.chrome.driver", "./bin/chromedriver.exe");
        driver =  new ChromeDriver();
    }

    @AfterClass
    public void stopClass(){
        driver.close();
    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
    }

    @AfterMethod()
    public void afterMethod(){
    }
    @Test()
    public void goToGoogle() throws Exception{
        driver.get("https://www.copart.com/");
        homePage homePageObj = new homePage(driver);
        String car = homePageObj.GetIfCarAvailable("exotics");
        Assert.assertEquals(car, "PORSCHE");

    }


}
