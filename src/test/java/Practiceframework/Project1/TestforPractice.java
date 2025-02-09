package Practiceframework.Project1;

import org.testng.Assert;
import org.testng.annotations.Test;

import Practiceframework.TestComponents.BaseTest;

public class TestforPractice extends BaseTest {

	
	@Test
	public void Testagain() throws InterruptedException
	{	
		
		//LoginPage login=new LoginPage(driver);
		login.loginApplication("rupapadmasrivutla@gmail.com","Hayaan123&");	
	
	}
	
	/*@Test(priority=1)
	public void JustPracticeTest2()
	{
		int a=234;
		int b=235;
		Assert.assertEquals(a,b);
		System.out.println(a-b);
	}*/
}
