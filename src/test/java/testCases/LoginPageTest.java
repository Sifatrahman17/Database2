package testCases;

import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpageObj1;

	 @BeforeMethod
	 public void setUp() {
	  initializeDriver();
	  loginpageObj1= PageFactory.initElements(driver, LoginPage.class);
	 }
	
	 @Test
	 public void LoginTest() throws InterruptedException {
		 loginpageObj1.enterUserName("demo@techfios.com"); 
		 loginpageObj1.enterPassword("abc123");
		 loginpageObj1.clickSignInButton();
		 Thread.sleep(2000);
	 }
	 @Test(priority=2)
	 public void loginpageTitleTest() throws ClassNotFoundException, SQLException, InterruptedException {  
		 loginpageObj1.enterUserName("demo@techfios.com");  
	  Thread.sleep(2000);  
	  loginpageObj1.enterPassword("abc123");
	  Thread.sleep(2000);  
	  loginpageObj1.clickSignInButton();  
	  String expectedTitle="Dashboard- iBilling";
	  String actualTitle=loginpageObj1.getPageTitle();
	  Assert.assertEquals(expectedTitle, actualTitle); 
	 }

	 @AfterMethod
	 public void tearDown() {  
	  driver.close();
	  driver.quit();
	 }
}
