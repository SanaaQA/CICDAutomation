package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstrtactClass;

public class P7GoToDashboard extends AbstrtactClass {

		WebDriver driver;

		public P7GoToDashboard(WebDriver driver) {
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
			@FindBy(css="a[title*='Click to view Dashboard']")
			WebElement goToDashboard;
			
			@FindBy(css="a[title='Files']")
			WebElement files;
			
			@FindBy(css=".fa.fa-plus-circle")
			WebElement plusIcon;
			
			@FindBy(xpath="//div[contains(@class,'upload_container')]//input[@type='file']")
			WebElement UploadIcon;
			
			 String File1="Files/sample.jpeg";
		
		public void Dashboard() {
		String parentWindow = switchToNextWindow();
		goToDashboard.click();
		waitforElementtoDisAppear(loader1);
		files.click();
		
}
		
		public void FileUpload() {
			mouseHover(plusIcon);
			//waitforElementtobeClickable(UploadIcon);
			fileUpload(UploadIcon,File1);
			
			
		}
}