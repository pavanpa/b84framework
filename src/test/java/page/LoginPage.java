package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage 
{
	@FindBy(name="username")
	private WebElement unTB;
	
	@FindBy(name="password")
	private WebElement pwTB;
	
	@FindBy(css="button[type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[1]")
	private WebElement errMsg;
	
	@FindBy(xpath = "(//li)[13]")
	private WebElement userMenue;
	
	@FindBy(xpath = "//a[contains(text(),\"Logout\")]")
	private WebElement logoutButton;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		pwTB.sendKeys(pw);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void clickUserMenueDropDown()
	{
		userMenue.click();
	}
	
	public void clickLogoutButton()
	{
		logoutButton.click();
	}

	public boolean verifyErrMsgDisplayed(WebDriverWait wait) 
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("Err Msg is displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("Err Msg is NOT displayed",true);
			return false;
		}
	}
	
	public boolean verifyLoginPageDisplayed(WebDriverWait wait)
	{
		try 
		{
			wait.until(ExpectedConditions.visibilityOf(loginButton));
			Reporter.log("Login Page is displayed",true);
			return true;
		}
		catch (Exception e) 
		{
			Reporter.log("Login Page is NOT displayed",true);
			return false;
		}
	}



	
	
}
