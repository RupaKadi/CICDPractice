package Project1.StepDefinitions;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;

import Practiceframework.Project1.CartPage;
import Practiceframework.Project1.CheckoutPage;
import Practiceframework.Project1.ConfirmationPage;
import Practiceframework.Project1.LoginPage;
import Practiceframework.Project1.OrderPage;
import Practiceframework.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsimpl extends BaseTest{

	public LoginPage login;
	public OrderPage orderpage;
	public CartPage cartpage;
	public CheckoutPage checkoutpage;
	public ConfirmationPage confirmpage;
	@Given("I logged in Ecommerce page")
	public void I_logged_in_Ecommerce_Page() throws IOException
	{
		login=Loginwebsite();        //code
		
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_In_Username_and_password(String username, String password) throws InterruptedException
	{
		orderpage= login.loginApplication(username,password);
	}
	
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productname)
	{
		
		orderpage.selectDesiredProduct(productname);
	}
	@And("^checkout (.+) and (.+) submit the order$")
	public void submit_the_Order(String productname,String countryname) throws InterruptedException
	{
		cartpage=orderpage.goToCart();
		Boolean match=cartpage.checkCart(productname);
		System.out.println(match);
		Assert.assertTrue(match);
		
		checkoutpage=cartpage.goToCheckout();		
		checkoutpage.selectCountry(countryname);		
		confirmpage=checkoutpage.submitorder();
	}
	
	@Then("{string} confirmation msg is displayed in Confirmation page")
	public void Check_confirmation_msg(String string)
	{
		String msg=confirmpage.Confirmationmsg();
		Assert.assertTrue(msg.equalsIgnoreCase(string));
	
	}
}