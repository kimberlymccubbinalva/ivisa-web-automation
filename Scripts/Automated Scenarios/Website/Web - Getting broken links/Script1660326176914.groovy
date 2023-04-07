import org.openqa.selenium.WebElement as WebElement
import com.kazurayam.ksbackyard.LinkTestUtils as LinkTestUtils
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// String pageUrl is passed by the caller, or will default to the value defined in the Variables tab of this testcase
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.ServerURL)

// wait until the page gets stable
WebUI.delay(5)

// find all <a> elements with non-null href attribute
TestObject tObjAnchors = new TestObject('all anchors').addProperty('xpath', ConditionType.EQUALS, '//a')

List<WebElement> anchors = WebUI.findWebElements(tObjAnchors, 10)

List<WebElement> hrefs = anchors.stream().filter({ def we ->
        we.getAttribute('href') != null
    }).map({ def we ->
        we.getAttribute('href')
    }).collect()

// prepare buffer for messages
StringBuilder messageBuffer = new StringBuilder()

messageBuffer.append("*** All <a> elements in $pageUrl ***$System.lineSeparator")

// Now we do the job!
int brokenLinksCount = LinkTestUtils.findBrokenLinks(hrefs, messageBuffer)

// print message
print(messageBuffer.toString())

WebUI.closeBrowser()

return brokenLinksCount

