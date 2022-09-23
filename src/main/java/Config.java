import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Config {
    private WebDriver driver;

    public Config(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean waitForCondition(Callable<Boolean> condition, Integer timeout, Integer pollInterval) {
        try {
            Awaitility.await()
                    .timeout(
                            timeout,
                            TimeUnit.MILLISECONDS
                    )
                    .pollInterval(
                            pollInterval,
                            TimeUnit.MILLISECONDS
                    )
                    .until(condition);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void waitForElement(By locator, int timeoutInSeconds) {
        waitForCondition(
                () -> driver.findElement(locator).isDisplayed(), timeoutInSeconds, timeoutInSeconds / 5
        );
    }

    public void waitForElementDisappear(By locator, int timeoutInSeconds) {
        waitForCondition(
                () -> !driver.findElement(locator).isDisplayed(), timeoutInSeconds, timeoutInSeconds / 5
        );
    }

}
