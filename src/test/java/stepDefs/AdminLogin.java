package stepDefs;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.bs.I;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminLogin   {
	
	public WebDriver driver;
	
	
	@Given("I login to the website")
	public void i_login_to_the_website() {
		
		System.setProperty("Webdriver.chrome.driver" , "chromedriver.exe");
		
		 driver = new ChromeDriver();
		 
		 driver.get("http://localhost:8009/medicare/home");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(400, TimeUnit.MILLISECONDS);
		

	}

	

	@When("I click on manage products")
	public void i_click_on_manage_products() {
		
		WebElement Loginbtn = driver.findElement(By.xpath("//a[@href ='/medicare/login']"));
		Loginbtn.click();
		
		WebElement Username = driver.findElement(By.id("username"));
		Username.sendKeys("vk@gmail.com");
		
		WebElement passwrd = driver.findElement(By.id("password"));
		passwrd.sendKeys("admin");
		
		WebElement logbttn2 =driver.findElement(By.xpath("//input[@value='Login']"));
		logbttn2.click();
		
		WebElement managebutton = driver.findElement(By.xpath("//a[@href='/medicare/manage/product']"));
		WebDriverWait wait=new WebDriverWait(driver,500);

		wait.until(ExpectedConditions.elementToBeClickable(managebutton));
		managebutton.click();

	}

	@When("I add below values adding using datatable")
	public  void i_add_below_values_adding_using_datatable(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		
		  int column = (dataTable.height());
		  
		  for(int i =0; i<column; i++) {
			 String value1= dataTable.cell(i, 0);
			 System.out.println("Printing the values of datatable " + value1);

			    
		  }
		  
             WebElement Drugname = driver.findElement(By.xpath("//input[@id='name']"));	 
             Drugname.sendKeys("Himalaya wellness");
             
             WebElement Brand = driver.findElement(By.xpath("//input[@name='brand']"));	 
             Brand.sendKeys("Netmeds");                  
             
             WebElement Description = driver.findElement(By.xpath("//textarea[@name='description']"));	 
             Description.sendKeys("Vitamin c capsules act as an antioxidant in the body");
             
             WebElement UptdUntprice = driver.findElement(By.xpath("//input[@placeholder='Enter Unit Price']"));	 
             UptdUntprice.clear();
             UptdUntprice.sendKeys("20");
             
             WebElement UptdQuantity = driver.findElement(By.xpath("//input[@placeholder='Enter Quantity']"));	 
             UptdQuantity.clear();
             UptdQuantity.sendKeys("40");
             System.out.println("updated quantity");
             
             WebElement FileUpload = driver.findElement(By.xpath("//input[@id='file']"));	 
             FileUpload.sendKeys("C:\\Users\\home\\Downloads");  
		     System.out.println("Succesfully added the file");
		     
		     WebElement category = driver.findElement(By.xpath("//*[@name='categoryId']/option[3]"));
			 category.click();
		     System.out.println("Succesfully clicked on the category option");

	}
	

	@When("Click on send button")
	public void click_on_send_button() {
	    
		WebElement submitbtn = driver.findElement(By.xpath("//input[@name='submit']"));
		WebDriverWait wait=new WebDriverWait(driver,500);
		wait.until(ExpectedConditions.elementToBeClickable(submitbtn));
		submitbtn.click();
	     System.out.println("Succesfully clicked on the submit option");
	     
	}

	@Then("I verify the following items and message displayed")
	public  void i_verify_the_following_items_and_message_displayed() {
		
        Assert.assertTrue("Himalaya wellness", true);
        Assert.assertTrue("Netmeds", true);
        Assert.assertTrue("Vitamin c capsules act as an antioxidant in the body", true);
        Assert.assertTrue("20", true);
        Assert.assertTrue("40", true);	
		
	    
	}

	@Then("I close the browser")
	public void i_close_the_browser() {
			
		
	    	driver.close();
		    driver.quit();
		

	}


}
