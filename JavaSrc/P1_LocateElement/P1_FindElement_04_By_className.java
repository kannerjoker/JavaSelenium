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

public class P1_FindElement_04_By_className {
    P0_srcLocation p0 = new P0_srcLocation();

    WebDriver driver;
    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(),p0.getDriverSrc());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterTest
    public void AfterExplorer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findElement_04_By_className(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P1_LocateElement/P1_FindElement_04_By_className.html");
        WebElement searchBox = driver.findElement(By.className("search-combobox-input"));
        searchBox.sendKeys("books");
        searchBox.submit();
        System.out.println(searchBox.getAttribute("abc"));      //标签属性可以自定义
    }
}
