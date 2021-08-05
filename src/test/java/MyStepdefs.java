import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }


    @Given("I am in the login page of the Para Bank Application")
    public void iAmInTheLoginPageOfTheParaBankApplication() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("teautester");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("password")).submit();
    }

    @Then("I should be taken to the Overview page")
    public void iShouldBeTakenToTheOverviewPage() {
        driver.findElement(By.className("title")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();


    }
}
