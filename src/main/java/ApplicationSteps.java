import org.openqa.selenium.WebDriver;

public class ApplicationSteps {
    private final WebDriver driver;
    protected ApplicationPageObjects applicationPageObjects;

    public ApplicationSteps(WebDriver driver) {
        this.driver = driver;
        init();
    }

    public void init() {
        applicationPageObjects = new ApplicationPageObjects(driver);
    }

    public void acceptCookies() {
        applicationPageObjects.waitForAcceptButton();
        applicationPageObjects.acceptCookies();
        applicationPageObjects.waitForDisappearAcceptButton();
    }

    public void fillOutFields() {
        applicationPageObjects.waitForFields();
        applicationPageObjects.fillFirstName();
        applicationPageObjects.fillLastName();
        applicationPageObjects.fillEmailField();
        applicationPageObjects.fillPhoneField();
        applicationPageObjects.clickManualButton();
        applicationPageObjects.waitForCVField();
        applicationPageObjects.attachCV();
        applicationPageObjects.acceptPrivacyPolicy();
        applicationPageObjects.fillGitHubField();
    }

    public void submitApplication() {
        //applicationPageObjects.submitApplication();
    }
}
