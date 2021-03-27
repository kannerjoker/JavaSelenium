package P1_LocateElement;

import P0_SrcLocation.P0_srcLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class P1_FindElement_03_By_tagName {
    P0_srcLocation p0 = new P0_srcLocation();

    WebDriver driver;
    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(),p0.getDriverSrc());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void closeExplorer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.quit();
    }
    @Test
    public void findElement_03_By_tagName_1(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P1_FindElement_03_By_tagName.html");
        List<WebElement> divElements = driver.findElements(By.tagName("div"));
        for (WebElement divEle : divElements) {
            System.out.println(divEle);
        }
    }

    @Test
    public void findElement_03_By_tagName_2(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P1_LocateElement/P1_FindElement_03_By_tagName.html");
        List<WebElement> inputElements = driver.findElements(By.tagName("input"));
        for (WebElement inputEle : inputElements) {
            if(inputEle.getAttribute("type").equals("text")){
                inputEle.sendKeys("hello world!");
                System.out.println("input Text is:"+inputEle.getAttribute("placeholder"));
            }
        }
    }
}
