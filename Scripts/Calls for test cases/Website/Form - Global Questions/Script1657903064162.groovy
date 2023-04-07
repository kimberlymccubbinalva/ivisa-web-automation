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

//Applicant #1
WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 5 - first_name (A1)'), Name)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 6 - last_name (A1)'), LastName)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 9 - gender (A1)'), 'Male', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.month (A1)'), BirthdayMonth, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.day (A1)'), BirthdayDay, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 8 - dob.year (A1)'), BirthdayYear, true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 10 - passport_num (A1)'), PassportNumber)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.month (A1)'), 
    PassportExpirationMonth, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.day (A1)'), 
    PassportExpirationDay, true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 11 - passport_expiration_date.year (A1)'), 
    PassportExpirationYear, true)

//No longer part of global questions
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.month (A1)'),
	2, FailureHandling.OPTIONAL)) {
WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.month (A1)'),
	PassportIssueDateMonth, true, FailureHandling.OPTIONAL)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.day (A1)'),
	PassportIssueDateDay, true, FailureHandling.OPTIONAL)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 66 - passport_issued_date.year (A1)'),
	PassportIssueDateYear, true, FailureHandling.OPTIONAL)
}