package Helpers;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Drivers {
	
	public WebDriver GetDriver(DesiredCapabilities capabilities, String grid) throws MalformedURLException
	{
		WebDriver driver=new RemoteWebDriver(new URL(grid),capabilities);
		
		return driver;
	}

	public WebDriver GetDriver(ChromeOptions setChromeOptionsCapabilities, String grid) throws MalformedURLException {
		
			String url="https://"+setChromeOptionsCapabilities.getCapability("user")+setChromeOptionsCapabilities.getCapability("accessKey")+grid;
		
		WebDriver driver=new RemoteWebDriver(new URL(url),setChromeOptionsCapabilities);
		
		
		return driver;
	}

	public WebDriver GetDriver(EdgeOptions setEdgeOptionsCapabilities, String grid) throws MalformedURLException {
		
		String url="https://"+setEdgeOptionsCapabilities.getCapability("user")+setEdgeOptionsCapabilities.getCapability("accessKey")+grid;
		
		WebDriver driver=new RemoteWebDriver(new URL(url),setEdgeOptionsCapabilities);
		
		return driver;
	}
}
