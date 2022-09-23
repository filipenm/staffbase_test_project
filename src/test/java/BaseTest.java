import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private WebDriver driver;
    protected ApplicationSteps applicationSteps;
    protected ApplicationAssertions applicationAssertions;
    private static final String baseUrl = Constants.URL;

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", Constants.DRIVER_PATH);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        init();
    }

    public void init() {
        applicationSteps = new ApplicationSteps(driver);
        applicationAssertions = new ApplicationAssertions(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
