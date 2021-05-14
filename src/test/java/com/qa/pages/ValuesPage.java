package com.qa.pages;

import java.util.Currency;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.utill.TestBase;

public class ValuesPage extends TestBase {

	// initialize Page Objects
	public ValuesPage() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "lbl_val_1")
	private WebElement value1;
	@FindBy(how = How.ID, using = "lbl_val_2")
	private WebElement value2;
	@FindBy(how = How.ID, using = "lbl_val_3")
	private WebElement value3;
	@FindBy(how = How.ID, using = "lbl_val_4")
	private WebElement value4;
	@FindBy(how = How.ID, using = "lbl_val_5")
	private WebElement value;
	@FindBy(how = How.ID, using = "lbl_ttl_val")
	private WebElement totalBalance;
	@FindBy(how = How.ID, using = "txt_val_1")
	private WebElement textValue1;
	@FindBy(how = How.ID, using = "txt_val_2")
	private WebElement textValue2;
	@FindBy(how = How.ID, using = "txt_val_4")
	private WebElement textValue3;
	@FindBy(how = How.ID, using = "txt_val_5")
	private WebElement textValue4;
	@FindBy(how = How.ID, using = "txt_val_6")
	private WebElement TextVal6;
	@FindBy(how = How.ID, using = "txt_ttl_val")
	private WebElement texttotalBalance;

	// Method to verify the right count of values appear on the screen
	public int getRightCountOfValues() {
		List<WebElement> findValues = driver.findElements(By.xpath("//*[@id]"));
		int size = findValues.size();
		return size;
	}

	// Method to verify the values on the screen are greater than 0
	public boolean verifyAmountGreaterThanZero() {
		List<WebElement> textAmount = driver.findElements(By.xpath("//*[contains(@id,'txt_val')"));
		for (int i = 0; i < textAmount.size(); i++) {
			String value = textAmount.get(i).getAttribute("value");
			if (value.indexOf(i) == 0)
				return false;
		}
		return true;
	}

	// Method to verify the total balance is correct based on the values listed on
	// the screen
	public boolean verifyTotalBalance() {
		List<WebElement> amount = driver.findElements(By.xpath("//*[contains(@id,'txt_val')"));
		double sum = 0;
		for (int i = 0; i < amount.size(); i++) {
			String value = amount.get(i).getAttribute("value");
			sum = sum + Integer.parseInt(value);
			;
		}
		String totalBal = texttotalBalance.getText();
		double TotalinInt = Integer.parseInt(totalBal);
		if (TotalinInt == sum)
			return true;
		else
			return false;
	}

	// Method to verify the values are formatted as currencies
	public boolean verifyCurrencyOfValue() {
		List<WebElement> values = driver.findElements(By.xpath("//*[contains(@id,'txt_val')"));
		for (int i = 0; i < values.size(); i++) {
			String amount = values.get(i).getText();
			Currency currency = Currency.getInstance("USD");
			String symbol = currency.getSymbol();
			if (!(amount.startsWith(symbol)))
				return false;
		}
		return true;
	}

}
