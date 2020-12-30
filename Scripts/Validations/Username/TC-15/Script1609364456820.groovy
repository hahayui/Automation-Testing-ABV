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

WebUI.sendKeys(findTestObject('Form Fields/Username Field'), '                       ')

WebUI.focus(findTestObject('Form Fields/First Password Field'))

WebUI.verifyElementText(findTestObject('Form Validation Messages/Username MSG'), GlobalVariable.invalid_data_in_the_username_field)

println(getColor())

WebUI.verifyEqual(getColor(), GlobalVariable.expected_red_color_For_validation_msg)

WebUI.closeBrowser( //Getting the RGBA value of the text color part of the element.  
    )

String getColor() {
    return WebUI.getCSSValue(findTestObject('Object Repository/Form Validation Messages/Username MSG'), 'color')
}

