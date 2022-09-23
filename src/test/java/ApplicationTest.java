
import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {
    @Test
    public void verifyUserCanApplyTest() {
        applicationSteps.acceptCookies();
        applicationSteps.fillOutFields();
        applicationSteps.submitApplication();
        applicationAssertions.assertApplicationIsSubmitted();
    }
}
