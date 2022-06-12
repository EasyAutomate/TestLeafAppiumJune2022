package learning;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class LearnSwitchBetweenApps extends GenericWrappers{
	
	@Test
	public void learnSwitchApps() {
		launchAndroidApp("my device", "com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity", "", "");
		enterValue(getWebElement(Locators.XPATH.toString(), "(//android.widget.EditText)[1]"), "rajkumar@testleaf.com");
		enterValue(getWebElement(Locators.XPATH.toString(), "(//android.widget.EditText)[2]"), "Leaf@123");
		click(getWebElement(Locators.XPATH.toString(), "//android.widget.Button"));
		//startAnAppUsingActivity("com.the511plus.MultiTouchTester", "com.the511plus.MultiTouchTester.MultiTouchTester");
		stopRunningApp("com.the511plus.MultiTouchTester");
		switchToAnotherApp("com.the511plus.MultiTouchTester");
		swipeLeftInApp();
		swipeRightInApp();
		//startAnAppUsingActivity("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity");
		switchToAnotherApp("com.testleaf.leaforg");
	}

}
