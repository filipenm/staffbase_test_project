import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public WebDriver driver;
    private static final String baseUrl = "https://staffbase.com/jobs/quality-assurance-engineer-2021_1730/apply";

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("webdriver.chrome.driver", "/Users/user/Documents/chrome_driver/chromedriver");
        WebDriver wd = new ChromeDriver();
        wd.get(baseUrl);
    }

    @BeforeClass
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
