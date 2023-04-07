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

//Calling test case Turkey eVisa
WebUI.callTestCase(findTestCase('Test Cases/Automated Products/Call - Turkey eVisa, 180 days, Single Entry'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Website/Customer dashboard/Recommended Add-ons/Box - Recommended add-ons'), 1)

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Upgrade - Rush'))

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Button - Purchase'))

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitPayment'))

WebUI.verifyElementNotPresent(findTestObject('Website/Customer dashboard/Recommended Add-ons/Upgrade - Rush'), 1)

WebUI.scrollToElement(findTestObject('Website/Customer dashboard/Recommended Add-ons/Box - Recommended add-ons'), 1)

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Upgrade - Super Rush'))

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Button - Purchase'))

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitPayment'))

WebUI.verifyElementNotPresent(findTestObject('Website/Customer dashboard/Recommended Add-ons/Upgrade - Super Rush'), 1)

WebUI.scrollToElement(findTestObject('Website/Customer dashboard/Recommended Add-ons/Box - Recommended add-ons'), 1)

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/EmbReg - US'))

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Button - Purchase'))

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitPayment'))

WebUI.verifyElementNotPresent(findTestObject('Website/Customer dashboard/Recommended Add-ons/EmbReg - US'), 1)

WebUI.scrollToElement(findTestObject('Website/Customer dashboard/Recommended Add-ons/Box - Recommended add-ons'), 1)

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Mail Documents'))

WebUI.setText(findTestObject('Website/Customer dashboard/Recommended Add-ons/Mail Documents - Address'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/Customer dashboard/Recommended Add-ons/Mail Documents - Address2'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/Customer dashboard/Recommended Add-ons/Mail Documents - City'), GlobalVariable.GeneralString)

WebUI.setText(findTestObject('Website/Customer dashboard/Recommended Add-ons/Mail Documents - Zip'), GlobalVariable.GeneralString)

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/Customer dashboard/Recommended Add-ons/Mail Documents - Country'
        , ('Option') : 'Kosovo (XK)'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Button - Purchase'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/Customer dashboard/Recommended Add-ons/Mail Documents - Country'
        , ('Option') : 'United States (US)'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Customer dashboard/Recommended Add-ons/Button - Purchase'))

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitPayment'))

WebUI.verifyElementNotPresent(findTestObject('Website/Customer dashboard/Recommended Add-ons/Mail Documents'), 1)

WebUI.closeBrowser()

