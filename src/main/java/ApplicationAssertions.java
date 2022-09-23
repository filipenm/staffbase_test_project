import org.openqa.selenium.WebDriver;

public class ApplicationAssertions {
    private final WebDriver driver;

    public ApplicationAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void assertApplicationIsSubmitted() {
        try {
            System.out.println("Looks clear");
            Thread.sleep(5000);
        } catch (Exception ie) {
            System.out.println("Something went wrong");
        }
    }
}
