package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class ValidLoginLogout extends BaseTest
{

	@Test(priority = 3,groups= {"smoke","regression"})
	public void testValidLoginLogout()
	{
		String un=Excel.getCellValue(xl_path, "ValidLogin", 1, 0);
		String pw=Excel.getCellValue(xl_path, "ValidLogin", 1, 1);
//		1. enter valid un
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
//		2. enter valid pw
		loginPage.setPassword(pw);
//		3. click login button
		loginPage.clickLoginButton();
//		4.click UserMenue DropDown
		loginPage.clickUserMenueDropDown();
//		5. click logout link
		loginPage.clickLogoutButton();
//		5. verify that login page is displayed
		boolean result = loginPage.verifyLoginPageDisplayed(wait);
		Assert.assertTrue(result);
	}
	
	
}
