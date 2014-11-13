com.tanjarine.exadel.android.appium.automation
======================

TanjarineAndroidAppium

this repo is created for storing android automation code. Appium is selected as base framework for development.


1) way to start appium server: 
`E:\InstalledSW\Appium>node.exe E:\InstalledSW\Appium\node_modules\appium\bin\app`
`ium.js -U UUID_of_device -p 4723 -a 127.0.0.1`

2) add standalone selenium server jar dependencies:
  	
	 `<dependency>`
         `   <groupId>org.seleniumhq.selenium</groupId>`
            `<artifactId>selenium-java</artifactId>`
         `   <version>2.41.0</version>`
        `</dependency>`

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-support</artifactId>
            <version>2.41.0</version>
        </dependency>
        
        
        




3) add java client dependency:

 https://github.com/appium/java-client/blob/171fcca4a546ccf1ab3c2afb1010b01510f59689/src/test/java/io/appium/java_client/AndroidUIAutomatorTest.java#L50

      <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>2.0.0</version>
        </dependency>
      
