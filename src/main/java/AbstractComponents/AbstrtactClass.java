package AbstractComponents;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstrtactClass {
	static WebDriver driver;
	public WebDriverWait wait;

	@SuppressWarnings("static-access")
	public AbstrtactClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".LoaderCardwraper")
	WebElement loader;

	public static WebElement loader1;

	public void YourAbstractClass(WebDriver driver) {
		loader1 = driver.findElement(By.cssSelector(".LoaderCardwraper"));
	}

	@SuppressWarnings("deprecation")
	public void waitforajax() {
		wait = new WebDriverWait(driver, 5);
		waitforajax();
	}

	public void RandomText(By locator, String Name) {
		Random random = new Random();
		int x = random.nextInt(1000);
		driver.findElement(locator).sendKeys(Name + x);
	}

	@SuppressWarnings("deprecation")
	public void waitforElementtobeClickable(WebElement elemnt2) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(elemnt2));
	}

	@SuppressWarnings("deprecation")
	public void waitforElementtobevisible(WebElement elemnt) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) elemnt));
	}

	@SuppressWarnings("deprecation")
	public void waitforElementtobeVisiblee(WebElement ele) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	@SuppressWarnings("deprecation")
	public void waitforelementToBeSelected(WebElement ele) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeSelected(ele));
	}

	@SuppressWarnings("deprecation")
	public void waitforElementtoDisAppear(WebElement ele2) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(ele2));
	}

	@SuppressWarnings("deprecation")
	public void waitforElementtobePresent(By ele2) {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) ele2));
	}

	public void Dropdown(WebElement element, String text) {
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(text);
		;

	}

	public void jsExecuteScript(String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String Scroll = value;
		js.executeScript(Scroll);
	}

	public String switchToNextWindow() {
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				driver.switchTo().window(handle);
				return handle;
			}
		}

		return null; // If no next window found
	}

	public static void fileUpload(WebElement uploadIcon, String text) {
		File file = new File(text);
		uploadIcon.sendKeys(file.getAbsolutePath());
	}

	public void mouseHover(WebElement mousehoverObj) {

		Actions actions = new Actions(driver);

		actions.moveToElement(mousehoverObj).build().perform();

	}

	public void mouseHoverClick(WebElement mousehoverClick) {

		Actions actions = new Actions(driver);

		actions.moveToElement(mousehoverClick).click().build().perform();
	}

	
	public static String Dates() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String date1 = dateFormat.format(date);
		return date1;
	}

	
	
}
