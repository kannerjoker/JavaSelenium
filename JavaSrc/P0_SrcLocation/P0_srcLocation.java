package P0_SrcLocation;

import java.io.File;
import java.io.IOException;

public class P0_srcLocation {
    private static String driverName;
    private static String driverSrc;
    private static String fileName;

    public P0_srcLocation(){
        this.driverName = "webdriver.gecko.driver";
        this.driverSrc = "F:\\java_Selenium\\Sources\\drivers\\geckodriver.exe";
        this.fileName = "http://www.sogou.com";
    }
    public P0_srcLocation(String driverName,String driverSrc,String fileName){
        this.driverName = driverName;
        this.driverSrc = driverSrc;
        this.fileName = fileName;
    }

    public void setDriverName(String driverName){
        this.driverName = driverName;
    }
    public String getDriverName(){
        return this.driverName;
    }

    public void setDriverSrc(String driverSrc){
        this.driverSrc = driverSrc;
    }
    public String getDriverSrc(){
        return this.driverSrc;
    }

    public void setFileName(String directory,String document){
        try {
            File file = new File("");
            File fileDirectory = new File(file.getCanonicalFile()+File.separator + "SeleniumHtml",directory);
            File fileDocument = new File(fileDirectory,document);
            this.fileName = fileDocument.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getFileName(){
        return this.fileName;
    }
}
