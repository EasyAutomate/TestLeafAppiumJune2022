package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LearnHybridAppsWithDualWebView {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("app", System.getProperty("user.dir") + "\\apks\\TheApp-v1.10.0.apk");
		dc.setCapability("deviceName", "My emulator device");
		// dc.setCapability("platformName", "Android");
		AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Dual Webview Demo']")).click();

		// Hybrid app -- Web view
		Set<String> contextHandles = driver.getContextHandles();
		for (String string : contextHandles) {
			System.out.println(string);
		}
		driver.context("WEBVIEW_io.cloudgrey.the_app");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String string : windowHandles) {
			driver.switchTo().window(string);
			System.out.println(driver.findElement(By.tagName("h2")).getText());
		}
		driver.context("NATIVE_APP");
		Thread.sleep(2000);
		// Hybrid app -- Native
		List<WebElement> findElements = driver.findElements(By.xpath("//android.webkit.WebView/android.view.View"));

		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());
		}

		// driver.quit();

	}
}
