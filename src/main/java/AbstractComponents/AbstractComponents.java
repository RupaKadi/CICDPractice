package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Practiceframework.Project1.CartPage;
import Practiceframework.Project1.CheckoutPage;

public class AbstractComponents {

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}	
	
	WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(3));
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cart;
	
	@FindBy(xpath="//div[contains(@class,'subtotal')]/ul/li[3]/button[contains(@class,'btn')]")
	WebElement checkOutBtn;
	
	public void WebElementToAppear(WebElement findBy)
	{
		w.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForsometime() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	
	public CartPage goToCart() throws InterruptedException
	{
		
		waitForsometime();
		cart.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
	}
	
	public CheckoutPage goToCheckout()
	{
		checkOutBtn.click();
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
	}
	
	
}
