package LambdaTest.LambdaTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LTAllIntergrations {
	WebDriver driver;
	public LTAllIntergrations(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="#codeless_row")
	private WebElement codelessDiv;
	
	@FindBy(css="[class*='active']")
	private WebElement codeless;

	@FindBy(css="[href='https://www.lambdatest.com/support/docs/testingwhiz-integration/']")
	private WebElement learnMore;
	
	
	public WebElement WebElement_CodelessDIV()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(codelessDiv));
		
		return codelessDiv;
	}
	
	public WebElement WebElement_Codeless()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(codeless));
		return codeless;
	}

	public WebElement WebElement_LearnMore()
	{
		return learnMore;
	}
}
