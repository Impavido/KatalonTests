import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat

import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/*
 * Define xpaths
 */
def xpathBTC = '//tr[@id=\'id-bitcoin\']//a[@class=\'currency-name-container link-secondary\'][contains(text(),\'Bitcoin\')]'
def xpathXRP = '//a[@class=\'currency-name-container link-secondary\'][contains(text(),\'XRP\')]'
def xpathHistoricData = '//a[contains(text(),\'Historische Daten\')]'
def xpathReportRange = '//*[@id="reportrange"]'
def xpathLast7Days = '//li[@data-range-key=\'Letzte 7 Tage\']'
def xpathCurrencyName = '//h1[@class=\'details-panel-item--name\']'

def DateDay1 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr/td'
def DateDay2 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[2]/td'
def DateDay3 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[3]/td'
def DateDay4 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[4]/td'
def DateDay5 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[5]/td'
def DateDay6 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[6]/td'
def DateDay7 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[7]/td'
def ValueDay1 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr/td[5]'
def ValueDay2 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[2]/td[5]'
def ValueDay3 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[3]/td[5]'
def ValueDay4 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[4]/td[5]'
def ValueDay5 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[5]/td[5]'
def ValueDay6 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[6]/td[5]'
def ValueDay7 = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr[7]/td[5]'

def DateAYearAgo = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr/td'
def ValueAYearAgo = '//div[@id=\'historical-data\']/div/div[2]/table/tbody/tr/td[5]'

/*
 * Create TestObjects
 */
TestObject toBTC = new TestObject('BTC')
TestObject toXRP = new TestObject('XRP')
TestObject toHistoricData = new TestObject('HD')
TestObject toReportRange = new TestObject('RR')
TestObject toLast7Days = new TestObject('L7D')
TestObject toCurrencyName = new TestObject('CurrencyName')

TestObject toDateDay1 = new TestObject('DateDay1')
TestObject toValueDay1 = new TestObject('ValueDay1')
TestObject toDateDay2 = new TestObject('DateDay2')
TestObject toValueDay2 = new TestObject('ValueDay2')
TestObject toDateDay3 = new TestObject('DateDay3')
TestObject toValueDay3 = new TestObject('ValueDay3')
TestObject toDateDay4 = new TestObject('DateDay4')
TestObject toValueDay4 = new TestObject('ValueDay4')
TestObject toDateDay5 = new TestObject('DateDay5')
TestObject toValueDay5 = new TestObject('ValueDay5')
TestObject toDateDay6 = new TestObject('DateDay6')
TestObject toValueDay6 = new TestObject('ValueDay6')
TestObject toDateDay7 = new TestObject('DateDay7')
TestObject toValueDay7 = new TestObject('ValueDay7')

TestObject toDateAYearAgo = new TestObject('DateAYearAgo')
TestObject toValueAYearAgo = new TestObject('ValueAYearAgo')

/*
 * Set xpath-property on the TestObjects
 */
List<TestObjectProperty> propsBTC = new ArrayList<TestObjectProperty>()
propsBTC.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathBTC))
toBTC.setProperties(propsBTC)

List<TestObjectProperty> propsXRP = new ArrayList<TestObjectProperty>()
propsXRP.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathXRP))
toXRP.setProperties(propsXRP)

List<TestObjectProperty> propsHD = new ArrayList<TestObjectProperty>()
propsHD.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathHistoricData))
toHistoricData.setProperties(propsHD)

List<TestObjectProperty> propsRR = new ArrayList<TestObjectProperty>()
propsRR.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathReportRange))
toReportRange.setProperties(propsRR)

List<TestObjectProperty> propsL7D = new ArrayList<TestObjectProperty>()
propsL7D.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathLast7Days))
toLast7Days.setProperties(propsL7D)

List<TestObjectProperty> propsCN = new ArrayList<TestObjectProperty>()
propsCN.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathCurrencyName))
toCurrencyName.setProperties(propsCN)

List<TestObjectProperty> propsFirst1 = new ArrayList<TestObjectProperty>()
propsFirst1.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateDay1))
toDateDay1.setProperties(propsFirst1)

List<TestObjectProperty> propsFirst2 = new ArrayList<TestObjectProperty>()
propsFirst2.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueDay1))
toValueDay1.setProperties(propsFirst2)

List<TestObjectProperty> props21 = new ArrayList<TestObjectProperty>()
props21.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateDay2))
toDateDay2.setProperties(props21)

List<TestObjectProperty> props22 = new ArrayList<TestObjectProperty>()
props22.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueDay2))
toValueDay2.setProperties(props22)

List<TestObjectProperty> props31 = new ArrayList<TestObjectProperty>()
props31.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateDay3))
toDateDay3.setProperties(props31)

List<TestObjectProperty> props32 = new ArrayList<TestObjectProperty>()
props32.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueDay3))
toValueDay3.setProperties(props32)

List<TestObjectProperty> props41 = new ArrayList<TestObjectProperty>()
props41.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateDay4))
toDateDay4.setProperties(props41)

List<TestObjectProperty> props42 = new ArrayList<TestObjectProperty>()
props42.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueDay4))
toValueDay4.setProperties(props42)

List<TestObjectProperty> props51 = new ArrayList<TestObjectProperty>()
props51.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateDay5))
toDateDay5.setProperties(props51)

List<TestObjectProperty> props52 = new ArrayList<TestObjectProperty>()
props52.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueDay5))
toValueDay5.setProperties(props52)

List<TestObjectProperty> props61 = new ArrayList<TestObjectProperty>()
props61.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateDay6))
toDateDay6.setProperties(props61)

List<TestObjectProperty> props62 = new ArrayList<TestObjectProperty>()
props62.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueDay6))
toValueDay6.setProperties(props62)

List<TestObjectProperty> propsLast1 = new ArrayList<TestObjectProperty>()
propsLast1.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateDay7))
toDateDay7.setProperties(propsLast1)

List<TestObjectProperty> propsLast2 = new ArrayList<TestObjectProperty>()
propsLast2.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueDay7))
toValueDay7.setProperties(propsLast2)

List<TestObjectProperty> propsAYearAgo1 = new ArrayList<TestObjectProperty>()
propsAYearAgo1.add(new TestObjectProperty('xpath', ConditionType.EQUALS, DateAYearAgo))
toDateAYearAgo.setProperties(propsAYearAgo1)

List<TestObjectProperty> propsAYearAgo2 = new ArrayList<TestObjectProperty>()
propsAYearAgo2.add(new TestObjectProperty('xpath', ConditionType.EQUALS, ValueAYearAgo))
toValueAYearAgo.setProperties(propsAYearAgo2)

/*
 * Url and additional initiatons
 */
def url = GlobalVariable.URL
List<TestObjectProperty> weekData = new ArrayList<TestObjectProperty>()
List<TestObjectProperty> dayData = new ArrayList<TestObjectProperty>()
def currency = ''

//True if you want to see the increase this year
def A_YEAR_AGO = false

//0 if you want to check out BTC only, 1 if you want to check out XRP too
def CHECK = 0

/*
 * Create last X days query urls
 */
Date date = new Date()
DateFormat df = new SimpleDateFormat('yyyyMMdd')
def queryDate = '&end=' + df.format(date)
Calendar cal = new GregorianCalendar()
cal.add(Calendar.DAY_OF_MONTH, -7)
Date sevenDaysAgo = cal.getTime()
queryDate = (('?start=' + df.format(sevenDaysAgo)) + queryDate)
cal = new GregorianCalendar()
cal.add(Calendar.YEAR, -1)
Date yearAgo = cal.getTime()
def queryDateAYearAgo = '?start=' + df.format(yearAgo) + '&end=' + df.format(yearAgo)

/*
 * Start test
 */
WebUI.openBrowser('')

WebUI.maximizeWindow()

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
            WebUI.click(toBTC)
			println("Base url called, so you were directed to Bitcoin.")
			break
    }
	
	currency = WebUI.getText(toCurrencyName)
    
    WebUI.click(toHistoricData)
	
	def historicUrl = WebUI.getUrl()

    def queryUrl = historicUrl + queryDate

    WebUI.navigateToUrl(queryUrl)

    //WebUI.click(toReportRange)
    //WebUI.click(toLast7Days)

    dayData.add(WebUI.getText(toDateDay1))
    dayData.add(Double.parseDouble(WebUI.getText(toValueDay1).replace(',', '')))
    weekData.add(new ArrayList<TestObjectProperty>(dayData))
    dayData.clear()

    dayData.add(WebUI.getText(toDateDay2))
    dayData.add(Double.parseDouble(WebUI.getText(toValueDay2).replace(',', '')))
    weekData.add(new ArrayList<TestObjectProperty>(dayData))
    dayData.clear()

    dayData.add(WebUI.getText(toDateDay3))
    dayData.add(Double.parseDouble(WebUI.getText(toValueDay3).replace(',', '')))
    weekData.add(new ArrayList<TestObjectProperty>(dayData))
    dayData.clear()

    dayData.add(WebUI.getText(toDateDay4))
    dayData.add(Double.parseDouble(WebUI.getText(toValueDay4).replace(',', '')))
    weekData.add(new ArrayList<TestObjectProperty>(dayData))
    dayData.clear()

    dayData.add(WebUI.getText(toDateDay5))
    dayData.add(Double.parseDouble(WebUI.getText(toValueDay5).replace(',', '')))
    weekData.add(new ArrayList<TestObjectProperty>(dayData))
    dayData.clear()

    dayData.add(WebUI.getText(toDateDay6))
    dayData.add(Double.parseDouble(WebUI.getText(toValueDay6).replace(',', '')))
    weekData.add(new ArrayList<TestObjectProperty>(dayData))
    dayData.clear()
	
    dayData.add(WebUI.getText(toDateDay7))
    dayData.add(Double.parseDouble(WebUI.getText(toValueDay7).replace(',', '')))
    weekData.add(new ArrayList<TestObjectProperty>(dayData))
    dayData.clear()

    def weekValueAtEnd = weekData[0].get(1)
    def weekValueAtStart = weekData[6].get(1)

    double progressThisWeek = Math.round((((weekValueAtEnd * 100) / weekValueAtStart) - 100) * 10) / 10

    CustomKeywords.'CustomFunctions.highlight'(('Increase this week was: ' + progressThisWeek) + '%')

    List<TestObjectProperty> weeksAverageValues = new ArrayList<TestObjectProperty>()

    for (int i : (0..6)) {
        weeksAverageValues.add(weekData[i].get(1))
    }
    
    def weeksAverage = 0.0

    for (def d : weeksAverageValues) {
        weeksAverage += d
    }
    
    weeksAverage = (Math.round((weeksAverage / weeksAverageValues.size()) * 100) / 100)

    CustomKeywords.'CustomFunctions.highlight'('The average this week was: EUR ' + weeksAverage)
	
	if(A_YEAR_AGO){
		def queryAYearAgo = historicUrl + queryDateAYearAgo
		
		WebUI.navigateToUrl(queryAYearAgo)
		
		dayData.add(WebUI.getText(toDateDay1))
		dayData.add(Double.parseDouble(WebUI.getText(toValueDay1).replace(',', '')))
		weekData.add(new ArrayList<TestObjectProperty>(dayData))
		
		def yearValueAtStart = weekData[7].get(1)
		
		double progressThisYear = Math.round((((weekValueAtEnd * 100) / yearValueAtStart) - 100) * 10) / 10
		
		CustomKeywords.'CustomFunctions.highlight'('Increase this year was: ' + progressThisYear)
		
	}
}

println('Done')

WebUI.closeBrowser()
