package com.syntax.class2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println(" ---- This is before suite annotation ----");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println(" ---- This is before test annotation ----");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println(" ---- This is before class annotation ----");
	}

	@BeforeMethod
	public void before() {
		System.out.println("This is before method");
	}

	@Test
	public void testMethod() {
		System.out.println("This is actual test method");
	}

	@AfterMethod
	public void after() {
		System.out.println("This is after method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println(" ---- This is after class annotation ---- ");
	}

	@AfterTest
	public void afterTest() {
		System.out.println(" ---- This is after test annotation ---- ");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println(" ---- This is after suite annotation ---- ");
	}
}