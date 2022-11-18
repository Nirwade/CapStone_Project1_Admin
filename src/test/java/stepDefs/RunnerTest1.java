package stepDefs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"html:target/html-cucumbers", "json:target/cucumber.json"},

features= "src/test/java/featuress",

tags = {"@Sanity"},

glue = {"stepDefs"}
	
		)
public class RunnerTest1 {

	
	
}
