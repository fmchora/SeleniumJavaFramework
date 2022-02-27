package challenge5;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pagesObject.homePage;

public class challenge5 {
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
        driver.manage().window().maximize();


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
    public void Challenge5() throws Exception{
        driver.get("https://www.copart.com/");
        homePage homePageObj = new homePage(driver);
        homePageObj.searchCar("PORSCHE");
        homePageObj.selectToOneHundreadItems();



    }


}
