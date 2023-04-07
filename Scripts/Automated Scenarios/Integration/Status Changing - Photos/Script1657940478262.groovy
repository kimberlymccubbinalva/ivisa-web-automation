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

//Calling test case Photo order
WebUI.callTestCase(findTestCase('Test Cases/Automated Products/Call - Printed Passport Photo, Home delivery'), [:], FailureHandling.STOP_ON_FAILURE)

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

WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

OrderStatus = WebUI.getText(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'))

WebUI.click(findTestObject('Admin Portal/Order Details page/MIN Icon - Phone'))

WebUI.click(findTestObject('Admin Portal/Order Details page/MIN Reason - Phone'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Dropdown - Add MIN'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Filter - Add MIN'))

WebUI.setText(findTestObject('Admin Portal/Order Details page/Filter - Add MIN'), 'Address In Zambia (textbox)')

WebUI.sendKeys(findTestObject('Admin Portal/Order Details page/Filter - Add MIN'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - OK new MIN'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

//Per applicant
//Applicant 1
WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - Documents section (A1)'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Document - Applicant Photo'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - More Info File'))

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/MIN Reason - applicant_photo'))

//Change status to MIN
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
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Mailhog - Get email link'), [('EmailSubject') : 'Object Repository/Admin Portal/Mailhog/Email Subject - Action Required PH'
        , ('EmbedLink') : 'Object Repository/Admin Portal/Mailhog/Email URL - login_link'], FailureHandling.STOP_ON_FAILURE)

//Solve MIN
//General
WebUI.setText(findTestObject('Website/General questions/ID 378 - address_in_zambia.general'), GlobalVariable.GeneralString)

WebUI.clearText(findTestObject('Website/General questions/ID 4 - phone'))

WebUI.setText(findTestObject('Website/General questions/ID 4 - phone'), '4444-4444')

WebUI.click(findTestObject('Website/Application CTAs/Button - ContinueUnderForm'))

//Per applicant
WebUI.uploadFile(findTestObject('Website/General questions/ID 100 - passport_photo (A1)'), GlobalVariable.PhotoFile)

WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitApplication'))

//Log out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

//Admin portal
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Login - Admin user'), [:], FailureHandling.STOP_ON_FAILURE)

//Cancel
//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 0)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Change Status'), 'cancelled', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Cancel Reason PH'), 'test_order', false)

WebUI.setText(findTestObject('Object Repository/Admin Portal/Order Details page/Textbox - order_id'), OrderID, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Email Preview'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Change Status'))

//Reprocess 1
//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/Admin Portal/Order Details page/Dropdown - Other actions'), 0)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Dropdown - Other actions'), 
    'reprocess_order', false)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Reprocess PH - Responsible'), 
    'agent_csa', false)

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Reprocess PH - Reason'), 'wrong_photo_size', 
    false)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - Reprocess Proceed'))

WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Object Repository/Admin Portal/Order Details page/Dropdown - Other actions'), 
    'reprocess_order', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Reprocess PH - Responsible'), 'client_paid', false)

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Reprocess PH - Reason'), 'add_more_photos', false)

WebUI.click(findTestObject('Object Repository/Admin Portal/Order Details page/Button - Reprocess Proceed'))

WebUI.delay(3)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Confirm'), FailureHandling.OPTIONAL)

//Charge more money
WebUI.selectOptionByValue(findTestObject('Admin Portal/Charge More Money/Dropdown - Charge Type'), 'service_fee', false)

WebUI.clearText(findTestObject('Admin Portal/Charge More Money/Textbox - Charge amount'))

WebUI.setText(findTestObject('Admin Portal/Charge More Money/Textbox - Charge amount'), '30')

WebUI.selectOptionByValue(findTestObject('Admin Portal/Charge More Money/Dropdown - Charge Reason'), 'Reorder', false)

WebUI.setText(findTestObject('Object Repository/Admin Portal/Order Details page/Textbox - order_id'), OrderID, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Email Preview'))

WebUI.click(findTestObject('Admin Portal/Charge More Money/Button - Send Charge Request'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Confirm'))

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.acceptAlert()

//Mailhog
//Log in to pay extra charge
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Mailhog - Get email link'), [('EmailSubject') : 'Object Repository/Admin Portal/Mailhog/Email Subject - Action Required PH'
        , ('EmbedLink') : 'Object Repository/Admin Portal/Mailhog/Email URL - approve_charge_request'], FailureHandling.STOP_ON_FAILURE)

//Pay charge more money
WebUI.click(findTestObject('Website/Application CTAs/Button - SubmitExtraCharge'))

WebUI.click(findTestObject('Website/Application CTAs/Button - ConfirmationModalOK'))

//Loging out
WebUI.callTestCase(findTestCase('Calls for test cases/Website/Logout - External user'), [:], FailureHandling.OPTIONAL)

//Admin portal
WebUI.callTestCase(findTestCase('Calls for test cases/Admin Portal/Login - Admin user'), [:], FailureHandling.STOP_ON_FAILURE)

//Complete
//Uploading deliverables
//Searching order ID
WebUI.callTestCase(findTestCase('Test Cases/Calls for test cases/Admin Portal/Search Order ID'), [('OrderID') : OrderID], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin Portal/Order Details page/Collapse - Info'))

//Applicant 1
WebUI.click(findTestObject('Admin Portal/Order Details page/Tab - Applicant 1'))

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Documents section (A1)'))

WebUI.selectOptionByValue(findTestObject('Admin Portal/Order Details page/Dropdown - Select document (A1)'), 'applicant_photo_cleaned', 
    false)

WebUI.uploadFile(findTestObject('Admin Portal/Order Details page/Box - Document upload (A1)'), GlobalVariable.PhotoFile)

WebUI.click(findTestObject('Admin Portal/Order Details page/Button - Save Doc (A1)'))

//Verify status
WebUI.scrollToElement(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'), 0)

WebUI.verifyElementText(findTestObject('Admin Portal/Order Details page/Label - Current Order Status'), 'Complete', FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin Portal/Header/Button - Logout'))

WebUI.closeBrowser()

