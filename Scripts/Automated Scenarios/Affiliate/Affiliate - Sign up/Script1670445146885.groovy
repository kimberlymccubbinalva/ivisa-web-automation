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

AffiliateEmail = 'new@affiliate.com'

AffiliatePassword = 'aaaa'

//Sign up as affiliate
WebUI.click(findTestObject('Affiliate/Footer - Affiliate'))

WebUI.setText(findTestObject('Object Repository/Affiliate/Form - Name'), 'Elias')

WebUI.setText(findTestObject('Object Repository/Affiliate/Form - Last name'), 'Taylor')

WebUI.setText(findTestObject('Object Repository/Affiliate/Form - Email'), AffiliateEmail)

WebUI.setText(findTestObject('Object Repository/Affiliate/Form - Website'), 'https://www.myweb.com')

WebUI.setText(findTestObject('Object Repository/Affiliate/Form - Password'), AffiliatePassword)

WebUI.setText(findTestObject('Object Repository/Affiliate/Form - About'), 'More about the website')

WebUI.click(findTestObject('Object Repository/Affiliate/Form - Traffic'))

WebUI.click(findTestObject('Object Repository/Affiliate/Form - Agreement'))

WebUI.click(findTestObject('Object Repository/Affiliate/Form - Captcha'))

WebUI.click(findTestObject('Object Repository/Affiliate/Button - Sign up'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

//Admin User
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.AdminUser)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.GeneraliVisaPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

//Affiliate module
WebUI.click(findTestObject('Object Repository/Admin Portal/Header/Menu - Affiliate'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Header/Menu - Pending Affiliates'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Affiliates/Dropdown - Select affiliate'), '1', false)

WebUI.click(findTestObject('Object Repository/Admin Portal/Affiliates/Button - Approve'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

//Logout admin user
WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

//Login new affiliate
//Login page
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), AffiliateEmail)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), AffiliatePassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

WebUI.click(findTestObject('Website/Header/Dropdown - HiUser'))

WebUI.click(findTestObject('Website/Header/Menu - Logout'))

//Affiliate page
WebUI.click(findTestObject('Affiliate/Footer - Affiliate'))

WebUI.setText(findTestObject('Object Repository/Affiliate/Login - Email'), AffiliateEmail)

WebUI.setText(findTestObject('Object Repository/Affiliate/Login - Password'), AffiliatePassword)

WebUI.click(findTestObject('Object Repository/Affiliate/Button - Login'))

WebUI.click(findTestObject('Website/Header/Dropdown - HiUser'))

WebUI.click(findTestObject('Website/Header/Menu - Logout'))

WebUI.closeBrowser()