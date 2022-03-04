package WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class facebooklogin {

	WebDriver driver;
	public facebooklogin(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	@FindBy(how = How.ID, using = "login_field") WebElement name_box;
	@FindBy(how = How.ID, using = "password") WebElement pass_box;
	@FindBy(how = How.NAME, using = "commit") WebElement btn_box;
	
	
	
	public void sendemail(String send_mail)
	{
		
		name_box.sendKeys(send_mail);
		
	}
	public void sendpass(String send_pass)
	{
		
		pass_box.sendKeys(send_pass);
		
	}
	public void pressbtn()
	{
		
		btn_box.click();
	}
}

