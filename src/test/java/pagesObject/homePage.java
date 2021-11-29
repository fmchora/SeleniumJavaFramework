package pagesObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;
import java.util.List;


public class homePage {
    WebDriver driver;
    By searchBoxImput = new By.ByXPath("//*[@id=\"input-search\"]");
    By searchBoxButton = new By.ByXPath("//*[@id=\"search-form\"]/div/div[1]/div/span/button/span");

    public homePage(WebDriver driver){
        this.driver = driver;
    }

    public String GetIfCarAvailable(String car){
        this.searchCar(car);
        List<WebElement> elements = driver.findElements(new By.ByXPath("//*[@id=\"serverSideDataTable\"]/tbody/tr/td[5]/span"));

        String temp = "";
        for(WebElement e: elements){
            String currentCar = e.getText();
             if (currentCar.contains("PORSCHE")) {
                 System.out.println(e.getText());
                 temp = e.getText();
                 break;
             }
             else
                 System.out.println(e.getText());
        }
        return temp;
    }

    public void searchCar(String car){
        driver.findElement(searchBoxImput).sendKeys(car);
        driver.findElement(searchBoxButton).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void getPopularItems(){
        List<WebElement> elements = driver.findElements(new By.ByXPath("//*[@id=\"serverSideDataTable\"]/tbody/tr/td[5]/span"));

        WebElement element = driver.findElement(new By.ByXPath("//*[@id=\"tabMakes\"]/div/span[46]/div/div[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        List<WebElement> table = driver.findElements(new By.ByXPath("//*[@id=\"tabMakes\"]/div/span/span/a"));

//        WebElement url;
//        for (int i =1; i< table.size(); i++){
//            String model = table.get(i).getText();
//            url = driver.findElement(new By.ByXPath("//*[@id=\"tabMakes\"]/div/span[" + i + "]/span/a"));
//            String link = url.getAttribute("href").toString();
//            System.out.println(model + "  " +link);
//        }
        table.forEach(t-> {System.out.println(t.getText() + " - " + t.getAttribute("href"));});
        System.out.println("test");
    }
}
