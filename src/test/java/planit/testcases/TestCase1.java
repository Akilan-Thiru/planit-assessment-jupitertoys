package planit.testcases;

import planit.jupitertoys.base.CsvDataProviders;
import planit.jupitertoys.base.TestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import planit.jupitertoys.pages.ContactPage;
import planit.jupitertoys.pages.HomePage;

import java.util.Map;

public class TestCase1 extends TestUtilities {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void testcase1(Map<String, String> testData) {
		// Data
		String strEnvironment = testData.get("Environment");
		String strForename = testData.get("Forename");
		String strEmail = testData.get("Email");
		String strMessage = testData.get("Message");
		String expectedForenameErrorMessage = testData.get("expectedForenameErrorMessage");
		String expectedEmailErrorMessage = testData.get("expectedEmailErrorMessage");
		String expectedMessageErrorMessage = testData.get("expectedMessageErrorMessage");

		// Open Home page
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage(strEnvironment);

		// Navigate to Contact page
		ContactPage contactPage = new ContactPage(driver, log);
		contactPage.clickContactButton();

		// Click on Submit button in Contact page
		contactPage.clickSubmitButton();

		// Validate mandatory field errors
		contactPage.waitForForenameErrorMessage();
		String actualForenameErrorMessage = contactPage.getForenameErrorMessageText();
		Assert.assertTrue(actualForenameErrorMessage.equalsIgnoreCase(expectedForenameErrorMessage),"Actual Forename error" +
				"message is not same as expected\n Expected Subtotals: "+ expectedForenameErrorMessage + "\nActual Subtotals: " + actualForenameErrorMessage);

		contactPage.waitForEmailEErrorMessage();
		String actualEmailErrorMessage = contactPage.getEmailErrorMessageText();
		Assert.assertTrue(actualEmailErrorMessage.equalsIgnoreCase(expectedEmailErrorMessage),"Actual Forename error" +
				"message is not same as expected\n Expected Subtotals: "+ expectedEmailErrorMessage + "\nActual Subtotals: " + actualEmailErrorMessage);

		contactPage.waitForMessageErrorMessage();
		String actualMessageErrorMessageText = contactPage.getMessageErrorMessageText();
		Assert.assertTrue(actualMessageErrorMessageText.equalsIgnoreCase(expectedMessageErrorMessage),"Actual Forename error" +
				"message is not same as expected\n Expected Subtotals: "+ expectedMessageErrorMessage + "\nActual Subtotals: " + actualMessageErrorMessageText);

		// Populate mandatory fields
		contactPage.enterForename(strForename);
		contactPage.enterEmail(strEmail);
		contactPage.enterMessage(strMessage);

		// Validate errors are gone
		Assert.assertFalse(contactPage.getForenameVisibility(),"Forename is required error message displayed");
		Assert.assertFalse(contactPage.getEmailVisibility(),"Email is required error message displayed");
		Assert.assertFalse(contactPage.getMessageVisibility(),"Message is required error message displayed");
	}
}
