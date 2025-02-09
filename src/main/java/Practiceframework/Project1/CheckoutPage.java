package Practiceframework.Project1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement desiredcountry;
	
	@FindBy(xpath="//section[contains(@class,'ta-results')]")
	WebElement section;
	
	@FindBy(xpath="//div//a[contains(text(),'Place Order')]")
	WebElement submit;
	
	public void selectCountry(String countryname)
	{
		country.sendKeys(countryname);
		WebElementToAppear(section);
		System.out.println(countryname);
		desiredcountry.click();		
	}
	
	public ConfirmationPage submitorder()
	{
		submit.click();
		ConfirmationPage confirmpage=new ConfirmationPage(driver);
		return confirmpage;
	}
	
	
	
	
	
	

}
