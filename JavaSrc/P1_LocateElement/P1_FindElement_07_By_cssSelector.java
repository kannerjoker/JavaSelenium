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

public class P1_FindElement_07_By_cssSelector {
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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();

    }

    @Test
    public void findElement_07_By_cssSelector(){
        p0.setFileName("P1_LocateElement","P1_FindElement_08_By_xpath.html");
        driver.get(p0.getFileName());
//        1、使用id选择器                         "#id"值
        WebElement cssSelector_01 = driver.findElement(By.cssSelector("#recordlist"));
//        2、使用属性选择器                        ".属性值"
        WebElement cssSelector_02 = driver.findElement(By.cssSelector(".subdiv"));
//        3、选择内部元素                          ele1 ele2
        WebElement cssSelector_03 = driver.findElement(By.cssSelector("div a"));
//        4、选择紧邻元素                          ele1+ele2
        WebElement cssSelector_04 = driver.findElement(By.cssSelector("div ul p+li"));
//        5、选择子元素                            ele1>ele2
        WebElement cssSelector_05 = driver.findElement(By.cssSelector("div ul>li"));
//        6、选择以字符value开头的标签                 a[attribute^="value"]
        WebElement cssSelector_06 = driver.findElement(By.cssSelector("[href^=\"http\"]"));
//        7、选择包含字符value的标签                  a[attribute*="value"]
        WebElement cssSelector_07 = driver.findElement(By.cssSelector("[href*=\"baidu\"]"));
//        8、选择以字符value结束的标签                 a[attribute$="value"]
        WebElement cssSelector_08 = driver.findElement(By.cssSelector("[href$=\"com\"]"));
//        9、选择第一个子元素                p li:first-of-type
        WebElement cssSelector_09 = driver.findElement(By.cssSelector("div ul li:first-of-type"));
//        10、选择最后一个子元素              p li:last-of-type
        WebElement cssSelector_10 = driver.findElement(By.cssSelector("div ul li:last—of-type"));
//        11、选择中间第n个子元素             p li:nth-of-type(n)
        WebElement cssSelector_11 = driver.findElement(By.cssSelector("div ul li:nth-of-type(n)"));
//        12、选择中间第n个子元素(倒叙)       p li:nth-last-of-type(n)
        WebElement cssSelector_12 = driver.findElement(By.cssSelector("div ul li:nth-last-of-type(n)"));








    }
}
