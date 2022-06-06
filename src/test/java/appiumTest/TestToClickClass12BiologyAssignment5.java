package appiumTest;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class TestToClickClass12BiologyAssignment5 {

	AndroidDriver<AndroidElement> dv;

	@BeforeClass
	public void launchWebsite() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "sdk_gphone_x86");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.khanacademy.android");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		dv = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
	}

	@Test
	public void methodToClickClass12Biology() throws InterruptedException {
		dv.findElement(MobileBy.AccessibilityId("Search tab")).click();
		Thread.sleep(3000);
		dv.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Science\")")).click();
		Thread.sleep(3000);
		TouchAction act = new TouchAction(dv);
		Dimension d = dv.manage().window().getSize();
		int width = d.width;
		int height = d.height;
		int x1 = width / 2;
		int y1 = 4 * height / 5;
		int x2 = width / 2;
		int y2 = height / 5;
		act.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(x2, y2)).release().perform();
		Thread.sleep(3000);
		dv.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Class 12 Biology (India)\")")).click();
		Thread.sleep(3000);
		String Expected = "Class 12 Biology (India)";
		String Actual = dv.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Class 12 Biology (India)\")")).getText();
		Assert.assertEquals(Actual, Expected);
	}

	@AfterClass
	public void quitBrowser() {
		dv.quit();
	}
}
