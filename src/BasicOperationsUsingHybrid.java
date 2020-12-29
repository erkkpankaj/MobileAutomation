import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicOperationsUsingHybrid extends HybridBase{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabalities("emulator");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Identify the object : //tagName[@attribute='value']
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		System.out.println("Clicked on the Preference button.!!");
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		System.out.println("Clicked on the Preference dependencies.!!");
		driver.findElementById("android:id/checkbox").click();
		System.out.println("Clicked on the Wifi button.!!");
		//Identifying objects based on indexing
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		System.out.println("Clicked on the Wifi settings.!!");
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
		//Identify the element based on the index using findElementsByClassName, it will grape all the elements with class name “android.widget.Button” and get the second element and click on it
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		System.out.println("Clicked cancel button.!!");
		

	}

}
