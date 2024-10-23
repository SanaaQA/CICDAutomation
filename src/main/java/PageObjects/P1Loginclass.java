package PageObjects;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstrtactClass;

public class P1Loginclass extends AbstrtactClass {
	WebDriver driver;
	private Map<String, Object[]> testNGResults;
	private String executedBy;


	
	public P1Loginclass(WebDriver driver, java.util.Map<String, Object[]> testNGResults, String executedBy) {
	    super(driver);
	    this.driver = driver;
	    this.testNGResults = testNGResults;
	    this.executedBy = executedBy;
	    PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="_fm[email]")
	WebElement username;
	
	@FindBy(name="_fm[pass]")
	WebElement passwordd;
	
	@FindBy(name="_fm[__s]")
	WebElement submit;
	
	public void URL(){
		driver.get("https://apr27release.vizru.com/");
	}
public void signin() {
	username.sendKeys("sana@vizru.com");
	passwordd.sendKeys("Sana@1234");
	submit.click();
    testNGResults.put("2", new Object[]{1d, "Login", "Login", "Passed", "", Dates(), "Selenium", executedBy});

}


}
