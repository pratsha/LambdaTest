package Helpers;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

	/*
	 * Sets Desired capabilities for Chrome
	 */
	public ChromeOptions SetChromeOptionsCapabilities(HashMap<String, String> hs)
	{
		
		ChromeOptions capabilities = new ChromeOptions();
		
		Iterator<Entry<String, String>> it=hs.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<String, String> keyVal=it.next();
			capabilities.setCapability(keyVal.getKey(), keyVal.getValue());
		}
		return capabilities;
		
	}

	/*
	 * Sets Desired capabilities for Edge
	 */
	public EdgeOptions SetEdgeOptionsCapabilities(HashMap<String, String> hs)
	{
		
		EdgeOptions capabilities = new EdgeOptions();
		
		Iterator<Entry<String, String>> it=hs.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<String, String> keyVal=it.next();
			capabilities.setCapability(keyVal.getKey(), keyVal.getValue());
		}
		return capabilities;
		
	}
	
	/*
	 * Sets Desired capabilities
	 */
	public DesiredCapabilities SetCapabilities(HashMap<String, String> hs)
	{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		Iterator<Entry<String, String>> it=hs.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<String, String> keyVal=it.next();
			capabilities.setCapability(keyVal.getKey(), keyVal.getValue());
		}
		return capabilities;
		
	}
	public HashMap<String, String> CapabiltiesMap(String completeCapabilties) {
		String[] capSeperated=completeCapabilties.split(",");
		HashMap<String,String>hs=new HashMap<String,String>();
		for(String cap: capSeperated)
		{
			String[] keyVal=cap.split(":");
			hs.put(keyVal[0],keyVal[1]);
		}
		return hs;
	}
}
