package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="Project1.StepDefinitions",
monochrome=true,plugin= {"html:target/cucmber.html"}) //asking cucmber to run that particular feature file with given stepdefinitions file using glue, which tyoe of report under plugin
public class TestNGtestrunner extends AbstractTestNGCucumberTests {

}
