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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://passport.abv.bg/app/profiles/registration')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Global Objects/Consent To All'))

WebUI.click(findTestObject('Form Fields/Username Field'))

WebUI.sendKeys(findTestObject('Form Fields/Username Field'), 'john_test')

WebUI.focus(findTestObject('Form Fields/First Password Field'))

WebUI.verifyTextNotPresent('Моля попълнете полето АБВ потребител.', false)

WebUI.verifyTextNotPresent('Полето АБВ потребител е попълнено некоректно', false)

WebUI.verifyElementNotPresent(findTestObject('Form Validation Messages/Username MSG'), 0)

WebUI.closeBrowser()

