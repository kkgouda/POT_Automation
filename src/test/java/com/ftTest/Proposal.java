package com.ftTest;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import freemarker.core.DirectiveCallPlace;

public class Proposal {

	com.frameworkUtil.PropertiesUtil globalSettingsProperties;
	com.frameworkUtil.PropertiesUtil locatorsProperties;
	com.frameworkUtil.ExcelDataSheetUtil excelDataSheetUtil;
	com.frameworkUtil.ReporterUtil reporterUtil;

	int invocationCount = 0;
	String scenarioName;
	int iterationCount = 0;
	int rowIncementor = 2;

	String businesstype = "None";
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

		webDriver = new com.frameworkUtil.WebDriverUtil();

		driver = webDriver.getWebDriver();

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
	public void proposal() throws Exception {

		
		
		while (iterationCount > 0) {

			// --------------------------------test logic goes here
			// -------------------------------------------------------------------------------------

			// Product

			//try {
				try {
					
						
					String MOTOR = excelDataSheetUtil.getData("Product", rowIncementor);

					if (MOTOR.equalsIgnoreCase("MOTOR")) {
						WebDriverWait wait=new WebDriverWait(driver,30);							
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Motro"))).click();
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("Motro"))));	
							
						
					} else if (MOTOR.equalsIgnoreCase("SME")) {
						WebDriverWait wait=new WebDriverWait(driver,30);			
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Sme"))).click();
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("Sme"))));
     				}
					
					reporterUtil.updateReport(driver, "Scenario", "Product", "Pass");
				
				} catch (Exception e2) {
					
					e2.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Product", "Fail");
				}

				// Types of Product

				try {
					
					//WebDriverWait wait=new WebDriverWait(driver,30);
					String typesofproduct = excelDataSheetUtil.getData("Types of Product", rowIncementor);

					if (typesofproduct.equalsIgnoreCase("CAR")) {
						Thread.sleep(500);
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Car"))).click();
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("Car"))));
						
					} else if (typesofproduct.equalsIgnoreCase("Two Wheeler")) {
						Thread.sleep(500);
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TwoWheeler"))).click();
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("TwoWheeler"))));
						
					} else if (typesofproduct.equalsIgnoreCase("PCV")) {
						Thread.sleep(500);
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("pcv"))).click();
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("pcv"))));
						
					} else if (typesofproduct.equalsIgnoreCase("GCV")) {
						Thread.sleep(500);
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("gcv"))).click();
						//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("gcv"))));
						
					}
					
					reporterUtil.updateReport(driver, "Scenario", "Types of Product", "Pass");
					
				} catch (Exception e2) {
					
					e2.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Types of Product", "Fail");
				}

				// Business Type
				boolean flag1 = false;

				businesstype = excelDataSheetUtil.getData("Bysiness Type", rowIncementor);
				if (businesstype.equalsIgnoreCase("RollOver")) {
					flag1 = true;
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RollOver"))).click();
				}

				else if (businesstype.equalsIgnoreCase("New Business")) {
					
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NewBusiness"))).click();
				}

				// Proposal and Vehicle

				Thread.sleep(2000);
				

				try {
					WebDriverWait wait=new WebDriverWait(driver,50);
					
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Aadhaarno1")))
							.sendKeys(excelDataSheetUtil.getData("Aadhaar no.1", rowIncementor));
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("Aadhaarno1"))));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Aadhaarno2")))
							.sendKeys(excelDataSheetUtil.getData("Aadhaar no.2", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Aadhaarno3")))
							.sendKeys(excelDataSheetUtil.getData("Aadhaar no.3", rowIncementor));

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("FirstName")))
							.sendKeys(excelDataSheetUtil.getData("First Name", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("LastName")))
							.sendKeys(excelDataSheetUtil.getData("Last Name", rowIncementor));

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("MobileNo")))
							.sendKeys(excelDataSheetUtil.getData("Mobile No", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("EmailId")))
							.sendKeys(excelDataSheetUtil.getData("Email Id", rowIncementor));

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegsNo1")))
							.sendKeys(excelDataSheetUtil.getData("Regs. No.1", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegsNo2")))
							.sendKeys(excelDataSheetUtil.getData("Regs. No.2", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegsNo3")))
							.sendKeys(excelDataSheetUtil.getData("Regs. No.3", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegsNo4")))
							.sendKeys(excelDataSheetUtil.getData("Regs. No.4", rowIncementor));

					new Select(
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("VehicleRegisteredInTheNameOf"))))
									.selectByVisibleText(
											excelDataSheetUtil.getData("Vehicle Registered In The Name Of", rowIncementor));
					new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ManufacturingYear"))))
							.selectByVisibleText(excelDataSheetUtil.getData("Manufacturing Year", rowIncementor));

					if (businesstype.equalsIgnoreCase("New Business")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegdDate"))).click();

						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TodayDate"))).click();

					} else if (businesstype.equalsIgnoreCase("RollOver")) {

						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegdDate"))).click();
						// driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TodayDate"))).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegMonthYear"))).click();
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RegYear"))).click();

						List<WebElement> allYear = driver.findElements(By.xpath(
								"//div[@class='datepicker-years']/table/thead/tr/th[3]/parent::*/parent::*/parent::*/tbody/tr/td/span"));

						for (WebElement ele : allYear) {

							String date = ele.getText();

							if (date.equalsIgnoreCase(excelDataSheetUtil.getData("Year", rowIncementor))) {
								ele.click();
								break;
							}

						}

						List<WebElement> allmonth = driver.findElements(
								By.xpath("//div[@class='datepicker-months']/table/thead/parent::*/tbody/tr/td/span"));

						for (WebElement ele : allmonth) {

							String date = ele.getText();

							if (date.equalsIgnoreCase(excelDataSheetUtil.getData("Month", rowIncementor))) {
								ele.click();
								break;
							}

						}
						List<WebElement> allday = driver.findElements(
								By.xpath("//div[@class='datepicker-days']/table/thead/tr[2]/parent::*/parent::*/tbody/tr/td"));

						for (WebElement ele : allday) {

							String date = ele.getText();

							if (date.equalsIgnoreCase(excelDataSheetUtil.getData("Day", rowIncementor))) {
								ele.click();
								break;
							}

						}

					}

					// Make
					Select mf = new Select(
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ManufacturerName"))));
					String mfn = excelDataSheetUtil.getData("Manufacturer Name", rowIncementor);
					mf.selectByVisibleText(mfn);

					// Model
					Select md = new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Model"))));
					String mdn = excelDataSheetUtil.getData("Model Name", rowIncementor);
					md.selectByVisibleText(mdn);

					// Sub Model
					Thread.sleep(5000);
					Select sm = new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("SubModel"))));
					String smn = excelDataSheetUtil.getData("Sub Model Name", rowIncementor);
					sm.selectByVisibleText(smn);

					Thread.sleep(1000);
					if (businesstype.equalsIgnoreCase("New Business")) {
						Thread.sleep(1000);
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PolicyStartdate"))).click();
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TodayDate"))).click();

					} else if (businesstype.equalsIgnoreCase("RollOver")) {

						Select pic = new Select(
								driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Previousinsurercompany"))));
						String picv = excelDataSheetUtil.getData("Previous insurer company", rowIncementor);
						pic.selectByVisibleText(picv);

						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PreviouspolicyExpDate"))).click();

						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TodayDate"))).click();

						// ((JavascriptExecutor)driver).executeScript("document.querySelector('input[name=prevPolicyExpDate]').setAttribute('value','20/12/2017')");

						String WasthecarOwnershipchangedinthepast12months = excelDataSheetUtil
								.getData("Was the car Ownership \n" + "changed in the past 12 months?", rowIncementor);
						String Wasthereanyclaiminlastyear = excelDataSheetUtil
								.getData("Was there any \n" + "claim in last year", rowIncementor);

						String yWasthecarOwnershipchangedinthepast12months = excelDataSheetUtil
								.getData("Was the car Ownership \n" + "changed in the past 12 months?", rowIncementor);
						String yWasthereanyclaiminlastyear = excelDataSheetUtil
								.getData("Was there any \n" + "claim in last year", rowIncementor);

						if (WasthecarOwnershipchangedinthepast12months.equalsIgnoreCase("No")) {
							driver.findElement(By
									.xpath(locatorsProperties.getPropertyValue("NWasthecarOwnershipchangedinthepast12months")))
									.click();
						} else {
							driver.findElement(By
									.xpath(locatorsProperties.getPropertyValue("YWasthecarOwnershipchangedinthepast12months")))
									.click();
						}

						if (Wasthereanyclaiminlastyear.equalsIgnoreCase("No")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NWasthereanyclaiminlastyear")))
									.click();
							Select nc = new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NCB"))));
							String ncb = excelDataSheetUtil.getData("NCB", rowIncementor);
							nc.selectByVisibleText(ncb);
						}

						else {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("YWasthereanyclaiminlastyear")))
									.click();
						}

					}

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("CalculatePremium"))).click();
				
					reporterUtil.updateReport(driver, "Scenario", "Proposal Information", "Pass");
					
				} catch (Exception e1) {
					
					e1.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Proposal Information", "Fail");
				}

				TimeUnit.SECONDS.sleep(30);

				// WebDriverWait wait=new WebDriverWait(driver,30);
				// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div/div[2]/div/div/div/div/div/form/div[6]/div/div/div[2]/div/div[13]/div/span[2]")));
				
				//WebDriverWait wait = new WebDriverWait(driver, 50);
				driver.findElement(By.xpath(locatorsProperties.getPropertyValue("MoreAddon"))).click();
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorsProperties.getPropertyValue("MoreAddon"))));
				
				// Additional

				try {
					
					String bifuel = excelDataSheetUtil.getData("Bi Fuel Kit", rowIncementor);
					String Unnamedpassinger = excelDataSheetUtil.getData("UnNamed Passenger", rowIncementor);

					// Addon

					String consumble = excelDataSheetUtil.getData("CONSUMABLES", rowIncementor);
					String DAILYALLOWANCE = excelDataSheetUtil.getData("DAILY ALLOWANCE", rowIncementor);
					String EMERGENCYTRANSPORTANDHOTELEXPENSES = excelDataSheetUtil
							.getData("EMERGENCY TRANSPORT \n" + "AND HOTEL EXPENSES", rowIncementor);
					String ENGINEPROTECT = excelDataSheetUtil.getData("ENGINE PROTECT", rowIncementor);
					String EYREPLACEMENT = excelDataSheetUtil.getData("KEY REPLACEMENT", rowIncementor);
					String NCBProtect = excelDataSheetUtil.getData("NCB PROTECT", rowIncementor);
					String PERSONALBELONGING = excelDataSheetUtil.getData("PERSONAL BELONGING", rowIncementor);
					String REPAIROFGLASSPLASTICFIBERANDRUBBERGLASS = excelDataSheetUtil
							.getData("REPAIR OF GLASS, PLASTIC FIBER AND RUBBER GLASS", rowIncementor);
					String RETURNTOINVOICE = excelDataSheetUtil.getData("RETURN TO INVOICE", rowIncementor);
					String ROADSIDEASSISTANCE = excelDataSheetUtil.getData("ROAD SIDE ASSISTANCE", rowIncementor);
					String TYRE = excelDataSheetUtil.getData("TYRE", rowIncementor);
					String ZERODEPRECIATION = excelDataSheetUtil.getData("ZERO DEPRECIATION", rowIncementor);

					// Discount

					String ANTITHEFTDISCOUNTAddon = excelDataSheetUtil.getData("ANTI THEFT DISCOUNT", rowIncementor);

					// Recalculate

					String Recalculate = excelDataSheetUtil.getData("Re-Calculate", rowIncementor);

					if (bifuel.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BiFuelKit"))).click();
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BiFuelKitAmountClear"))).clear();
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BiFuelKitAmount")))
								.sendKeys(excelDataSheetUtil.getData("Bi Fuel Kit Amount", rowIncementor));
					}
					TimeUnit.SECONDS.sleep(5);
					if (Unnamedpassinger.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("UnNamedPassenger"))).click();
						new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("UnNamedPassengerAmt"))))
								.selectByVisibleText(excelDataSheetUtil.getData("UnNamed Passenger Amt", rowIncementor));

					}

					// Addon

					

					if (consumble.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Consumables"))).click();
					}
					if (DAILYALLOWANCE.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("DailyAllowance"))).click();
					}
					if (EMERGENCYTRANSPORTANDHOTELEXPENSES.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("EMERGENCYTRANSPORTANDHOTELEXPENSES")))
								.click();
						new Select(driver.findElement(
								By.xpath(locatorsProperties.getPropertyValue("EMERGENCYTRANSPORTANDHOTELEXPENSESAmt"))))
										.selectByVisibleText(excelDataSheetUtil
												.getData("EMERGENCY TRANSPORT \n" + "AND HOTEL EXPENSES Amt.", rowIncementor));
					}
					if (ENGINEPROTECT.equalsIgnoreCase("Yes")) {
						// flag=true;
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ENGINEPROTECT"))).click();
					}
					if (EYREPLACEMENT.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("EYREPLACEMENT"))).click();
					}
					if (NCBProtect.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NCBProtect"))).click();
					}
					if (PERSONALBELONGING.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PERSONALBELONGING"))).click();
						new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PERSONALBELONGINGAmt"))))
								.selectByVisibleText(excelDataSheetUtil.getData("PERSONAL BELONGING Amt.", rowIncementor));
					}
					if (REPAIROFGLASSPLASTICFIBERANDRUBBERGLASS.equalsIgnoreCase("Yes")) {
						driver.findElement(
								By.xpath(locatorsProperties.getPropertyValue("REPAIROFGLASSPLASTICFIBERANDRUBBERGLASS")))
								.click();
					}
					if (RETURNTOINVOICE.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RETURNTOINVOICE"))).click();
					}
					if (ROADSIDEASSISTANCE.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ROADSIDEASSISTANCE"))).click();
					}
					if (TYRE.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TYRE"))).click();
					}
					if (ZERODEPRECIATION.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ZERODEPRECIATION"))).click();
					}

					// Discount

					if (ANTITHEFTDISCOUNTAddon.equalsIgnoreCase("Yes")) {
						Thread.sleep(500);
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ANTITHEFTDISCOUNTAddon"))).click();
					}

					// Recalculate

					if (Recalculate.equalsIgnoreCase("Yes")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ReCalculate"))).click();
					}
					
					reporterUtil.updateReport(driver, "Scenario", "Addon", "Pass");
					
				} catch (Exception e1) {
					
					e1.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Addon", "Fail");
				}

				// Different Insurer PremiumBreakup

				TimeUnit.SECONDS.sleep(30);
				try {
					
					String PremiumBreakup = excelDataSheetUtil.getData("Premium  Breakup", rowIncementor);

					if (PremiumBreakup.equalsIgnoreCase("Bharti Axa")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BhartiAxaPremiumBreakup"))).click();
					} else if (PremiumBreakup.equalsIgnoreCase("HDFC")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("GDFCPremiumBreakup"))).click();
					} else if (PremiumBreakup.equalsIgnoreCase("ICICI")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ICICIPremiumBreakup"))).click();
					} else if (PremiumBreakup.equalsIgnoreCase("Kotak")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("KootakPremiumBreakup"))).click();
					} else if (PremiumBreakup.equalsIgnoreCase("Reliance")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ReliancePremiumBreakup"))).click();
					} else if (PremiumBreakup.equalsIgnoreCase("RS")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RSPremiumBreakup"))).click();
					} else if (PremiumBreakup.equalsIgnoreCase("TATA")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TATAAIGPremiumBreakup"))).click();
					} else if (PremiumBreakup.equalsIgnoreCase("New India")) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NEWIndiaAssurancePremiumBreakup")))
								.click();
					}

					Actions action = new Actions(driver);
					action.moveToElement(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BasicCovers"))))
							.build().perform();
					action.sendKeys(Keys.PAGE_DOWN).perform();
					Thread.sleep(3000);
					action.sendKeys(Keys.PAGE_UP).perform();

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Close"))).click();
					
					reporterUtil.updateReport(driver, "Scenario", "Premium Breakup", "Pass");
				
				} catch (Exception e1) {
					
					e1.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Premium Breakup", "Fail");
				}

				// Different Insurer Premium
				
				 //boolean flag=false;
				try {
					String InsurerPremium = excelDataSheetUtil.getData("Insurer Premium", rowIncementor);

					if (InsurerPremium.equalsIgnoreCase("Bharti Axa")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BhartiAxaAmount"))).click();
						String BhartiAxaAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BhartiAxaAmount"))).getText();
						String BhartiAxaIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BhartiAxaIDV"))).getAttribute("value");
						System.out.println("BhartiAxa Amount is " + BhartiAxaAmount );
						System.out.println("BhartiAxa IDV is " + BhartiAxaIDV);
					} else if (InsurerPremium.equalsIgnoreCase("HDFC")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("HDFCAmount"))).click();
						String HDFCAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("HDFCAmount"))).getText();
						String HDFCIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("HDFCIDV"))).getAttribute("value");
						System.out.println("HDFC Amount is " + HDFCAmount );
						System.out.println("HDFC IDV is " + HDFCIDV);
					} else if (InsurerPremium.equalsIgnoreCase("ICICI")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ICICIAmount"))).click();
						String ICICIAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ICICIAmount"))).getText();
						String ICICIIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ICICIIDV"))).getAttribute("value");
						System.out.println("ICICIA Amount is " + ICICIAmount );
						System.out.println("ICICI IDV is " + ICICIIDV);
					} else if (InsurerPremium.equalsIgnoreCase("Kotak")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("KotakAmount"))).click();
						String KotakAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("KotakAmount"))).getText();
						String KotakIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("KotakIDV"))).getAttribute("value");
						System.out.println("Kotak Amount is " + KotakAmount );
						System.out.println("Kotak IDV is " + KotakIDV);
					} else if (InsurerPremium.equalsIgnoreCase("Reliance")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RelianceAmount"))).click();
						String RelianceAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RelianceAmount"))).getText();
						String RelianceIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RelianceIDV"))).getAttribute("value");
						System.out.println("Reliance Amount is " + RelianceAmount );
						System.out.println("Reliance IDV is " + RelianceIDV);
					} else if (InsurerPremium.equalsIgnoreCase("RS")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RSAmount"))).click();
						String RSAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RSAmount"))).getText();
						String RSIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RSIDV"))).getAttribute("value");
						System.out.println("RS Amount is " + RSAmount );
						System.out.println("RS IDV is " + RSIDV);
					} else if (InsurerPremium.equalsIgnoreCase("TATA")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TATAAIGAmount"))).click();
						String TATAAIGAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TATAAIGAmount"))).getText();
						String TATAAIGIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TATAAIGIDV"))).getAttribute("value");
						System.out.println("TATA AIG Amount is " + TATAAIGAmount );
						System.out.println("TATA AIG IDV is " + TATAAIGIDV);
					} else if (InsurerPremium.equalsIgnoreCase("New India")) {
						
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NEWIndiaAssuranceAmount"))).click();
						String NEWIndiaAssuranceAmount=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NEWIndiaAssuranceAmount"))).getText();
						String NEWIndiaAssuranceIDV=driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NEWIndiaAssuranceIDV"))).getAttribute("value");
						System.out.println("NEWIndia Assurance Amount is " + NEWIndiaAssuranceAmount );
						System.out.println("NEWIndia Assurance IDV is " + NEWIndiaAssuranceIDV);
					}
					
					reporterUtil.updateReport(driver, "Scenario", "Premium Amount", "Pass");
					
				} catch (Exception e2) {
					
					e2.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Premium Amount", "Fail");
				}

				// Was add on cover existing in previous year policy?

				String ROADSIDEASSISTANCE2 = excelDataSheetUtil.getData("ROAD SIDE ASSISTANCE2", rowIncementor);
				String CONSUMABLES2 = excelDataSheetUtil.getData("CONSUMABLES2", rowIncementor);
				String ENGINEPROTECT2 = excelDataSheetUtil.getData("ENGINE PROTECT2", rowIncementor);
				String ZERODEPRECIATION2 = excelDataSheetUtil.getData("ZERO DEPRECIATION2", rowIncementor);
				String REPAIROFGLASSPLASTICFIBERANDRUBBERGLASS2 = excelDataSheetUtil
						.getData("REPAIR OF GLASS, PLASTIC FIBER AND RUBBER GLASS2", rowIncementor);
				String KEYREPLACEMENT2= excelDataSheetUtil.getData("KEY REPLACEMENT2", rowIncementor);
				String BuyNow = excelDataSheetUtil.getData("Buy Now", rowIncementor);

				// if(flag) {

				
					try {
						if (ROADSIDEASSISTANCE2.equalsIgnoreCase("No")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RSAN"))).click();
						} 
						else if (ROADSIDEASSISTANCE2.equalsIgnoreCase("Yes")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RSAY"))).click();
						}

						if (CONSUMABLES2.equalsIgnoreCase("No")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("CONN"))).click();
						} 
						else if (CONSUMABLES2.equalsIgnoreCase("Yes")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("CONY"))).click();
						}
						if (KEYREPLACEMENT2.equalsIgnoreCase("No")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("KCYN"))).click();
						} 
						else if (KEYREPLACEMENT2.equalsIgnoreCase("Yes")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("KCY"))).click();
						}
						if (ENGINEPROTECT2.equalsIgnoreCase("No")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("EngPrctN"))).click();
						} 
						else if (ENGINEPROTECT2.equalsIgnoreCase("Yes")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("EngPrctY"))).click();
						}
						if (ZERODEPRECIATION2.equalsIgnoreCase("No")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ZDYN"))).click();
						} 
						else if (ZERODEPRECIATION2.equalsIgnoreCase("Yes")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ZDY"))).click();
						}
						if (REPAIROFGLASSPLASTICFIBERANDRUBBERGLASS2.equalsIgnoreCase("No")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RGN"))).click();
						} 
						else if (REPAIROFGLASSPLASTICFIBERANDRUBBERGLASS2.equalsIgnoreCase("Yes")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RGY"))).click();
						}
					
						reporterUtil.updateReport(driver, "Scenario", "Was any Previous Addon", "Pass");
						
					} catch (Exception e1) {
						
						e1.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Was any Previous Addon", "Fail");
					}
					
					
										
					try {
						if (BuyNow.equalsIgnoreCase("Yes")) {
							driver.findElement(By.xpath(locatorsProperties.getPropertyValue("BuyNow"))).click();

						}
						
						
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
				

				Thread.sleep(20000);
			
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("IaccepttheTermsandconditionsofservice")))
							.click();
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Online"))).click();
				
				

				// Proposal Information

				Thread.sleep(15000);
				try {
					new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Title"))))
							.selectByVisibleText(excelDataSheetUtil.getData("Title", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Address1")))
							.sendKeys(excelDataSheetUtil.getData("Address1", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Address2")))
							.sendKeys(excelDataSheetUtil.getData("Address2", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Address3")))
							.sendKeys(excelDataSheetUtil.getData("Address3", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("City")))
							.sendKeys(excelDataSheetUtil.getData("City", rowIncementor));
					Thread.sleep(200);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Area")))
							.sendKeys(excelDataSheetUtil.getData("Area", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PinCode")))
							.sendKeys(excelDataSheetUtil.getData("Pin code", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Pancardno")))
							.sendKeys(excelDataSheetUtil.getData("Pan card no.", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("AltMobno")))
							.sendKeys(excelDataSheetUtil.getData("Alt Mob no.", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Stdcode")))
							.sendKeys(excelDataSheetUtil.getData("Std code", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("TelephoneNo")))
							.sendKeys(excelDataSheetUtil.getData("Telephone No.", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("AltEmailid")))
							.sendKeys(excelDataSheetUtil.getData("Alt Email id", rowIncementor));
					Thread.sleep(500);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PropNext"))).click();
				
					reporterUtil.updateReport(driver, "Scenario", "Proposal", "Pass");
					
				} catch (Exception e) {
					
					e.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Proposal", "Fail");
				}

				// Vehicle Information
				Thread.sleep(5000);
				try {
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("EngineNo")))
							.sendKeys(excelDataSheetUtil.getData("Engine No.", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ChassisNo")))
							.sendKeys(excelDataSheetUtil.getData("Chassis No.", rowIncementor));

					if (flag1) {
						driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PreviousPolicyNo")))
								.sendKeys(excelDataSheetUtil.getData("Previous Policy No", rowIncementor));
					}
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Checkboxox1"))).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("VehiNext"))).click();
				
					reporterUtil.updateReport(driver, "Scenario", "Vehicle", "Pass");
					
				} catch (Exception e) {
					
					e.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Vehicle", "Fail");
				}

				// Nominee and FinanceInformation
				Thread.sleep(3000);

				try {
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Nomineeename")))
							.sendKeys(excelDataSheetUtil.getData("Nominee e_name.", rowIncementor));

					Thread.sleep(500);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NomineeDOB"))).click();
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ExactDate1"))).click();

					new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("RelationAme"))))
							.selectByVisibleText(excelDataSheetUtil.getData("Relation Ame.", rowIncementor));

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("GuardianName")))
							.sendKeys(excelDataSheetUtil.getData("Guardian Name.", rowIncementor));

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Gdob"))).click();
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("ExactDate2"))).click();

					new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("GuardianElation"))))
							.selectByVisibleText(excelDataSheetUtil.getData("Guardian Elation.", rowIncementor));

					new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("FinancierYpe"))))
							.selectByVisibleText(excelDataSheetUtil.getData("Financier Ype.", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("CityName")))
							.sendKeys(excelDataSheetUtil.getData("City y.", rowIncementor));
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("FinancierName")))
							.sendKeys(excelDataSheetUtil.getData("Financier Ame.", rowIncementor));

					Thread.sleep(1200);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NomnNext"))).click();
				
					reporterUtil.updateReport(driver, "Scenario", "Nominee", "Pass");
				
				} catch (Exception e) {
					
					e.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Nominee", "Fail");
				}

				try {
					Thread.sleep(20000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PayNext"))).click();
				
					reporterUtil.updateReport(driver, "Scenario", "Inspection", "Pass");
				} catch (Exception e) {
					
					e.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Inspection", "Fail");
				}

				try {
					Thread.sleep(20000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("OnlinePayment"))).click();

					// Payment
					Thread.sleep(5000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("MaincontentRbCCaenue"))).click();
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("MaincontentBtnpayNow"))).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("NetBanking"))).click();

					new Select(driver.findElement(By.xpath(locatorsProperties.getPropertyValue("SelectBank"))))
							.selectByVisibleText("AvenuesTest");

					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("MakePayment"))).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Marchent"))).click();
					
					
					reporterUtil.updateReport(driver, "Scenario", "Payment", "Pass");
					
				} catch (Exception e) {
					
					e.printStackTrace();reporterUtil.updateReport(driver, "Scenario", "Payment", "Fail");
				}
				
				try {
					Thread.sleep(4000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("UploadFile"))).click();

					Screen sc = new Screen();
					sc.click("D:\\com.ft\\SikuliScreen\\Disc_D.png");
					sc.click("D:\\com.ft\\SikuliScreen\\FileName.png");
					sc.paste("D:\\com.ft\\SikuliScreen\\cheque.png");
					sc.click("D:\\com.ft\\SikuliScreen\\Open1.png");

					Thread.sleep(2000);
					driver.findElement(By.xpath(locatorsProperties.getPropertyValue("Submit"))).click();
					Thread.sleep(15000);
					String PolicyNo = driver.findElement(By.xpath(locatorsProperties.getPropertyValue("PolicyNo"))).getText();
					System.out.println(PolicyNo);
					
					reporterUtil.updateReport(driver, "Scenario", "Quote", "Pass");
					
				} catch (Exception e) {
					
					e.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Quote", "Fail");
				}

			
		
			try {
				driver.findElement(By.xpath(locatorsProperties.getPropertyValue("HomeButton"))).click();
				reporterUtil.updateReport(driver, "Scenario", "Home", "Pass");
			} catch (Exception e) {
				
				e.printStackTrace(); reporterUtil.updateReport(driver, "Scenario", "Home", "Fail");
			}

			// --------------------------------test logic goes here
			// -------------------------------------------------------------------------------------

			--iterationCount;
			++rowIncementor;
		}

	}

}
