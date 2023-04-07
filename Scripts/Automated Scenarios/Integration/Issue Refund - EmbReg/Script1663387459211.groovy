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

import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

//Calling test case EmbReg
WebUI.callTestCase(findTestCase('Automated Products/Call - Embassy Registration 2'), [('Email') : GlobalVariable.CustomerEmail
        , ('Name') : 'Taylor', ('LastName') : 'Loren', ('Gender') : 'Male', ('BirthdayMonth') : '9', ('BirthdayDay') : '19'
        , ('BirthdayYear') : '1994', ('PassportNumber') : '12345', ('PassportIssueDateMonth') : '5', ('PassportIssueDateDay') : '1'
        , ('PassportIssueDateYear') : '2020', ('PassportExpirationMonth') : '5', ('PassportExpirationDay') : '1', ('PassportExpirationYear') : '2025'], 
    FailureHandling.STOP_ON_FAILURE)

//Get order ID
OrderLink = WebUI.getUrl()

OrderID = (OrderLink.split('/')[4])

//Calling test case 'Setting Password'
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Account - Set Password'), [('Password') : 'aaaa'], FailureHandling.OPTIONAL)

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

//Admin portal
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Login - Admin user'), [:], FailureHandling.STOP_ON_FAILURE)

//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Label href - US Embassy Registration'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'), 2)

WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'))

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Label - Order Number'), 2)

//Generate refund link
WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Other actions'), 'request_refund_url', false)

String my_clipboard = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null).getTransferData(DataFlavor.stringFlavor);

System.out.println(my_clipboard)

WebUI.delay(2)

WebUI.acceptAlert(FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.delay(2)

WebUI.acceptAlert()

//Reaching Refund Form
WebUI.navigateToUrl(my_clipboard)

WebUI.click(findTestObject('Website/Login page/Option 3 - Login with password'))

WebUI.click(findTestObject('Website/Login page/Option 3.1 - User email'))

WebUI.setText(findTestObject('Website/Login page/Option 3.1 - User email'), GlobalVariable.CustomerEmail)

WebUI.click(findTestObject('Website/Login page/Option 3.2 - User password'))

WebUI.setText(findTestObject('Website/Login page/Option 3.2 - User password'), GlobalVariable.CustomerPassword)

WebUI.click(findTestObject('Website/Login page/Button - Login'))

WebUI.check(findTestObject('Admin Portal/Issue Refund/Refund Form - Checkbox'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Issue Refund/Refund Form - Refund Reason'), 'missed_deadline', false)

WebUI.setText(findTestObject('Admin Portal/Issue Refund/Refund Form - Refund Comment'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Admin Portal/Issue Refund/Refund Form - Submit Form'))

WebUI.delay(2)

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

//Admin portal
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Login - Admin user'), [:], FailureHandling.STOP_ON_FAILURE)

//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Label href - US Embassy Registration'))

//Issue refund
WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Other actions'), 'issue_refund', false)

WebUI.acceptAlert()

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Dropdown - Refund category'), 'company', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Issue Refund/Issue Refund - Reason'), 'test_order', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Issue Refund/Issue Refund - Manually Perfomed'), 'true', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Issue Refund/Issue Refund - Refund Method'), 'wire_transfer', false)

WebUI.setText(findTestObject('Admin Portal/Issue Refund/Issue Refund - Confirmation Code'), '12345')

WebUI.check(findTestObject('Admin Portal/Issue Refund/Refund Items (A1)'))

WebUI.check(findTestObject('Admin Portal/Issue Refund/Refund Option 1 (A1)'))

//WebUI.setText(findTestObject('Admin Portal/Order Details page/Textbox - order_id'), OrderID)
WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Email Preview'))

WebUI.click(findTestObject('Admin Portal/Issue Refund/Button - Issue Refund'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

//Log out
WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.delay(2)

WebUI.acceptAlert()

WebUI.closeBrowser()

