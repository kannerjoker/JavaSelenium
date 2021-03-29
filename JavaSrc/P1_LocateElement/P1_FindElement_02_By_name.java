package P1_LocateElement;

import P0_SrcLocation.P0_srcLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P1_FindElement_02_By_name {
    P0_srcLocation p0 = new P0_srcLocation();

    WebDriver driver;
    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(),p0.getDriverSrc());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void closeExployer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
    @Test
    public void findElement_02_By_name(){
        p0.setFileName("P1_LocateElement","P1_FindElement_02_By_name.html");
        driver.get(p0.getFileName());
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("movies");
    }
}
