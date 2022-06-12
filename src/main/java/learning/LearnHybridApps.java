package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LearnHybridApps {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("app", System.getProperty("user.dir") + "\\apks\\leaforg.apk");
		dc.setCapability("deviceName", "My emulator device");
		//dc.setCapability("platformName", "Android");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		Set<String> contextHandles = driver.getContextHandles();
		for (String string : contextHandles) {
			System.out.println(string);
		}
		driver.context("WEBVIEW_com.testleaf.leaforg");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("rajkumar@testleaf.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		// driver.quit();

	}
}
