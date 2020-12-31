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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.abv.bg/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Global Objects/Consent To All'))

WebUI.setText(findTestObject('Home Page/Login username field'), GlobalVariable.Username)

WebUI.setEncryptedText(findTestObject('Home Page/Login password field'), GlobalVariable.Password)

WebUI.click(findTestObject('Home Page/Login Button'))

WebUI.click(findTestObject('Mail Homepage/Inbox'))

//Init a web driver
WebDriver driver = DriverFactory.getWebDriver()

//Locating the table body
/*The table can not be identified at this moment with any other selector and this is why we keep it only to the first page.
 * The only way of identifying the table is by XPath which will be changed if the page of results is changed.*/
WebElement tableBody = driver.findElement(By.xpath('/html/body/div[1]/div/div[4]/div/div[4]/div/div[4]/div/div[2]/div/div[2]/div/div[6]/div/div/div[2]/table/tbody[1]'))

//Locating every unread email
List<Object> emails = tableBody.findElements(By.tagName("tr"))

//Calculating the unread emails on the first page
int countUnreadEmails = emails.size()


println(countUnreadEmails)

WebUI.closeBrowser()

