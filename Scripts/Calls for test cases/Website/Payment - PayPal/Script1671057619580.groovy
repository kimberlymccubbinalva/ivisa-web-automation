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

WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Button - PayPal'))

WebUI.switchToWindowTitle('Log in to your PayPal account')

WebUI.setText(findTestObject('Website/Application CTAs/PayPal/PayPal - Email'), 'paypaltest@ivisa.com')

WebUI.click(findTestObject('Website/Application CTAs/PayPal/PayPal - Next'))

WebUI.setText(findTestObject('Website/Application CTAs/PayPal/PayPal - Password'), GlobalVariable.GeneraliVisaPassword)

WebUI.click(findTestObject('Website/Application CTAs/PayPal/PayPal - Button Login'))

WebUI.click(findTestObject('Website/Application CTAs/PayPal/PayPal - Button Submit Payment'))

WebUI.switchToWindowTitle('US Embassy Registration Application')