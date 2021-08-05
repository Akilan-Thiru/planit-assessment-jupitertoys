package planit.jupitertoys.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

	private String pageUrl = "https://jupiter.cloud.planittesting.com/#/";

	private By btnHome = By.xpath(".//a[contains(text(),'Home')]");
	private By btnStartShopping = By.xpath(".//a[contains(text(),'Start Shopping')]");

	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	/** Open HomePage with it's url */
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
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
