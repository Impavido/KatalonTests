import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/*
 * Define xpaths
 */
def xpathHistoricData = '//a[contains(text(),\'Historische Daten\')]'
def xpathCurrencyName = '//h1[@class=\'details-panel-item--name\']'

/*
 * Create TestObjects
 */
TestObject toHistoricData = new TestObject('HD')
TestObject toCurrencyName = new TestObject('CurrencyName')

/*
 * Set xpath-property on the TestObjects
 */

List<TestObjectProperty> propsHD = new ArrayList<TestObjectProperty>()
propsHD.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathHistoricData))
toHistoricData.setProperties(propsHD)

List<TestObjectProperty> propsCN = new ArrayList<TestObjectProperty>()
propsCN.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathCurrencyName))
toCurrencyName.setProperties(propsCN)

/*
 * Url and additional initiatons
 */
def url = GlobalVariable.URL
List<TestObjectProperty> weekData = new ArrayList<TestObjectProperty>()
List<TestObjectProperty> dayData = new ArrayList<TestObjectProperty>()
def weekValueAtEnd = 0.0
def weekValueAtStart = 0.0
def currency = ''

//True if you want to see the increase this year
def final A_YEAR_AGO = false

//(0)If you want to check out BTC only, (1) if you want to check out XRP too, (2) if you want to check out a random one too
def final CHECK = 0

//Choose how many days into the past you want to go
def final DAYS_AGO = 7

/*
 * Create last X days query urls
 */
Date date = new Date()
DateFormat df = new SimpleDateFormat('yyyyMMdd')
def queryDate = '&end=' + df.format(date)
Calendar cal = new GregorianCalendar()
cal.add(Calendar.DAY_OF_MONTH, -DAYS_AGO)
Date sevenDaysAgo = cal.getTime()
queryDate = (('?start=' + df.format(sevenDaysAgo)) + queryDate)
def queryDateAYearAgo = ''

if(A_YEAR_AGO){
	cal = new GregorianCalendar()
	cal.add(Calendar.YEAR, -1)
	Date yearAgo = cal.getTime()
	queryDateAYearAgo = '?start=' + df.format(yearAgo) + '&end=' + df.format(yearAgo)
}

/*
 * Start test
 */
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebDriver webDriver = DriverFactory.getWebDriver()

WebElement table

List<WebElement> rows_table

for (def index : (0..CHECK)) {
	switch (index) {
		case 0:
			WebUI.navigateToUrl(GlobalVariable.URL_BTC)
			break
		case 1:
			WebUI.navigateToUrl(GlobalVariable.URL_XRP)
			break
		default:
			WebUI.navigateToUrl(GlobalVariable.URL)
			println("You didnt specify a currency so we navigated you to a random one.")
			
			WebElement currencyTable = webDriver.findElement(By.xpath('//table/tbody'))

			rows_table = currencyTable.findElements(By.tagName('tr'))
			
			def randomNumber = new Random().nextInt(rows_table.size())
			
			List<WebElement> columns = rows_table.get(randomNumber).findElements(By.tagName('td'))
			
			def strCurrency = columns.get(1).getText()
			
			def xpathRandomCurrency = '//a[@class=\'currency-name-container link-secondary\'][contains(text(),\'' + strCurrency + '\')]'
			
			TestObject toRandomCurrency = new TestObject('Currency')
			
			List<TestObjectProperty> propsCurrency = new ArrayList<TestObjectProperty>()
			propsCurrency.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathRandomCurrency))
			toRandomCurrency.setProperties(propsCurrency)
						
			if(randomNumber > 10){
				TestObject toScrollTo = new TestObject('ScrollTo')
			
				List<WebElement> columnsTemp = rows_table.get(randomNumber - 1).findElements(By.tagName('td'))
				def strScrollTo = columnsTemp.get(1).getText()
				
				def xpathScrollTo = '//a[@class=\'currency-name-container link-secondary\'][contains(text(),\'' + strScrollTo + '\')]'
				
				List<TestObjectProperty> propsScrollTo = new ArrayList<TestObjectProperty>()
				propsScrollTo.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathScrollTo))
				toScrollTo.setProperties(propsScrollTo)
				
				WebUI.scrollToElement(toScrollTo, 10)
			}
			
			WebUI.click(toRandomCurrency)
			break
	}

	currency = WebUI.getText(toCurrencyName)

	WebUI.click(toHistoricData)

	def historicUrl = WebUI.getUrl()

	def queryUrl = historicUrl + queryDate

	WebUI.navigateToUrl(queryUrl)

	table = webDriver.findElement(By.xpath('//table/tbody'))

	rows_table = table.findElements(By.tagName('tr'))

	def numberOfRows = rows_table.size()

	println('Number of rows are ' + numberOfRows)

	for(int row = 0; row < numberOfRows; row++){
		List<WebElement> columns_row = rows_table.get(row).findElements(By.tagName('td'))

		dayData.add(columns_row.get(0).getText())
		dayData.add(Double.parseDouble((columns_row.get(4).getText()).replace(',', '')))
		weekData.add(new ArrayList<TestObjectProperty>(dayData))
		dayData.clear()

		if(row == numberOfRows - 1){
			weekValueAtStart = weekData[row].get(1)
		}
	}

	weekValueAtEnd = weekData[0].get(1)

	double progressThisWeek = Math.round((((weekValueAtEnd * 100) / weekValueAtStart) - 100) * 10) / 10

	CustomKeywords.'CustomFunctions.highlight'('The increase of ' + currency + ' the last ' + DAYS_AGO + ' days was: ' + progressThisWeek + '%')

	List<TestObjectProperty> weeksAverageValues = new ArrayList<TestObjectProperty>()

	for (int i : (0 .. numberOfRows - 1)) {
		weeksAverageValues.add(weekData[i].get(1))
	}

	def weeksAverage = 0.0

	for (def d : weeksAverageValues) {
		weeksAverage += d
	}
	
	weeksAverage = (Math.round((weeksAverage / weeksAverageValues.size()) * 100) / 100)

	CustomKeywords.'CustomFunctions.highlight'('The average of ' + currency + ' the last ' + DAYS_AGO + ' days was: EUR ' + weeksAverage)

	if(A_YEAR_AGO){
		def queryAYearAgo = historicUrl + queryDateAYearAgo

		WebUI.navigateToUrl(queryAYearAgo)

		table = webDriver.findElement(By.xpath('//table/tbody'))

		rows_table = table.findElements(By.tagName('tr'))

		List<WebElement> columns_row = rows_table.get(0).findElements(By.tagName('td'))

		dayData.add(columns_row.get(0).getText())
		dayData.add(Double.parseDouble((columns_row.get(4).getText()).replace(',', '')))
		weekData.add(new ArrayList<TestObjectProperty>(dayData))
		dayData.clear()

		def yearValueAtStart = weekData[weekData.size()-1].get(1)

		double progressThisYear = Math.round((((weekValueAtEnd * 100) / yearValueAtStart) - 100) * 10) / 10

		CustomKeywords.'CustomFunctions.highlight'('Increase of ' + currency + ' this year was: ' + progressThisYear + '%')

	}

	weekData.clear()
}

println('Done')

WebUI.closeBrowser()
