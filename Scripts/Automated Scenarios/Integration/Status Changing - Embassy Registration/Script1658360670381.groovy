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

OrderStatus = WebUI.getText(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Dropdown - Add MIN'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Filter - Add MIN'))

WebUI.setText(findTestObject('Admin Portal/Order Details page/Filter - Add MIN'), 'Address In Zambia (textbox)')

WebUI.sendKeys(findTestObject('Admin Portal/Order Details page/Filter - Add MIN'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - OK new MIN'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/MIN Icon - passport_number'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/MIN Reason - passport_number'))

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 0)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 'info_needed', false)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Yes change to MIN'))

WebUI.setText(findTestObject('Object Repository/Admin Portal/Order Details page/Textbox - order_id'), OrderID, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Email Preview'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Change Status'))

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.acceptAlert()

//Mailhog
//Log in to solve MIN
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Mailhog - Get email link'), 
	[('EmailSubject') : 'Object Repository/Admin Portal/Mailhog/Email Subject - Action Required PH', 
		('EmbedLink') : 'Object Repository/Admin Portal/Mailhog/Email URL - login_link'], FailureHandling.STOP_ON_FAILURE)

//Solve MIN
WebUI.setText(findTestObject('Website/General questions/ID 378 - address_in_zambia.general'), GlobalVariable.GeneralString)

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

WebUI.clearText(findTestObject('Object Repository/Website/General questions/ID 10 - passport_num (A1)'))

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 10 - passport_num (A1)'), '12345678')

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitApplication'))

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitApplication'), FailureHandling.OPTIONAL)

//Log out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

//Admin portal
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Login - Admin user'), [:], FailureHandling.STOP_ON_FAILURE)

//Cancel
//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Label href - US Embassy Registration'))

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 0)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 'cancelled', false)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Dropdown - Cancel reason ER'), 
    'test_order', false)

WebUI.setText(findTestObject('Object Repository/Admin Portal/Order Details page/Textbox - order_id'), OrderID, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Email Preview'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Change Status'))

//Complete
//Uploading deliverables
//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Label href - US Embassy Registration'))

WebUI.scrollToElement(findTestObject('Object Repository/Admin Portal/Order Details page/Dropdown - Other actions'), 0)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Dropdown - Other actions'), 
    'reprocess_order', false)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Reprocess PH - Responsible'), 
    'agent_csa', false)

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Reprocess PH - Reason'), 'name', 
    false)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - Reprocess Proceed'))

WebUI.delay(3)

WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

//Applicant 1
WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Documents section (A1)'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Select document (A1)'), 'embassy_reg', 
    false)

WebUI.uploadFile(findTestObject('Admin Portal/Order Details page/Box - Document upload (A1)'), GlobalVariable.PhotoFile)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Save Doc (A1)'))

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 0)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 'complete', false)

WebUI.setText(findTestObject('Object Repository/Admin Portal/Order Details page/Textbox - order_id'), OrderID, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Email Preview'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Change Status'))

//Verify status
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Label href - US Embassy Registration'))

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'), 0)

WebUI.verifyElementText(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'), 'Complete', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.closeBrowser()