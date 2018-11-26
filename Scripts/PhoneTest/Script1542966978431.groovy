import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

def xpathSearch = "//input[@id='q']"
def xpathCellChoice = "//nav[@id='navigation-area']//div//ul//li[1]//button[1]"
def xpathSortAfter = "/html/body/div[4]/div[2]/section/div/div/div[2]/div/div[3]/div[1]/div[3]/div/div[1]/div[2]/div/select"
def xpathSortAfterNewest = "/html/body/div[4]/div[2]/section/div/div/div[2]/div/div[3]/div[1]/div[3]/div/div[1]/div[2]/div"
def xpathBewertung = '''//span[@id='select2-jthh-container']'''

def xpathOptions = "/html/body/div[4]/div[2]/section/div/div/div[2]/div/div[3]/div[1]/div[3]/div/div[1]/div[2]/div/select/option"

//def xpathNeueste = '''//div[@id='filter-content']/div/div/div[2]/div/span/span/span/span'''
def xpathNeueste = '''//span[@id='select2-9q9y-container']'''

TestObject toSearch = new TestObject('Search')
TestObject toCellChoice = new TestObject('CellChoice')
TestObject toSortAfter = new TestObject('SortAfter')
TestObject toSortAfterNewest = new TestObject('SortAfterNewest')
TestObject toBewertung = new TestObject('ChoiceBewertung')
TestObject toNeueste = new TestObject('ChoiceNeueste')

TestObject toOption = new TestObject('ChoiceOption')

List<TestObjectProperty> props = new ArrayList<TestObjectProperty>()
props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathSearch))
toSearch.setProperties(props)

props = new ArrayList<TestObjectProperty>()
props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathCellChoice))
toCellChoice.setProperties(props)

props = new ArrayList<TestObjectProperty>()
props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathSortAfter))
toSortAfter.setProperties(props)

props = new ArrayList<TestObjectProperty>()
props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathSortAfterNewest))
toSortAfterNewest.setProperties(props)

props = new ArrayList<TestObjectProperty>()
props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathBewertung))
toBewertung.setProperties(props)

props = new ArrayList<TestObjectProperty>()
props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathNeueste))
toNeueste.setProperties(props)

props = new ArrayList<TestObjectProperty>()
props.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathOptions))
toOption.setProperties(props)

def vEP = false

/*
 * Test start
 */

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.digitec.ch/de/s1/producttype/mobiltelefon-24?tagIds=82')

WebUI.setText(toSearch, 'HTC U12')

WebUI.sendKeys(toSearch, Keys.chord(Keys.ENTER))

Thread.sleep(2000)

WebUI.click(toCellChoice)

if(vEP == true){
	WebUI.verifyElementPresent(toSortAfter, 10)
	
	WebUI.verifyElementPresent(toSortAfterNewest, 10)
	
	WebUI.verifyElementPresent(toOption, 10)
	
	WebUI.verifyElementPresent(toBewertung, 10)
	
	WebUI.verifyElementPresent(toNeueste, 10)
}


WebDriver webDriver = DriverFactory.getWebDriver()

Select options = new Select(webDriver.findElement(By.xpath(xpathSortAfter)))

//WebUI.click(toSortAfterNewest)

//WebUI.scrollToElement(toOption, 10)

//WebUI.waitForElementVisible(toOption, 10)

//select.selectByVisibleText('Bewertung')
options.selectByIndex(2)

WebUI.navigateToUrl('http://demo.guru99.com/test/newtours/register.php')
Select drpCountry = new Select(webDriver.findElement(By.name("country")));
drpCountry.selectByVisibleText("ANTARCTICA");
//drpCountry.selectByValue('ETHIOPIA')
//drpCountry.selectByIndex(30)

WebUI.navigateToUrl('http://jsbin.com/osebed/2')
Select fruits = new Select(webDriver.findElement(By.id("fruits")));
fruits.selectByVisibleText("Banana");
fruits.selectByIndex(1);

WebUI.closeBrowser()
