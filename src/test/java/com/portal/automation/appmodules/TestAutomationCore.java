package com.portal.automation.appmodules;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.portal.automation.appException.DescriptionInterface;
import com.portal.automation.appException.ElementDescriptionReader;
import com.portal.automation.appException.TestAutomationElementNotFoundException;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;


public class TestAutomationCore  {
	public static  RemoteWebDriver driver;
	public static PropertyReader reader;
	static TestAutomationElementNotFoundException exception;
	protected String pageTitle;
	public DesiredCapabilities caps;

	public TestAutomationCore(Browser browser) throws Exception {
		
		if (driver == null) {
			try {
			driver = generateWebDriver(browser);
			}catch(Exception e) {
				System.out.println(e.toString());
			}
		System.out.println(driver.toString());
		}else if(Browser.FIREFOX_WIN.ordinal() == browser.ordinal() && !(driver instanceof FirefoxDriver)){
			driver = generateWebDriver(browser);
		}else if(Browser.CHROME_WIN.ordinal() == browser.ordinal() && !(driver instanceof ChromeDriver)){
			driver = generateWebDriver(browser);
			
		}else if(Browser.IE.ordinal() == browser.ordinal() && !(driver instanceof InternetExplorerDriver)){			
			driver = generateWebDriver(browser);		
			System.out.println(driver.toString());
		}else if(Browser.FIREFOX_MAC.ordinal() == browser.ordinal() && !(driver instanceof FirefoxDriver)){
			//To Do
		}else if(Browser.CHROME_MAC.ordinal() == browser.ordinal() && !(driver instanceof FirefoxDriver)){
			//To Do
		}else if(Browser.SAFARI_MAC.ordinal() == browser.ordinal() && !(driver instanceof FirefoxDriver)){
			//To Do
		}

	}
		@SuppressWarnings("deprecation")
		public RemoteWebDriver generateWebDriver(Browser browser) throws Exception{
		if(Browser.FIREFOX_WIN.ordinal() == browser.ordinal()){
			return new FirefoxDriver();
		}else if(Browser.CHROME_WIN.ordinal() == browser.ordinal()){
			try {
			File file = new File("C:\\Users\\IBM_ADMIN\\JAVA_Maven\\sampleMaven\\chromedriver_win32\\chromedriver.exe");
			System.out.println( file.getAbsolutePath());
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBM_ADMIN\\JAVA_Maven\\sampleMaven\\chromedriver_win32\\chromedriver.exe");	
			
			driver = new ChromeDriver();
			return driver;
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		}else if(Browser.IE.ordinal() == browser.ordinal()){
			try {
			File file = new File("C:\\Users\\IBM_ADMIN\\JAVA_Maven\\sampleMaven\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			return new InternetExplorerDriver();
			
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			
			
		} else if(Browser.FIREFOX_MAC.ordinal() == browser.ordinal()){
			return new FirefoxDriver();
		}else if(Browser.CHROME_MAC.ordinal() == browser.ordinal()){
			
			return new ChromeDriver();
		}else if(Browser.SAFARI_MAC.ordinal() == browser.ordinal()){
			return new SafariDriver();
		}
		return null;
	}

	
	public boolean isPageLoad(String pageTitle) throws TestAutomationException{
		return (driver.getTitle().contains(pageTitle));
	}
	
	public void openURL(String url) throws TestAutomationException{
		driver.get(url);
	}

	public static void quit() throws TestAutomationException{
		driver.quit();
		driver = null;
	}
	
	public void close() throws TestAutomationException{
		driver.close();
	}
	
	public static void maximiseBrowser() {
		driver.manage().window().maximize();
	}
	
	
	/*****locating a webelement using various locators *******/
	public static  WebElement getElementById(String key,String elementDescKey) throws TestAutomationException{
		try
		{
			
			WebElement ele = driver.findElement(By.id(key));
			System.out.println("The value of the element is :::: "+ele);
			if(ele== null) throw new WebDriverException();
		return ele;
		} catch(WebDriverException ex){
			
			throw new TestAutomationElementNotFoundException(key,"ID",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	
	public  List<WebElement> getElementsById(String key,String elementDescKey) throws TestAutomationException{
		try {
			List<WebElement> ele = driver.findElements(By.id(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;

		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"ID", ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	
	}


	
	public static  WebElement getElementByXpath(String key,String elementDescKey) throws TestAutomationException{
		List<WebElement> ele = getElementsByXpath(key,elementDescKey);
		if(ele==null){
			return null;
		}
        return ele.get(0);
 }
	
	public static  List<WebElement> getElementsByXpath(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> ele=null;
		try {
    	   System.out.println("Before exception ::::"+key);
   
      	  ele = driver.findElements(By.xpath(key));
      	  if(ele== null ||ele.isEmpty()) throw new WebDriverException();
            
            
        } catch(WebDriverException ex){
        	
        	throw new TestAutomationElementNotFoundException(key,"XPATH",ElementDescriptionReader.getReader().getProperties(elementDescKey));
        	
        }
		return ele;
  }
	
	public static  WebElement getElementByName(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{List<WebElement> ele = getElementsByName(key,elementDescKey);
		return ele.get(0);
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"NAME",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public static  List<WebElement> getElementsByName(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> ele = driver.findElements(By.name(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;

		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"NAME",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  WebElement getElementByCSS(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{List<WebElement> ele = getElementsByCSS(key,elementDescKey);
		return ele.get(0);
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"CSS",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  List<WebElement> getElementsByCSS(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> ele = driver.findElements(By.cssSelector(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;

		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"CSS",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  WebElement getElementByTag(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{List<WebElement> ele = getElementsByName(key,elementDescKey);
		return ele.get(0);
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"TAG",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  List<WebElement> getElementsByTag(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> ele = driver.findElements(By.tagName(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;

		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"TAG",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  WebElement getElementByPartialLinkText(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{List<WebElement> ele = getElementsByPartialLinkText(key,elementDescKey);
		if(ele== null ||ele.isEmpty()) return null;
		return ele.get(0);
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"PARTIAL_LINK",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  List<WebElement> getElementsByPartialLinkText(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> ele = driver.findElements(By.partialLinkText(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;

		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"PARTIAL_LINK",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  WebElement getElementByLinkText(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{List<WebElement> ele = getElementsByLinkText(key,elementDescKey);
		return ele.get(0);
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"LINK_TEXT",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  List<WebElement> getElementsByLinkText(String key,String elementDescKey) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> ele = driver.findElements(By.linkText(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"LINK_TEXT",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  WebElement getElementByTagOnObject(String key,String elementDescKey,WebElement obj) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{List<WebElement> ele = getElementsByTagOnObject(key,elementDescKey,obj);
		return ele.get(0);
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"TAG",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  List<WebElement> getElementsByTagOnObject(String key,String elementDescKey, WebElement obj) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> ele = obj.findElements(By.tagName(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"TAG",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  WebElement getElementByXpathOnObject(String key,String elementDescKey,WebElement obj) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try
		{List<WebElement> ele = getElementsByXpathOnObject(key,elementDescKey,obj);
		return ele.get(0);
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"XPATH",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public  List<WebElement> getElementsByXpathOnObject(String key,String elementDescKey, WebElement obj) throws TestAutomationException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			List<WebElement> ele = obj.findElements(By.xpath(key));
			if(ele== null ||ele.isEmpty()) throw new WebDriverException();
			return ele;
		} catch(WebDriverException ex){
			throw new TestAutomationElementNotFoundException(key,"XPATH",ElementDescriptionReader.getReader().getProperties(elementDescKey));
		}
	}
	
	public String getPageSource(){
		return driver.getPageSource();

	}


	public static void setImplicitlyWaitTime(int waitTimeInSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTimeInSeconds, TimeUnit.SECONDS);
	}

	public boolean isElementPresentById(String key,String elementDescKey){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(getElementById(key,elementDescKey)!=null)
				return true;
		}catch(TestAutomationException ex){
			ex.printStackTrace();
			//do nothing
		}
		return false;
	}

	public boolean isElementPresentByName(String key,String elementDescKey){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(getElementByName(key,elementDescKey)!=null)
				return true;
		}catch(TestAutomationException ex){
			ex.printStackTrace();
			//do nothing
		}
		return false;
	}

	public boolean isElementPresentByCSS(String key,String elementDescKey){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(getElementByCSS(key,elementDescKey)!=null)
				return true;
		}catch(TestAutomationException ex){
			ex.printStackTrace();
			//do nothing
		}
		return false;
	}

	public boolean isElementPresentByTag(String key,String elementDescKey){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(getElementByTag(key,elementDescKey)!=null)
				return true;
		}catch(TestAutomationException ex){
			ex.printStackTrace();
			//do nothing
		}
		return false;
	}

	public boolean isElementPresentByXpath(String key,String elementDescKey){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try{
			if(getElementByXpath(key, elementDescKey)!=null)
				return true;
		}catch(TestAutomationException ex){
			ex.printStackTrace();
			//do nothing
		}
		return false;
	}

	public void scrollPage(int x, int y){
		String arg = "scrollTo("+x+","+y+")";
		((JavascriptExecutor)driver).executeScript(arg);
	}
	

	/* To Select an option from DROPDOWN based on the Name of the Dropdown box */
	public void selectOptionFromDropDown(String dropdown, int index, String elementDescKey) throws TestAutomationException{
		Select sel = new Select(getElementByName(dropdown,elementDescKey));
		sel.selectByIndex(index);
	}

	public void selectOptionFromDropDownByID(String id, int index,String elementDescKey) throws TestAutomationException{
		Select sel = new Select(getElementById(id,elementDescKey));
		sel.selectByIndex(index);
	}

	public void selectOptionFromDropDownByID(String id, String text, String elementDescKey) throws TestAutomationException {
		Select sel = new Select(getElementById(id,elementDescKey));

		for (int i=0; i<sel.getOptions().size();i++){
			if ((sel.getOptions().get(i).getText()).equals(text)){
				sel.selectByVisibleText(text);
			}
		}
	}

	public static void selectSpecificOptionFromDropDown(String dropdown, String text, String elementDescKey) throws TestAutomationException{
		WebElement dropDownListBox = getElementByXpath(dropdown,elementDescKey);
		Select clickThis = new Select(dropDownListBox);
		//clickThis.selectByVisibleText(text);
		//System.out.println(".............Trying to selet drop down operation with text ="+text+"\n xpath = "+dropdown);
		clickThis.selectByVisibleText(text);		
		//System.out.println("-------------Successfully select drop down value --------------   :) ");
	}


	public int getListOfElementsUsingCSSSelector(String CSSSelector, String elementDescKey) throws TestAutomationException {
		List<WebElement> items = getElementsByCSS(CSSSelector,elementDescKey);
		return items.size();
	}

	public void selectOptionFromListUsingName(String dropdown, int index, String elementDescKey) throws TestAutomationException {
		List<WebElement> list = getElementsByName(dropdown, elementDescKey);
        list.get(index).click();
	}

	public void selectOptionFromListUsingID(String ID, int index, String elementDescKey) throws TestAutomationException {

		List<WebElement> list = getElementsById(ID, elementDescKey);
		list.get(index).click();

	}

	public void selectOptionFromListUsingCSS(String CSS, int index, String elementDescKey) throws TestAutomationException {
		List<WebElement> List = getElementsByCSS(CSS, elementDescKey);
		List.get(index).click();

	}
	
	public static void selectOptionFromRadioButton(String name, int index, String elementDescKey) throws TestAutomationException, InterruptedException {
	List<WebElement> radio = driver.findElements(By.name(name));
	radio.get(index).click();
	Thread.sleep(3000);
	}

	public String getLinkElementsInDiv(String ID, String elementDescKey) throws TestAutomationException  {
		String listOfElements = "";
		WebElement obj = getElementById(ID, elementDescKey);
		List<WebElement> list = getElementsByTagOnObject("a",elementDescKey,obj);
		int index = (list != null ? list.size():0);
		for (int x=0; x<index;x++) {
			listOfElements = listOfElements +((list.get(x).getText())+"\n");
		}

		return listOfElements;
	}

	public String truncateString(int charNum, String text){
		if( null == text )
			return text;
		if (text.length()<charNum)
			return text;

		return text.substring(0,charNum-1)+"...";

	}

	public void clickFirstElementInDiv(String ID, String elementDescKey) throws TestAutomationException  {
		WebElement obj = getElementById(ID, elementDescKey);
		List<WebElement> list =getElementsByTagOnObject("a",elementDescKey,obj);
        if (list!=null && !list.isEmpty()) {
		   list.get(0).click();
        }
	}

	public boolean selectValueFromListUsingVisibleText(int charNum,String ID, String visibleText, String elementDescKey) throws TestAutomationException  {

        WebElement obj = getElementById(ID,elementDescKey);

        List<WebElement> list = getElementsByTagOnObject("a",elementDescKey,obj);
        for (WebElement item : list){
            if(truncateString(charNum,visibleText).equals(item.getText())){
                item.click();
                return true;
                //break ;
            }
        }
        return false;
	}

	public boolean isValuePresentInTableUsingVisibleText(String key, String visibleText, String elementDescKey) throws TestAutomationException  {

        WebElement obj = getElementByXpath(key, elementDescKey);

        List<WebElement> list = getElementsByTagOnObject("td",elementDescKey,obj);
        for (WebElement item : list){
            if(visibleText.trim().equalsIgnoreCase(item.getText())){
                //item.click();
                return true;
                //break ;
            }
        }
        return false;
	}
	
	public WebElement getRowOfTableUsingVisibleText(String key, String visibleText, String elementDescKey) throws TestAutomationException {
		WebElement obj = getElementByXpath(key, elementDescKey);
		List<WebElement> tds = getElementsByTagOnObject("td",elementDescKey,obj);
		for (WebElement td : tds){
			if (visibleText.trim().equalsIgnoreCase(td.getText())) {
				WebElement tr =  getElementByXpathOnObject("./parent::*","",td);
				return tr;
			}

		}
		return null;

	}

	public void clickEnterKey(String name, String elementDescKey) throws TestAutomationException  {
		getElementByName(name,elementDescKey).sendKeys(Keys.RETURN);

	}

	/******Working with Alerts ********/
	public static boolean isAlertPresent() {
		if (driver.switchTo().alert()!=null){
		return true;
		}
		else return false;
	}

	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}
	
	public static void alertDismiss() {
		driver.switchTo().alert().dismiss();
	}
	
	public static String alertText() {
		return driver.switchTo().alert().getText();
	}
	
	/***** Working with popups & multiple browser windows *******/
	String homePage;
	public void homePage() {

		Set windows = driver.getWindowHandles();

		Iterator<String> itr = windows.iterator();

		homePage = itr.next();

	}

	public void secondPage() {
		for (String secondpage : driver.getWindowHandles()) {

			driver.switchTo().window(secondpage);

		}

	}
	
	public void returnToSecondPage(){
		secondPage();
	}

	public void returnToHomepage() {
			homePage();
			driver.switchTo().window(homePage);
	}




	/* Refreshing the page */
	public void PageRefresh() {
		driver.navigate().refresh();
	}


	/* Is the Element present in the DOM. */
	public boolean isCssElementPresent(String id){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			getElementByCSS(id,"");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	
	/*** entering texts in text box ****/
	public void sendTextByXpath(String xpath, String text, String elementDescKey) throws TestAutomationException {
        getElementByXpath(xpath,elementDescKey) .sendKeys(text);
	}

	public void sendTextByName(String name, String text, String elementDescKey) throws TestAutomationException{
		setImplicitlyWaitTime(5000);
        getElementByName(name,elementDescKey).sendKeys(text);
	}

	public void sendTextById(String id, String text, String elementDescKey) throws TestAutomationException{
         getElementById(id,elementDescKey).sendKeys(text);
	}




	public String getElementName(String name, String elementDescKey) throws TestAutomationException{
		WebElement element = getElementsByPartialText(name, elementDescKey);
		return element.getAttribute("name");

	}
	
	
	public WebElement getElementsByPartialText(String name, String elementDescKey) throws TestAutomationException{

        WebElement element = getElementsByPartialText(name,elementDescKey);
        element = getElementByXpathOnObject("./parent::*",elementDescKey,element);
        element = getElementByXpathOnObject("./parent::*",elementDescKey,element);
        element = getElementByTagOnObject("td",elementDescKey,element);
        element = getElementByTagOnObject("input",elementDescKey,element);
        return element;

	}

	/* Get the text displayed on the webpage based on various locators . */
	public String getTextByXpath(String xpath, String elementDescKey) throws TestAutomationException {
       
        String text = getElementByXpath(xpath,elementDescKey).getText();
        return text;
	}

	
	public String getTextByID(String id,String elementDescKey) throws TestAutomationException{//Need to handle null pointer exception---HOW???
		return getElementById(id, elementDescKey).getText();
		
	}

	public String getTextByName(String name,String elementDescKey) throws TestAutomationException{
        return getElementByName(name,elementDescKey).getText();
            
	}

	public String getAttributeByXpath(String xpath, String value,String elementDescKey) throws TestAutomationException {
		return getElementByXpath(xpath,elementDescKey).getAttribute(value);
		
	}

	/* Find the Link/Button and click */
	public static void clickElementByXpath(String xpath, String elementDescKey) throws TestAutomationException {
		getElementByXpath(xpath,elementDescKey).click();
	}

	public void clickElementByText(String text, String elementDescKey) throws TestAutomationException {
		getElementByPartialLinkText(text, elementDescKey).click();
	}

	public void clickElementByID(String id, String elementDescKey) throws TestAutomationException {
		getElementById(id,elementDescKey).click();
		
	}
	
	public void clickElementByLinkText(String linkText,String elementDescKey)  throws TestAutomationException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf((WebElement) getElementByLinkText(linkText, elementDescKey)));		
		getElementByLinkText(linkText, elementDescKey).click();
	}

	
	public void clickElementByName(String name,String elementDescKey)  throws TestAutomationException{
		getElementByName(name, elementDescKey).click();
	}
	
	public void clickElementByPartialLinkText(String key,String elementDescKey)  throws TestAutomationException{
		getElementByPartialLinkText(key, elementDescKey).click();
	}

	public String getListOfElementsInDiv(String ID, String elementDescKey) throws TestAutomationException { 
		String listOfElements = ""; 
		WebElement obj = getElementById(ID, elementDescKey); 
		List<WebElement> list = getElementsByTagOnObject("a", elementDescKey, obj); 
		int index = list.size(); 
		for (int x=0; x<index;x++) { 
			listOfElements = listOfElements +((list.get(x).getText())+"\n"); 
		} 

		return listOfElements; 
		}


	public boolean isElementPresentInDiv(int charNum,String ID, String visibleText, String elementDescKey ) throws TestAutomationException { 
	WebElement obj = getElementById(ID, elementDescKey); 
	
	List<WebElement> list = getElementsByTagOnObject("a", elementDescKey, obj); 
	for (WebElement item : list){ 
	if(truncateString(charNum,visibleText).equals(item.getText())){ 
		return true; 
	
	} 
	
	} 
	return false; 
	}
    
    
	/*** hovering over web elements ***/
	/*
	 * public void hoverByXpath(String menu , String item) throws
	 * TestAutomationException{
	 * 
	 * Actions action = new Actions(driver); WebElement webElement =
	 * getElementByXpath(menu, DescriptionInterface.MENU); WebElement webElement1 =
	 * getElementByXpath(item, DescriptionInterface.MENU_ITEM);
	 * action.moveToElement(webElement).perform();
	 * action.moveToElement(webElement1).click().perform();
	 * 
	 * }
	 * 
	 * 
	 * public void hoverByID(String menu , String item) throws
	 * TestAutomationException{
	 * 
	 * Actions action = new Actions(driver); WebElement webElement =
	 * getElementById(menu, DescriptionInterface.MENU); WebElement div =
	 * getElementById("showEditOption",""); List<WebElement> links =
	 * getElementsByTagOnObject("a", "", div); WebElement webElement1= null ; for
	 * (WebElement ele : links) { if (ele.getText().equalsIgnoreCase(item)) {
	 * webElement1 = ele; } } if(webElement1==null){ return; }
	 * action.moveToElement(webElement).perform();
	 * action.moveToElement(webElement1).click().perform();
	 * 
	 * }
	 */
    /** Returns the page title */
	public String getTitle() {
		return pageTitle;
	}
	/**
	 * Check if page is loaded by comparing the expected page-title with an
	 * actual page-title.
	 * @throws TestAutomationException 
	 **/
	public boolean isPageLoad() throws TestAutomationException {
		return isPageLoad(pageTitle);
	}
	
	
}
