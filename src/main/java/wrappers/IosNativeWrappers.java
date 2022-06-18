package wrappers;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import io.appium.java_client.remote.SupportsContextSwitching;

public class IosNativeWrappers extends AndroidWebWrappers {

	public boolean launchIosApp(String deviceName, String udid, String xcodeOrgId, String bundleId, String app) {
		return launchApp("iOS", deviceName, udid, "", "", "XCUITest", "", "", xcodeOrgId, "iPhone Developer", bundleId,
				app, "", "");
	}

	public boolean launchIosAppInParallel(String deviceName, String udid, String xcodeOrgId, String bundleId,
			String app, String wdaLocalPort) {
		return launchApp("iOS", deviceName, udid, "", "", "XCUITest", "", "", xcodeOrgId, "iPhone Developer", bundleId,
				app, "", wdaLocalPort);
	}

	public boolean chooseNextOptionInPickerWheel(String locator, String locatorValue) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("order", "next");
		params.put("offset", 0.15);
		params.put("element", getWebElement(locator, locatorValue));
		getDriver().executeScript("mobile: selectPickerWheelValue", params);
		return true;
	}

	public boolean chooseNextOptionInPickerWheel(WebElement ele) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("order", "next");
		params.put("offset", 0.15);
		params.put("element", ele);
		getDriver().executeScript("mobile: selectPickerWheelValue", params);
		return true;
	}

	public boolean choosePreviousOptionInPickerWheel(String locator, String locatorValue) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("order", "previous");
		params.put("offset", 0.15);
		params.put("element", getWebElement(locator, locatorValue));
		getDriver().executeScript("mobile: selectPickerWheelValue", params);
		return true;
	}

	public boolean choosePreviousOptionInPickerWheel(WebElement ele) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("order", "previous");
		params.put("offset", 0.15);
		params.put("element", ele);
		getDriver().executeScript("mobile: selectPickerWheelValue", params);
		return true;
	}

	public void clickGivenKeyboardButtonInIosByName(String name) {
		boolean isNative = ((SupportsContextSwitching) getDriver()).getContext().equalsIgnoreCase("NATIVE_APP");
		if (!isNative) {
			switchNativeview();
		}
		if (isKeyboardShown()) {
			click(getWebElement(Locators.NAME.toString(), name));
		}
		if (!isNative) {
			switchWebview();
		}
	}

	public void clickGivenKeyboardButtonInIosByXpath(String xPath) {
		boolean isNative = ((SupportsContextSwitching) getDriver()).getContext().equalsIgnoreCase("NATIVE_APP");
		if (!isNative) {
			switchNativeview();
		}
		if (isKeyboardShown()) {
			click(getWebElement(Locators.XPATH.toString(), xPath));
		}
		if (!isNative) {
			switchWebview();
		}
	}

}
