# White_SeleniumFramework
A Selenium Framework that will help to execute tests and functions faster and reduce the effort to access many sections Selenium related.

Just import the Maven Dependency Define your tests in classes extending from TestCase and launch the tests with 
```
		TestSuite.registerTest(new MyTestCase());
	    TestSuite.launchTests();
```

Some useful configuration you can establish on your project context [src/main/resources/<yourfile>.properties on maven projects]
```
run.tests.chrome=false
run.tests.ie=true
run.tests.edge=true
run.tests.firefox=true
run.tests.opera=false
default-explicit-wait=5
#implicit-wait:5
maximize-on-open=true
close-on-error=false
#you can use websites as properties in here
mywebsite.url=mywebsite.mydomain.com
```

You can also use the util methods for faster function execution and organization in your code.
```
	WebDriverUtils util = new WebDriverUtils(driver);
	driver.get(getProperty("mywebsite.url"));//mywebsite.url being the property you introduced in the properties
```

The library uses org.bitbucket.white_sdev.PropertiesManager dependencies to achieve this