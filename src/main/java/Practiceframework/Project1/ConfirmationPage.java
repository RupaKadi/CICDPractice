package Practiceframework.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//tbody//tr//td//h1")
	WebElement confirmationmsg;
	
	@FindBy(xpath="//tbody//tr[3]/child::td[1]//label")
	WebElement orderId;
	
	public String Confirmationmsg()
	{
		String msg=confirmationmsg.getText();
	return msg;
		
	}
	
	public String OrderId()
	{
		String[] id= orderId.getText().trim().split(" ");
		return id[1];
		
	}

	
}
