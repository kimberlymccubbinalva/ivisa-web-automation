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

//Application process
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Application - Standalone Subscription'),
	[('FirstName') : 'Amazon',
	('LastName') : 'Payment',
	('Email') : 'family.subs@amazon.com',
	('CurrencyOption') : 'USD'],
	FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Website/Subscriptions/Subscription - Option Family'))

TotalFamily = WebUI.getText(findTestObject('Website/Application CTAs/Summary Card - order-total'))

WebUI.verifyEqual(TotalFamily, '$134.99', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - ContinueUnderSidebar'))

//Review
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - ContinueUnderSidebar'))

//Payment Amazon
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Payment Amazon'), [:], FailureHandling.STOP_ON_FAILURE)

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()

