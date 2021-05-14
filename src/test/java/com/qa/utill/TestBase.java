package com.qa.utill;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public String propertiespath = "C:/Users/juhit/eclipse-workspace/Cucumber-PageObjectModel/src/test/java/com/qa/config/config.properties";

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(propertiespath);
			prop.load(fis);
		} catch (IOException e) {
			e.getMessage();
			// TODO: handle exception
		}
	}
	public static void initialization() {
		String browerName = prop.getProperty("browser");
		String driverPath = prop.getProperty("driverPath");

		if (browerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}
		if (browerName.equals("Iexplorer")) {
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void maximizeWindow() {
		System.out.println("Maximize window");
		driver.manage().window().maximize();
		
	}
	public static void teardown() {
		System.out.println("Close all active webdriver browsers");
		driver.quit();
	}
}
