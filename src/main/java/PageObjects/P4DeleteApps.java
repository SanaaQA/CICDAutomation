package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstrtactClass;

public class P4DeleteApps extends AbstrtactClass {
	WebDriver driver;

	public  P4DeleteApps(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="searchTop")
	WebElement search;
	
	@FindBy(xpath="(//a[@name='editls'])[2]")
	WebElement settingsicon;
	
	@FindBy(xpath="//a[@aria-controls='lsmanage']")
	WebElement ManageTab;
	
	@FindBy(xpath="(//button[text()='Delete'])[1]")
	WebElement DeleteIcon;
	
	@FindBy(xpath="(//button[text()='Delete'])[2]")
	WebElement Deltebtn;
	
	@FindBy(xpath="//input[@placeholder='Type here']")
	WebElement cnfrmfield;
	public void DeleteApp() throws InterruptedException {
		search.sendKeys("MyAutomation");
		waitforElementtobeClickable(settingsicon);
		Thread.sleep(1000);
		settingsicon.click();
		waitforElementtobeVisiblee(ManageTab);
		waitforElementtobeClickable(ManageTab);
		ManageTab.click();
		Thread.sleep(3000);
		waitforElementtobevisible(DeleteIcon);
		waitforElementtobeClickable(DeleteIcon);
		DeleteIcon.click();
		cnfrmfield.sendKeys("CONFIRM");
		Deltebtn.click();
		
		
	}

}
