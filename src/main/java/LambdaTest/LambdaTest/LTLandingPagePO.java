package LambdaTest.LambdaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LTLandingPagePO {
	
	WebDriver driver;
	String urlSUT="https://www.lambdatest.com/";
	public LTLandingPagePO(WebDriver driver, String url)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		urlSUT=url;
		
	}
		
		
	@FindBy(css="[class='text-center mt-25'] a[href='https://www.lambdatest.com/integrations']")
	private WebElement seeAllIntergration;

	
	public boolean LoadPage()
	{
		driver.get(urlSUT);
		
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[alt='Automated Browser Testing Tools']"))));
		
		return driver.findElement(By.cssSelector("[alt='Automated Browser Testing Tools']")).isDisplayed();
		
	}
	
	public WebElement WebElement_SeeAllIntegration()
	{

		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(seeAllIntergration));
		return seeAllIntergration;
	}

}
