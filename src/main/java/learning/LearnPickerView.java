package learning;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import wrappers.GenericWrappers;

public class LearnPickerView extends GenericWrappers {

	@Test
	public void learnPickerView() throws MalformedURLException {
		launchIosApp("iPhone SE (3rd generation)", "", "", "", "/apks/UiCatalog.zip");
		click(getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Picker View"));
		chooseNextOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Red color component value"));
		chooseNextOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Red color component value"));
		chooseNextOptionInPickerWheel(getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Red color component value"));
		choosePreviousOptionInPickerWheel(
				getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Blue color component value"));
		choosePreviousOptionInPickerWheel(
				getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Blue color component value"));
		choosePreviousOptionInPickerWheel(
				getWebElement(Locators.ACCESSIBILITY_ID.toString(), "Blue color component value"));
		sleep(5000);
		closeApp();

	}
}
