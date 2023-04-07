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
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Visa Widget Interaction'), [('Nationality') : 'United States - US'
        , ('Destination') : 'Vietnam - VN'], FailureHandling.STOP_ON_FAILURE)

//Reaching the Learn More for destination country
WebUI.click(findTestObject('Website/Learn More/Button - ApplyNow Learn More'))

//Starting the application process for destination country
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Trip dates'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 98 - port_of_arrival.general'
        , ('Option') : 'La Lay Landport'], FailureHandling.STOP_ON_FAILURE)

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

//Post-sale
//General questions
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 101 - traveling_by.general'), 'Airplane / Jet', true)

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '1234-1234')

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 62 - reason_for_travel.general'), 
    'Tourism', true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 28 - destination_address.general'), GlobalVariable.GeneralString)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 189 - destination_city.general'
        , ('Option') : 'Ha Noi'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 443 - contact_city.general'), GlobalVariable.GeneralString)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 338 - point_of_exit.general'
        , ('Option') : 'Phu Bai Int Airport'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Per applicant questions
//Personal
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 202 - religion (A1)'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Work
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 46 - occupation.input (A1)'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Documents
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'), [('FileUpload') : 'Object Repository/Website/General questions/ID 100 - passport_photo (A1)'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'), [('FileUpload') : 'Object Repository/Website/General questions/ID 29 - passport_scan (A1)'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitApplication'))

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()

