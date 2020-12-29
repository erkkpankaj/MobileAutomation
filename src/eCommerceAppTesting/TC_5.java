package eCommerceAppTesting;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

//This needs to be imported manually
import static io.appium.java_client.touch.TapOptions.tapOptions;

//This needs to be imported manually
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

//This needs to be imported manually
import static io.appium.java_client.touch.offset.ElementOption.element;

//This needs to be imported manually
import static java.time.Duration.ofSeconds;

public class TC_5 extends eComBaseSetup {

	// TC5: Tap and long press operations 

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabalities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
						+ "Australia" + "\").instance(0))"));
		driver.findElement(By.xpath("//*[@text='Australia']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kat");
		// This is used to hide the keyboard
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		Thread.sleep(1000);
		System.out.println("First item added to cart..!!");
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		System.out.println("Second item added to cart..!!");
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		System.out.println("Clicked on Add to cart button..!!");
		Thread.sleep(4000);
	
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		System.out.println("Clicked on visit to the website to complete purchase..!!");
		
	
		
		Thread.sleep(7000);
	
		//Switching from Native to WebView mode
		Set<String> contexts=driver.getContextHandles();
		Thread.sleep(7000);
		for (String contextName : contexts)
		{
			System.out.println("Context name: " + contextName);
			//Provide the name of Webveiw application to switch
			driver.context("WEBVIEW_com.androidsample.generalstore");
			driver.findElement(By.name("q")).sendKeys("Hello");
			System.out.println("Enterned hello in Google serach box..!!");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			System.out.println("Hit the enter button..!!");
			//Clicking on the back button to come back to Native application 
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			System.out.println("Clicked on the back button..!!");
			driver.context("NATIVE_APP");
			System.out.println("Switched back to Native application..!!");
			
			
		}
		
		
		

		

		
	}

}
