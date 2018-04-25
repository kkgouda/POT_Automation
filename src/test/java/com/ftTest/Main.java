package com.ftTest;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;

public class Main {

	public static void main(String[] args) {
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng = new TestNG();
		List<String> suites = Lists.newArrayList();
		suites.add("D:\\com.ft\\src\\test\\resources\\com\\ftSuite\\proposalSuite.xml");//path to xml..
		
		testng.setTestSuites(suites);
		
		testng.run();

	}

}
