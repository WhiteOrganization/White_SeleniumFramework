# White_SeleniumFramework
A Selenium Framework that will help to execute tests and functions faster and reduce the effort to access many sections Selenium related.



### What is this repository for? ###

* Quick summary.

The framework will help you structure your classes and give you some EXTRA tools to automate your scenarios faster.
For example instead of doing this to click on the first element:
```java
List<WebElement> divSimulatesButtons=webDriver.findElements(By.xpath("//*[text() = '"+text+"']");
if(divSimulatesButtons !=null && divSimulatesButtons.size()>0){
	WebElement firstButton=divSimulatesButtons.get(0);
	firstButton.click();
}else{
	throw new RuntimeException("Button not found");
}
```

You can instead do :
```java
util.clickText(text);
```
and will perform the same action.

The framework will force the structure of your classes to be ordered and encourage the use of its utility but you can still use WebDriver methods by taking it from the util.
```java
WebDriver webDriver=util.driver;
```

The framework will also take care of the entire configuration of the Drivers, you just need to specify what supported WebExplorers do you want to run your scenarios on.


* Version.

0.1.3 - 
This is still in development and some methods are being constantly added as they are used. Please help us requesting those you need or need more detailed documentation.

### How do I get set up? ###

* Summary of set up.

look for the library on maven (["white-sdev + White_SeleniumFramework"](https://mvnrepository.com/artifact/com.github.white-sdev/White_SeleniumFramework)) and import the library into your project
by including it in your POM. [0.1.3 version](https://mvnrepository.com/artifact/com.github.white-sdev/White_SeleniumFramework/0.1.3)
```XML
	<!-- https://mvnrepository.com/artifact/com.github.white-sdev/White_SeleniumFramework -->
	<dependency>
    		<groupId>com.github.white-sdev</groupId>
    		<artifactId>White_SeleniumFramework</artifactId>
    		<version>0.1.3</version>
	</dependency>
```



Alternatively you can manually import the .jar file into your project.
* Configuration.

Define your test cases or scenario classes by implementing TestCase in classes extending from TestCase 
```java
public class LoginApp implements AutomationScenario{
	//...
}
```

To run the scenarios you need to register your TestCases under TestSuite and then run them any time you need.
```
	AutomationSuite.registerAutomationScenario(new LoginApp());
	AutomationSuite.registerAutomationScenario(new MyTestCase());
	AutomationSuite.launchExecutions();
```

Some useful configuration you can establish on your project context [src/main/resources/<yourFileName>.properties on maven projects]
```
run.tests.chrome=true
run.tests.ie=true
run.tests.edge=true
run.tests.firefox=true
run.tests.opera=false
default-explicit-wait=5
maximize-on-open=true
close-on-error=false

#my custom websites
mywebsite.url=mywebsite.mydomain.com
```
You can just copy paste this into your project or edit it


* Dependencies.

this library uses 
- lombok to log errors and general logs.
	- Slf4j
- PropertiesManager to obtain the default properties values.
- White_Validations to validate parameters.

* Database configuration
None
* Deployment instructions
No need for those. Some working projects using this library are:
- [White_LoLPicker](https://github.com/white-sdev/White_LoLPicker)

### Contribution guidelines ###

* Writing tests.

Please do. Only some basic Unit testing is setup at the moment
* Code review.

Request if needed
* Other guidelines.

Ask for the code standard to use as guidelines and reflect them in here.

### Who do I talk to? ###

* Repo owner or admin.

owner - current main developer - obed.vazquez@gmail.com
* Other community or team contact.

Please contact me if you want to help, I'm developing and mantaining and supporting in general this project on my own with no help or support of anyone and any tip, comment, change or help in general is well received.

