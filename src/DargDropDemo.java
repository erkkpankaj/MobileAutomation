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
public class DargDropDemo extends BaseSetup{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabalities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		System.out.println("Clicked on the Views..!!");
		
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		System.out.println("Clicked on Drag and drop..!!");
		
		WebElement source=driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination=driver.findElementsByClassName("android.view.View").get(1);
		TouchAction t = new TouchAction(driver);
		
		//Long press (source)/move(destination)/release
		//If want to perform multiple operations like with duration etc. then need to code like below 
		t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		
		//This also works fine as no need to perform any extra operations here 
		//t.longPress((element(source))).moveTo(element(destination)).release().perform();
		
		System.out.println("Drag drop done successfully..!!");
	}

}
