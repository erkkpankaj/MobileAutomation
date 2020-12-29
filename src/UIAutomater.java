
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomater extends BaseSetup {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabalities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Identify the objects using AndroidUIAutomator : driver.findElementByAndroidUIAutomator("attribute(\"value\")")
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

		// Example: Validate properties (Say as clickable) of any object
		// We can check the properties of the object with the help of AndroidUIAutomator itself
		//Syntax: driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)")
		System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}

}