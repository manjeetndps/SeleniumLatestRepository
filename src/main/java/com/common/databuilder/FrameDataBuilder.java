package com.common.databuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FrameDataBuilder {
	
	private By by;
	private WebElement element;
	private String attribute;
	private String attributeValue;
	private int frameIndex;
	private String frameName;
	private boolean isByIndex;

	public FrameDataBuilder(By by , String attribute, String attributeValue) {
        super();
        by = null;
		element = null;
		attribute = null;
		attributeValue = null;
		frameIndex = 0;
    }
	
	public By getBy() {
		return by;
	}
	
	public boolean isByIndex() {
		return isByIndex;
	}

	public void setByIndex(boolean isByIndex) {
		this.isByIndex = isByIndex;
	}

	public void setBy(By by) {
		this.by = by;
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	public int getFrameIndex() {
		return frameIndex;
	}

	public void setFrameIndex(int frameIndex) {
		this.frameIndex = frameIndex;
	}

	public String getFrameName() {
		return frameName;
	}

	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}
}
	
