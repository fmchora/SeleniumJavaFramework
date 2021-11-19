package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class homePage {
    WebDriver driver;
    By searchBoxImput = new By.ByXPath("//*[@id=\"input-search\"]");
    By searchBoxButton = new By.ByXPath("//*[@id=\"search-form\"]/div/div[1]/div/span/button/span");

    public homePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchCar(String car){
        driver.findElement(searchBoxImput).sendKeys(car);
        driver.findElement(searchBoxButton).click();

        List<WebElement> elements = driver.findElements(new By.ByXPath("//*[@id=\"serverSideDataTable\"]/tbody/tr/td[5]/span"));
        boolean elementInResult = elements.contains("HONDA");

//        WebElement cars = driver.findElement(By.linkText("Login"));
//        WebElement cdcdß = driver.findElement(By.linkText("Login"));
        //fsdf
    }
}
