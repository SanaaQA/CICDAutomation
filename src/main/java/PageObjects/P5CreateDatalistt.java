package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstrtactClass;

public class P5CreateDatalistt extends AbstrtactClass {
	WebDriver driver;

	public P5CreateDatalistt(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	String value = "NewFormTest";
	@FindBy(id = "form-id")
	WebElement form;

	@FindBy(xpath = "(//i[@title='Move'])[1]")
	WebElement plusicon1;

	@FindBy(xpath = "(//i[@title='Move'])[2]")
	WebElement plusicon2;

	@FindBy(xpath = "(//i[@title='Move'])[3]")
	WebElement plusicon3;

	@FindBy(xpath = "(//i[@title='Move'])[4]")
	WebElement plusicon4;

	@FindBy(xpath = "(//i[@title='Move'])[5]")
	WebElement plusicon5;

	@FindBy(xpath = "(//i[@title='Move'])[6]")
	WebElement plusicon6;

	@FindBy(xpath = "(//i[@title='Move'])[7]")
	WebElement plusicon7;

	@FindBy(xpath = "(//i[@title='Move'])[8]")
	WebElement plusicon8;

	@FindBy(xpath = "(//i[@title='Move'])[9]")
	WebElement plusicon9;

	@FindBy(xpath = "(//i[@title='Move'])[10]")
	WebElement plusicon10;

	@FindBy(xpath = "(//a[@title='Click to create Datalist'])[1]")
	WebElement CreateDD;

	@FindBy(xpath = "(//input[@placeholder='Add title'])[1]")
	WebElement ColumnTitle1;

	@FindBy(xpath = "(//input[@placeholder='Add title'])[2]")
	WebElement ColumnTitle2;

	@FindBy(xpath = "(//input[@placeholder='Add title'])[3]")
	WebElement ColumnTitle3;

	@FindBy(xpath = "(//input[@placeholder='Add title'])[4]")
	WebElement ColumnTitle4;

	@FindBy(xpath = "(//input[@placeholder='Add title'])[5]")
	WebElement ColumnTitle5;

	@FindBy(css = "div[data-item='1']")
	WebElement Column2;

	@FindBy(css = "div[data-item='2']")
	WebElement Column3;

	@FindBy(css = "div[data-item='3']")
	WebElement Column4;

	@FindBy(css = "div[data-item='5']")
	WebElement Column5;

	@FindBy(id = "title")
	WebElement DatalistTitle;

	@FindBy(id = "addColumnWrapper")
	WebElement addcolumn;

	@FindBy(xpath = "//div[@id='c-field']//span[@class='icon-chevron fro ']")
	WebElement cstmarrow;
	@FindBy(id = "cf-id")
	WebElement CustomField;

	@FindBy(id = "cf-id")
	WebElement Fieldvalue;

	@FindBy(name = "cf-alias")
	WebElement fieldalias;

	@FindBy(css = ".alert-success")
	WebElement savedmsg;

	By Column51 = By.cssSelector("div[data-item='5']");
	By savedmsg1 = By.cssSelector(".alert-success");
	By nxtBtn = By.cssSelector("button[data-role='next']");

	@FindBy(xpath = "//div[@class='flex justify-between']//a[@class='btn btn-info btn-small add-cf-bt fro mt10']")
	WebElement add;
	
	@FindBy(name="Save")
	WebElement Save;

	public void CreateDataList() throws InterruptedException {

		Thread.sleep(1000);
		CreateDD.click();
		for (int i = 0; i < 4; i++) {
			waitforElementtobePresent(nxtBtn);
			driver.findElement(nxtBtn).click();
			i++;
			Thread.sleep(1000);
		}

		plusicon1.click();
		plusicon2.click();
		Thread.sleep(1000);
		ColumnTitle1.sendKeys("General");
		System.out.println("First Column Added");
		DatalistTitle.sendKeys("NewDl");
		Column2.click();
		plusicon3.click();
		plusicon4.click();
		Thread.sleep(1000);
		ColumnTitle2.sendKeys("Academics");
		System.out.println("Second Column Added");
		Column3.click();
		plusicon5.click();
		plusicon6.click();
		ColumnTitle3.sendKeys("Personal");
		System.out.println("Third Column Added");
		Column4.click();
		plusicon7.click();
		plusicon8.click();
		ColumnTitle4.sendKeys("Work");
		System.out.println("Forth Column Added");
		addcolumn.click();
		waitforElementtobePresent(Column51);
		Column5.click();
		ColumnTitle5.sendKeys("Additional");
		plusicon7.click();
		plusicon8.click();
		System.out.println("Fifth Column Added");
		Dropdown(form, value);
		System.out.println("Form Selected");

		waitforElementtobeVisiblee(cstmarrow);
		waitforElementtobeClickable(cstmarrow);
		cstmarrow.click();
		driver.findElement(nxtBtn).click();
		waitforElementtobeClickable(CustomField);
		CustomField.sendKeys("sum(marks)");
		Thread.sleep(1000);
fieldalias.sendKeys("sum of marks");
		add.click();
		System.out.println("Custom field Added");

		Save.click();
		System.out.println("SavedDatalistt");

		
		

	}

}
