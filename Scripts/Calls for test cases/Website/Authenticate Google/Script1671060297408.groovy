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

/*WebUI.navigateToUrl('https://www.google.com')

WebUI.setText(findTestObject('Website/Application CTAs/Google/Google - Browser'), 'Inicia sesión: Cuentas de Google')

WebUI.sendKeys(findTestObject('Website/Application CTAs/Google/Google - Browser'), Keys.chord(Keys.ENTER))

WebUI.verifyElementPresent(findTestObject('Website/Application CTAs/Google/Google - Session'), 3)

WebUI.click(findTestObject('Website/Application CTAs/Google/Google - Session'))
*/
WebUI.navigateToUrl('https://accounts.google.com')

WebUI.setText(findTestObject('Website/Application CTAs/Google/Google - Email'), GoogleEmail)

WebUI.click(findTestObject('Website/Application CTAs/Google/Google - Button Next 1'))

WebUI.setMaskedText(findTestObject('Website/Application CTAs/Google/Google - Password'), GooglePass)

WebUI.click(findTestObject('Website/Application CTAs/Google/Google - Button Next 2'))

WebUI.verifyElementPresent(findTestObject('Website/Application CTAs/Google/Google - Welcome label'), 3)

