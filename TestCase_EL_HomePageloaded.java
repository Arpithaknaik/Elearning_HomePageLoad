package SmokeTest_TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SmokeTestPage.elogin;

public class TestCase_EL_HomePageloaded {
	
	//WebDriver driver;
	static String driverPath = "D:\\chromedriver_win32\\chromedriver.exe";
    static WebDriver driver;	
	
@AfterTest
public void closeAll()
{
	driver.close();
}
    
    
    @BeforeTest
    public void init()
    {
    	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		driver.manage().window().maximize();
		
	
		
    }
    @Test(priority=0)
	public void checkPageLoaded()
	{
    	elogin login=new elogin(driver);
		
    	boolean isfound=login.isFooterFound();
		if (isfound==true)
		{
			System.out.println("Footer Found");
			
		}
		 
		else
		{
			System.out.println("Cannot find the footer");
		}
	}
    
    
   @Test(priority=2)
    public void chkFooter_method() {
		// TODO Auto-generated method stub
		
		
		// creating object of LoginPage class
    	elogin login=new elogin(driver);
					
			String actualfooter = login.getFooterString();
			System.out.println("Found Footer "+actualfooter);
			
			boolean status = false;
			if(actualfooter.equals("Not found"))
			{
				status = false;
			}
			else
			{
				if(actualfooter.contains("Administrator"))
				{
					status= true;
				}
				else
				{
					status=false;
				}
			}
		Assert.assertEquals(status, true);
		
		
	
			
	}
    
    
			

}
