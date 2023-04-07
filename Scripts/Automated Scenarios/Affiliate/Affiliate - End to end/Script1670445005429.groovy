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

//Getting an order with utm
WebUI.navigateToUrl(GlobalVariable.ServerURL + '/turkey-turkish-visa?utm_source=zeropromos')

//Reaching the Learn More for destination country
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Dropdown question'), [('Question') : 'Object Repository/Website/Learn More/Dropdown - Nationality'
        , ('Option') : 'United States - US'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Learn More/Button - ApplyNow Learn More'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Starting the application process for destination country
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Trip dates'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '1234-1234')

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), GlobalVariable.CustomerEmail)

//Calling test case Login modal
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Login modal'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Step_3
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Form - Global Questions'), [('Name') : Name, ('LastName') : LastName
        , ('Gender') : 'Male', ('BirthdayMonth') : BirthdayMonth, ('BirthdayDay') : BirthdayDay, ('BirthdayYear') : BirthdayYear
        , ('PassportNumber') : PassportNumber, ('PassportIssueDateMonth') : PassportIssueDateMonth, ('PassportIssueDateDay') : PassportIssueDateDay
        , ('PassportIssueDateYear') : PassportIssueDateYear, ('PassportExpirationMonth') : PassportExpirationMonth, ('PassportExpirationDay') : PassportExpirationDay
        , ('PassportExpirationYear') : PassportExpirationYear], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_4
WebUI.click(findTestObject('Object Repository/Website/Application CTAs/Processing - Super Rush Turkey'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_addons
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_review
WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderSidebar'))

//Step_payment - Calling test case 'Payment'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Application - Payment CC'), [:], FailureHandling.STOP_ON_FAILURE)

//Get order ID
OrderLink = WebUI.getUrl()

OrderID = (OrderLink.split('/')[4])

//Logout customer
WebUI.click(findTestObject('Website/Header/Dropdown - HiUser'))

WebUI.click(findTestObject('Website/Header/Menu - Logout'))

//Login admin
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.AdminUser)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.GeneraliVisaPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

//Complete
//Uploading deliverables
//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Documents section (A1)'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Select document (A1)'), 'visa', false)

WebUI.uploadFile(findTestObject('Admin Portal/Order Details page/Box - Document upload (A1)'), GlobalVariable.PhotoFile)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Save Doc (A1)'))

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'), 0)

WebUI.verifyElementText(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'), 'Complete', FailureHandling.STOP_ON_FAILURE)

//Pay affiliate commission
WebUI.click(findTestObject('Object Repository/Admin Portal/Header/Menu - Affiliate'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Header/Menu - Affiliate make payment'))

WebUI.setText(findTestObject('Admin Portal/Affiliates/Calendar - Make payment'), GlobalVariable.PaymentEndDate)

WebUI.click(findTestObject('Object Repository/Admin Portal/Affiliates/Button - Calculate payment'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Affiliates/Button - Pay affiliate'))

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

//Pay affiliate bonus
Bonnus = 'Testing bonnus payment'

WebUI.click(findTestObject('Object Repository/Admin Portal/Header/Menu - Affiliate'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Header/Menu - Affiliates 1'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Affiliates/Button - Edit affilliate'))

WebUI.scrollToElement(findTestObject('Admin Portal/Affiliates/Button - Pay bonnus'), 1)

WebUI.click(findTestObject('Object Repository/Admin Portal/Affiliates/Button - Pay bonnus'))

WebUI.setText(findTestObject('Object Repository/Admin Portal/Affiliates/Input - Bonnus amount'), '30')

WebUI.selectOptionByValue(findTestObject('Admin Portal/Affiliates/Dropdown - Bonnus currency'), 'EUR', false)

WebUI.setText(findTestObject('Object Repository/Admin Portal/Affiliates/Input - Bonnus description'), Bonnus)

WebUI.click(findTestObject('Object Repository/Admin Portal/Affiliates/Button - Send bonnus'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

//Logout admin
WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.acceptAlert()

//Login new affiliate
//Login page
WebUI.click(findTestObject('Website/Header/Icon - My Account'))

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.AffiliateUser)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.GeneraliVisaPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

//Looking for bonnus paid
WebUI.click(findTestObject('Affiliate/Menu - Activity detail'))

WebUI.click(findTestObject('Object Repository/Affiliate/Menu - Payment history'))

WebUI.setText(findTestObject('Object Repository/Affiliate/Calendar - Payment endDate'), GlobalVariable.PaymentEndDate)

WebUI.click(findTestObject('Object Repository/Affiliate/Button - Update payment'))

RecentBonnus = WebUI.getText(findTestObject('Affiliate/Label - Bonnus description'))

WebUI.verifyEqual(RecentBonnus, Bonnus)

//Logout
WebUI.click(findTestObject('Website/Header/Dropdown - HiUser'))

WebUI.click(findTestObject('Website/Header/Menu - Logout'))

WebUI.closeBrowser()

