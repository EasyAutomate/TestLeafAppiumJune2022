package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class LearnTouchActionWithinWebElement {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "My emulator device");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.android.vending");
		dc.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
		AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String bounds = driver.findElement(By.xpath(
				"//android.view.View[@content-desc='More results for Based on your recent activity']/../following-sibling::android.view.View"))
				.getAttribute("bounds");
		String[] split = bounds.replace("][", "!").replace("[", "").replace("]", "").split("!");
		String[] eleStart = split[0].split(",");
		String[] eleEnd = split[1].split(",");

		// Swipe left
		int startX = (int) ((Integer.parseInt(eleEnd[0]) - Integer.parseInt(eleStart[0])) * 0.8)
				+ Integer.parseInt(eleStart[0]);
		int startY = (int) ((Integer.parseInt(eleEnd[1]) - Integer.parseInt(eleStart[1])) * 0.5)
				+ Integer.parseInt(eleStart[1]);
		int endX = (int) ((Integer.parseInt(eleEnd[0]) - Integer.parseInt(eleStart[0])) * 0.2)
				+ Integer.parseInt(eleStart[0]);
		int endY = (int) ((Integer.parseInt(eleEnd[1]) - Integer.parseInt(eleStart[1])) * 0.5)
				+ Integer.parseInt(eleStart[1]);
		PointerInput input = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger1 = new Sequence(input, 1);
		finger1.addAction(input.createPointerMove(Duration.ofMillis(0), Origin.viewport(), startX, startY));
		finger1.addAction(input.createPointerDown(MouseButton.LEFT.asArg()));
		finger1.addAction(input.createPointerMove(Duration.ofMillis(2000), Origin.viewport(), endX, endY));
		finger1.addAction(input.createPointerUp(MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(finger1));
		driver.quit();
	}

}
