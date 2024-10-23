package TestComponents;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.Map;

import PageObjects.P1Loginclass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {

	public WebDriver driver;
	public P1Loginclass l1;

	public WebDriver InitialiseDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser")
				: prop.getProperty("browser");
		// above mentioned is called ternary operator , we can give a question and
		// answers in a single line ..frst line means it will run from the browser we
		// give in the cmd . in cmd give -Dbrowser=chrome

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--ignore-certificate-errors");
			//options.addArguments("--ignore-ssl-errors");
			options.addArguments("--disable-web-security", "--allow-running-insecure-content");
			options.addArguments("--remote-allow-origins=*");
			// options.addArguments("--headless");
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// code for firefox
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
	}

	@BeforeSuite

	public P1Loginclass launchApp() throws IOException {
		driver = InitialiseDriver();
	    l1 = new P1Loginclass(driver, TestNGResults, Executedby);
		l1.URL();
		return l1;
	}
/*
	@AfterMethod
	public void Quit() {
		driver.quit();
	}*/

	public String getScreenshott(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	public static HSSFWorkbook workbook;// Declare An Excel Work Book
	public static HSSFSheet sheet;// Declare An Excel Work Sheet
	public static Map<String, Object[]> TestNGResults;// Declare A Map Object To Hold TestNG Results
	public  String path;
	public  String Executedby;
	
	@BeforeMethod
	@Parameters({"reportpath","executedBy"})
	public void getconfigg(String reportpath,String executedBy) throws Exception {
	  path = reportpath;
	  Executedby = executedBy;
	}
	 @BeforeMethod(alwaysRun = true)
		public static void suiteSetUp()
	 {
			workbook = new HSSFWorkbook();
			sheet = workbook.createSheet("TestNG Result Summary");
			TestNGResults = new LinkedHashMap<String, Object[]>();
			TestNGResults.put("1", new Object[] { "ActionID", "Module", "Action", "Status", "QAReleaseNumber", "TestedDate", "Testing Mode","Executed By" });
	  }
	 
	 @AfterMethod// write excel file and file name is SaveTestNGResultToExcel.xls
		public void suiteTearDown() {
		
				Set<String> keyset = TestNGResults.keySet();
				int rownum = 0;
				for (String key : keyset) {
					Row row = sheet.createRow(rownum++);
					Object[] objArr = TestNGResults.get(key);
					int cellnum = 0;
					for (Object obj : objArr) {
						Cell cell = row.createCell(cellnum++);
						if (obj instanceof Date)
							cell.setCellValue((Date) obj);
						else if (obj instanceof Boolean)
							cell.setCellValue((Boolean) obj);
						else if (obj instanceof String)
							cell.setCellValue((String) obj);
						else if (obj instanceof Double)
							cell.setCellValue((Double) obj);
					}
				}
				try {
					 String folder = System.getProperty("user.dir") + path; 
					FileOutputStream out = new FileOutputStream(new File(folder));
					workbook.write(out);
					out.close();
		 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
}