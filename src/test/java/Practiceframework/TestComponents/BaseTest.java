package Practiceframework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Practiceframework.Project1.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {	

	WebDriver driver;
	public LoginPage login;
	
	public WebDriver InitializeDriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//Practiceframework//resources//GlobalData.properties");
		prop.load(fis);
		
		String browsername= System.getProperty("browser")!=null? System.getProperty("browser") : prop.getProperty("browser"); //instead of prop.getProperty("browser"); give this line to accept property from maven command
		
		System.out.println(browsername);
		
		if(browsername.contains("chrome")) //modified for headless mode
		{
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browsername.contains("headless")){
			options.addArguments("headless");
			}		
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
			
			//System.setProperty("webdriver.chrome.driver", "C:/Users/ITADMIN/Downloads/chromedriver-win64/chromedriver.exe");
			//driver=new ChromeDriver();
		}
		
		else if(browsername.equals("firefox")) {
			driver= new FirefoxDriver();
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LoginPage Loginwebsite() throws IOException
	{
		driver=InitializeDriver();
		login= new LoginPage(driver);
		login.goTo();
		return login;
	}
	
		
	@SuppressWarnings("deprecation")
	public List<HashMap<String, String>> getJsonDatatoMap(String filepath) throws IOException
	{
		//convert Json to String
		String jsonContent= FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		//String to Map using Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		  return data; //this data will contains-- map,map1
	}
	
	public String Screenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png"; //returns path where the file is stored
	}
	
	@AfterMethod(alwaysRun=true)
public void tearDown()
{
		driver.quit();
}
	
}
	



