package learning;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class LearnHybridAppInIos extends GenericWrappers {

	@Test
	public void learnPickerView() throws MalformedURLException {
		launchIosApp("iPhone SE (3rd generation)", "", "", "", "/apks/UiCatalog.zip");
		swipeUpInApp();
		click(getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Web View"));
		sleep(5000);
		printContext();
		switchWebview();
		click(getWebElement(Locators.XPATH.toString(), "//span[text()='Global Nav Open Menu']/.."));
		click(getWebElement(Locators.XPATH.toString(), "(//span[text()='Watch']/..)[1]"));
		sleep(5000);
		closeApp();

	}
}
