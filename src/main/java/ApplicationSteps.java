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
    }
}
