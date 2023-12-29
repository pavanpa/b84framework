package generic;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Date;

public class BaseTest {
	public final String d_grid="no";
	public final String d_gridurl="http://localhost:4444";
	public final String d_browser="chrome";
	public final String d_appurl="http://www.google.com";	
	public final String d_ito="10";
	public final String d_eto="10"; 
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"grid","gridurl","browser","appurl","ito","eto"})
	@BeforeMethod
	public void preCondition(
			@Optional(d_grid) String grid,
			@Optional(d_gridurl) String gridurl,
			@Optional(d_browser) String browser,
			@Optional(d_appurl) String appurl,
			@Optional(d_ito) String ito,
			@Optional(d_eto) String eto)throws Exception
	{
		if(grid.equalsIgnoreCase("yes"))
		{
			AbstractDriverOptions browserOptions;
			if(browser.equalsIgnoreCase("chrome"))
			{
				
				browserOptions = new ChromeOptions();
				
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				
				browserOptions = new FirefoxOptions();
			}
			else
			{

				browserOptions = new EdgeOptions();
			}
			URL url=new URL(gridurl);
			driver=new RemoteWebDriver(url, browserOptions);
		}
		else
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else
			{
				driver=new EdgeDriver();
			}
		}
		
		driver.get(appurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ito)));
		wait=new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(eto)));
	}
	
	@AfterMethod
	public void postCondition(ITestResult result) throws Exception
	{
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
		String testName=result.getName();
		int status = result.getStatus();
		if(status==2)
		{
			TakesScreenshot t=(TakesScreenshot)driver;
			File srcFile = t.getScreenshotAs(OutputType.FILE);
			File dstFile=new File("./screenshot/"+testName+"_"+dateFormat.format(date)+".png");//HW add date and time
			FileUtils.copyFile(srcFile, dstFile);
			
		}
		driver.quit();
	}

}
