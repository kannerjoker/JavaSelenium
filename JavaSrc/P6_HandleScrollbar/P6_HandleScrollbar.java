package P6_HandleScrollbar;

import P0_SrcLocation.P0_srcLocation;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class P6_HandleScrollbar {
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
    public void handleScrollbar_Left() throws InterruptedException {
        p0.setFileName("P6_HandleScrollbar","frame_scroll.htm.html");
        driver.get(p0.getFileName());
        driver.manage().window().setSize(new Rectangle(0,0,500,500).getDimension());

        driver.switchTo().frame(driver.findElement(By.id("leftFrame")));
//        横向滚动条右移
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(10000,0)");
        Thread.sleep(2000);
//        横向滚动条左移
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);
//        纵向滚动条向下
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,10000)");
        Thread.sleep(2000);
//        纵向滚动条
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
        Thread.sleep(2000);
//        滚动条逐渐向下移动
        int numAbstractDown = 10;
        for (int i = 0; i < numAbstractDown; i++) {
            ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+(i+1)*50+")");
            Thread.sleep(500);
        }
//        滚动条从当前位置逐渐向上移动
        int numRelativeUp = 10;
        for (int i = 0; i < numRelativeUp; i++) {
            ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+50*(-1)+")");
            Thread.sleep(500);
        }
//        滚动条逐渐向右移动
        int numAbstractRight = 10;
        for (int i = 0; i < numAbstractRight; i++) {
            ((JavascriptExecutor)driver).executeScript("window.scrollTo("+i*150+",0)");
            Thread.sleep(500);
        }

    }

    @Test
    public void handleScrollbar_Right(){
        p0.setFileName("P6_HandleScrollbar","frame_scroll.htm.html");
        driver.get(p0.getFileName());
//        driver.manage().window().maximize();
//        元素element对象的“顶端”与当前窗口的“顶部”对齐
        driver.switchTo().frame(driver.findElement(By.id("rightFrame")));
        WebElement ele1 = driver.findElement(By.cssSelector("tbody tr:first-of-type"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",ele1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        元素element对象的“底端”与当前窗口的“底部”对齐
        WebElement ele2 = driver.findElement(By.xpath("//a[contains(text(),\"通过 scrollBy() 滚动文档\")]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false)",ele2);

//        移动到指定的坐标(相对当前的坐标移动)
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        移动到窗口绝对位置坐标，如下移动到顶部
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,0)");
    }

}
