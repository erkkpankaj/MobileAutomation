package eCommerceAppTesting;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC_3 extends eComBaseSetup {

	// TC3: Search for a particular items in list and add to cart

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
			// This is used to scroll the complete list of items till desired object is displayed 
	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""
		 + "Nike SFB Jungle" + "\").instance(0))"));	
	 System.out.println("The item is visible on the screen");
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println("The count of items in list are : " + productCount);
		for (int i = 0; i <= productCount; i++) {
			String itemName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			if (itemName.equalsIgnoreCase("Nike SFB Jungle")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				break;
			}
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		System.out.println("Clicked on Add to cart button..!!");
		Thread.sleep(1000);
		String checkedOutItem = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		System.out.println("The checkedout items is: " + checkedOutItem);
		
	}

}
