package learning;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FirstAndroidCode {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("app", System.getProperty("user.dir") + "\\apks\\leaforg.apk");
		dc.setCapability("deviceName", "My emulator device");
		dc.setCapability("platformName", "Android");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
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
