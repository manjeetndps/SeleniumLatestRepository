package com.training.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.common.utility.BasePage;

public class WidgetPage extends BasePage{
	
	public WidgetPage() {
		initialize();
	}
	
	@FindBy(xpath = "//a[text()='Widget']")
	private WebElement lnkWidget;
	
	@FindBy(xpath = "//a[text()='Slider']")
	public WebElement lnkSlider;
	
	@FindBy(xpath = "//div[@id='slider-range-max']/span")
	private WebElement btnSlider;
	
	@FindBy(xpath = "//a[text()='Tooltip']")
	public WebElement lnkTooltip;
	
	@FindBy(xpath = "//a[text()='Tooltips']")
	public WebElement btnTooltip;
	
	@FindBy(css = ".ui-tooltip-content")
	public WebElement txtTooltipContent;
	
	@FindBy(xpath = "//label[contains(text(), 'Minimum number of bedrooms:')]")
	private WebElement bedrooms;
	
	public WebElement getLnkWidget() {
		return lnkWidget;
	}

	public WebElement getLnkSlider() {
		return lnkSlider;
	}	
	
	public WebElement getBtnSlider() {
		return btnSlider;
	}
	
	public WebElement getLnkTooltip() {
		return lnkTooltip;
	}
	
	public WebElement getBtnTooltip() {
		return btnTooltip;
	}
	
	public WebElement getTooltipContent() {
		return txtTooltipContent;
	}
	
	public WebElement getBedrooms() {
		return bedrooms;
	}
}
