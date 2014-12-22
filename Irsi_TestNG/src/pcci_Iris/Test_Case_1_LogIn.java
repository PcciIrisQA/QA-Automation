package pcci_Iris;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;



public class Test_Case_1_LogIn
{
	
	
	//Test Case - Login - Start
  @Test
  public void tescase1_LogIn()throws BiffException, IOException,
	WriteException {
	  
		Workbook workbook = Workbook.getWorkbook(new File(
				"./TestData/testdata.xls"));
		Sheet sheet = workbook.getSheet(0);
		Cell cell1 = sheet.getCell(0, 2);
		String username1 = cell1.getContents();
		// System.out.println(username);
		Cell cell2 = sheet.getCell(1, 2);
		String password1 = cell2.getContents();
		// System.out.println(cell2.getContents());
		Cell cell0 = sheet.getCell(0, 1);
		String baseurl = cell0.getContents();
		System.out.println("URL:"+baseurl);
		workbook.close();
	 
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username1);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password1);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("buttonLogin")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("pinViaEmail")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("cancelBrowserCommunicateModal")));
		driver.findElement(
				By.cssSelector("button[onclick^=submitCommunicationMethod]"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("inputPin")));

		driver.findElement(By.id("inputPin")).clear();
		driver.findElement(By.id("inputPin")).sendKeys(pin());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("browserAuthenticatePassword")));
		driver.findElement(By.id("browserAuthenticatePassword")).clear();
		driver.findElement(By.id("browserAuthenticatePassword")).sendKeys(
				password1);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("privateOption")));
		driver.findElement(By.id("privateOption")).click();

		driver.findElement(By.cssSelector("button[onclick^=submitPin]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("loggedInUsername")));
	//	String user = driver.findElement(By.id("loggedInUsername")).getText();
	//	System.out.println("TC2: Login Successful - PASS. User:" + user);
		driver.quit();
  }
  public static String pin()throws BiffException, IOException,
	WriteException{
	  
		Workbook workbook = Workbook.getWorkbook(new File(
				"./TestData/testdata.xls"));
		Sheet sheet = workbook.getSheet(0);
		Cell cell3 = sheet.getCell(0, 3);
		String username2 = cell3.getContents();
		// System.out.println(username2);
		Cell cell4 = sheet.getCell(1, 3);
		String password2 = cell4.getContents();
		// System.out.println(password2);
		workbook.close();

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://mail.phhs.org/owa/auth/logon.aspx?replaceCurrent=1&url=https%3a%2f%2fmail.phhs.org%2fowa%2f");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username2);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password2);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".btn")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.className("bdyItmPrt")));
		String text = driver.findElement(By.className("bdyItmPrt")).getText();
		// System.out.println(text);
		String output = CharMatcher.is('-').or(CharMatcher.DIGIT)
				.retainFrom(text);
		System.out.println("Pin E-mailed - PASS. Pin:" + output);
		driver.quit();
		return output;
		
		
		
	  
  } //Test Case - Login - End
  
 




}
