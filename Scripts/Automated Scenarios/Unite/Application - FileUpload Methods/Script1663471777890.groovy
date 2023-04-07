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

//Authenticating
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.CustomerEmail)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.CustomerPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

//Applying for a photo
WebUI.click(findTestObject('Object Repository/Website/Header/Header - Photos'))

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - GetStarted'))

//Step_1
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 64 - home_country.general'
        , ('Option') : 'United States (US)'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/General questions/ID 160 - shipping_country_code.general'
        , ('Option') : 'United States (US)'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Step_2
WebUI.click(findTestObject('Website/Application CTAs/Delivery - Digital'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_3
//Upload file by using send by email
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/FileUpload - SendByEmail'))

GeneratedEmail = WebUI.getText(findTestObject('Website/Application CTAs/FileUpload - Generated Email'))

WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Open Tab'), [('path') : GlobalVariable.ServerURL + '/staging/email_file_upload'], FailureHandling.STOP_ON_FAILURE)

WebUI.setText('Website/Application CTAs/Field - Generated email', GeneratedEmail)

WebUI.uploadFile(findTestObject('Website/Application CTAs/Field - File attachment 1'), GlobalVariable.PhotoFile)

WebUI.click(findTestObject('Website/Application CTAs/Button - Submit attachments'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

//Switch to application process
WebUI.switchToWindowUrl(GlobalVariable.ServerURL + '/photos/order#step=step_3')

WebUI.waitForElementPresent(findTestObject('Website/Application CTAs/Label - File received'), 8)


/*
 //Upload file by using browse
 WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Website/Form - FileUpload question'), [('FileUpload') : 'Website/General questions/ID 100 - passport_photo (A1)'],
	 FailureHandling.STOP_ON_FAILURE)
 
 //Remove file
 WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Icon - Delete File'))
 
 WebUI.scrollToElement(findTestObject('Website/Application CTAs/FileUpload - SendByEmail'), 1)
 */