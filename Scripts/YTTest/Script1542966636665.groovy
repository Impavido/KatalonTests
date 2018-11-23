import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.maximizeWindow()

def xpathTrends = '/html[1]/body[1]/ytd-app[1]/app-drawer[1]/div[2]/div[1]/div[2]/div[2]/ytd-guide-renderer[1]/div[1]/ytd-guide-section-renderer[1]/div[1]/ytd-guide-entry-renderer[2]/a[1]'
def xpathFirstTitle = '//div[@id=\'contents\']//ytd-item-section-renderer[1]//div[2]//ytd-shelf-renderer[1]//div[1]//div[2]//ytd-expanded-shelf-contents-renderer[1]//div[1]//ytd-video-renderer[1]//div[1]//div[1]//div[1]//div[1]//h3[1]//a[1]'
def xpathSecondTitle = '//div[@id=\'contents\']//ytd-item-section-renderer[1]//div[2]//ytd-shelf-renderer[1]//div[1]//div[2]//ytd-expanded-shelf-contents-renderer[1]//div[1]//ytd-video-renderer[2]//div[1]//div[1]//div[1]//div[1]//h3[1]//a[1]'
def xpathThirdTitle = '//div[@id=\'contents\']//ytd-item-section-renderer[1]//div[2]//ytd-shelf-renderer[1]//div[1]//div[2]//ytd-expanded-shelf-contents-renderer[1]//div[1]//ytd-video-renderer[3]//div[1]//div[1]//div[1]//div[1]//h3[1]//a[1]'
def objectName = 'Trends'
def url = ''

TestObject toTrends = new TestObject(objectName)
TestObject toFirstTitle = new TestObject('First title')
TestObject toSecondTitle = new TestObject('Second title')
TestObject toThirdTitle = new TestObject('Third title')

List<TestObjectProperty> propsTrends = new ArrayList<TestObjectProperty>()
propsTrends.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathTrends))
toTrends.setProperties(propsTrends)

List<TestObjectProperty> propsFirstTitle = new ArrayList<TestObjectProperty>()
propsFirstTitle.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathFirstTitle))
toFirstTitle.setProperties(propsFirstTitle)

List<TestObjectProperty> propsSecondTitle = new ArrayList<TestObjectProperty>()
propsSecondTitle.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathSecondTitle))
toSecondTitle.setProperties(propsSecondTitle)

List<TestObjectProperty> propsThirdTitle = new ArrayList<TestObjectProperty>()
propsThirdTitle.add(new TestObjectProperty('xpath', ConditionType.EQUALS, xpathThirdTitle))
toThirdTitle.setProperties(propsThirdTitle)

List<List<String>> countries = new ArrayList<ArrayList<String>>()
List<String> topFive = new ArrayList<String>()


for (def index : (0..1)) {
	
	switch(index){
		case 0:
		url = GlobalVariable.URL1
		break
		case 1:
		url = GlobalVariable.URL2		
		break
		case 2:
		url = GlobalVariable.URL3
		break
		case 3:
		url = GlobalVariable.URL4
		break
		case 4:
		url = GlobalVariable.URL5
		break
		default:
		url = GlobalVariable.URL9
		break
	}
	
	CustomKeywords.'CustomFunctions.highlight'('Started Youtube test with URL: ' + url)
	
	WebUI.navigateToUrl(url)
	
//	Thread.sleep(1000)
    
	WebUI.click(toTrends)

    topFive.add(WebUI.getText(toFirstTitle))
    topFive.add(WebUI.getText(toSecondTitle))
    topFive.add(WebUI.getText(toThirdTitle))
	
	countries.add(new ArrayList<String>(topFive))
	
	CustomKeywords.'CustomFunctions.highlight'('Top 3 are:')
	
	for(String s : topFive){
		CustomKeywords.'CustomFunctions.highlight'(s)
	}
	
	topFive.clear()
}


println('Done')

WebUI.closeBrowser()

