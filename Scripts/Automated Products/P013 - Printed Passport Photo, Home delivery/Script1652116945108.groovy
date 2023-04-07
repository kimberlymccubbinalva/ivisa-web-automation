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

WebUI.click(findTestObject('Object Repository/Website/Header/Header - Photos'))

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - GetStarted'))

//Step_1
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 64 - home_country.general'
        , ('Option') : 'United States - US'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 160 - shipping_country_code.general'
        , ('Option') : 'United States - US'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_3
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'), [('FileUpload') : 'Website/General questions/ID 100 - passport_photo (A1)'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '123')

WebUI.setText(findTestObject('Website/General questions/ID 5 - first_name.general'), Name)

WebUI.setText(findTestObject('Website/General questions/ID 6 - last_name.general'), LastName)

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), Email)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_5
WebUI.setText(findTestObject('Website/General questions/ID 154 - shipping_address.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 155 - shipping_address2.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 156 - shipping_city.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 157 - shipping_state.general'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/General questions/ID 159 - shipping_zip.general'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_6
WebUI.click(findTestObject('Object Repository/Website/General questions/ID 890 - photo_expert_review'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_payment - Calling test case 'Payment'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Payment CC'), [:], FailureHandling.STOP_ON_FAILURE)

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

WebUI.closeBrowser()

