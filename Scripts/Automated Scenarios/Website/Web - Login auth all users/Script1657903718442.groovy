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

//Customer User
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.CustomerEmail)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.CustomerPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

WebUI.click(findTestObject('Website/Header/Dropdown - HiUser'))

WebUI.click(findTestObject('Website/Header/Menu - Logout'))

//Affiliate User
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.AffiliateUser)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.GeneraliVisaPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

WebUI.click(findTestObject('Website/Header/Dropdown - HiUser'))

WebUI.click(findTestObject('Website/Header/Menu - Logout'))

//Admin User
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.AdminUser)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.GeneraliVisaPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.closeBrowser()
