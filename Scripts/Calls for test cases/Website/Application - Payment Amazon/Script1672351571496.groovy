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

//Step_payment - Calling test case 'Payment Amazon'
//Evaluating disclaimer modal appearance
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Website/Application CTAs/ButtonDisclaimer - ContinueWithApplication'),
	2, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Website/Application CTAs/ButtonDisclaimer - ContinueWithApplication'),
		FailureHandling.OPTIONAL)

	WebUI.click(findTestObject('Website/Application CTAs/Discount - Code'), FailureHandling.OPTIONAL)

	WebUI.setText(findTestObject('Website/Application CTAs/Discount - Code'), 'abandon_cart', FailureHandling.OPTIONAL)

	WebUI.click(findTestObject('Website/Application CTAs/Discount - Redeem code'), FailureHandling.OPTIONAL)

	WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Payment - Amazon'), [:], FailureHandling.OPTIONAL)
	
} else {
	WebUI.click(findTestObject('Website/Application CTAs/Discount - Code'), FailureHandling.OPTIONAL)

	WebUI.setText(findTestObject('Website/Application CTAs/Discount - Code'), 'abandon_cart', FailureHandling.OPTIONAL)

	WebUI.click(findTestObject('Website/Application CTAs/Discount - Redeem code'), FailureHandling.OPTIONAL)

	WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Payment - Amazon'), [:], FailureHandling.OPTIONAL)
}

WebUI.verifyElementPresent(findTestObject('Website/Application CTAs/Button - CompleteProcess'), 10)

WebUI.click(findTestObject('Website/Application CTAs/Button - CompleteProcess'))