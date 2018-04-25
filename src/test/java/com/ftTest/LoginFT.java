package com.ftTest;

import org.openqa.selenium.By;
import org.testng.Reporter;

import com.frameworkUtil.ReporterUtil;


public class LoginFT {

	com.frameworkUtil.PropertiesUtil globalSettingsProperties;
	com.frameworkUtil.PropertiesUtil locatorsProperties;
	com.frameworkUtil.ExcelDataSheetUtil excelDataSheetUtil;
	com.frameworkUtil.ScreenCaptureutil screenCaptureutil;
	com.frameworkUtil.ReporterUtil reporterUtil;
	int invocationCount = 0;
	String scenarioName;
	int iterationCount = 0;
	int rowIncementor = 2;

	com.frameworkUtil.WebDriverUtil webDriver;
	org.openqa.selenium.WebDriver driver;

	@org.testng.annotations.BeforeSuite
	public void setup() {

		globalSettingsProperties = new com.frameworkUtil.PropertiesUtil("GlobalSettings.properties");

		locatorsProperties = new com.frameworkUtil.PropertiesUtil("Locators.properties");

		excelDataSheetUtil = new com.frameworkUtil.ExcelDataSheetUtil();

		scenarioName = this.getClass().getName();

		invocationCount = excelDataSheetUtil.getInvocationCountByRowCount(scenarioName);

		iterationCount = invocationCount;

		webDriver = new com.frameworkUtil.WebDriverUtil("chrome");

		driver = webDriver.getWebDriver(globalSettingsProperties.getPropertyValue("AppURL"));
		
		screenCaptureutil = new com.frameworkUtil.ScreenCaptureutil();
		reporterUtil = new com.frameworkUtil.ReporterUtil();
	}

	@org.testng.annotations.BeforeTest
	public void setInvocationCount(org.testng.ITestContext context) {
		org.testng.ITestNGMethod currentTestNGMethod = null;
		for (org.testng.ITestNGMethod testNGMethod : context.getAllTestMethods()) {
			if (testNGMethod.getInstance() == this) {
				currentTestNGMethod = testNGMethod;
				break;
			}
		}
		currentTestNGMethod.setInvocationCount(invocationCount);

	}

	@org.testng.annotations.Test 
	public void loginFT() throws Exception {

		driver.manage().window().maximize();
		while (iterationCount > 0) {

			// --------------------------------test logic goes here
			// -------------------------------------------------------------------------------------

			
			try {
				Thread.sleep(1200);
				driver.findElement(By.xpath(locatorsProperties.getPropertyValue("UserId")))
						.sendKeys(excelDataSheetUtil.getData("Username", rowIncementor));
				
				driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Passowrd")))
				.sendKeys(excelDataSheetUtil.getData("Password", rowIncementor));			
				Thread.sleep(500);
				driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Login"))).click();
				
				reporterUtil.updateReport(driver, "Scenario", "Login", "Pass");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	reporterUtil.updateReport(driver, "Scenario", "Login", "Fail");
			}
			
//			Thread.sleep(500);
//			System.out.println("</br>Kiran successfully loged in  "+ "<img src = \""+ screenCaptureutil.captureScreen(driver)+"\"/>");
//			String report = "</br><p>Kiran successfully loged in  </p>"+ "<img src=\""+ screenCaptureutil.captureScreen(driver)+"\"></img>";
//			Reporter.log(report);

			// --------------------------------test logic goes here
			// -------------------------------------------------------------------------------------

			--iterationCount;
			++rowIncementor;
		}

	}
	
}
