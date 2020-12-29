package eCommerceAppTesting;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC_4_OptimizedCodeVersion extends eComBaseSetup {

	// TC4: Code optimization for TC4

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
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		System.out.println("Total items count: " +  count);
		double sumOfProducts = 0;
		for (int i = 0; i <count; i++) {
			String amount = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i)
					.getText();
			Thread.sleep(2000);
			double item1Amount = getAmount(amount);
			System.out.println("Item cost :" + item1Amount);
			sumOfProducts = sumOfProducts + item1Amount;
			System.out.println("Sum of products is :" + sumOfProducts);
		}
		Thread.sleep(2000);
		// Total purchase amount
		String totalPrice = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println("Total purchase amount :" + totalPrice);

		double totalPriceOfItems = getAmount(totalPrice);
		Assert.assertEquals(sumOfProducts, totalPriceOfItems, 0);
		System.out.println("Validated that Sum of prices of items is equals to total purchase amount");
	}

	public static double getAmount(String value) {
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		return amountValue;
	}
}
