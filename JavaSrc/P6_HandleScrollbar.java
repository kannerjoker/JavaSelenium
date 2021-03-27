import P0_SrcLocation.P0_srcLocation;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    public void handleScrollbar(){
        driver.get("file:///home/kan/IdeaProjects/JavaWeb/SeleniumHtml/P6_HandleScrollbar/frame_scroll.htm.html");
//        element对象的“顶端”对齐
        WebElement ele = driver.findElement(By.cssSelector("tbody tr:first-of-type"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollToView(true)",ele);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        element对象的“底端”对齐
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollToView(false)",ele);


    }

}
