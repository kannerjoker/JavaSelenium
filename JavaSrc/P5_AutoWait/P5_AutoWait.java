package P5_AutoWait;

import P0_SrcLocation.P0_srcLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P5_AutoWait {
    P0_srcLocation p0 = new P0_srcLocation();
    WebDriver driver;

    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(),p0.getDriverSrc());
        driver = new FirefoxDriver();
    }
    @AfterTest
    public void afterExplorer(){}
    @Test
    public void w1_implicitlyWait(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P5_AutoWait/P5_AutoWait.html");
        driver.findElement(By.cssSelector("input[value*=\"click\"]")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border=\"10px solid blue\"",driver.findElement(By.id("abc")));
    }
    @Test
    public void w2_exceptedCondtions(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P5_AutoWait/P5_AutoWait.html");
        driver.findElement(By.cssSelector("input[value*=\"click\"]")).click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("d1")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border=\"8px solid purple\"",driver.findElement(By.id("abc")));
    }
}
