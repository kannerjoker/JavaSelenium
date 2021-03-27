package P4_HandleWindow_switchTo;

import P0_SrcLocation.P0_srcLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class P4_03_HandleWindow {
    P0_srcLocation p0 = new P0_srcLocation();

    WebDriver driver;
    @BeforeTest
    public void preExplorer(){
        System.setProperty(p0.getDriverName(),p0.getDriverSrc());
        driver = new FirefoxDriver();
        if((p0.getDriverName().equals("driver.chrome.driver"))){
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @AfterTest
    public void afterExplorer(){}
    @Test
    public void handleWindow(){
        driver.get("http://www.baidu.com");

        Map<String,String> ma = new LinkedHashMap();

        //win_1
        Set<String> winHandles_01 = driver.getWindowHandles();
        Set<String> win_1 = new HashSet<>(winHandles_01);
        for (String s : win_1) {
            ma.put("win1",s);
        }

        WebElement kw = driver.findElement(By.id("kw"));
        kw.sendKeys("hello");
        kw.sendKeys(Keys.ENTER);
        //win_2
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> winHandles_02 = driver.getWindowHandles();
        String win_2 = getCurrentWin(winHandles_01,winHandles_02);
        ma.put("win2",win_2);

        WebElement item_01 = driver.findElement(By.cssSelector("div[id=\"2\"] h3 a"));
        item_01.click();
        //win_3
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> winHandles_03 = driver.getWindowHandles();
        String win_3 = getCurrentWin(winHandles_02,winHandles_03);
        driver.switchTo().window(win_3);
        ma.put("win3",win_3);
        System.out.println("win_3: "+driver.getTitle());

        WebElement win_3_item01 = driver.findElement(By.cssSelector("a[href=\"/usercenter\"]"));
        win_3_item01.click();
        //win_4
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> winHandles_04 = driver.getWindowHandles();
        String win_4 = getCurrentWin(winHandles_03,winHandles_04);
        driver.switchTo().window(win_4);
        ma.put("win4", win_4);
        System.out.println("win_4: "+driver.getTitle());
        WebElement win_4_item01 = driver.findElement(By.cssSelector("a[data-title=\"qzone\"]"));
        win_4_item01.click();

        //win_5
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> winHandles_05 = driver.getWindowHandles();
        String win_5 = getCurrentWin(winHandles_04,winHandles_05);
        driver.switchTo().window(win_5);
        ma.put("win5",win_5);
        System.out.println("win5: "+driver.getTitle());
        System.out.println("ma = " + ma);
        System.out.println("winHandles_05 = " + winHandles_05);
        Set<String> keySet = ma.keySet();
        System.out.println("------------>>>>>>>>>>>>>>>>");
        for (String s : keySet) {
            driver.switchTo().window(ma.get(s));
            System.out.println(s+" : "+driver.getTitle());
        }
    }


    //新增窗口
    public String getCurrentWin(Set<?> setsBefore,Set<?> setsNow){
        Set<String> set_n = new HashSet(setsBefore);
        Set<String> set_m = new HashSet(setsNow);
        set_m.removeAll(set_n);

        String str = "";
        for (String s : set_m) {
            str = s;
        }
        return str;
    }
}
