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

//Affiliate
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.AffiliateUser)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.GeneraliVisaPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

//Menus interaction
WebUI.click(findTestObject('Affiliate/Menu - Dashboard'))

WebUI.click(findTestObject('Affiliate/Menu - Activity detail'))

WebUI.click(findTestObject('Affiliate/Menu - Order history'))

WebUI.click(findTestObject('Affiliate/Menu - Payment history'))

WebUI.click(findTestObject('Affiliate/Menu - Assets'))

WebUI.click(findTestObject('Affiliate/Menu - Account'))

WebUI.click(findTestObject('Affiliate/Menu - Resources'))

//Logout
WebUI.click(findTestObject('Website/Header/Dropdown - HiUser'))

WebUI.click(findTestObject('Website/Header/Menu - Logout'))

WebUI.closeBrowser()

