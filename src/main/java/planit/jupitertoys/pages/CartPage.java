package planit.jupitertoys.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePageObject {

	private By btnCart = By.xpath(".//*[contains(@class,'shopping-cart')]");
	private By btnCheckOut = By.xpath(".//*[contains(@class,'btn-checkout')]");
	private By btnEmptyCart = By.xpath(".//a[contains(text(),'Empty Cart')]");
	private By btnCartTable = By.xpath(".//*[contains(@class,'table table-striped cart-items')]");
	private By strTotal = By.xpath(".//*[contains(@class,'total') and contains(text(),'Total:')]");

	public CartPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open Cart Page by clicking on Cart button  */
	public void clickCartButton() {
		log.info("Clicking Cart button on Cart Page");
		click(btnCart);
	}

	/** Clicking on Check out button */
	public void clickCheckOutButton() {
		log.info("Clicking Check out button on Cart Page");
		click(btnCheckOut);
	}

	/** Clicking on Empty Cart button */
	public void clickEmptyCartButton() {
		log.info("Clicking Empty cart button on Cart Page");
		click(btnEmptyCart);
	}

	/** Clicking on Empty Cart button */
	public String getItemInCartTable(String item) {
		return getTableData(btnCartTable,"Item",item);
	}

	/** Clicking on Empty Cart button */
	public String getItemQuantityInCartTable(String item) {
		return getTableData(btnCartTable,"Quantity",item);
	}

	/** Clicking on Empty Cart button */
	public Double getItemPriceInCartTable(String item) {
		Double fltPrice = Double.parseDouble(getTableData(btnCartTable,"Price",item).replace("$","").trim());
		return fltPrice;
	}

	/** Clicking on Empty Cart button */
	public Double getItemSubtotalInCartTable(String item) {
		Double dblSubtotal = Double.parseDouble(getTableData(btnCartTable,"Subtotal",item).replace("$","").trim());
		return dblSubtotal;
	}

	public Double getTotalInCartTable() {
		Double dblTotal = Double.parseDouble(find(strTotal).getText().replace("Total:","").trim());
		return dblTotal;
	}
}
