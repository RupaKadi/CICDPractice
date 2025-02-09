package Practiceframework.Project1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
@FindBy(id="userEmail")
WebElement email;

@FindBy(id="userPassword")
WebElement passwordele;

@FindBy(id="login")
WebElement loginbtn;

@FindBy(xpath="//*[@id='toast-container']")
WebElement toaster;

@FindBy(css="[class*='flyInOut']")
WebElement errorMessage;


public OrderPage loginApplication(String emailId, String password) throws InterruptedException
{
	email.sendKeys(emailId);
	passwordele.sendKeys(password);
	loginbtn.click();
	OrderPage orderpage=new OrderPage(driver);
	return orderpage;
	
}

public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");
}

public String Errormsg()
{
	WebElementToAppear(errorMessage);
	return errorMessage.getText();
	
}
public void loginSuccess(WebElement toaster)
{
	WebElementToAppear(toaster);
}
}
