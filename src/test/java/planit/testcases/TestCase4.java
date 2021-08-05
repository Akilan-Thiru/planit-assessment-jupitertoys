package planit.testcases;

import planit.jupitertoys.base.CsvDataProviders;
import planit.jupitertoys.base.TestUtilities;
import planit.jupitertoys.pages.CartPage;
import planit.jupitertoys.pages.HomePage;
import planit.jupitertoys.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Map;

public class TestCase4 extends TestUtilities {

	@Test(dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
	public void testcase4(Map<String, String> testData) {

		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);

		// Data
		String[] arrItems = ((testData.get("Items")).split("\\|"));
		String[] arrQuantity = (testData.get("Quantity").split("\\|"));

		// Open Home page
		HomePage homePage = new HomePage(driver, log);
		homePage.openPage();

		// Navigate to Shop page
		ShopPage shopPage = new ShopPage(driver, log);
		shopPage.clickShopButton();

		// Purchase items
		Double[] fltPrices = new Double[arrItems.length];
		for(int i=0; i<arrItems.length; i++){
			shopPage.buyItem(arrItems[i],Integer.parseInt(arrQuantity[i]));
			fltPrices[i] = shopPage.getItemPrice(arrItems[i]);
		}

		// Navigate to cart
		CartPage cartPage = new CartPage(driver, log);
		cartPage.clickCartButton();

		//Verify the price of each item/product
		for(int i=0; i<arrItems.length; i++){
			Double actualPrice = cartPage.getItemPriceInCartTable(arrItems[i]);
			Double expectedPrice = fltPrices[i];
			Assert.assertEquals(expectedPrice, actualPrice, "Actual price of "+ arrItems[i] +" not same as expected price\nExpected Price: "
					+ expectedPrice + "\nActual Price: " + actualPrice);
		}

		// Verify that each product’s sub total = product price * quantity
		double expectedTotal = 0.00d;
		for (String arrItem : arrItems) {
			Double actualPrice = cartPage.getItemPriceInCartTable(arrItem);
			Double actualQuantity = Double.parseDouble(cartPage.getItemQuantityInCartTable(arrItem));
			Double actualSubtotal = cartPage.getItemSubtotalInCartTable(arrItem);
			Double expectedSubtotal = actualPrice * actualQuantity;
			expectedTotal = expectedTotal + expectedSubtotal;
			df.format(expectedSubtotal);
			Assert.assertTrue(Double.compare(actualSubtotal, expectedSubtotal) == 0, "Actual Subtotal of "+ arrItems +" not same as expected " +
					"Subtotal\n Expected Subtotals: "+ expectedSubtotal + "\nActual Subtotals: " + actualSubtotal);
		}

		// Verify total = sum(sub totals)
		Double actualTotal = cartPage.getTotalInCartTable();
		df.format(expectedTotal);
		Assert.assertTrue(Double.compare(expectedTotal,actualTotal) == 0, "Actual total does not contain expected total\nExpected totals: "
				+ expectedTotal + " \nActual totals: " + actualTotal);
	}
}
