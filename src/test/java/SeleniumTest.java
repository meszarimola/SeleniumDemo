import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
  private WebDriver driver;
  private String expectedTitle;
  private String actualTitle;

  //Just one Selenium test
  @BeforeTest
  public void setUp() {
//    System.setProperty("webdriver.chrome.driver", "C:\\Users\\alice\\IdeaProjects\\SeleniumDemo\\chromedriver.exe");
//    ChromeOptions options = new ChromeOptions();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
  }

  @Test
  public void testTitle() {
    driver.get("https://bevasarlas.tesco.hu/groceries/en-GB");
    expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
    actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  @AfterTest
  public void tearDown() {
    driver.close();
  }

  //Gherkin lines, BDD
  @Given("I am on the home page")
  public void i_am_on_the_home_page(){
//    System.setProperty("webdriver.chrome.driver", "C:\\Users\\alice\\IdeaProjects\\SeleniumDemo\\chromedriver.exe");
//    ChromeOptions options = new ChromeOptions();
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://bevasarlas.tesco.hu/groceries/en-GB");
  }

  @When("I check the page title")
  public void i_check_the_page_title(){
    expectedTitle = "Tesco Groceries - Online food shopping - Grocery delivery - Tesco Online, Tesco From Home";
    actualTitle = driver.getTitle();
  }

  @Then("I see the Tesco home page")
  public void i_see_the_tesco_home_page(){
    Assert.assertEquals(actualTitle, expectedTitle);
    driver.close();
  }

}
