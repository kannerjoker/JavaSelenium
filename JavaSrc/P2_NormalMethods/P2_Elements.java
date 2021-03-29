package P2_NormalMethods;

import P0_SrcLocation.P0_srcLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P2_Elements {
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
    public void P2_Elemnts_01_Link(){
        p0.setFileName("P2_NormalMethods","P2_Elements.html");
        driver.get(p0.getFileName());
        WebElement link = driver.findElement(By.xpath("//a[text()=\"小坦克\"]"));
        //点击链接
        link.click();
    }
    @Test
    public void P2_Elemnts_02_Textbox(){
        p0.setFileName("P2_NormalMethods","P2_Elements.html");
        driver.get(p0.getFileName());
        WebElement textbox = driver.findElement(By.id("usernameid"));

        //清除
        textbox.clear();
        //输入指定字符
        textbox.sendKeys("baidu");
    }
    @Test
    public void P2_Elemnts_03_Button(){
        p0.setFileName("P2_NormalMethods","P2_Elements.html");
        driver.get(p0.getFileName());
        WebElement button = driver.findElement(By.cssSelector("input[value*=\"添加\"]"));
        //点击
        button.click();
        //判断是否可用
        boolean enabled = button.isEnabled();
        System.out.println(enabled);
    }
    @Test
    public void P2_Elemnts_04_Select(){
        p0.setFileName("P2_NormalMethods","P2_Elements.html");
        driver.get(p0.getFileName());
        WebElement seElement = driver.findElement(By.xpath("//select"));
        Select se = new Select(seElement);
//        通过索引定位选项
        se.selectByIndex(0);
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

//        通过value属性定位选项
        se.selectByValue("18");
        try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

//        通过文本定位选项
        se.selectByVisibleText("种类CC");

        List<WebElement> list = se.getOptions();
        for (WebElement ele : list) {
            System.out.println(ele.getText());
        }


    }
    @Test
    public void P2_Elemnts_05_RadioButton(){
        p0.setFileName("P2_NormalMethods","P2_Elements.html");
        driver.get(p0.getFileName());
        WebElement radioButton_1 = driver.findElement(By.cssSelector("div input:nth-of-type(1)"));
        WebElement radioButton_2 = driver.findElement(By.cssSelector("div input:nth-of-type(2)"));
        WebElement radioButton_3 = driver.findElement(By.cssSelector("div input:nth-of-type(3)"));
        WebElement radioButton_4 = driver.findElement(By.cssSelector("div input:nth-of-type(4)"));
        //同时只能选中一个
        radioButton_1.click();
        radioButton_2.click();
        radioButton_3.click();
        //判断是否被选中
        boolean isSelected = radioButton_3.isSelected();
        System.out.println(isSelected);
    }
    @Test
    public void P2_Elemnts_06_CheckBox(){
        p0.setFileName("P2_NormalMethods","P2_Elements.html");
        driver.get(p0.getFileName());
        WebElement checkbox_1 = driver.findElement(By.cssSelector("div+div input:nth-of-type(1)"));
        WebElement checkbox_2 = driver.findElement(By.cssSelector("div+div input:nth-of-type(2)"));
        WebElement checkbox_3 = driver.findElement(By.cssSelector("div+div input:nth-of-type(3)"));
        WebElement checkbox_4 = driver.findElement(By.cssSelector("div+div input:nth-of-type(4)"));
        checkbox_1.click();
        //初次选中，再次则取消
        checkbox_3.click();
        checkbox_3.click();
        //判断是否被选中
        boolean isSelected = checkbox_2.isSelected();
        System.out.println(isSelected);
    }
}
