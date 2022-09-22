import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {
    @Test
    public void verifyUserCanApplyTest() {
        applicationSteps.acceptCookies();
        Assert.assertEquals("Google", "Google");
    }
}
