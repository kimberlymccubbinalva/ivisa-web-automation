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

//Admin portal
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.ServerURL)

WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Login - Admin user'), [:], FailureHandling.STOP_ON_FAILURE)

//MIN
//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : '92'], FailureHandling.STOP_ON_FAILURE)

//Sending a MIN
//Per applicant
//Applicant 1
WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - Documents section (A1)'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Document - Applicant Photo'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - More Info File'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/MIN Reason - applicant_photo'))

//Applicant 2
WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 2'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - Documents section (A2)'))

WebUI.verifyElementClickable(findTestObject('Admin Portal/Order Details page/Document - Applicant Photo'), 5)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Document - Applicant Photo'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - More Info File'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/MIN Reason - applicant_photo'))

//Change status
WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 0)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 'info_needed', false)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Yes change to MIN'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Email Preview'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Change Status'))

