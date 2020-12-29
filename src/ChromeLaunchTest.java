import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ChromeLaunchTest extends BaseChromeSetup{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = Capabalities();
		driver.get("http://www.google.com");
		System.out.println("Google is lauched successfully.!!");
		
		
	}

}
