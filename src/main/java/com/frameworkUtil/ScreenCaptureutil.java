package com.frameworkUtil;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCaptureutil {

	public String captureScreen(WebDriver driver) {
		String fileWithPath = "\\screenShots\\" + System.currentTimeMillis() + ".png";
		String currentDirectoryFileWithPath = System.getProperty("user.dir")+fileWithPath;
		System.out.println(currentDirectoryFileWithPath);

		TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(currentDirectoryFileWithPath);
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return currentDirectoryFileWithPath;
	}

}
