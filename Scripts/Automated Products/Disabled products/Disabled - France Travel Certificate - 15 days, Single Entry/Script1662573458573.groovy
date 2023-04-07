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
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Visa Widget Interaction'), [('Nationality') : 'United States (US)'
        , ('Destination') : 'France (FR)'], FailureHandling.STOP_ON_FAILURE)

//Reaching the Learn More for destination country
WebUI.click(findTestObject('Website/Learn More/Button - ApplyNow Learn More'))

//Starting the application process for destination country
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Trip dates'), [:], FailureHandling.STOP_ON_FAILURE)

//
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 101 - traveling_by.general'
        , ('Option') : 'Airplane'], FailureHandling.STOP_ON_FAILURE)

//
WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), Email)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_3
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Global Questions'), [('Name') : Name, ('LastName') : LastName
        , ('Gender') : 'Male', ('BirthdayMonth') : BirthdayMonth, ('BirthdayDay') : BirthdayDay, ('BirthdayYear') : BirthdayYear
        , ('PassportNumber') : PassportNumber, ('PassportIssueDateMonth') : PassportIssueDateMonth, ('PassportIssueDateDay') : PassportIssueDateDay
        , ('PassportIssueDateYear') : PassportIssueDateYear, ('PassportExpirationMonth') : PassportExpirationMonth, ('PassportExpirationDay') : PassportExpirationDay
        , ('PassportExpirationYear') : PassportExpirationYear], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_addons
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_payment - Calling test case 'Payment'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Payment CC'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '1234-1234')

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Website/General questions/ID 174 - traveling_from.general'
        , ('Option') : 'United States (US)'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 856 - airport.general'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 647 - date_of_event.month.general'), '6', false)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 647 - date_of_event.day.general'), '5', false)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 647 - date_of_event.year.general'), '2024', false)

WebUI.setText(findTestObject('Website/General questions/ID 311 - departure_flight_time.general'), '10:00 p.m.')

WebUI.setText(findTestObject('Website/General questions/ID 98 - port_of_arrival.general'), GlobalVariable.GeneralString, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 22 - arrival_flight_airline.general'), GlobalVariable.GeneralString, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 21 - arrival_flight_number.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 310 - arrival_flight_time.general'), '05:00 a.m.')

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

WebUI.setText(findTestObject('Website/General questions/ID 14 - home_address (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 15 - home_city (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 17 - home_zip (A1)'), GlobalVariable.GeneralString, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

WebUI.setText(findTestObject('Website/General questions/ID 699 - ticket_number (A1)'), 'A4')

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Website/General questions/ID 633 - which_statement_applies (A1)', 
	('Option') : 'I am a visitor to this country visiting for a short period of time (for tourist, business purposes or other).'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitApplication'))

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()

