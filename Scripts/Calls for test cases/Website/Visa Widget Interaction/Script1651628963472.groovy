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

//Interacting with the visa widget in the homepage
WebUI.click(findTestObject('Object Repository/Website/Visa widget/WidQuestion - Traveling from'))

WebUI.click(findTestObject('Object Repository/Website/Visa widget/Input Traveling from'))

WebUI.setText(findTestObject('Object Repository/Website/Visa widget/Input Traveling from'), Nationality)

WebUI.sendKeys(findTestObject('Object Repository/Website/Visa widget/Input Traveling from'), Keys.chord(Keys.ENTER))

//WebUI.click(findTestObject('Website/Visa widget/Filter 2'))

//WebUI.click(findTestObject('Object Repository/Website/Visa widget/WidQuestion - Traveling to'))

WebUI.click(findTestObject('Object Repository/Website/Visa widget/Input Traveling to'))

WebUI.setText(findTestObject('Object Repository/Website/Visa widget/Input Traveling to'), Destination)

WebUI.sendKeys(findTestObject('Object Repository/Website/Visa widget/Input Traveling to'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Website/Visa widget/Button - GetStarted Widget'))

WebUI.waitForElementPresent(findTestObject('Website/Learn More/Button - ApplyNow Learn More'), 2)
