package Practiceframework.Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Practiceframework.TestComponents.BaseTest;

public class Testcase1 extends BaseTest{

	WebDriver driver;
	String productname="IPHONE 13 PRO";
	String countryname="India";
	
	@Test
	public void Test1() throws InterruptedException
	{	
		
		//LoginPage login=new LoginPage(driver);
		OrderPage orderpage= login.loginApplication("roopapadmasri@gmail.com","Hayaan123&");
		
		orderpage.selectDesiredProduct(productname);
		orderpage.goToCart();
		CartPage cartpage=new CartPage(driver);
		Boolean match=cartpage.checkCart(productname);
		System.out.println(match);
		Assert.assertTrue(match);
		//cartpage.clickOnCheckout();---needed
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.selectCountry(countryname);
		checkoutpage.submitorder();
		ConfirmationPage confirmpage=new ConfirmationPage(driver);
		String msg=confirmpage.Confirmationmsg();
		Assert.assertTrue(msg.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(confirmpage.OrderId());
		
	}
}
