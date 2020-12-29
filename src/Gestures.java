import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//This needs to be imported manually
import static io.appium.java_client.touch.TapOptions.tapOptions;

//This needs to be imported manually
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

//This needs to be imported manually
import static io.appium.java_client.touch.offset.ElementOption.element;

//This needs to be imported manually
import static java.time.Duration.ofSeconds;

public class Gestures extends BaseSetup {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabalities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		System.out.println("Clicked on the Views..!!");

		// Tap operations on Mobile devices
		TouchAction t = new TouchAction(driver);

		WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		// Performing the tap operations
		t.tap(tapOptions().withElement(element(expandList))).perform();
		System.out.println("Tap on the expandList..!!");

		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement peopleName = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		// Performing the long operations
		t.longPress(longPressOptions().withElement(element(peopleName)).withDuration(ofSeconds(2))).release().perform();
		System.out.println("Longpress on the peopleName..!!");

		Thread.sleep(2000);

		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		System.out.println("Sample menu is displayed..!!");

	}
}
