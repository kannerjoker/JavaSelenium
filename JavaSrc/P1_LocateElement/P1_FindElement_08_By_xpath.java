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

public class P1_FindElement_08_By_xpath {
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
        driver.quit();
    }
    @Test
    public void findElement_08_By_xpath(){
        p0.setFileName("P1_LocateElement","P1_FindElement_08_By_xpath.html");
        driver.get(p0.getFileName());
//    1、绝对路径
        WebElement xpath_Element_01 = driver.findElement(By.xpath("/html/body/div"));
//    2、相对路径
        WebElement xpath_Element_02 = driver.findElement(By.xpath("//body/div"));
//    3、索引定位
        WebElement xpath_Element_03 = driver.findElement(By.xpath("//body/div[1]"));    //索引从1开始
//    4、页面属性定位
        WebElement xpath_Element_04 = driver.findElement(By.xpath("//input[@name=\"div1_input\"]"));
//    5、模糊定位starts-with
        WebElement xpath_Element_05 = driver.findElement(By.xpath("//div[starts-with(@id,\"div\")]"));      //"starts-with" Not "strat with"
//    6、模糊定位contains
        WebElement xpath_Element_06 = driver.findElement(By.xpath("//img[contains(@alt,\"img1\")]"));
//    7、文本定位text()                          //<a> enabled; but <img>、<input> not enabled
        WebElement xpath_Element_07 = driver.findElement(By.xpath("//a[text()=\"baidu_picture\"]"));
        WebElement xpath_Element_08 = driver.findElement(By.xpath("//*[contains(text(),\"baidu\")]"));      //  "//*" == any html

    }

}
