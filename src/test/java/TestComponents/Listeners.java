package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners extends Basetest implements ITestListener
{

	WebDriver driver;
	ExtentTest test;
	ExtentReports extend = ExtendReports.getReport();
	ThreadLocal<ExtentTest> extendtest = new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		test = extend.createTest(result.getMethod().getMethodName());
		extendtest.set(test);		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test failed"); // or
		extendtest.get().fail(result.getThrowable());
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {

			e1.printStackTrace();
		}
		String filepath = null;		
		try {
			filepath = getScreenshott(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extendtest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}
			
		public void onFinish(ITestContext context) {
			extend.flush();
			
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		
	}	public void onStart(ITestContext context) {
	}

}
