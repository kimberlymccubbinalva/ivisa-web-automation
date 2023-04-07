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

WebUI.openBrowser('')

//Plus page
WebUI.navigateToUrl(GlobalVariable.ServerURL)

WebUI.scrollToElement(findTestObject('Website/General page/Footer'), 0)

WebUI.click(findTestObject('Website/Footer/iVisa Plus'))

//WebUI.click(findTestObject('Website/Subscriptions/Button - View plans'))

//WebUI.scrollToElement(findTestObject('Object Repository/Website/Subscriptions/Button - Get started'), 0)

WebUI.click(findTestObject('Object Repository/Website/Subscriptions/Button - Get started'))

//Application process
//Step_2
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 1 - email'), Email)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 4 - phone'), '4444-4444')

WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Application - Change currency'), [('SelectCurrency') : CurrencyOption],
	FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 5 - first_name (A1)'), FirstName)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 6 - last_name (A1)'), LastName)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Website/General questions/ID 8 - dob.month (A1)'),
	2, FailureHandling.OPTIONAL)) {
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.month (A1)'), '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.day (A1)'), '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.year (A1)'), '1995', true)
}

//Review
