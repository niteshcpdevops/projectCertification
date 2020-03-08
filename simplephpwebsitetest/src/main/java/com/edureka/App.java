package com.edureka;

import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeOptions;
/**
 * Hello world!
 *
 */
public class App {
	private static String OS = System.getProperty("os.name").toLowerCase();
	private static PropertiesUtil propsUtil = new PropertiesUtil();
	
    @Test
    public static void main( String[] args )  {
    	propsUtil.loadTestCasesPropertyFile();
    	
    	String aboutMeText = PropertiesUtil.getPropsValue("ABOUT_ME_TEXT");
    	
    	if (isUnix())    	
    		System.setProperty("webdriver.chrome.driver","chromedriver_linux64_80.0.3987.106/chromedriver");
    	else
    		System.setProperty("webdriver.chrome.driver","chromedriver_win32_80.0.3987.106/chromedriver.exe");
    	
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(chromeOptions);
		chromeOptions.addArguments("--headless");
		driver.get("http://13.127.132.63:8081/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("About Us")).click();
		String test = driver.findElement(By.id("PID-ab2-pg")).getText();
		
		//System.out.println("TEST : " + test);
		Assert.assertEquals(test,aboutMeText);
		
		/*Assert.assertEquals(test, "This is about page. Lorem Ipsum Dipsum is simply dummy text of the " +
			"printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy " +
			"text ever since the 1500s, when an unknown printer took a galley of type and "+
			"scrambled it to make a type specimen book. It has survived not only five centuries, "+
			"but also the leap into electronic typesetting, remaining essentially unchanged. It "+
			"was popularised in the 1960s with the release of Letraset sheets containing Lorem "+
			"Ipsum passages, and more recently with desktop publishing software like Aldus "+
			"PageMaker including versions of Lorem Ipsum.");*/
		
        System.out.println("Test Succeeded!!");
        driver.quit();
    }
    
    public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}

}
