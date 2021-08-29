package LambdaTest.LambdaTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LTBlog {

	private WebDriver driver;
	private String urlSUT="https://www.lambdatest.com/blog/";

	public LTBlog(WebDriver driver)
	{

		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(className="search-field")
	WebElement search;
	
	@FindBy(css="[id='normal-slidedown']")
	WebElement topSlider;

			
	@FindBy(css="[href='https://community.lambdatest.com/']")
	WebElement community;
	
	public boolean LoadPage()
	{
		driver.get(urlSUT);
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(search));
		
		return search.isDisplayed();
		
	}
	
	public WebElement WebElement_TopSlider()
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(topSlider));
		
		return topSlider;
	}
	
	public WebElement WebElement_Community()
	{
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(topSlider));
		
		topSlider.findElement(By.id("onesignal-slidedown-cancel-button")).click();
		
		return community;
	}
}
