package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import AbstractComponents.AbstrtactClass;

public class P2GotoStudio extends AbstrtactClass {
	WebDriver driver;

	public P2GotoStudio(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "staticIid")
	WebElement CreateApp;

	@FindBy(css = ".blockUI.blockOverlay")
	WebElement loader;

	@FindBy(css = ".section1")
	WebElement ele;

	By locator = By.xpath("//input[@name='appName']");
	String Name = "MyAutomationApp";
	
	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement cntnue;

	@FindBy(xpath = "//span[contains(text(),'Use our Guided Tour')]")
	WebElement GuidedTour;

	@FindBy(xpath = "//button[contains(text(),'Open app in Studio')]")
	WebElement OpninStudio;

	@FindBy(xpath = "//input[contains(@placeholder,'Eg : My first dashboard')]")
	WebElement DbName;

	@FindBy(id = "createappBeginner")
	WebElement Save;

	@FindBy(css = "a[title*='create Spreadsheet']")
	WebElement CreateSS;

	public void AppCreation() throws InterruptedException {
		waitforElementtobeVisiblee(CreateApp);
		waitforElementtobeClickable(CreateApp);

		CreateApp.click();
		waitforElementtoDisAppear(loader);

		waitforElementtobeVisiblee(ele);
		waitforElementtoDisAppear(loader);
		waitforElementtobeVisiblee(ele);

		waitforElementtobeClickable(ele);

		ele.click();
		RandomText(locator, Name);
		waitforElementtobeVisiblee(cntnue);

		waitforElementtobeClickable(cntnue);
		cntnue.click();
		System.out.println("App Creation Succesful");

	}

	public void OpenInStudio() {
		waitforElementtobeVisiblee(OpninStudio);
		waitforElementtobeClickable(OpninStudio);
		OpninStudio.click();
		waitforElementtobeVisiblee(GuidedTour);

		waitforElementtobeClickable(GuidedTour);
		GuidedTour.click();
		DbName.sendKeys("MyDashboard");
		Save.click();
		System.out.println("Dashboard Creation Successful");
		waitforElementtobeClickable(CreateSS);
		CreateSS.click();
	}
}