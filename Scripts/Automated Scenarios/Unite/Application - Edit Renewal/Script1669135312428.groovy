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

WebUI.click(findTestObject('Object Repository/Website/Header/Header - Passport'))

WebUI.click(findTestObject('Website/Passport Renewal/Button - US Learn More'))

WebUI.click(findTestObject('Website/Passport Renewal/Button - Renew your passport'))

//Step_1
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.month.general'), '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.day.general'), '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.year.general'), '1980', 
    true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.month.general'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.day.general'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.year.general'), 
    '2018', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.month.general'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.day.general'), 
    '1', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.year.general'), 
    '2022', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 870 - upcoming_trip_exists.general'), 'No', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 869 - passport_current_name.general'), 'No', true)

WebUI.click(findTestObject('Website/General questions/ID 324 - disclaimer_10.general'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
WebUI.setText(findTestObject('Website/General questions/ID 10 - passport_num.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '1234-1234')

WebUI.setText(findTestObject('Website/General questions/ID 5 - first_name.general'), 'Iris')

WebUI.setText(findTestObject('Website/General questions/ID 6 - last_name.general'), 'Lian')

WebUI.setText(findTestObject('Website/General questions/ID 14 - home_address.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 871 - home_address_2.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 15 - home_city.general'), GlobalVariable.GeneralString)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Website/General questions/ID 16 - home_state.general'
        , ('Option') : 'CA'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 17 - home_zip.general'), '33160')

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), 'mail6@mail.com')

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_3
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
//
WebUI.click(findTestObject('Website/Application CTAs/Icon - Review 1'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Edit Review'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.year.general'), '1990', true)

WebUI.click(findTestObject('Website/Application CTAs/Button - Save Edit'))

//
WebUI.click(findTestObject('Website/Application CTAs/Icon - Review 2'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Edit Review'))

WebUI.setText(findTestObject('Website/General questions/ID 6 - last_name.general'), 'Lian Wood')

WebUI.click(findTestObject('Website/Application CTAs/Button - Save Edit'))

//
WebUI.click(findTestObject('Website/Application CTAs/Icon - Review 3'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Edit Review'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Save Edit'))

WebUI.closeBrowser()
