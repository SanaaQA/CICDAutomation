package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstrtactClass;

public class P3CreateComponents extends AbstrtactClass {

	WebDriver driver;

	public P3CreateComponents(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".refreshSSData")
	WebElement refresh;

	@FindBy(id = "name-")
	WebElement SSName;

	String ssName = "SS1";
	String resultdata = "hot3Conf[''].SPdata = hot3[\"\"].getData();";

	By nxtBtn = By.cssSelector("button[data-role='next']");

	@FindBy(id = "savebtn")
	WebElement Save;

	@FindBy(css = "body div div div div button[type='button']")
	WebElement close;

	@FindBy(css = "a[title='Click to create Form']")
	WebElement createForm;

	@FindBy(id = "frm_title")
	WebElement FormName;

	@FindBy(xpath = "(//i[@title='Move'])[1]")
	WebElement plusicon1;

	@FindBy(name = "Save")
	WebElement saveform;

	@FindBy(css = ".active-indication")
	WebElement formactive;

	public void CreateSS() throws InterruptedException {
		SSName.sendKeys(ssName);
		for (int i = 0; i < 4; i++) {
			waitforElementtobePresent(nxtBtn);
			driver.findElement(nxtBtn).click();
			i++;
			Thread.sleep(1000);
		}
		jsExecuteScript(SSData);
		jsExecuteScript(resultdata);
		System.out.println("SS records entered");
		refresh.click();
		Save.click();

		close.click();
	}

	public void CreateForm() throws InterruptedException {

		waitforElementtobeVisiblee(formactive);
		waitforElementtobeClickable(createForm);
		waitforElementtobeVisiblee(createForm);
		waitforElementtobeClickable(createForm);
		createForm.click();
		FormName.sendKeys("NewFormTest");
		for (int i = 0; i < 4; i++) {
			waitforElementtobePresent(nxtBtn);
			driver.findElement(nxtBtn).click();
			i++;
			Thread.sleep(1000);
		}

		plusicon1.click();
		Thread.sleep(2000);
		waitforElementtobeClickable(saveform);

		saveform.click();
		System.out.println("Form Creation successfull");
		close.click();

	}

	String SSData = "hot3[\"\"].loadData([\n"
			+ "   [\"a566da6dddad6767sa1\", \"id\", \"name\",\"marks\", \"email\", \"date\",\"html\", \"formula\", \"dropdown value\",\"date_time\",\"onchange\",\"file\",\"status\"],\n"
			+ "  [\"a566da6dddad6767sa2\", \"1\", \"Kiran\",\"76\", \"kiranabcd123abcdef smhefkj  kjsdfh skdjnfvdf dsjfhj ajfh @vizru.com\", \"24/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"20\"],\n"
			+ "  [\"a566da6dddad6767sa3\", \"2\", \"Rahul\",\"66\", \"rahulabcd123@vizru.com.com\", \"24/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"30\"],\n"
			+ "  [\"a566da6dddad6767sa4\", \"3\", \"Jithin\",\"43\", \"jithin@vizru.com\", \"24/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"40\"],\n"
			+ "  [\"a566da6dddad6767sa5\", \"4\", \"Ratheesh\",\"87\", \"ratheesh@vizru.com\", \"24/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"50\"],\n"
			+ "  [\"a566da6dddad6767sa6\", \"5\", \"Vizru\", \"23\", \"test@vizru.com\", \"24/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"60\"],\n"
			+ "  [\"a566da6dddad6767sa7\", \"6\", \"Ramesh\", \"76\", \"ramesh@vizru.com\", \"24/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"70\"],\n"
			+ "  [\"a566da6dddad6767sa8\", \"7\", \"Luke\",  \"67\", \"luke@vizru.com\", \"21/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"80\"],\n"
			+ "   [\"a566da6dddad6767sa9\",\"8\", \"Geon\",  \"32\", \"justin@vizru.com\", \"19/12/2018\",\"\",\"\",\"\",\"\",\"\",\"\",\"90\"],\n"
			+ "])";

}
