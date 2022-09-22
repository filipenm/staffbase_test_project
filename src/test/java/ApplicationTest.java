import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplicationTest extends BaseTest {
    @Test
    public void verifyUserCanApplyTest() {
        String getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, "Google");
    }
}
