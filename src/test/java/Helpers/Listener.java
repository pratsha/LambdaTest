package Helpers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	WebDriver driver;
	Date date;
	SimpleDateFormat formatter;
	private Logger log;
	public Listener()
	{
		date=new Date();
		formatter=new SimpleDateFormat("mmddyyyyHHMMSSSs");
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		log=LogManager.getLogger(result.getTestClass().getRealClass().getSimpleName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		log.info("Success Test Method: "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		File src=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		try {
			
			FileUtils.copyFile(src,new File(System.getProperty("user.dir")+"test-output\\FailureScreenshots\\"+result.getName()+"_"+formatter.format(date)+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.error("Failed Test Method: ", result.getName().toString());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		log.info("Test Skipped: "+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		log.error("Failure with Time out Test Method: "+result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
