import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.stream.Collectors;

public class ApplicationPageObjects {
    private WebDriver driver;
    private Config config;

    public ApplicationPageObjects(WebDriver driver) {
        this.driver = driver;
        config = new Config(driver);
    }

    private static final String acceptButton = "onetrust-accept-btn-handler";

    public void waitForAcceptButton() {
        config.waitForElement(By.id(acceptButton), Duration.ofMillis(1000));
    }

    public void acceptCookies() {
        driver.findElements(By.id(acceptButton))
                .stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList())
                .get(0)
                .click();
    }
}
