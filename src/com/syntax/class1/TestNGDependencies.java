package com.syntax.class1;
import org.testng.annotations.Test;

public class TestNGDependencies {

	@Test
	public void login() {
		System.out.println("Test that logges in into the application and has login steps");
	}
	
	@Test(dependsOnMethods="login")
	public void checkReport() {
		System.out.println("Test that checkes reports and has navigation to the report steps");
	}
}