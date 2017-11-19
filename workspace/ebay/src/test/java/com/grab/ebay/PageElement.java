package com.grab.ebay;

import java.util.List;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageElement {
//	@AndroidFindBy(id = "com.ebay.mobile:id/search_box")
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ebay.mobile:id/search_box\")")
	public AndroidElement search_box;
	
	@AndroidFindBy(id = "com.ebay.mobile:id/search_src_text")
	public AndroidElement search_src_text;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ebay.mobile:id/text\")")
    public List<AndroidElement> search_result;
    
	@AndroidFindBy(id = "com.ebay.mobile:id/button_sort")
	public AndroidElement sort;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ebay.mobile:id/button_filter_subelement\")")
    public List<AndroidElement> filter;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.ebay.mobile:id/cell_collection_item\")")
    public List<AndroidElement> items;

	@AndroidFindBy(id = "com.ebay.mobile:id/textview_item_price")
	public List<AndroidElement> prices;

	@AndroidFindBy(id = "com.ebay.mobile:id/button_watch")
	public AndroidElement watch;

	@AndroidFindBy(id = "com.ebay.mobile:id/sign_in_title")
	public AndroidElement sign_in_title;

	@AndroidFindBy(id = "com.ebay.mobile:id/button_close")
	public AndroidElement close;
	
	
}
