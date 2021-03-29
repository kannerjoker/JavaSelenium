package P4_HandleWindow_switchTo;

import P0_SrcLocation.P0_srcLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P4_02_HandelIframe {
    P0_srcLocation p0 = new P0_srcLocation();

    WebDriver driver;
    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(), p0.getDriverSrc());

        driver = new FirefoxDriver();
        if((p0.getDriverName()).equals("webdriver.chrome.driver")){
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
    public void handleIframe(){
        p0.setFileName("P4_HandleAlert","P4_02_HandleWindow.html");
        driver.get(p0.getFileName());
        WebElement searchBox_DefaultPage = driver.findElement(By.cssSelector("body div+input:first-of-type"));
        searchBox_DefaultPage.sendKeys("hello");
//        定位iframe元素
        WebElement iframeEle = driver.findElement(By.cssSelector("iframe[src*=\"baidu.com\"]"));
//        进入iframe
        driver.switchTo().frame(iframeEle);

        WebElement searchBox_IframePage = driver.findElement(By.id("kw"));
        searchBox_IframePage.sendKeys("world!");

//        回到主界面
        driver.switchTo().defaultContent();
        searchBox_DefaultPage.sendKeys(" world!");

    }
}
