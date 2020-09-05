package com.syntax.class1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void before() {
	  System.out.println("This is before method");
  }
  @Test
  public void testMethod() {
	  System.out.println("This is actual test method");
  }
  @Test
  public void after() {
	  System.out.println("This is after method");
  }
}
