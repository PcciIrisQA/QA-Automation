package pcci_Iris;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.google.common.base.CharMatcher;

public class Test_Case_2_LogOut {
	

  @Test
  public void tescase1_LogOut() {
	  
		
	  System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://199.36.142.164/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("vijaym");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Dallas@1");
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
				"Dallas@1");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("privateOption")));
		driver.findElement(By.id("privateOption")).click();

		driver.findElement(By.cssSelector("button[onclick^=submitPin]"))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("loggedInUsername")));
	//	String user = driver.findElement(By.id("loggedInUsername")).getText();
	//	System.out.println("TC2: Login Successful - PASS. User:" + user);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("dropdownMenu1")));
		// String username = driver.findElement(By.cssSelector(".username"))
		// .getText();
		// System.out.println("\nLogin successful. User Name:"
		// + username);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("dropdownMenu1")));
		driver.findElement(By.id("dropdownMenu1")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[text()='Logout']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id("buttonLogin")));
	
		driver.quit();
		
}
public static String pin(){

		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("https://mail.phhs.org/owa/auth/logon.aspx?replaceCurrent=1&url=https%3a%2f%2fmail.phhs.org%2fowa%2f");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("p45956");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Aarian!1");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".btn")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.className("bdyItmPrt")));
		String text = driver.findElement(By.className("bdyItmPrt")).getText();
		// System.out.println(text);
		String output = CharMatcher.is('-').or(CharMatcher.DIGIT)
				.retainFrom(text);
		//System.out.println("Pin E-mailed - PASS. Pin:" + output);
		driver.quit();
		return output;
	  
} //Test Case - Login - End



}
