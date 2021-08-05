package planit.testcases;

import planit.jupitertoys.base.CsvDataProviders;
import planit.jupitertoys.base.TestUtilities;
import planit.jupitertoys.pages.ContactPage;
import planit.jupitertoys.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class TestCase2 extends TestUtilities {

	@Test(invocationCount = 5, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void testcase2(Map<String, String> testData) {
		// Data
		String strEnvironment = testData.get("Environment");
		String strForename = testData.get("Forename");
		String strEmail = testData.get("Email");
		String strMessage = testData.get("Message");

		// Open Home page
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage(strEnvironment);

		// Navigate to Contact page
		ContactPage contactPage = new ContactPage(driver, log);
		contactPage.clickContactButton();

		// Populate mandatory fields
		contactPage.enterForename(strForename);
		contactPage.enterEmail(strEmail);
		contactPage.enterMessage(strMessage);

		// Click on Submit button in Contact page
		contactPage.clickSubmitButton();

		// Verify success message
		Assert.assertTrue(contactPage.waitForSuccessMessage(),"Success message not displayed");
	}
}
