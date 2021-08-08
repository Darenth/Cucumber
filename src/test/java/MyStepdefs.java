import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs extends BaseUtil {

    private BaseUtil baseUtil;

    public MyStepdefs(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }


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

    @After
    public void tearDown() {
        driver.quit();
    }


    @Given("I am in the login page of the Para Bank Application")
    public void iAmInTheLoginPageOfTheParaBankApplication() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        driver.findElement(By.name("username")).sendKeys("autotester");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("password")).submit();
    }


    @When("I enter valid credentials from Data Table")
    public void iEnterValidCredentialsFromDataTable(DataTable table) {

        List<String> loginForm = table.asList();
        driver.findElement(By.name("username")).sendKeys(loginForm.get(0));
        driver.findElement(By.name("password")).sendKeys(loginForm.get(1));
        driver.findElement(By.name("password")).submit();
    }

    @When("I enter valid {string} and {string}")
    public void iEnterValidCredentialsWithParameters(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("password")).submit();
    }

    @When("I enter valid {string} and {string} with {string}")
    public void iEnterValidCredentials(String username, String password, String userFullName) {

        baseUtil.userFullName = userFullName;

        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("username")).submit();

    }

    @Then("I should be taken to the Overview page")
    public void iShouldBeTakenToTheOverviewPage() {
        driver.findElement(By.className("title")).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("smallText")));
        String actualUserFullName = driver.findElement(By.className("smallText")).getText();
        assertTrue(actualUserFullName.contains(baseUtil.userFullName));
        driver.findElement(By.linkText("Log Out")).click();


    }


}
