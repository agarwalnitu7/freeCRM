package datadriventest;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;


public class DataDrivenTest_1 {
	
	public WebDriver driver;
	
@BeforeMethod
public void setup()
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\na00450192\\Downloads\\chromedriver.exe");	
	driver = new ChromeDriver(); 
	driver.get("https://www.freecrm.com/");
	driver.findElement(By.id("username")).sendKeys("naveenk");
	driver.findElement(By.id("password")).sendKeys("test@123");
	driver.findElement(By.id("login")).click();
}

@DataProvider
public Iterator<Object[]> gettestData()
{
	ArrayList<Object[]> arraylist=TestUtil.getdata();
	return arraylist.iterator();
	
}
@Test(dataProvider="gettestData")
public void test1(String title1, String FirstName, String Lastname)
{
	Actions action =new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[4]/a"))).build().perform();
	driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/ul/li[3]/a")).click();
	Select title=new Select(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/select")));
	title.selectByValue(title1);
	driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[2]/td[1]/table/tbody/tr[2]/td[2]/input")).sendKeys(FirstName);;
	driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[2]/td[1]/table/tbody/tr[4]/td[2]/input")).sendKeys(Lastname);;
	
	
}
@AfterMethod
public void teardown()
{
	
}
	

}
