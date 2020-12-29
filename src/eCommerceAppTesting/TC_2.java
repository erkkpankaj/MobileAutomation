package eCommerceAppTesting;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC_2 extends eComBaseSetup {

	//TC1: Validating the error messages 
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabalities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.findElementsByAndroidUIAutomator("new UiScrollable(new
		// UiSelector()).scrollIntoView(text(\"India\"))");
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
						+ "Brazil" + "\").instance(0))"));
		driver.findElement(By.xpath("//*[@text='Brazil']")).click();
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kat");
		// This is used to hide the keyboard
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//Developers provide the "android.widget.toast" class name for error messages and "Name" attribute is used to fetch the toast message
		String ToastMessage = driver.findElement(By.xpath("*//android.widget.Toast[1]")).getAttribute("Name");
		System.out.println("The toast message is: " + ToastMessage);		
	}
}
