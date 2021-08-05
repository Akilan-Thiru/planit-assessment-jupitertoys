package planit.testcases;

import planit.jupitertoys.base.CsvDataProviders;
import planit.jupitertoys.base.TestUtilities;
import planit.jupitertoys.pages.CartPage;
import planit.jupitertoys.pages.HomePage;
import planit.jupitertoys.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class TestCase3 extends TestUtilities {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void testcase3(Map<String, String> testData) {
		// Data
		String strEnvironment = testData.get("Environment");
		String[] arrItems = ((testData.get("Items")).split("\\|"));
		String[] arrQuantity = (testData.get("Quantity").split("\\|"));

		// Open Home page
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage(strEnvironment);

		// Navigate to Shop page
		ShopPage shopPage = new ShopPage(driver, log);
		shopPage.clickShopButton();

		// Purchase items
		for(int i=0; i<arrItems.length; i++){
			shopPage.buyItem(arrItems[i],Integer.parseInt(arrQuantity[i]));
		}

		// Navigate to cart
		CartPage cartPage = new CartPage(driver, log);
		cartPage.clickCartButton();

		//Verify the items in the cart
		for(int i=0; i<arrItems.length; i++){
			String actualItem = cartPage.getItemInCartTable(arrItems[i]);
			String expectedItem = arrItems[i];
			Assert.assertTrue(actualItem.equalsIgnoreCase(expectedItem), "Actual item of "+ arrItems[i]+" not same as expected item" +
					"\nExpected totals: "+ expectedItem + "\nActual totals: " + actualItem);

			String actualQuantity = cartPage.getItemQuantityInCartTable(arrItems[i]);
			String expectedQuantity = arrQuantity[i];
			Assert.assertTrue(actualQuantity.equalsIgnoreCase(expectedQuantity), "Actual quantity of "+ arrItems[i]+" not same as expected quantity" +
					"\nExpected totals: "+ expectedQuantity + "\nActual totals: " + actualQuantity);
		}
	}
}
