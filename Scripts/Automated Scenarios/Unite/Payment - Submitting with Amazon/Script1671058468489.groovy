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
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Visa Widget Interaction'), [('Nationality') : 'United States (US)'
		, ('Destination') : 'United Kingdom (GB)'], FailureHandling.STOP_ON_FAILURE)

//Reaching the Learn More for destination country
WebUI.click(findTestObject('Object Repository/Website/Learn More/Link - United Kingdom LM'))

WebUI.click(findTestObject('Object Repository/Website/Learn More/Button - ApplyNow Learn More'))

//Starting the application process for destination country
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Trip dates'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 359 - emergency_contact_email.general'), 'emergency@email.com')

WebUI.setText(findTestObject('Website/General questions/ID 128 - emergency_contact_name.general'), 'Emergency Contact')

WebUI.setText(findTestObject('Website/General questions/ID 129 - emergency_contact_phone.general'), '(51) 1234-1234')

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
//Applicant #1
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 5 - first_name (A1)'), Name)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 6 - last_name (A1)'), LastName)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 7 - nationality_country (A1)'
        , ('Option') : 'Maldives (MV)'], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 9 - gender (A1)'), 'Male', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.month (A1)'), BirthdayMonth, 
    true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.day (A1)'), BirthdayDay, 
    true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.year (A1)'), BirthdayYear, 
    true)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 65 - birth_country (A1)'
        , ('Option') : 'Maldives (MV)'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 64 - home_country (A1)'
        , ('Option') : 'Maldives (MV)'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 10 - passport_num (A1)'), PassportNumber)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.month (A1)'), 
    PassportIssueDateMonth, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.day (A1)'), 
    PassportIssueDateDay, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.year (A1)'), 
    PassportIssueDateYear, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.month (A1)'), 
    PassportExpirationMonth, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.day (A1)'), 
    PassportExpirationDay, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.year (A1)'), 
    PassportExpirationYear, true)

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), Email)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_payment - Calling test case 'Payment Amazon'
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Application - Payment Amazon'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()