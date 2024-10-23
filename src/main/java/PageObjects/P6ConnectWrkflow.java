package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstrtactClass;

public class P6ConnectWrkflow extends AbstrtactClass {

	WebDriver driver;

	public P6ConnectWrkflow(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "a[title='Click to create Workflow']")
	WebElement CreateWorkflow;

	@FindBy(xpath = "(//span[contains(text(),'Search Workflow')])[2]")
	WebElement WfdropDown;
	@FindBy(xpath = "//input[@type='search'][@autocapitalize='off']")
	WebElement search;

	String WorkflowName = "WorkflowwTestTrigger";

	@FindBy(id = "//li[@role='treeitem']")
	WebElement Searchresult;

	@FindBy(xpath = "//input[@value='Update']")
	WebElement Update;

	@FindBy(css = "body div div div div button[type='button']")
	WebElement close;

	@FindBy(xpath = "//a[@title='Click to integrate Services']")
	WebElement EditWorkflow;

	@FindBy(css = "a[title='Open workflow debugger']")
	WebElement Test;

	String keydata = "action";
	String valuedata = "Success";

	@FindBy(name = "key[]")
	WebElement key;

	@FindBy(name = "val[]")
	WebElement value;

	@FindBy(css = ".viz-btn-solid.btn-primary.small.re-execute-confirm")
	WebElement execute;

	@FindBy(xpath = "//span[@data-dismiss='modal']")
	WebElement wflog;

	By workflowlog = By.xpath("//span[@data-dismiss='modal']");
	By Testt = By.cssSelector("a[title='Open workflow debugger']");

	@FindBy(css = "div[id='wBugaccordion'] li:nth-child(1)")
	WebElement Output;

	public void CreateWorkflw() throws InterruptedException {
		waitforElementtobeVisiblee(CreateWorkflow);
		waitforElementtobeClickable(CreateWorkflow);
		Thread.sleep(2000);
		CreateWorkflow.click();
		waitforElementtobeVisiblee(WfdropDown);
		waitforElementtobeClickable(WfdropDown);
		WfdropDown.click();
		search.sendKeys(WorkflowName);
		search.sendKeys(Keys.ENTER);
		Update.click();
		Thread.sleep(3000);
		close.click();

	}

	public void EditWorkflow() throws InterruptedException {
		EditWorkflow.click();
		String nextWindowHandle = switchToNextWindow();
		waitforElementtoDisAppear(loader1);
		Thread.sleep(3000);
		waitforElementtobePresent(Testt);
		waitforElementtobeClickable(Test);
		Test.click();
		waitforElementtobeClickable(key);
		key.sendKeys(keydata);
		value.sendKeys(valuedata);
		execute.click();
		waitforElementtobePresent(workflowlog);
		waitforElementtobeClickable(wflog);
		wflog.click();
		Output.getText();
		if (Output.getText().equalsIgnoreCase("\"action\": \"Success\"")) {
			System.out.println("Workflow Execution Success");
		} else {
			System.out.println("Something wrong with workflow execution");
		}
	}
}
