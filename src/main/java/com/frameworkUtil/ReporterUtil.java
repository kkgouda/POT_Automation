package com.frameworkUtil;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ReporterUtil {
	com.frameworkUtil.ScreenCaptureutil screenCaptureutil = new com.frameworkUtil.ScreenCaptureutil();

	public void updateReport(WebDriver driver, String testScenario, String value, String status) {
		String screenShot = screenCaptureutil.captureScreen(driver);
		String report = "<table style=\"width: 100%\" border=\"0\">" + "<tr>" + "<td>" + testScenario + "</td>" + "<td>"
				+ value + "</td>"
				+"<td>"+status+"</td>"
				+ "<td align=\"right\"><a href=\"" + screenShot + "\" target=\"_blank\">" + "<img src=\"" + screenShot + "\""
				+ "style=\"width: 100px; height: 100px;\" ></img></a></td>" + "</tr>" + "</table>";

		Reporter.log(report);

	}

}
