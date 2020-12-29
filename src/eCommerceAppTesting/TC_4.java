package eCommerceAppTesting;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC_4 extends eComBaseSetup {

	// TC4: Validate that Sum of prices of items is equals to total purchase amount


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
	
		//1st item price
		String item1Price = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();		
		System.out.println("First item price is :" + item1Price);
		
		item1Price = item1Price.substring(1);
		double item1Amount = Double.parseDouble(item1Price);
		
		//2nd item price
		String item2Price = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();		
		System.out.println("Second item price is :" + item2Price);
		
		item2Price = item2Price.substring(1);
		double item2Amount =Double.parseDouble(item2Price);
		
		double sumOfProducts = item1Amount + item2Amount;
		System.out.println("Sum of products is :" + sumOfProducts);

		//Total purchase amount
		String totalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();		
		System.out.println("Total purchase amount :" + totalPrice);
		
		totalPrice = totalPrice.substring(1);
		double totalPriceOfItems = Double.parseDouble(totalPrice);
		
		Assert.assertEquals(sumOfProducts, totalPriceOfItems, 0);
	
		System.out.println("Validated that Sum of prices of items is equals to total purchase amount");
		
	}

}
