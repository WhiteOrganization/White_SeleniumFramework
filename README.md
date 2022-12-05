# White_SeleniumFramework
A Selenium Framework that will help to execute tests and functions faster and reduce the effort to access many sections Selenium related.



### What is this repository for? ###

* Quick summary.

The framework will help you structure your classes and give you some EXTRA tools to automate your scenarios faster.
For example instead of doing this to click on the first element:
``` java
List<WebElement> divSimulatesButtons=webDriver.findElements(By.xpath("//*[text() = '"+text+"']"));
if(divSimulatesButtons !=null && divSimulatesButtons.size()>0){
	WebElement firstButton=divSimulatesButtons.get(0);
	firstButton.click();
}else{
	throw new RuntimeException("Button not found");
}
```

You can instead do :
```
util.clickText(text);
```
and will perform the same action.

The framework will force the structure of your classes to be ordered and encourage the use of its utility, but you can still use WebDriver methods by taking it from the util.
```
WebDriver webDriver=util.driver;
```

The framework will also take care of the entire configuration of the Drivers, you just need to specify what supported WebExplorers do you want to run your scenarios on.


* Version: [0.2.3](https://github.com/orgs/WhiteOrganization/packages) 

    This is still in development and some methods are being constantly added as they are used. Please help us by requesting those you need or need more detailed documentation.

### How do I get set up? ###

* Summary of set up.

look for the library on maven ([" White_SeleniumFramework"](https://github.com/orgs/WhiteOrganization/packages)) and [import the library into your project
by including it in your POM](https://maven.pkg.github.com/whiteorganization/white_seleniumframework).
```XML
	<!-- https://jitpack.io/#WhiteOrganization/White_SeleniumFramework -->
	<dependency>
    		<groupId>io.github.white-sdev</groupId>
    		<artifactId>white-selenium-framework</artifactId>
    		<version>0.2.3</version>
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
``` java
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
run.tests.browserless=false
default-explicit-wait=5
maximize-on-open=true
close-on-error=false

#my custom websites
mywebsite.url=mywebsite.mydomain.com
```
You can just copy and paste this into your project or edit it


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

## How to Deploy?
use [maven](https://spring.io/guides/gs/maven/) to release new version to any Dependency Repository.

### GitHub and JitPack (Not working)
You usually don't need to execute manually a release, configured GitHub actions will take care of the Build and release process.

### Sonatype - Nexus - Maven Central Repository
for SNAPSHOT's use:

	mvn clean deploy -D target=sonatype
For Releases use:

	mvn versions:set -DnewVersion=1.x.x -D target=sonatype
Followed by:

	mvn clean deploy -D target=sonatype
	mvn release:clean release:prepare -D target=sonatype
	mvn release:perform -D target=sonatype

## Contribution guidelines ###

* Writing tests.

Please do. Only some basic Unit testing is set up at the moment
* Code review.

Request if needed
* Other guidelines.

Ask for the code standard to use as guidelines and reflect them in here.

## Who do I talk to?

<table>
<thead><tr><th><b>Role</b></th> <th><b>Contact</b></th></tr></thead>
<tr><td>developer</td><td> <a href='mailto:obed.vazquez@gmail.com'>obed.vazquez@gmail.com</a></td></tr>
<tr><td>developer</td><td> <a href='mailto:marcela.nunez@gmail.com'>marcela.nunez@gmail.com</a></td></tr>
<tr><td>Supporters</td><td>we have supporters with knowledge on the setup process of the project only</td></tr>
<tr><td>Community</td><td> send us a message in <a href='http://discord.whiteweb.tech'> our Discord Server</a></td></tr>
</table>

>Please contact us if you want to help, we are developing, maintaining and supporting this project
on our own with no help or support of anyone and any tip, comment, change or help in general is well-received.
