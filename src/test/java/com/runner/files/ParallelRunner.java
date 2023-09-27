package com.runner.files;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\Mumi17\\ProjectClass\\CucumberAug\\src\\test\\java\\com\\feature\\files\\Parallel.feature", 
				 glue="com.stepdefinition.files")	
public class ParallelRunner extends AbstractTestNGCucumberTests{

	@DataProvider(parallel=true)
	public Object[][] scenario(){
		return super.scenarios();
	}
}
