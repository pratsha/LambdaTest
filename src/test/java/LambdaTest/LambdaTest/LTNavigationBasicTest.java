package LambdaTest.LambdaTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Helpers.Capabilities;
import Helpers.Drivers;



public class LTNavigationBasicTest {
	
	public ArrayList<String> tabsArray;
	public String urlSUT;
	public String platform;
	public WebDriver driver;
	public LTLandingPagePO landingPage;
	public LTAllIntergrations allIntegrations;	
	public LTBlog blog;
	public Actions action;
	public JavascriptExecutor js;
	public Capabilities cap;
	
	@Parameters({"URLLandingPage","CompleteCapabilties","Grid"})
	@BeforeTest
	public void Test_Init(String url,String completeCapabilties, String grid) throws IOException
	{
		this.urlSUT=url;
		
		
		this.cap=new Capabilities();
		Drivers drive=new Drivers();
		
		HashMap<String,String>mapCapbilities=new HashMap<String,String>();
		 mapCapbilities=this.cap.CapabiltiesMap(completeCapabilties);
		this.platform=mapCapbilities.get("platform");
		
		this.driver=drive.GetDriver(cap.SetCapabilities(mapCapbilities),grid);
		
		driver.manage().window().maximize();
		
		this.landingPage=new LTLandingPagePO(driver,urlSUT);
		this.allIntegrations=new LTAllIntergrations(driver);
		this.blog=new LTBlog(driver);
		
		this.action=new Actions(driver);
		this.js=(JavascriptExecutor)driver;
		this.tabsArray=new ArrayList<String>();
		
	}

	@Test
	public void LoadPage_VerifyPageIsLoaded()
	{
		boolean isLoaded=landingPage.LoadPage();
		
		Assert.assertTrue(isLoaded,"Page did not load.");
	}
	
	@Test(dependsOnMethods= {"LoadPage_VerifyPageIsLoaded"})
	public void Scroll_To_SeeAllIntegration_VerifyURL()
	{
	
		WebElement seeallInt= landingPage.WebElement_SeeAllIntegration();
		String linkText=seeallInt.getAttribute("href");
		
		//Moving to DIV as browser was jumping to Reviews.
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("[class='container relative']")));
		
		if(platform.contains("mac"))
		{
			action.moveToElement(seeallInt).keyDown(Keys.COMMAND).click().build().perform();
			action.keyUp(Keys.COMMAND).build().perform();
		}
		else
		{
			action.moveToElement(seeallInt).keyDown(Keys.CONTROL).click().build().perform();
			action.keyUp(Keys.CONTROL).build().perform();
		}
			
		
		tabsArray=WindowHandle();
		
		driver.switchTo().window(tabsArray.get(1).toString());
		
		String currentURL=driver.getCurrentUrl();
		
		System.out.println(currentURL);
		Assert.assertTrue(currentURL.equals(linkText),
			"Not the same link as Element.");
		
		
	}

	@Test(dependsOnMethods= {"Scroll_To_SeeAllIntegration_VerifyURL"})
	public void Scroll_To_CodeLess_VerifySelected()
	{
		
		WebElement codelessDiv=allIntegrations.WebElement_CodelessDIV();
		js.executeScript("arguments[0].scrollIntoView();", codelessDiv);
		
		WebElement codeless=allIntegrations.WebElement_Codeless();
				
		Assert.assertTrue(codeless.getText().contains("Codeless Automation"));
				
	
	}
	
	@Test(dependsOnMethods= {"Scroll_To_CodeLess_VerifySelected"})
	public void Click_On_LearnMore_VerifyTitle()
	{
		
		WebElement learnMore=allIntegrations.WebElement_LearnMore();
		
		learnMore.click();
		
		Assert.assertTrue(driver.getTitle().contains("TestingWhiz LambdaTest | Lambdatest"));
		
		driver.switchTo().window(tabsArray.get(1));
		driver.close();
		System.out.println("Current Window Count: "+driver.getWindowHandles().size());
		
		
	}
	
	@Test(dependsOnMethods= {"Click_On_LearnMore_VerifyTitle"})
	public void Navigate_To_Blog()
	{
		driver.switchTo().window(tabsArray.get(0));
		
		boolean isLoaded= blog.LoadPage();
		
		Assert.assertTrue(isLoaded,"Blog page is not open.");
		
	}
	
	@Test(dependsOnMethods= {"Navigate_To_Blog"})
	public void Click_On_Community_VerifyTitle()
	{
		WebElement community=blog.WebElement_Community();
		
		community.click();
		
		driver.getCurrentUrl().equals("https://community.lambdatest.com/");		
		Assert.assertTrue(driver.getCurrentUrl().equals("https://community.lambdatest.com/"),"Url Did not match.");
		
	}
	
	@AfterTest
	public void Test_CleanUp()
	{
		driver.quit();
	}
	
	//Method to get WindowHandle in ArrayList
	private ArrayList<String> WindowHandle() {
		
		Set<String> _tabs= driver.getWindowHandles();
		Iterator<String> it=_tabs.iterator();
		ArrayList<String> tabs=new ArrayList<String>();
		while(it.hasNext())
		{
			String link=it.next().toString();
			tabs.add(link);
			System.out.println("Window Handles: "+link);
		}
		return tabs;
	}
}
