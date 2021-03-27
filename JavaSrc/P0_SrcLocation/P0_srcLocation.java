package P0_SrcLocation;

public class P0_srcLocation {
    private static String driverName;
    private static String driverSrc;
    private static String fileName;
    public P0_srcLocation(String driverName,String driverSrc,String fileName){
        this.driverName = driverName;
        this.driverSrc = driverSrc;
        this.fileName = fileName;
    }

    public P0_srcLocation(){
        this.driverName = "webdriver.gecko.driver";
        this.driverSrc = "/home/kan/下载/geckodriver";
        this.fileName = "http://www.sogou.com";
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
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getFileName(){
        return this.fileName;
    }
}
