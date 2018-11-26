import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords


class CustomFunctions {

	@Keyword
	def highlight(def text){
		println('\n   ' + text + '   \n')
	}

	/*
	 @Keyword
	 def clickElement(TestObject to) {
	 try {
	 WebElement element = WebUiBuiltInKeywords.findWebElement(to);
	 KeywordUtil.logInfo("Clicking element")
	 element.click()
	 KeywordUtil.markPassed("Element has been clicked")
	 } catch (WebElementNotFoundException e) {
	 KeywordUtil.markFailed("Element not found")
	 } catch (Exception e) {
	 KeywordUtil.markFailed("Fail to click on element")
	 }
	 }
	 */
}
