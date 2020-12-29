import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseChromeSetup {

	public static AndroidDriver<AndroidElement> Capabalities() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		// To run the TCs on the mobile browsers add BROWSER_NAME Capability
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");	
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;

	}
}
