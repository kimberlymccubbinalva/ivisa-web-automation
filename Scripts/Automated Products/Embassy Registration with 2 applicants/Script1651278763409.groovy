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

WebUI.navigateToUrl('https://master--b609bc44.visachinaonline.com/embassy-registration#step=step_1')

WebUI.click(findTestObject('Website/General questions/ID 2 - arrival_date.general'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('Website/General questions/ID 3 - departure_date.general'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 339 - destination_country.general'), 'AR', true)

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 359 - emergency_contact_email.general'), 'emergency@contact.com')

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 128 - emergency_contact_name.general'), 'Lee Santos')

WebUI.setText(findTestObject('Object Repository/Website/General questions/ID 129 - emergency_contact_phone.general'), '321323112')

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('Website/General questions/ID 1 - email'), 'test.mail@mail.com')

WebUI.setText(findTestObject('Website/General questions/ID 5 - first_name (A1)'), 'Reyna')

WebUI.setText(findTestObject('Website/General questions/ID 6 - last_name (A1)'), 'Lopez')

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 7 - nationality_country (A1)'), 'ES', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 9 - gender (A1)'), 'Female', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 8 - dob.month (A1)'), '5', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 8 - dob.day (A1)'), '8', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 8 - dob.year (A1)'), '1989', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 65 - birth_country (A1)'), 'ES', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 64 - home_country (A1)'), 'ES', true)

WebUI.setText(findTestObject('Website/General questions/ID 10 - passport_num (A1)'), '98473482')

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 66 - passport_issued_date.month (A1)'), '7', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 66 - passport_issued_date.day (A1)'), '6', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 66 - passport_issued_date.year (A1)'), '2019', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 11 - passport_expiration_date.month (A1)'), '5', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 11 - passport_expiration_date.day (A1)'), '6', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 11 - passport_expiration_date.year (A1)'), '2024', true)

WebUI.click(findTestObject('null'))

WebUI.setText(findTestObject('Website/General questions/ID 5 - first_name (A2)'), 'Luis')

WebUI.setText(findTestObject('Website/General questions/ID 6 - last_name (A2)'), 'Thurner')

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 7 - nationality_country (A2)'), 'AU', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 9 - gender (A2)'), 'Male', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 8 - dob.month (A2)'), '8', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 8 - dob.day (A2)'), '4', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 8 - dob.year (A2)'), '1987', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 65 - birth_country (A2)'), 'AU', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Website/General questions/ID 64 - home_country (A2)'), 'AU', true)

WebUI.setText(findTestObject('Website/General questions/ID 10 - passport_num (A2)'), '93423984')

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 66 - passport_issued_date.month (A2)'), '5', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 66 - passport_issued_date.day (A2)'), '5', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 66 - passport_issued_date.year (A2)'), '2019', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 11 - passport_expiration_date.month (A2)'), '5', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 11 - passport_expiration_date.day (A2)'), '3', true)

WebUI.selectOptionByValue(findTestObject('Website/General questions/ID 11 - passport_expiration_date.year (A2)'), '2025', true)

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.closeBrowser()

