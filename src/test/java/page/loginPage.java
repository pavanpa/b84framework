package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage 
{
	@FindBy(name="username")
	private WebElement unTB;
	
	@FindBy(name="password")
	private WebElement pwTB;
	
	@FindBy(css="button[type='submit']")
	private WebElement loginButton;
	
	public void LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	
	public void setPassword(String pw)
	{
		unTB.sendKeys(pw);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}

}
