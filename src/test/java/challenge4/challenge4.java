package challenge4;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pagesObject.homePage;

public class challenge4 {
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

    }

    @AfterClass
    public void stopClass(){

    }

    @BeforeMethod()
    public void beforeMethod() throws Exception {
    }

    @AfterMethod()
    public void afterMethod(){
    }
    @Test()
    public void challenge4test() throws Exception{

        int n = new fibonacci().getFibonacciNumber(7);
        fibonacci.convert(n);
        System.out.println(n + ": " + fibonacci.convert(n));
        int e = new fibonacci().getFibonacciNumber(12);
        System.out.println(e + ": " + fibonacci.convert(e));
        int w = new fibonacci().getFibonacciNumber(15);
        System.out.println(w + ": " + fibonacci.convert(w));

    }


}
