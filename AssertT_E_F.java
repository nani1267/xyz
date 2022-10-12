package WebDriveScript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.*;

public class AssertT_E_F {
	
	WebDriver d;
	@Test
	public void testLogin() throws Exception
	{
		// Load web page
		d.get("https://retail.onlinesbi.sbi/retail/login.htm");
		// Verify page title
		assertEquals(d.getTitle(),"State Bank of India - Personal Banking");
		// Print page title
		System.out.println(d.getTitle());
		// Click on CONTINUE TO LOGIN
		d.findElement(By.linkText("CONTINUE TO LOGIN")).click();
		assertTrue(d.findElement(By.id("capOption")).isSelected());
		assertEquals(d.findElement(By.xpath("//label[@for='username']")).getText(),"Username*");
		assertFalse(d.findElement(By.id("chkbox")).isSelected());
		// Enter user name
		assertTrue(d.findElement(By.id("username")).isDisplayed());
		d.findElement(By.id("username")).sendKeys("selenium");
		// Enter password
		d.findElement(By.id("label2")).sendKeys("selenium");
		// Click on Login button
		d.findElement(By.id("Button2")).click();
		// Assert.fail("Alert is not handled");
		
		// 3sec
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
