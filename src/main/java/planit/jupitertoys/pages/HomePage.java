package planit.jupitertoys.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

	private String pageJupiter1Url = "https://jupiter.cloud.planittesting.com/#/";
	private String pageJupiter2Url = "https://jupiter2.cloud.planittesting.com/#/shop";
	private By btnHome = By.xpath(".//a[contains(text(),'Home')]");
	private By btnStartShopping = By.xpath(".//a[contains(text(),'Start Shopping')]");

	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open HomePage with it's url */
	public void openPage(String strEnvironment) {

		switch (strEnvironment.toLowerCase()) {
			case "jupiter2":
				log.info("Opening page: " + pageJupiter2Url);
				openUrl(pageJupiter2Url);
				break;
			default:
				log.info("Opening page: " + pageJupiter1Url);
				openUrl(pageJupiter1Url);
		}
		log.info("Page opened!");
	}

	/** Open HomePage by clicking on Home button */
	public void clickHomeButton() {
		log.info("Clicking Home button on Home Page");
		click(btnHome);
	}

	/** Open Hopping Page by clicking on Start Shopping button */
	public void clickStartShoppingButton() {
		log.info("Clicking Start Shopping button on Home Page");
		click(btnStartShopping);
	}

}
