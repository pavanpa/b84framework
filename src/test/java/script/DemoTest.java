package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;

public class DemoTest extends BaseTest
{
	
	@Test
	public void testA()
	{
		Reporter.log(driver.getTitle(),true);
		
		int rc=Excel.getRowCount("./src/test/resources/data/actiTIME.xlsx","login");
		Reporter.log("RC:"+rc,true);
		
		int cc=Excel.getColumnCount("./src/test/resources/data/actiTIME.xlsx", "login",0);
		Reporter.log("CC:"+cc,true);
		
		String v=Excel.getCellValue("./src/test/resources/data/actiTIME.xlsx", "login",0,0);
		Reporter.log("value"+v,true);
		
		Excel.setCellValue("./src/test/resources/data/actiTIME.xlsx", "login",0,0,"Bhanu");
	}

}
