package tanjarine.exadel.android.appium.automation;

/**
 * Created by ypolshchykau on 13.11.2014.
 */

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AppiumTest {

    private AndroidDriver webDriver;

    @BeforeClass
    public void setUp(){

    /*    DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("appium-version", "1.2.4");
        capabilities.setCapability("platformVersion", "4.2.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
//        capabilities.setCapability("device","Android");
        */
/*capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
        capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");*//*

//        capabilities.setCapability("deviceName", "0114011700000523");
        capabilities.setCapability("appPackage", "com.tanjarine.dashboard");
        capabilities.setCapability("appActivity", "com.tanjarine.dashboard.ui.AssignPartyActivity");
*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device","Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.VERSION, "4.2.2");
//        capabilities.setCapability(CapabilityType.PLATFORM, "MAC");
        capabilities.setCapability("deviceName", "0114011700000523");
        capabilities.setCapability("appPackage", "com.tanjarine.dashboard");
        capabilities.setCapability("appActivity", "com.tanjarine.dashboard.ui.AssignPartyActivity");

        try {
            webDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            //new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        //  webDriver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

    }

	/* @Test
	 public void appiumExampleTest() throws Exception {
		 List<WebElement> developersOptListButtons = webDriver.findElements(By.className("android.widget.Button"));
		 if (developersOptListButtons.size()!=0) {
			 developersOptListButtons.get(2).click();
		 }
	     WebElement startDash=webDriver.findElement(By.name("Start Dashboard launcher"));
	     startDash.click();

	     List<WebElement> tables = webDriver.findElements(By.className("android.widget.TextView")) ;
	     if (tables.size()!= 0) {
	    	 tables.get(4).click();
	     }
	     WebElement foodSection  = webDriver.findElement(By.name("food"));
	     foodSection.click();
	  // we are on second screen now
	  // check if second screen contains TextView with text “Activity2”

	 }
*/


    @Test(priority = 1)
    public void testAssignTable() throws InterruptedException{

        WebElement tableEditBox = (WebElement) webDriver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
        tableEditBox.sendKeys("test_appium_UI");

        List<WebElement> assignTableBtn =webDriver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")");
        assignTableBtn.get(1).click();
        Thread.sleep(2000);
        ///workaround due to assign bug
        WebElement tableEditBox_1 = (WebElement) webDriver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
        tableEditBox_1.sendKeys("test_appium_UI");

        List<WebElement> assignTableBtn_1 =webDriver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")");
        assignTableBtn_1.get(1).click();
        Thread.sleep(3000);
        ////// end workaround

        MobileElement serverOnTheWayLabel = (MobileElement) webDriver.findElementByAndroidUIAutomator("text(\"ON THE WAY\")");

        Assert.assertEquals(serverOnTheWayLabel.isDisplayed(),true);

        // UIObject my = new UIObject (new UISelector().className("ddd").instance(2));
		/* WebElement newTableEditBox = webDriver.findElement(By.className("android.widget.EditText"));
		 if (newTableEditBox != null){
			 newTableEditBox.sendKeys("test_1");
		 }
		 Thread.sleep(3000);
		 List<WebElement> buttons = webDriver.findElements(By.className("android.widget.Button")); //we have 2 buttons and we shoult teke second
		 if (buttons.size() != 0) {
			 buttons.get(1).click();
		 }
		 Thread.sleep(5000);
		 List<WebElement> dashBoardMenuBtns = webDriver.findElements(By.className("android.widget.Button"));
		 dashBoardMenuBtns.get(1).click();
		 Thread.sleep(10000);
		 List<WebElement> foodMenuBtn = webDriver.findElements(By.className("android.widget.TextView"));

			 for(WebElement foodUpper: foodMenuBtn){
			 if (foodUpper.getText().equals("Sandwiches")){
				 foodUpper.click();
				 break ;
			 }
		 }

			 webDriver.navigate().back();
			 Thread.sleep(3000);

		 WebElement waiterIcon  = webDriver.findElement(By.className("android.widget.ImageView"));
		 if (waiterIcon!= null){
			 // WebElement row = driver.findElements(By.tagName("tableCell")).get(4);
			 JavascriptExecutor js = (JavascriptExecutor) webDriver;
			 HashMap<String, String> tapObject = new HashMap<String, String>();
			 //tapObject.put("x", 20); // in pixels from left
			// tapObject.put("y", 15); // in pixels from top
			 tapObject.put("element", ((RemoteWebElement) waiterIcon).getAttribute(name)); // the id of the element we want to tap
			 js.executeScript("mobile: longClick", tapObject);

		 }
		 webDriver.navigate().back();
		 Thread.sleep(3000);
		 */

    }

    @Test (priority = 2)
    public void testLogOutFromDashboard()throws InterruptedException {
        // (WebElement) webDriver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\")");
        Thread.sleep(5000);
        List<WebElement> waiterImg = webDriver.findElements(By.className("android.widget.ImageView"));
        // MobileElement waiterImg = (MobileElement) webDriver.findElementByAndroidUIAutomator("new UiSelector().className(\"adroid.widget.ImageView\")");
        if (waiterImg.get(1) != null) {
            TouchAction action = new TouchAction(webDriver);
            Thread.sleep(1000);
            action.longPress(waiterImg.get(1)).perform();
            Thread.sleep(5000);
        }

        WebElement plsEnterPswrd = webDriver.findElement(By.className("android.widget.EditText"));
        //android.widget.EditText
        if (plsEnterPswrd != null) {
            plsEnterPswrd.sendKeys("357159");
        }

        List<WebElement> okBtn =webDriver.findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")");
        okBtn.get(0).click();
        Thread.sleep(3000);

    }


    @AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
