package Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import WebPages.facebooklogin;

public class LoginTestcase extends Fbbaseclass {

	@Test(dataProvider = "fbdata")
	public  void init(String mail, String passwoed) throws InterruptedException
	{
		
		
		facebooklogin loginpage = PageFactory.initElements(driver, facebooklogin.class);
		loginpage.sendemail(mail);
		Thread.sleep(5000);
		loginpage.sendpass(passwoed);
		Thread.sleep(5000);
		loginpage.pressbtn();
		
	}
	
	@DataProvider
	public Object[][] fbdata()
	{												
		Exceldata config = new Exceldata("C:\\Newxlfiles\\GithubLogin.xlsx");
		int row = config.getrowcount(0);
		Object[][] data = new Object[row][2];
		
		for(int i=0;i<row;i++)
		{
			data[i][0]=config.getdata(0, i, 0);
			data[i][1]=config.getdata(0, i, 1);
			
			
		}
		return data;
		
	}
}
