import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseSetup {

	public static AndroidDriver<AndroidElement> Capabalities() throws MalformedURLException {
		// TODO Auto-generated method stub
		File f = new File("scr");
		File fs = new File(f, "ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		// To run the TCs on the Emulators provide the device name as Emulator
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "KKAVD");
		// To run the TCs on the Real devices just provide "Android Device"
	//	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		// cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());		
		cap.setCapability(MobileCapabilityType.APP, "C:\\IVL_Selenium@2019\\MobileAutomation\\ApiDemos-debug.apk");	
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;

	}
}
