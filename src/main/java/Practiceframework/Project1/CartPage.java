package Practiceframework.Project1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{

	WebDriver driver;
	Boolean match;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}	
	
@FindBy(xpath="//div[@class='cart']//ul//li//div[1]//div//h3")
List<WebElement> cartProducts;
	
public boolean checkCart(String productName)
{
	for(int i=0;i<cartProducts.size();i++)
	{
		if(cartProducts.get(i).getText().equalsIgnoreCase(productName))
		{
			match=true;
		}
	}
	return match;
}

	
}
