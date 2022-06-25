package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LearnAndroidInSauceLabs {

	public static void main(String[] args) throws MalformedURLException {
		MutableCapabilities caps = new MutableCapabilities();
		// caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=leaforg.apk");
		caps.setCapability("appium:deviceName", "Google Pixel 4a (5G) GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "12.0");
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("appiumVersion", "1.22.1");
		sauceOptions.setCapability("build", "12");
		sauceOptions.setCapability("name", "Appium_June_Sample");
		caps.setCapability("sauce:options", sauceOptions);

		URL url = new URL("Cloud URL");
		AndroidDriver driver = new AndroidDriver(url, caps);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys("rajkumar@testleaf.com");
		driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//android.widget.Button")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();

	}
}
