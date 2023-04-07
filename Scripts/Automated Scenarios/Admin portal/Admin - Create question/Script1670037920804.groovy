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

WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Login - Admin user'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin Portal/Header/Menu - Product config'))

WebUI.click(findTestObject('Admin Portal/Header/Menu - App Questions'))

WebUI.click(findTestObject('Admin Portal/App Question/Button - Add question'))

WebUI.setText(findTestObject('Admin Portal/App Question/Input - Question slug'), 'test_question')

WebUI.selectOptionByValue(findTestObject('Admin Portal/App Question/Dropdown - Per applicant'), 'true', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/App Question/Dropdown - Field type'), 'textbox', false)

WebUI.click(findTestObject('Admin Portal/App Question/Button - Save question'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

NewQuestion = WebUI.getText(findTestObject('Admin Portal/App Question/Label - Question ID'))

WebUI.click(findTestObject('Admin Portal/Header/Menu - Site Config'))

WebUI.click(findTestObject('Admin Portal/Header/Menu - Application Editor'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Application Editor/Dropdown - Select product'), '10331', false)

WebUI.click(findTestObject('Admin Portal/Application Editor/Button - Add question to appl'))

WebUI.setAlertText(NewQuestion)

WebUI.acceptAlert()

WebUI.selectOptionByValue(findTestObject('Admin Portal/Application Editor/Dropdown - Select section 5'), 'step_3', false)

WebUI.click(findTestObject('Admin Portal/Application Editor/Button - Save application'))

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'), FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)