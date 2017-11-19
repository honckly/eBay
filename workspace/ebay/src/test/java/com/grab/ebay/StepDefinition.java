package com.grab.ebay;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;


@FixMethodOrder(MethodSorters.JVM)
public class StepDefinition extends BaseDefinition{
	private static final String KEYWORD = "iPhone X";
	@Test
	public void testSearch() {
		//search for keyword
		pageElement.search_box.click();
		pageElement.search_src_text.sendKeys(KEYWORD);
		pageElement.search_result.get(0).click();
		
		//sort search result
		pageElement.sort.click();
		pageElement.filter.get(1).click();
		
		//get first 'N' item prices
		firstNItemPrice(10,pageElement.items,pageElement.prices);
		
		//production
		pageElement.items.get(2).click();
		
		//click on 'watch'
		(new TouchAction(driver)).press(926, 1268).moveTo(0, -26).release().perform();
		pageElement.watch.click();
		
		//close sign in
		if(pageElement.sign_in_title.isDisplayed()){
			pageElement.close.click();
		}
	}
	
}
