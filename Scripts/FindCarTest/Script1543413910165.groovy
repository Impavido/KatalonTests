import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def xpath_ExtendedSearch = '''//*[@id="ExtendedSearch"]'''
def xpath_Price = '''//div[@id="PriceTo"]/div[@class="select-button"]'''
//def xpath_Price = "//div[@id='PriceTo']//span[@class='icon']"
def xpath_KM = "//div[@id='KmFrom']//span[@class='icon']"
def xpath_Year = '//div[@id="YearFrom"]'
def xpath_PS = '//div[@id="HpFrom"]'
def xpath_MFK = '//*[@id="BitwiseProperties1"]'

def xpath_StartSearch = '//*[@id="lnkSearchBig"]'

def xpath_CHFSearch = '''//div[starts-with(@id,"Price")]//li[@data-value="15000"]'''
//def xpathCHFSearch = '''//div[@class="select-options-overlay"]//li[@class="option" and text()="CHF 15'000"]'''


TestObject to_ExtSearch = getTestObjectWithProperties(xpath_ExtendedSearch, 'Extended Search')
TestObject to_Price = getTestObjectWithProperties(xpath_Price, 'Price')
TestObject to_KM = getTestObjectWithProperties(xpath_KM, 'KM')
TestObject to_Year = getTestObjectWithProperties(xpath_Year, 'Year')
TestObject to_PS = getTestObjectWithProperties(xpath_PS, 'PS')
TestObject to_MFK = getTestObjectWithProperties(xpath_MFK, 'MFK')

TestObject to_StartSearch = getTestObjectWithProperties(xpath_StartSearch, 'Search')
TestObject to_CHFSearch = getTestObjectWithProperties(xpath_CHFSearch, 'CHFSearch')

WebUI.openBrowser('https://www.autoscout24.ch/de')

WebUI.click(to_ExtSearch)

WebUI.verifyElementPresent(to_StartSearch, 10)
WebUI.verifyElementPresent(to_CHFSearch, 10)

//WebUI.click(to_Price)

//WebUI.click(to_CHFSearch)
//WebUI.sendKeys(to_CHFSearch, Keys.chord(Keys.DOWN))

WebUI.navigateToUrl('https://www.autoscout24.ch/de/auto/suche?allmakes=1&hpfrom=180&kmto=150000&priceto=15000&prop=1&st=2&vehtyp=10&yearfrom=2010')
WebUI.click(to_StartSearch)

WebDriver driver = DriverFactory.getWebDriver()
//Actions action = new Actions(driver);
//WebElement optionsList = driver.findElement(By.xpath('//ul[@class="select-options"]'));
//action.moveToElement(optionsList);

//List<WebElement> options = driver.findElements(By.xpath('//div[starts-with(@id,"Price")]//li[@class="option"]'));
//def number = 1
//for(WebElement option : options) {
//	println(number++)
//	println(option.getAttribute('data-value'))
//	if (option.getAttribute('data-value').equals('15000')) {
//		option.sendKeys(Keys.chord(Keys.ENTER))
//	}
//}


WebUI.closeBrowser()


def getTestObjectWithProperties(String xpath, String objectName){
	
	List<TestObjectProperty> props = new ArrayList<TestObjectProperty>()
	props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpath))
	TestObject to = new TestObject(objectName)
	to.setProperties(props)
	
	return to
}
