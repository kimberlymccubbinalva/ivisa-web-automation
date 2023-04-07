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
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Visa Widget Interaction'), [('Nationality') : 'India - IN'
        , ('Destination') : 'Spain - ES'], FailureHandling.STOP_ON_FAILURE)

//Reaching the Learn More for destination country
WebUI.click(findTestObject('Website/Learn More/Button - ApplyNow Learn More'))

//Starting the application process for destination country
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
WebUI.click(findTestObject('Website/General questions/ID 2 - arrival_date.general'))

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Right Arrow'))

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Arrival Date'))

WebUI.click(findTestObject('Website/General questions/ID 3 - departure_date.general'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Right Arrow'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Right Arrow'), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/Application CTAs/Calendar - Departure Date'), FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), Email)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '1234-1234')

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_3
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Global Questions'), [('Name') : Name, ('LastName') : LastName
        , ('Gender') : 'Male', ('BirthdayMonth') : BirthdayMonth, ('BirthdayDay') : BirthdayDay, ('BirthdayYear') : BirthdayYear
        , ('PassportNumber') : PassportNumber, ('PassportIssueDateMonth') : PassportIssueDateMonth, ('PassportIssueDateDay') : PassportIssueDateDay
        , ('PassportIssueDateYear') : PassportIssueDateYear, ('PassportExpirationMonth') : PassportExpirationMonth, ('PassportExpirationDay') : PassportExpirationDay
        , ('PassportExpirationYear') : PassportExpirationYear], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 523 - residence_country_other (A1)'), 
    'Yes', true, FailureHandling.OPTIONAL)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 260 - visa_request_location (A1)'
        , ('Option') : 'India'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 465 - document_pick_up_city_state (A1)'
        , ('Option') : 'New Delhi'], FailureHandling.STOP_ON_FAILURE)

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
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 592 - schengen_destination_country.general'
        , ('Option') : 'Austria'], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 694 - number_of_entries'), 'One entry', 
    true, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Per applicant questions
//Personal
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 67 - national_identity_number (A1)'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.month (A1)'), 
    PassportIssueDateMonth, true, FailureHandling.OPTIONAL)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.day (A1)'), 
    PassportIssueDateDay, true, FailureHandling.OPTIONAL)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.year (A1)'), 
    PassportIssueDateYear, true, FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 13 - birth_city (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 14 - home_address (A1)'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 605 - right_of_freedom (A1)'), 
    'No', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Work
WebUI.setText(findTestObject('Website/General questions/ID 46 - occupation.input (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 135 - employer (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 49 - employer_address (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 137 - employer_phone (A1)'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Family
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 79 - marital_status (A1)'), 'Single', 
    true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Travel
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 332 - purpose_of_visit (A1)'
        , ('Option') : 'Tourism'], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 431 - type_of_contact (A1)'), 'Hotel/Hostel/AirBnB', 
    true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 219 - hotel_name (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 287 - destination_contact_address (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 185 - destination_email (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 184 - destination_phone (A1)'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 413 - person_entity_paying (A1)'), 
    'I am paying for my trip', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 524 - subsistence_proof (A1)'), 
    'Cash', true)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 592 - schengen_destination_country.general'
        , ('Option') : 'Austria'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Past travel
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 428 - ten_printed (A1)'), 'No', 
    true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Documents
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'), [('FileUpload') : 'Object Repository/Website/General questions/ID 100 - passport_photo (A1)'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'), [('FileUpload') : 'Object Repository/Website/General questions/ID 29 - passport_scan (A1)'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Declarations
WebUI.check(findTestObject('Object Repository/Website/General questions/ID 315 - disclaimer_1 (A1)'))

WebUI.check(findTestObject('Object Repository/Website/General questions/ID 316 - disclaimer_2 (A1)'))

WebUI.check(findTestObject('Object Repository/Website/General questions/ID 317 - disclaimer_3 (A1)'))

WebUI.check(findTestObject('Object Repository/Website/General questions/ID 318 - disclaimer_4 (A1)'))

WebUI.check(findTestObject('Object Repository/Website/General questions/ID 319 - disclaimer_5 (A1)'))

WebUI.check(findTestObject('Object Repository/Website/General questions/ID 320 - disclaimer_6 (A1)'))

WebUI.scrollToElement(findTestObject('Website/Application CTAs/Button - SubmitApplication'), 5, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitApplication'))

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()

