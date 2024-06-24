package lesson9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	
	WebDriver driver = new ChromeDriver();
	
	String MyURL="https://www.saucedemo.com/inventory.html";
	String UserName="standard_user";
	String Password="secret_sauce";
	
	@BeforeTest
	public void MySetup() {
		driver.get(MyURL);
		driver.manage().window().maximize();
		
	}
	
	@Test (priority=1)
	public void LoginTest() {
		
		WebElement UserNameInput=driver.findElement(By.id("user-name"));
		UserNameInput.sendKeys(UserName);
		WebElement PasswordInput=driver.findElement(By.id("password"));
		PasswordInput.sendKeys(Password);
		
		WebElement LoginButton=driver.findElement(By.id("login-button"));
		LoginButton.click();
		}
	@Test (priority=2 ,enabled=false)
	public void addAllItems() {

		List<WebElement>MyAddToCartButtons=driver.findElements(By.className("btn"));

		System.out.println(MyAddToCartButtons.size());

       for (int i =0 ; i<MyAddToCartButtons.size();i++) {
    	   MyAddToCartButtons.get(i).click();
    	   
       }
       
	}
      // @Test(priority=3)
       public void addOneItemSkipTheNextOne() {
    	   List<WebElement>MyAddToCartButtons=driver.findElements(By.className("btn"));

   		System.out.println(MyAddToCartButtons.size());

          for (int i =0 ; i<MyAddToCartButtons.size();i++) {
        	 
       	   if(i==2) {
       		 //  continue;
       	   }
       	   MyAddToCartButtons.get(i).click(); }

          }
    	   
    	   @Test(priority=4)
    	   public void FindElementThatHasTheTextLab() { 
    		   List<WebElement>ItemsNames=driver.findElements(By.className("inventory_item_name"));
    		   
        	   List<WebElement>MyAddToCartButtons = driver.findElements(By.className("btn"));


    	          for (int i =0 ; i<ItemsNames.size();i++) {
     	        	  String itemName = ItemsNames.get(i).getText();
     	        	  
     	        	  if(itemName.contains("Labs")) {
     	        		  MyAddToCartButtons.get(i).click();

     	        		  break;
     	        		  
     	        		  
     	        	  }
    	       	 

    	          
    	   }
      }
      
    		   


		
		
	}
	


