import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Login into mailhog and get the URL needed so customer can directly reach the website
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Mailhog - Log in'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject(EmailSubject))

WebUI.click(findTestObject('Object Repository/Admin Portal/Mailhog/Email - btnText'))

EmailURL = WebUI.getText(findTestObject(EmbedLink))

WebUI.navigateToUrl(EmailURL)

for (int i = 1; i < 10; i++) {
    while (WebUI.verifyElementPresent(findTestObject('Object Repository/Website/General page/Oops Modal - Message'), 1, 
        FailureHandling.OPTIONAL)) {
        WebUI.click(findTestObject('Website/General page/Oops Modal - OK CTA'))

        WebUI.delay(10)

        EmailURL = EmailURL.substring(0, EmailURL.length() - i)

        System.out.println(EmailURL)

        WebUI.navigateToUrl(EmailURL)
    }
}

