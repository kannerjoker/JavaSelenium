package P3_Browser;

import P0_SrcLocation.P0_srcLocation;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class P3_Browser {
    P0_srcLocation p0 = new P0_srcLocation();

    WebDriver driver;
    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(),p0.getDriverSrc());
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @AfterTest
    public void aterExplorer(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.quit();
    }
    @Test
    public void browerHandles(){
        driver.get("http://www.baidu.com");
        // 浏览器最大化
        driver.manage().window().maximize();

        // 浏览器跳转
        driver.navigate().to("http://www.sogou.com");
        // 刷新浏览器
        driver.navigate().refresh();
        // 浏览器后退
        driver.navigate().back();
        // 浏览器前进
        driver.navigate().forward();
        // 浏览器退出
        driver.quit();
    }

    @Test
    public void prtScreen(){
        driver.get("http://www.baidu.com");
//        TakesScreenshot screenshot = new FirefoxDriver();         false,more than one page;
//        TakesScreenshot screenshot = (TakesScreenshot)driver;     true,多态

        /*//截取1:
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // 浏览器界面
        try {
            FileUtils.copyFile(srcFile,new File("/home/kan/图片/1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //截取2:
        try {
            BufferedImage img = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));        // 整个屏幕界面
            ImageIO.write(img,"jpg",new File("/home/kan/图片/2.jpg"));
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }*/

        //截取3
        try {
            WebElement search_Element = driver.findElement(By.id("kw"));
            WrapsDriver wraps = (WrapsDriver)search_Element;
            File screenshotAs = ((TakesScreenshot) wraps.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(screenshotAs);

            int width = search_Element.getSize().getWidth();
            int height = search_Element.getSize().getHeight();
            Rectangle rect = new Rectangle(width,height);
            Point p = search_Element.getLocation();

            BufferedImage im = image.getSubimage(p.getX(),p.getY(),rect.width,rect.height);
            ImageIO.write(im,"png",new File("/home/kan/图片/31.png"));

//            FileUtils.copyFile(screenshotAs,new File("/home/kan/图片/3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void prtScreen_01(){
        driver.get("https://www.cnblogs.com/TankXiao/p/5260557.html");
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File shot = screenshot.getScreenshotAs(OutputType.FILE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
        String time = sdf.format(Calendar.getInstance().getTime());
        try {
            FileUtils.copyFile(shot,new File("/home/kan/图片/"+"m1"+time+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void prtScreen_02(){
        driver.get("https://www.cnblogs.com/TankXiao/p/5260557.html");
        try {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String time = sdf.format(Calendar.getInstance().getTime());
            ImageIO.write(image,"png",new File("/home/kan/图片/"+"m2"+time+".png"));
        } catch (AWTException|IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void prtScreen_03(){
        driver.get("https://www.cnblogs.com/TankXiao/p/5260557.html");
        WebElement book = driver.findElement(By.cssSelector("div p+br+a img"));

        WrapsDriver wraps = (WrapsDriver)book;
        File partialShot = ((TakesScreenshot)wraps.getWrappedDriver()).getScreenshotAs(OutputType.FILE);            //通过WrapsDriver接口的getWrappedDriver方法获取Driver对象
        try {
            BufferedImage image = ImageIO.read(partialShot);
            Point p = book.getLocation();
            BufferedImage im = image.getSubimage(p.getX(),p.getY(),book.getSize().getWidth(),book.getSize().getHeight());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
            String time = sdf.format(Calendar.getInstance().getTime());
            ImageIO.write(im,"png",new File("/home/kan/图片/"+"m3"+time+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void handleMouse(){
        driver.get("http://www.baidu.com");
        WebElement searchbox = driver.findElement(By.id("kw"));
        WebElement text1 = driver.findElement(By.cssSelector("div+ul li:nth-of-type(1) a[href^=\"https\"]"));


        Actions mouseActions = new Actions(driver);
//        1、单击:
        mouseActions.click();
//        2、右击
        mouseActions.contextClick(searchbox).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        3、按住不放
        mouseActions.clickAndHold();
//        4、双击
        mouseActions.doubleClick();
//        5、光标移动到指定元素
        mouseActions.moveToElement(text1).perform();
//        6、一定要在末尾增加.perform()不然Selenium会将鼠标动作保存在缓冲区中而不去执行
        mouseActions.click().perform();
    }

}
