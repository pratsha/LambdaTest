package Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Drivers {
	
	public WebDriver GetDriver(DesiredCapabilities capabilities) throws IOException
	{
		
		Properties prop=new Properties();
		FileInputStream dataFile=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Helpers\\data.properties");
		prop.load(dataFile);
	
		WebDriver driver=new RemoteWebDriver(new URL(prop.getProperty("Grid")),capabilities);
		
		return driver;
	}
}
