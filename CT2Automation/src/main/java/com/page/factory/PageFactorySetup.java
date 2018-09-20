package com.page.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactorySetup {

	WebDriver driver;

	public PageFactorySetup(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	
	// Locators for method01Registration
	public void getURL01() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@FindBy(css = "input[id='email_create']")
	public WebElement fieldEmailAddress;

	@FindBy(css = ".button-medium.exclusive span")
	public WebElement buttonCreateAnAccount;

	@FindBy(css = "div[id='create_account_error']")
	public WebElement errorEmailAlreadyRegistered;

	@FindBy(css = "input[id='id_gender1']")
	public WebElement radioTitleMr;

	@FindBy(css = "input[id='customer_firstname']")
	public WebElement fieldFirstName;

	@FindBy(css = "input[id='customer_lastname']")
	public WebElement fieldLastName;

	@FindBy(css = "input[id='passwd']")
	public WebElement fieldPassword;

	@FindBy(css = "select[id='days']")
	public WebElement dropdownDays;

	@FindBy(css = "select[id='months']")
	public WebElement dropdownMonths;

	@FindBy(css = "select[id='years']")
	public WebElement dropdownYears;

	@FindBy(css = "input[id='newsletter']")
	public WebElement checkboxNewsletter;

	@FindBy(css = "input[id='optin']")
	public WebElement checkboxSpecialOffers;

	@FindBy(css = "input[id='firstname']")
	public WebElement fieldFirstNameAddress;

	@FindBy(css = "input[id='lastname']")
	public WebElement fieldLastNameAddress;

	@FindBy(css = "input[id='company']")
	public WebElement fieldCompany;

	@FindBy(css = "input[id='address1']")
	public WebElement fieldAddress1;

	@FindBy(css = "input[id='address2']")
	public WebElement fieldAddress2;

	@FindBy(css = "input[id='city']")
	public WebElement fieldCity;

	@FindBy(css = "select[id='id_state']")
	public WebElement dropdownState;

	@FindBy(css = "input[id='postcode']")
	public WebElement fieldZipPostalCode;

	@FindBy(css = "select[id='id_country']")
	public WebElement dropdownCountry;

	@FindBy(css = "textarea[id='other']")
	public WebElement fieldAdditonalInformation;

	@FindBy(css = "input[id='phone']")
	public WebElement fieldHomePhone;

	@FindBy(css = "input[id='phone_mobile']")
	public WebElement fieldMobilePhone;

	@FindBy(css = "input[id='alias']")
	public WebElement fieldAddressAlias;

	@FindBy(css = "button[id='submitAccount']")
	public WebElement buttonRegister;

	
	
	// Locators for method02Order
	public void getURL02() {
		driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
	}
	
	@FindBy(css = "img[src='http://automationpractice.com/img/p/8/8-home_default.jpg']")
	public WebElement imagePrintedDress1;
	
	@FindBy(css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line.hovered > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span")
	public WebElement buttonPrintedDress1AddToCart;

	@FindBy(css = "a[title='Proceed to checkout']")
	public WebElement buttonProceedToCheckout1;
	
	@FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium")
	public WebElement buttonProceedToCheckout2;
	
	@FindBy(css = "button[name='processAddress']")
	public WebElement buttonProceedToCheckout3;
	
	@FindBy(css = "input[id='cgv']")
	public WebElement checkboxTermsOfService;
	
	@FindBy(css = "button[name='processCarrier']")
	public WebElement buttonProceedToCheckout4;

	@FindBy(css = "a[class='bankwire']")
	public WebElement payByBankwire;

	@FindBy(css = "button[class='button btn btn-default button-medium']")
	public WebElement buttonIConfirmMyOrder;

	@FindBy(css = "a[title='Back to orders']")
	public WebElement backToOrders;
}