import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;

public class ApplicationPageObjects {
    private WebDriver driver;
    private Config config;

    private static final String acceptButton = "onetrust-accept-btn-handler";
    private static final String firstNameField = "first_name";
    private static final String lastNameField = "last_name";
    private static final String emailField = "email";
    private static final String phoneField = "phone";
    private static final String cvText = "resume_text";
    private static final String manualButton = "//button[@class='unstyled-button link-button' and text() = 'or enter manually']";
    private static final String githubField = "job_application_answers_attributes_2_text_value";
    private static final String privacyPolicyDropdown = "select2-container";
    private static final String yesButton = "//div[text()='Yes']";
    private static final String privacyPolicyOpenedDropdown = "select2-container select2-container-active select2-dropdown-open";
    private static final String submitField = "submit_app";

    public ApplicationPageObjects(WebDriver driver) {
        this.driver = driver;
        config = new Config(driver);
    }

    //ToDo: move to base page object page
    public void scrollIntoView(String locator) {
        WebElement element = driver.findElement(By.className(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForAcceptButton() {
        config.waitForElement(By.id(acceptButton), Constants.WAIT_DURATION);
    }

    public void waitForDropdown() {
        config.waitForElement(By.id(privacyPolicyOpenedDropdown), Constants.WAIT_DURATION);
    }

    public void waitForCVField() {
        config.waitForElement(By.id(cvText), Constants.WAIT_DURATION);
    }

    public void waitForFields() {
        config.waitForElement(By.xpath(firstNameField), Constants.WAIT_DURATION);
    }

    public void waitForDisappearAcceptButton() {
        config.waitForElementDisappear(By.id(acceptButton), Constants.WAIT_DURATION);
    }

    public void acceptCookies() {
        driver.findElements(By.id(acceptButton))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .click();
    }

    public void fillFirstName() {
        driver.switchTo().frame("grnhse_iframe");
        driver.findElements(By.id(firstNameField))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .sendKeys(Constants.FIRST_NAME);
    }

    public void fillLastName() {
        driver.findElements(By.id(lastNameField))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .sendKeys(Constants.LAST_NAME);
    }

    public void fillEmailField() {
        driver.findElements(By.id(emailField))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .sendKeys(Constants.EMAIL);
    }

    public void fillPhoneField() {
        driver.findElements(By.id(phoneField))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .sendKeys(Constants.PHONE);
    }

    public void attachCV() {
        driver.findElements(By.id(cvText))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .sendKeys(Constants.CV_PATH);
    }

    public void clickManualButton() {
        driver.findElements(By.xpath(manualButton))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .click();
    }

    public void fillGitHubField() {
        driver.findElements(By.id(githubField))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .sendKeys(Constants.GITHUB);
    }

    public void acceptPrivacyPolicy() {
        scrollIntoView(privacyPolicyDropdown);
        WebElement dropdown = driver.findElement(By.className(privacyPolicyDropdown));
        dropdown.click();
        waitForDropdown();
        driver.findElements(By.xpath(yesButton))
                .get(0)
                .click();
    }

    public void submitApplication() {
        driver.findElements(By.id(submitField))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .click();
    }
}
