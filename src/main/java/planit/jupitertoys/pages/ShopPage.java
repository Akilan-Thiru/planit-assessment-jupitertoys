package planit.jupitertoys.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePageObject {

	private By btnShop = By.xpath(".//a[contains(text(),'Shop')]");
	private By btnTeddyBear = By.xpath(".//*[contains(text(),'Teddy Bear')]/following-sibling::*//a[text()='Buy']");
	private By btnStuffedFrog = By.xpath(".//*[contains(text(),'Stuffed Frog')]/following-sibling::*//a[text()='Buy']");
	private By btnHandmadeDoll = By.xpath(".//*[contains(text(),'Handmade Doll')]/following-sibling::*//a[text()='Buy']");
	private By btnFluffyBunny = By.xpath(".//*[contains(text(),'Fluffy Bunny')]/following-sibling::*//a[text()='Buy']");
	private By btnSmileyBear = By.xpath(".//*[contains(text(),'Smiley Bear')]/following-sibling::*//a[text()='Buy']");
	private By btnFunnyCow = By.xpath(".//*[contains(text(),'Funny Cow')]/following-sibling::*//a[text()='Buy']");
	private By btnValentineBear = By.xpath(".//*[contains(text(),'Valentine Bear')]/following-sibling::*//a[text()='Buy']");
	private By btnSmileyFace = By.xpath(".//*[contains(text(),'Smiley Face')]/following-sibling::*//a[text()='Buy']");
	private By strTeddyBearPrice = By.xpath(".//*[contains(text(),'Teddy Bear')]/following-sibling::*//*[contains(@class,'product-price')]");
	private By strStuffedFrogPrice = By.xpath(".//*[contains(text(),'Stuffed Frog')]/following-sibling::*//*[contains(@class,'product-price')]");
	private By strHandmadeDollPrice = By.xpath(".//*[contains(text(),'Handmade Doll')]/following-sibling::*//*[contains(@class,'product-price')]");
	private By strFluffyBunnyPrice = By.xpath(".//*[contains(text(),'Fluffy Bunny')]/following-sibling::*//*[contains(@class,'product-price')]");
	private By strSmileyBearPrice = By.xpath(".//*[contains(text(),'Smiley Bear')]/following-sibling::*//*[contains(@class,'product-price')]");
	private By strFunnyCowPrice = By.xpath(".//*[contains(text(),'Funny Cow')]/following-sibling::*//*[contains(@class,'product-price')]");
	private By strValentineBearPrice = By.xpath(".//*[contains(text(),'Valentine Bear')]/following-sibling::*//*[contains(@class,'product-price')]");
	private By strSmileyFacePrice = By.xpath(".//*[contains(text(),'Smiley Face')]/following-sibling::*//*[contains(@class,'product-price')]");

	public ShopPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open Shopping Page by clicking on Start Shopping button  */
	public void clickShopButton() {
		log.info("Clicking Shop button on Shop Page");
		click(btnShop);
	}

	public Double getItemPrice(String item){
		Double dblPrice;
		switch (item.toLowerCase()) {
			case "teddy bear":
				dblPrice = Double.parseDouble(find(strTeddyBearPrice).getText().replace("$","").trim());
				break;
			case "stuffed frog":
				dblPrice= Double.parseDouble(find(strStuffedFrogPrice).getText().replace("$","").trim());
				break;
			case "handmade doll":
				dblPrice = Double.parseDouble(find(strHandmadeDollPrice).getText().replace("$","").trim());
				break;
			case "fluffy bunny":
				dblPrice = Double.parseDouble(find(strFluffyBunnyPrice).getText().replace("$","").trim());
				break;
			case "smiley bear":
				dblPrice = Double.parseDouble(find(strSmileyBearPrice).getText().replace("$","").trim());
				break;
			case "funny cow":
				dblPrice = Double.parseDouble(find(strFunnyCowPrice).getText().replace("$","").trim());
				break;
			case "valentine bear":
				dblPrice = Double.parseDouble(find(strValentineBearPrice).getText().replace("$","").trim());
				break;
			case "smiley face":
				dblPrice = Double.parseDouble(find(strSmileyFacePrice).getText().replace("$","").trim());
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + item.toLowerCase());
		}
		return dblPrice;
	}

	/** Buy Teddy bear by clicking on Buy button */
	public void buyItem(String strItemName, int numItemCount) {
		log.info("Clicking "+strItemName+"'s Buy button to purchase "+numItemCount+" quantities on Shop Page");
		while(numItemCount > 0){
			switch (strItemName.toLowerCase()) {
				case "teddy bear":
					click(btnTeddyBear);
					break;
				case "stuffed frog":
					click(btnStuffedFrog);
					break;
				case "handmade doll":
					click(btnHandmadeDoll);
					break;
				case "fluffy bunny":
					click(btnFluffyBunny);
					break;
				case "smiley bear":
					click(btnSmileyBear);
					break;
				case "funny cow":
					click(btnFunnyCow);
					break;
				case "valentine bear":
					click(btnValentineBear);
					break;
				case "smiley face":
					click(btnSmileyFace);
					break;
			}
			numItemCount--;
		}
	}
}
