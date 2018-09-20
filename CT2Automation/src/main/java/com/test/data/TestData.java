package com.test.data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TestData {

	WebDriver driver;

	public TestData(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	

	// DATA
	public String emailAddressPart1 = "user";

	public String emailAddressPart2 = "@mail.com";

	public String firstName = "First";

	public String lastName = "Last";

	public String password = "password";

	public String company = "Company";

	public String address1 = "111 111st";

	public String address2 = "1A";

	public String city = "New York";

	public String zipPostalCode = "11111";

	public String additionalInformation = "Type additional information here";

	public String homePhone = "888-888-8888";

	public String mobilePhone = "555-555-5555";

	public String addressAlias = "MyAddress";
}