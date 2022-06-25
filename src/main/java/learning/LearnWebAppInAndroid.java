package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LearnWebAppInAndroid {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserName", "Chrome");
		dc.setCapability("deviceName", "My emulator device");
		// dc.setCapability("platformName", "Android");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Lokesh");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.quit();

	}
}
