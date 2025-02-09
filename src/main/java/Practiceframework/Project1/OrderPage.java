package Practiceframework.Project1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{

WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	
	@FindBy(xpath="//*[@id='products']/div[1]/div[2]/div/descendant::b")
	List<WebElement> products;
	
	@FindBy(xpath="//*[@id='products']/div[1]/div[2]/div/descendant::button[contains(@class,'w-10')]")
	List<WebElement> addToCarts;
	
	@FindBy(xpath="//*[@id='toast-container']")
	WebElement toaster;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	public void selectDesiredProduct(String productname)
	{
		for(int i=0;i<products.size();i++)
		{
			if(products.get(i).getText().equalsIgnoreCase(productname))
			{
				System.out.println(products.get(i).getText());
				addToCarts.get(i).click();
				break;
			}
		}
	}
	
	public void itemAddedSuccess(WebElement toaster) throws InterruptedException
	{
		
		waitForsometime();
		WebElementToAppear(toaster);
	}
	
}
