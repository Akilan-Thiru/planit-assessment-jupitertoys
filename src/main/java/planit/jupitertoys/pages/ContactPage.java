package planit.jupitertoys.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePageObject {

//	private String pageUrl = "https://jupiter.cloud.planittesting.com/#/";

	private By btnContact = By.xpath(".//a[contains(text(),'Contact')]");
	private By txtForename = By.id("forename");
	private By txtSurname = By.id("surname");
	private By txtEmail = By.id("email");
	private By txtTelephone = By.id("telephone");
	private By txtMessage = By.id("message");
	private By btnSubmit = By.xpath(".//a[text()='Submit']");
	private By txtForenameError = By.id("forename-err");
	private By txtEmailError = By.id("email-err");
	private By txtMessageError = By.id("message-err");
	private By txtSuccessMsg = By.xpath(".//*[@class='alert alert-success']");
	private By btnBack = By.xpath(".//*[@class='btn' and contains(text(),'Back')]");

	public ContactPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open Contact Page by clicking on Contact button */
	public void clickContactButton() {
		log.info("Clicking Contact button on toolbar");
		click(btnContact);
	}

	/** Enter Fore name on Forename text field in Conatct page */
	public void enterForename(String forename) {
		log.info("Enter Fore name [" + forename + "] in Contact page");
		type(forename, txtForename);
	}

	/** Enter Fore name on Forename text field in Conatct page */
	public void enterSurname(String surname) {
		log.info("Enter Fore name [" + surname + "] in Contact page");
		type(surname, txtSurname);
	}
	/** Enter Fore name on Forename text field in Conatct page */
	public void enterEmail(String email) {
		log.info("Enter Fore name [" + email + "] in Contact page");
		type(email, txtEmail);
	}
	/** Enter Fore name on Forename text field in Conatct page */
	public void enterTelephone(String telephone) {
		log.info("Enter Fore name [" + telephone + "] in Contact page");
		type(telephone, txtTelephone);
	}
	/** Enter Fore name on Forename text field in Conatct page */
	public void enterMessage(String message) {
		log.info("Enter Fore name [" + message + "] in Contact page");
		type(message, txtMessage);
	}

	/** Open Contact Page by clicking on Contact button */
	public void clickSubmitButton() {
		log.info("Clicking Submit button on Contact page");
		click(btnSubmit);
	}

	/** Wait for error message to be visible on the page */
	public void waitForForenameErrorMessage() {
		waitForVisibilityOf(txtForenameError, 5);
	}

	public String getForenameErrorMessageText() {
		return find(txtForenameError).getText();
	}

	/** Wait for error message to be visible on the page */
	public void waitForEmailEErrorMessage() {
		waitForVisibilityOf(txtEmailError, 5);
	}

	public String getEmailErrorMessageText() {
		return find(txtEmailError).getText();
	}

	/** Wait for error message to be visible on the page */
	public void waitForMessageErrorMessage() {
		waitForVisibilityOf(txtMessageError, 5);
	}

	public String getMessageErrorMessageText() {
		return find(txtMessageError).getText();
	}

	public Boolean getForenameVisibility(){ return isElementVisible(txtForenameError);}
	public Boolean getEmailVisibility(){ return isElementVisible(txtEmailError);}
	public Boolean getMessageVisibility(){ return isElementVisible(txtMessageError);}

	public void clickBackButton() {
		log.info("Clicking Back button on Contact success page");
		click(btnBack);
	}

	/** Wait for error message to be visible on the page */
	public Boolean waitForSuccessMessage() {return isElementVisible(txtSuccessMsg,30);}

}
