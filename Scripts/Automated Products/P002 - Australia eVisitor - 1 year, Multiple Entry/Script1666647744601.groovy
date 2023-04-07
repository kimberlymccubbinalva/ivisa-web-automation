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

WebUI.navigateToUrl(GlobalVariable.ServerURL)

//Calling test case Visa Widget
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Visa Widget Interaction'), [('Nationality') : 'United Kingdom - GB'
        , ('Destination') : 'Australia - AU'], FailureHandling.STOP_ON_FAILURE)

//Reaching the Learn More for destination country
WebUI.click(findTestObject('Website/Learn More/Button - ApplyNow Learn More'))

//Starting the application process for destination country
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), Email)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Trip dates'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_3
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Global Questions'), [('Name') : Name, ('LastName') : LastName
        , ('Gender') : 'Male', ('BirthdayMonth') : BirthdayMonth, ('BirthdayDay') : BirthdayDay, ('BirthdayYear') : BirthdayYear
        , ('PassportNumber') : PassportNumber, ('PassportIssueDateMonth') : PassportIssueDateMonth, ('PassportIssueDateDay') : PassportIssueDateDay
        , ('PassportIssueDateYear') : PassportIssueDateYear, ('PassportExpirationMonth') : PassportExpirationMonth, ('PassportExpirationDay') : PassportExpirationDay
        , ('PassportExpirationYear') : PassportExpirationYear], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 76 - brazil_nationality (A1)'), 'No', false)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_addons
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_payment - Calling test case 'Payment'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Payment CC'), [:], FailureHandling.STOP_ON_FAILURE)

//Post-sale
//General questions
WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '1234-1234')

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 62 - reason_for_travel.general'), 
    'Tourism', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Per applicant questions
//Personal
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 68 - birth_place (A1)'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.month (A1)'), 
    PassportIssueDateMonth, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.day (A1)'), 
    PassportIssueDateDay, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.year (A1)'), 
    PassportIssueDateYear, true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 14 - home_address (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 17 - home_zip (A1)'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 102 - has_secondary_nationality (A1)'), 'No', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 347 - has_secondary_citizenship (A1)'), 'No', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Work
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 46 - occupation.dropdown (A1)'), 'Unemployed', 
    true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 462 - last_position (A1)'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 47 - occupation_start_date.month (A1)'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 47 - occupation_start_date.day (A1)'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 47 - occupation_start_date.year (A1)'), 
    '2022', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 51 - last_work_activity_date.month (A1)'), 
    '8', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 51 - last_work_activity_date.day (A1)'), 
    '10', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 51 - last_work_activity_date.year (A1)'), 
    '2022', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Family
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 79 - marital_status (A1)'), 'Never Married',
	true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Past-travel
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 37 - previous_argentina_visa (A1)'), 'No', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Documents
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'),
	[('FileUpload') : 'Object Repository/Website/General questions/ID 29 - passport_scan (A1)'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Declarations
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 104 - previously_applied (A1)'), 
    'No', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitApplication'))

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()

