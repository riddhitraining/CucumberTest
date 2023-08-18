package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{
	
	@Before (order=1)
	public void beforescenario() {
		System.out.println("This will run before the scenario");
	}
	@Before (order=0)
	public void beforescenariostarts() {
		System.out.println("-----------starts--------------");
	}
	
	@After (order=0)
	public void afterscenarioends() {
		System.out.println("----------ends----------------");
	}
	@After (order=1)
	public void afterscenario() {
		System.out.println("This will run after the scenario");
	}
	
}