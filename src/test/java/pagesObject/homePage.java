package pagesObject;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.lang.Thread;

import java.util.Dictionary;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.*;



public class homePage {
    WebDriver driver;
    By searchBoxImput = new By.ByXPath("//*[@id=\"input-search\"]");
    By searchBoxButton = new By.ByXPath("//*[@id=\"search-form\"]/div/div[1]/div/span/button/span");
    By dropMenuListItems = new By.ByXPath("//*[@id=\"mainBody\"]/div[2]/div[3]/div/app-root/lot-search-results/search-results/div/div[2]/div[2]/search-table-component/copart-table/div/p-table/div/p-paginator/div/p-dropdown/div/div[2]/span");
    By oneHundredItems = new By.ByXPath("//*[@id=\"mainBody\"]/div[2]/div[3]/div/app-root/lot-search-results/search-results/div/div[2]/div[2]/search-table-component/copart-table/div/p-table/div/p-paginator/div/p-dropdown/div/div[3]/div/ul/p-dropdownitem[5]/li/span");
    By filterModelExpand = new By.ByXPath("//*[@id=\"p-panel-7-label\"]/span");
    By searchFilterModel = new By.ByXPath("//*[@id=\"p-panel-7-content\"]/div/div/div/search-checkbox-filter/div/p-listbox/div/div[1]/div/input");
    By searchFilterRsults = new By.ByXPath("//*[@id=\"p-panel-7-content\"]/div/div/div/search-checkbox-filter/div/p-listbox/div/div[2]/ul/li");


    public homePage(WebDriver driver){
        this.driver = driver;
    }

    public String GetIfCarAvailable(String car){
        this.searchCar(car);
        List<WebElement> elements = driver.findElements(new By.ByXPath("//*[@id='mainBody']/div[2]/div[3]/div/app-root/lot-search-results/search-results/div/div[2]/div[2]/search-table-component/copart-table/div/p-table/div/div[1]/table/tbody/tr/td[2]/span[2]/div/span/a/span"));

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

    public final void waitForSecconds(int s){
        driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);
    }
    public void searchCar(String car){
        this.waitForSecconds(5);
        driver.findElement(searchBoxImput).sendKeys(car);
        driver.findElement(searchBoxButton).click();

        this.waitForSecconds(3);
        try {
            driver.findElement(new By.ByXPath("/html/body/joyride-step/div/div/div[2]/tour-header/div/span")).click();
        }
        catch(Exception e) {}

        System.out.println("Search completed");
    }

    public void getPopularItems(){
        this.waitForSecconds(2);
        //Scroll to element
        WebElement element = driver.findElement(new By.ByXPath("//*[@id=\"tabMakes\"]/div/span[47]/div/div[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        //Get all the elements
        List<WebElement> table = driver.findElements(new By.ByXPath("//*[@id='tabMakes']/div/span/span/a"));
        //Loop and print
        table.forEach(t-> {System.out.println(t.getText() + " - " + t.getAttribute("href"));});
        System.out.println("test");
    }

    public void selectToOneHundreadItems(){
        WebElement element = driver.findElement(dropMenuListItems);
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        driver.findElement(dropMenuListItems).click();
        this.waitForSecconds(1);
        driver.findElement(oneHundredItems).click();

        //Scroll to element - top of the page
        WebElement element1 = driver.findElement(new By.ByXPath("//*[@id=\"mainBody\"]/div[2]/div[3]/div/app-root/lot-search-results/search-results/div/div[2]/div[2]/search-table-component/copart-table/div/p-table/div/div[1]/table/thead/tr/th[1]"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(element1);
        actions1.perform();

        HashMap<String, Integer> make = new HashMap<String, Integer>();
        HashMap<String, Integer> damages = new HashMap<String, Integer>();

        damages.put("Side Damage",0);
        damages.put("Keys Available",0);
        damages.put("Salvage Title",0);
        damages.put("Mechanical Damage",0);
        damages.put("Front End Damage",0);
        damages.put("Undercarriage Damage",0);
        damages.put("Normal Wear Damage",0);
        damages.put("Clean Title",0);
        damages.put("Missing/Altered Vin Damage",0);
        damages.put("Rear End Damage",0);
        damages.put("Rollover Damage",0);
        damages.put("Burn Damage",0);
        damages.put("Top/Roof Damage",0);
        damages.put("All Over Damage",0);
        damages.put("Burn - Engine Damage",0);
        damages.put("Keys Not Available",0);


        for(int i = 1; i <= 100; i++)
        {
            WebElement makeCar= driver.findElement(new By.ByXPath("//*[@id='mainBody']/div[2]/div[3]/div/app-root/lot-search-results/search-results/div/div[2]/div[2]/search-table-component/copart-table/div/p-table/div/div[1]/table/tbody/tr["+i+"]/td[2]/span[2]/div/span/a/span"));
            //System.out.println(makeCar.getText());
            Actions actionsLoop = new Actions(driver);
            actionsLoop.moveToElement(makeCar);
            actionsLoop.perform();

            String carMakeString = makeCar.getText().replaceAll("\\d", "");
            if(make.containsKey(carMakeString))
                {
                    make.put(carMakeString, make.get(carMakeString) + 1);
                }
            else
            {
                make.put(carMakeString, 1);
            }


            List<WebElement> damagesItems = driver.findElements(new By.ByXPath("//*[@id='mainBody']/div[2]/div[3]/div/app-root/lot-search-results/search-results/div/div[2]/div[2]/search-table-component/copart-table/div/p-table/div/div[1]/table/tbody/tr["+i+"]/td[4]/span[2]/div/div"));


          for(WebElement temp : damagesItems)
          {
              String individualDamage = temp.getAttribute("innerText");
              if(damages.containsKey(individualDamage))
              {
                  damages.put(individualDamage, damages.get(individualDamage) + 1);
              }

              //System.out.println(temp.getAttribute("innerText"));
          }

        }
        make.forEach((key, value) -> System.out.println(key + " : " + value));

        System.out.println("---------------------------------------------------------");

        damages.forEach((key, value) -> System.out.println(key + "  : " + value));
    }


public void trySearchFilterModel(String model) throws IOException {
        this.waitForSecconds(1);
        driver.findElement(filterModelExpand).click();
        driver.findElement(searchFilterModel).sendKeys(model);
        this.waitForSecconds(1);

        try {
            driver.findElement(new By.ByXPath(" //*[@id=\"p-panel-7-content\"]/div/div/div/search-checkbox-filter/div/p-listbox/div/div[2]/ul/li/div[1]/div")).click();

        }
        catch(Exception e) {
            String result = driver.findElement(searchFilterRsults).getText();

            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            // Now you can do whatever you need to do with it, for example copy somewhere
            File dest = new File("src/test/java/challenge6/challenge6.png");
            FileHandler.copy(scrFile, dest);

        }


    }


    public void validateMakesModels() throws Exception {
        this.waitForSecconds(2);
        //Scroll to element
        WebElement element = driver.findElement(new By.ByXPath("/html/body/div[2]/div[3]/div/app-root/div[1]/div/fragment[3]/div/div/div[2]/div[1]/div[3]/div/span[47]/div/div[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
        //Get all the elements
        List<WebElement> table = driver.findElements(new By.ByXPath("/html/body/div[2]/div[3]/div/app-root/div[1]/div/fragment[3]/div/div/div[2]/div[1]/div[3]/div/span/span/a"));

        HashMap<String, String> make = new HashMap<String, String>();

        for(WebElement e: table){
            String link = e.getAttribute("href");
            String carMake = e.getText();

            make.put(carMake,link);

            }

        for (Map.Entry mapElement : make.entrySet())
        {
            this.waitForSecconds(10);
            driver.get((String) mapElement.getValue());
            this.waitForSecconds(2);
            try {
                driver.findElement(new By.ByXPath(" //*[@id=\"p-panel-7-content\"]/div/div/div/search-checkbox-filter/div/p-listbox/div/div[2]/ul/li/div[1]/div")).click();

            }
            catch(Exception e) {

            }

            String searchResultText = driver.findElement(new By.ByXPath("/html/body/div[2]/div[3]/div/app-root/vehicle-search-results/search-results/div/div[2]/div[2]/div[1]/div[1]/search-results-header/div/h3/span[2]")).getText();

            Assert.assertTrue(searchResultText.contains((String)mapElement.getKey()));
        }


    }


}
