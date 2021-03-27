package P4_HandleWindow_switchTo;

import P0_SrcLocation.P0_srcLocation;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P4_01_HandelAlert {
    P0_srcLocation p0 = new P0_srcLocation();

    WebDriver driver;
    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(),p0.getDriverSrc());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @AfterTest
    public void afterExplorer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.quit();
    }
    @Test
    public void handleAlert(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P4_HandleAlert/P4_01_HandleAlert.html");
        WebElement alertButton = driver.findElement(By.xpath("//body/p[1]/input"));
        alertButton.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void handleConfirm(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P4_HandleAlert/P4_01_HandleAlert.html");
        WebElement confirmButton = driver.findElement(By.cssSelector("body p:nth-of-type(2) input"));
        confirmButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Alert confirm = driver.switchTo().alert();
        confirm.dismiss();
    }
    @Test
    public void handlePrompt(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P4_HandleAlert/P4_01_HandleAlert.html");
        WebElement promptButton = driver.findElement(By.cssSelector("body p:last-of-type input"));

        Actions act = new Actions(driver);
        act.moveToElement(promptButton).perform();

        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("hello world!");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        prompt.accept();
        act.moveByOffset(0, 0);
    }
}
