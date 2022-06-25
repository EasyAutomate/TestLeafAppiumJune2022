package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class LearniOSInSauceLabs {

	public static void main(String[] args) throws MalformedURLException {
		MutableCapabilities caps = new MutableCapabilities();
		// caps.setCapability("platformName", "iOS");
		caps.setCapability("appium:app", "storage:filename=UICatalog.zip"); // The filename of the mobile app
		caps.setCapability("appium:deviceName", "iPhone 13 Simulator");
		caps.setCapability("appium:platformVersion", "15.4");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "1.22.3");
		sauceOptions.setCapability("build", "12");
		sauceOptions.setCapability("name", "Appium_June_Sample");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("Cloud URL");
		IOSDriver driver = new IOSDriver(url, caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.accessibilityId("Action Sheets")).click();
		driver.findElement(AppiumBy.accessibilityId("Okay / Cancel")).click();
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"UICatalog\"]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();

	}
}
