package Helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Drivers {
	
	public WebDriver GetDriver(DesiredCapabilities capabilities, String grid) throws IOException
	{
		
		WebDriver driver=new RemoteWebDriver(new URL(grid),capabilities);
		return driver;
	}
}
