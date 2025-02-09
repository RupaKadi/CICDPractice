package Practiceframework.Project1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Practiceframework.TestComponents.BaseTest;
import Practiceframework.TestComponents.Retry;

public class NewTestCase extends BaseTest{

	WebDriver driver;
	//String productname="IPHONE 13 PRO";
	//String countryname="India";
	
	@Test(dataProvider="getData", groups= {"Testmultiple"})
	public void Test1(HashMap<String,String> input) throws InterruptedException
	{	
		
		//LoginPage login=new LoginPage(driver);
		OrderPage orderpage= login.loginApplication(input.get("email"),input.get("password"));		
		orderpage.selectDesiredProduct(input.get("productname"));
		
		CartPage cartpage=orderpage.goToCart();
		Boolean match=cartpage.checkCart(input.get("productname"));
		System.out.println(match);
		Assert.assertTrue(match);
		
		CheckoutPage checkoutpage=cartpage.goToCheckout();		
		checkoutpage.selectCountry(input.get("countryname"));
		
		ConfirmationPage confirmpage=checkoutpage.submitorder();		 
		String msg=confirmpage.Confirmationmsg();
		AssertJUnit.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		System.out.println("Order Id is:"+confirmpage.OrderId());
		
	}
	
	@Test(groups= {"Testmultiple"}, retryAnalyzer= Retry.class)
	public void Test2() throws IOException, InterruptedException
	{
		
		login.loginApplication("ruoapadmasri@gmail.com","Hayaan123");
		System.out.println("new login");
		Assert.assertEquals(login.Errormsg(), "Incoect email or password.");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
//   	HashMap<String,String> map= new HashMap<String,String>();
//		map.put("email", "roopapadmasri@gmail.com");
//		map.put("password", "Hayaan123&");
//		map.put("productname", "IPHONE 13 PRO");
//		map.put("countryname", "India");
//		
//		HashMap<String,String> map1= new HashMap<String,String>();
//		map1.put("email", "rupapadmasrivutla@gmail.com");
//		map1.put("password", "Hayaan123&");
//		map1.put("productname", "Banarsi Saree");
//		map1.put("countryname", "India");
		
		List<HashMap<String, String>> data=getJsonDatatoMap(System.getProperty("user.dir")+"//src//test//java//Practicework//Data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
