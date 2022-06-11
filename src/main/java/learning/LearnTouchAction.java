package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.internal.MouseAction.Button;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LearnTouchAction {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("app", System.getProperty("user.dir") + "\\apks\\MultiTouch Tester_v1.2.apk");
		dc.setCapability("deviceName", "My emulator device");
		dc.setCapability("platformName", "Android");
		dc.setCapability("noReset", true);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		int maxY = driver.manage().window().getSize().getHeight();
		int maxX = driver.manage().window().getSize().getWidth();
		// Swipe up
		PointerInput input = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger1 = new Sequence(input, 1);
		finger1.addAction(input.createPointerMove(Duration.ofMillis(0), Origin.viewport(), (int) (maxX * 0.5),
				(int) (maxY * 0.8)));
		finger1.addAction(input.createPointerDown(Button.LEFT.asArg()));
		finger1.addAction(input.createPointerMove(Duration.ofMillis(2000), Origin.viewport(), (int) (maxX * 0.5),
				(int) (maxY * 0.2)));
		finger1.addAction(input.createPointerUp(Button.LEFT.asArg()));
		driver.perform(Arrays.asList(finger1));

		// Swipe down
		PointerInput input1 = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger2 = new Sequence(input1, 1);
		finger2.addAction(input1.createPointerMove(Duration.ofMillis(0), Origin.viewport(), (int) (maxX * 0.5),
				(int) (maxY * 0.2)));
		finger2.addAction(input1.createPointerDown(Button.LEFT.asArg()));
		finger2.addAction(input1.createPointerMove(Duration.ofMillis(2000), Origin.viewport(), (int) (maxX * 0.5),
				(int) (maxY * 0.8)));
		finger2.addAction(input1.createPointerUp(Button.LEFT.asArg()));
		driver.perform(Arrays.asList(finger2));

		// Swipe left
		PointerInput input2 = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger3 = new Sequence(input2, 1);
		finger3.addAction(input2.createPointerMove(Duration.ofMillis(0), Origin.viewport(), (int) (maxX * 0.8),
				(int) (maxY * 0.5)));
		finger3.addAction(input2.createPointerDown(Button.LEFT.asArg()));
		finger3.addAction(input2.createPointerMove(Duration.ofMillis(2000), Origin.viewport(), (int) (maxX * 0.2),
				(int) (maxY * 0.5)));
		finger3.addAction(input2.createPointerUp(Button.LEFT.asArg()));
		driver.perform(Arrays.asList(finger3));

		// Swipe right
		PointerInput input3 = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger4 = new Sequence(input3, 1);
		finger4.addAction(input3.createPointerMove(Duration.ofMillis(0), Origin.viewport(), (int) (maxX * 0.2),
				(int) (maxY * 0.5)));
		finger4.addAction(input3.createPointerDown(Button.LEFT.asArg()));
		finger4.addAction(input3.createPointerMove(Duration.ofMillis(2000), Origin.viewport(), (int) (maxX * 0.8),
				(int) (maxY * 0.5)));
		finger4.addAction(input3.createPointerUp(Button.LEFT.asArg()));
		driver.perform(Arrays.asList(finger4));

		PointerInput input4 = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger5 = new Sequence(input4, 1);
		finger5.addAction(input4.createPointerMove(Duration.ofMillis(0), Origin.viewport(), (int) (maxX * 0.25),
				(int) (maxY * 0.25)));
		finger5.addAction(input4.createPointerDown(Button.LEFT.asArg()));
		finger5.addAction(input4.createPointerMove(Duration.ofMillis(2000), Origin.viewport(), (int) (maxX * 0.5),
				(int) (maxY * 0.5)));
		finger5.addAction(input4.createPointerUp(Button.LEFT.asArg()));

		PointerInput input5 = new PointerInput(Kind.TOUCH, "finger 1");
		Sequence finger6 = new Sequence(input5, 1);
		finger6.addAction(input5.createPointerMove(Duration.ofMillis(0), Origin.viewport(), (int) (maxX * 0.75),
				(int) (maxY * 0.75)));
		finger6.addAction(input5.createPointerDown(Button.LEFT.asArg()));
		finger6.addAction(input5.createPointerMove(Duration.ofMillis(2000), Origin.viewport(), (int) (maxX * 0.5),
				(int) (maxY * 0.5)));
		finger6.addAction(input5.createPointerUp(Button.LEFT.asArg()));
		driver.perform(Arrays.asList(finger5, finger6));

	}

}
