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
        , ('Destination') : 'Turkey (TR)'], FailureHandling.STOP_ON_FAILURE)

//Reaching the Learn More for destination country
WebUI.click(findTestObject('Website/Learn More/Button - ApplyNow Learn More'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Starting the application process for destination country
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Trip dates'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '1234-1234')

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), 'mail1@mail.com')

//Calling test case Login modal
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_3
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Global Questions'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_addons
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Icon - Review 1'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Edit Review'))

WebUI.click(findTestObject('Website/General questions/ID 4 - phone'))

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '2')

WebUI.click(findTestObject('Website/Application CTAs/Button - Save Edit'))

WebUI.click(findTestObject('Website/Application CTAs/Icon - Review 2'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Edit Review'))

WebUI.click(findTestObject('Website/General questions/ID 5 - first_name (A1)'))

WebUI.setText(findTestObject('Website/General questions/ID 5 - first_name (A1)'), 'Ann Lee')

WebUI.click(findTestObject('Website/Application CTAs/Button - Save Edit'))

WebUI.click(findTestObject('Website/Application CTAs/Icon - Review 3'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Edit Review'))

WebUI.click(findTestObject('Website/Application CTAs/Processing - Rush Turkey'))

WebUI.click(findTestObject('Website/Application CTAs/Button - Save Edit'))

WebUI.closeBrowser()

