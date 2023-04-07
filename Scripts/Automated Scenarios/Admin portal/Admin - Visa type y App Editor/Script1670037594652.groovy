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

WebUI.click(findTestObject('Admin Portal/Header/Menu - Visa types'))

WebUI.click(findTestObject('Admin Portal/Visa Types/Button - Edit visa types'))

WebUI.click(findTestObject('Admin Portal/Visa Types/Button - Add visa category'))

WebUI.setText(findTestObject('Admin Portal/Visa Types/Field - Category name'), 'Test category')

WebUI.setText(findTestObject('Admin Portal/Visa Types/Field - Category url'), '/test-category')

WebUI.click(findTestObject('Admin Portal/Visa Types/Button - Create category'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

WebUI.click(findTestObject('Admin Portal/Visa Types/Button - Create visa type'))

WebUI.waitForAlert(3)

WebUI.acceptAlert()

WebUI.click(findTestObject('Admin Portal/Visa Types/Button - Engine icon'))

WebUI.click(findTestObject('Admin Portal/Visa Types/Button - Reenable'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

NewProduct = WebUI.getText(findTestObject('Admin Portal/Visa Types/Label - Product ID'))

WebUI.click(findTestObject('Admin Portal/Header/Menu - Site Config'))

WebUI.click(findTestObject('Admin Portal/Header/Menu - Application Editor'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Application Editor/Dropdown - Select product'), NewProduct, false)

WebUI.click(findTestObject('Admin Portal/Application Editor/Checkbox - Add question'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Application Editor/Dropdown - Select section 1'), 'step_2', false)

WebUI.click(findTestObject('Admin Portal/Application Editor/Button - Save application'))

WebUI.click(findTestObject('Admin Portal/Application Editor/Button - Add question to appl'))

WebUI.setAlertText('20,21')

WebUI.acceptAlert()

WebUI.selectOptionByValue(findTestObject('Admin Portal/Application Editor/Dropdown - Select section 2'), 'step_3', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Application Editor/Dropdown - Select section 3'), 'step_2', false)

WebUI.click(findTestObject('Admin Portal/Application Editor/Button - Save application'))

WebUI.click(findTestObject('Admin Portal/Application Editor/Button - Resort questions'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'), FailureHandling.STOP_ON_FAILURE)

WebUI.acceptAlert()

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

