package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class DashboardPage 
{
	@FindBy(xpath = "//h6")
	private WebElement dashboard;
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyDashboardPageIsDisplayed(WebDriverWait wait)
	{
		try
		{
			wait.until(ExpectedConditions.visibilityOf(dashboard));
			Reporter.log("Home Page is displayed",true);
			return true;
		}
		catch(Exception e)
		{
			Reporter.log("Home Page is NOT displayed",true);
			return false;
		}
		
	}

}
