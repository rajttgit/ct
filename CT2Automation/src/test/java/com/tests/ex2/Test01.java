/*
	This test covers both Registration and Order
*/

package com.tests.ex2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.factory.PageFactorySetup;
import com.test.data.TestData;

public class Test01 {

	WebDriver driver;
	PageFactorySetup ob1;
	TestData ob2;

	@BeforeTest
	public void setupBrowser() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ob1 = PageFactory.initElements(driver, PageFactorySetup.class);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void method01Registration() throws Exception {

		ob1.getURL01();
		Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account");

		ob2 = PageFactory.initElements(driver, TestData.class);

		// this section is needed to bypass the "email already registered error"
		int i = 7;
		ob1.fieldEmailAddress.sendKeys(ob2.emailAddressPart1 + i + ob2.emailAddressPart2);
		ob1.buttonCreateAnAccount.click();

		Thread.sleep(3000);

		if (driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {

			while (driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account")) {

				ob1.fieldEmailAddress.clear();
				i++;
				ob1.fieldEmailAddress.sendKeys(ob2.emailAddressPart1 + i + ob2.emailAddressPart2);
				ob1.buttonCreateAnAccount.click();
				Thread.sleep(3000);

				if (driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")) {

					break;
				}
			}
		} 
		else if (driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")) {

		} 
		else {

		}
		// section ends here

		ob1.radioTitleMr.click();
		ob1.fieldFirstName.sendKeys(ob2.firstName);
		ob1.fieldLastName.sendKeys(ob2.lastName);
		ob1.fieldPassword.sendKeys(ob2.password);

		Select sel = new Select(ob1.dropdownDays);
		sel.selectByIndex(1);
		sel = new Select(ob1.dropdownMonths);
		sel.selectByVisibleText("January ");
		sel = new Select(ob1.dropdownYears);
		sel.selectByValue("2018");

		ob1.checkboxNewsletter.click();
		ob1.checkboxSpecialOffers.click();
		ob1.fieldFirstNameAddress.sendKeys(ob2.firstName);
		ob1.fieldLastNameAddress.sendKeys(ob2.lastName);
		ob1.fieldCompany.sendKeys(ob2.company);
		ob1.fieldAddress1.sendKeys(ob2.address1);
		ob1.fieldAddress2.sendKeys(ob2.address2);
		ob1.fieldCity.sendKeys(ob2.city);
		
		sel = new Select(ob1.dropdownState);
		sel.selectByVisibleText("New York");
		
		ob1.fieldZipPostalCode.sendKeys(ob2.zipPostalCode);
		
		sel = new Select(ob1.dropdownCountry);
		sel.selectByValue("21");
		
		ob1.fieldAdditonalInformation.sendKeys(ob2.additionalInformation);
		ob1.fieldHomePhone.sendKeys(ob2.homePhone);
		ob1.fieldMobilePhone.sendKeys(ob2.mobilePhone);
		ob1.fieldAddressAlias.sendKeys(ob2.addressAlias);
		ob1.buttonRegister.click();

		Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
		Assert.assertEquals(driver.getTitle(), "My account - My Store");
	}

	@Test(priority = 2)
	public void method02Order() {

		ob1.getURL02();
		Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?id_category=8&controller=category");

		Actions act = new Actions(driver);
		act.moveToElement(ob1.imagePrintedDress1).perform();

		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(ob1.buttonPrintedDress1AddToCart));
		ob1.buttonPrintedDress1AddToCart.click();
		wait.until(ExpectedConditions.visibilityOf(ob1.buttonProceedToCheckout1));
		ob1.buttonProceedToCheckout1.click();
		ob1.buttonProceedToCheckout2.click();
		ob1.buttonProceedToCheckout3.click();
		ob1.checkboxTermsOfService.click();
		ob1.buttonProceedToCheckout4.click();
		ob1.payByBankwire.click();
		ob1.buttonIConfirmMyOrder.click();

		// This is storing the Order Reference which will then be used to Assert if the order is in Order History
		String orderReference = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div")).getText();
		orderReference = orderReference.substring(216, 225);

		ob1.backToOrders.click();

		String tableData = driver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]")).getText();
		Assert.assertEquals(orderReference, tableData);
	}
	
	@AfterTest
	public void quitBrowser() {
		driver.quit();
	}
}