package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.DashboardPage;
import page.LoginPage;

public class ValidLogin extends BaseTest
{
	@Test(priority = 1,groups= {"smoke","regression"})
	public void testValidLogin() 
	{
//		1. enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName("Admin");
//		2. enter valid pw
		loginPage.setPassword("admin123");
//		3. click login button
		loginPage.clickLoginButton();
//		4. home page should be displayed
		DashboardPage dashBoardPage=new DashboardPage(driver);
		
		boolean result = dashBoardPage.verifyDashboardPageIsDisplayed(wait);
		
		Assert.assertTrue(result);
		

	}
}
