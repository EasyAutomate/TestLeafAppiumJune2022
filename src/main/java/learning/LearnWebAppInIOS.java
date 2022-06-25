package learning;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class LearnWebAppInIOS extends GenericWrappers {

	@Test
	public void learnPickerView() {
		launchSafariBrowser("iPhone SE (3rd generation)", "http://www.google.com", "");
		enterValue(getWebElement(Locators.NAME.toString(), "q"), "Lokesh");
		sleep(3000);
		click(getWebElement(Locators.XPATH.toString(), "//input[@name='q']"));
		clickGivenKeyboardButtonInIosByAccessibilityId("Search");
		sleep(5000);
		closeApp();

	}
}
