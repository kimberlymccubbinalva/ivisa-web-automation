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
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 903 - visa_type_id.general'), '5473', 
    true)

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

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), GlobalVariable.IndividualSubs)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_3
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Global Questions'), [('Name') : Name, ('LastName') : LastName
        , ('Gender') : 'Male', ('BirthdayMonth') : BirthdayMonth, ('BirthdayDay') : BirthdayDay, ('BirthdayYear') : BirthdayYear
        , ('PassportNumber') : PassportNumber, ('PassportIssueDateMonth') : PassportIssueDateMonth, ('PassportIssueDateDay') : PassportIssueDateDay
        , ('PassportIssueDateYear') : PassportIssueDateYear, ('PassportExpirationMonth') : PassportExpirationMonth, ('PassportExpirationDay') : PassportExpirationDay
        , ('PassportExpirationYear') : PassportExpirationYear], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 242 - residence_equals_nationality (A1)'), 'Yes', 
    false)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 260 - visa_request_location (A1)'
        , ('Option') : 'India'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_addons
WebUI.verifyElementNotPresent(findTestObject('Website/Application CTAs/Addon - Subscription Family'), 1)

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Addon - Subscription Individual'), FailureHandling.STOP_ON_FAILURE)

TotalIndividual = WebUI.getText(findTestObject('Website/Application CTAs/Summary Card - order-total'))

WebUI.verifyEqual(TotalIndividual, '$89.99', FailureHandling.STOP_ON_FAILURE)

//Going back to confirm price correctly updates
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - Previous'))

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - Previous'))

//Adding a new applicant
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - AddApplicant'))

TotalIndividual = WebUI.getText(findTestObject('Website/Application CTAs/Summary Card - order-total'))

WebUI.verifyNotEqual(TotalIndividual, '$89.99', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Icon - Trash (A2)'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Processing speed
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Addons
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Addon - Subscription Individual'), FailureHandling.STOP_ON_FAILURE)

TotalIndividual = WebUI.getText(findTestObject('Website/Application CTAs/Summary Card - order-total'))

WebUI.verifyEqual(TotalIndividual, '$89.99', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_payment - Calling test case 'Payment'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Payment CC'), [:], FailureHandling.STOP_ON_FAILURE)

//Post-sale
//General
WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '123')

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 376 - arrival_port.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 741 - travel_company.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 27 - destination_location_name.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 28 - destination_address.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 184 - destination_phone.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 432 - contact_person_full_name.general'), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 608 - destination_contact_gender.general'), 
    'Male', true)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 609 - destination_contact_nationality.general'
        , ('Option') : 'Japan (JP)'], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 591 - date_birth.month.general'), 
    1, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 591 - date_birth.day.general'), 
    1, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 591 - date_birth.year.general'), 
    1980, true)

WebUI.setText(findTestObject(''), GlobalVariable.GeneralString)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 329 - immigration_status.general'), 
    'Citizen', true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 911 - emergency_contact_address.general'), 
    GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 194 - destination_contact_phone.general'), 
    GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 638 - relationship_to_you.general'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Per applicant
//Personal
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 13 - birth_city (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 14 - home_address (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 67 - national_identity_number (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 541 - issuing_authority (A1)'), GlobalVariable.GeneralString)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 103 - secondary_nationality_country (A1)'
        , ('Option') : 'India (JP)'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 5 - first_name (A1)'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 6 - last_name (A1)'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Work
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 46 - occupation.dropdown (A1)'), 'Retired', 
    true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 300 - matchmaker_occupation (A1)'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Family
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 79 - marital_status (A1)'), 'Single', 
    true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Past travel
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 388 - previously_visited (A1)'), 
    'No', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Documents
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'), [('FileUpload') : 'Website/General questions/ID 100 - passport_photo (A1)'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Declarations
WebUI.click(findTestObject('Object Repository/Website/General questions/ID 315 - disclaimer_1 (A1)'))

WebUI.click(findTestObject('Object Repository/Website/General questions/ID 316 - disclaimer_2 (A1)'))

WebUI.click(findTestObject('Object Repository/Website/General questions/ID 317 - disclaimer_3 (A1)'))

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - SubmitApplication'))

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()

