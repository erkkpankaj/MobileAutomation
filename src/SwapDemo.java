import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

//This needs to be imported manually
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

//This needs to be imported manually
import static io.appium.java_client.touch.offset.ElementOption.element;

//This needs to be imported manually
import static java.time.Duration.ofSeconds;

public class SwapDemo extends BaseSetup{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabalities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		System.out.println("Clicked on the Views..!!");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();	
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
	
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		TouchAction t = new TouchAction(driver);
		
		// Long press on element and move to another element and release the mouse 
		WebElement first= driver.findElement(By.xpath("//*[@content-desc='45']"));
		WebElement second= driver.findElement(By.xpath("//*[@content-desc='15']"));
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		System.out.println("Swapping done successfully..!!");
	}

}
