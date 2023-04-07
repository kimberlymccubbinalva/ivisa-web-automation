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

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.ServerURL)

//Calling test case Visa Widget
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Visa Widget Interaction'), [('Nationality') : 'India (IN)'
        , ('Destination') : 'Japan (JP)'], FailureHandling.STOP_ON_FAILURE)

//Reaching the Learn More for destination country
WebUI.click(findTestObject('Website/Learn More/Button - ApplyNow Learn More'))

//Step_1
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 903 - visa_type_id.general'), '5473', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
WebUI.click(findTestObject('Website/General questions/ID 2 - arrival_date.general'))

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Right Arrow'))

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Right Arrow'))

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Arrival Date'))

if (WebUI.verifyElementPresent(findTestObject('Website/General questions/ID 3 - departure_date.general'), 2, FailureHandling.OPTIONAL)) {
	
	WebUI.click(findTestObject('Website/General questions/ID 3 - departure_date.general'), FailureHandling.OPTIONAL)

	WebUI.click(findTestObject('Website/Application CTAs/Calendar - Right Arrow'), FailureHandling.OPTIONAL)
	
	WebUI.click(findTestObject('Website/Application CTAs/Calendar - Right Arrow'), FailureHandling.OPTIONAL)

	WebUI.click(findTestObject('Website/Application CTAs/Calendar - Departure Date'), FailureHandling.OPTIONAL)
}

//WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 98 - port_of_arrival.general', ('Option') : 'Ahmedabad Airport'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), GlobalVariable.FamilySubs)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_3
//Applicant #1
WebUI.selectOptionByValue(findTestObject('Website/Application CTAs/Dropdown - Prefill Applicant'), '2', false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Website/Calculator tool/Add applicant'), 1)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 242 - residence_equals_nationality (A1)'), 'Yes',
	false)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 260 - visa_request_location (A1)'
		, ('Option') : 'India'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - AddApplicant'))

//Applicant #2
WebUI.selectOptionByValue(findTestObject('Website/Application CTAs/Dropdown - Prefill Applicant'), '2', false, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Website/Calculator tool/Add applicant'), 1)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 242 - residence_equals_nationality (A2)'), 'Yes',
	false)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 260 - visa_request_location (A2)'
		, ('Option') : 'India'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - AddApplicant'))

//Applicant #3
WebUI.selectOptionByValue(findTestObject('Website/Application CTAs/Dropdown - Prefill Applicant'), '2', false)

WebUI.scrollToElement(findTestObject('Website/Calculator tool/Add applicant'), 1)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 242 - residence_equals_nationality (A3)'), 'Yes',
	false)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 260 - visa_request_location (A3)'
		, ('Option') : 'India'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - AddApplicant'))

//Applicant #4
WebUI.selectOptionByValue(findTestObject('Website/Application CTAs/Dropdown - Prefill Applicant'), '2', false)

WebUI.scrollToElement(findTestObject('Website/Calculator tool/Add applicant'), 1)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 242 - residence_equals_nationality (A4)'), 'Yes',
	false)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 260 - visa_request_location (A4)'
		, ('Option') : 'India'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - AddApplicant'))

//Applicant #5
WebUI.selectOptionByValue(findTestObject('Website/Application CTAs/Dropdown - Prefill Applicant'), '2', false)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 242 - residence_equals_nationality (A5)'), 'Yes',
	false)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 260 - visa_request_location (A5)'
		, ('Option') : 'India'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_addons
//Individual Subscription
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Addon - Subscription Individual'), FailureHandling.STOP_ON_FAILURE)

TotalIndividual = WebUI.getText(findTestObject('Website/Application CTAs/Summary Card - order-total'))

WebUI.verifyNotEqual(TotalIndividual, '$89.99', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Addon - Subscription Individual'), FailureHandling.STOP_ON_FAILURE)

//Family Subscription
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Addon - Subscription Family'), FailureHandling.STOP_ON_FAILURE)

TotalFamily = WebUI.getText(findTestObject('Website/Application CTAs/Summary Card - order-total'))

WebUI.verifyEqual(TotalFamily, '$134.99', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_payment - Calling test case 'Payment'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Payment CC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()