import Page.ContactUs;
import Page.ScreenShot;
import Page.SignIn;
import Page.TopMenu;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.assertj.core.api.Assertions;

public class Main {
    private static WebDriver driver;
    private static TopMenu topMenu;
    private static ContactUs contactUs;
    private static SignIn signIn;
    private static ScreenShot screenShot;
    
    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        topMenu = new TopMenu(driver);
        contactUs = new ContactUs(driver);
        signIn = new SignIn(driver);
        screenShot = new ScreenShot(driver);
    }

    @BeforeEach
    public  void beforeEach() {
        driver.get("http://automationpractice.com/");
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void checkTitle() {
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Store");
    }

    @Test
    public void canNotSendContactUsMessageWithEmptyEmail() {
        topMenu.clickOnContactUsButton();
        contactUs.clickOnSendButton();
        Assertions.assertThat(contactUs.isErrorAlertDisplayed()).isTrue();
        screenShot.capturePageScreenshot();
    }
    
    @Test
    public void canNotCreateAnAccountWithEmptyEmail() {
        topMenu.clickOnSignInButton();
        signIn.clickOnCreateAnAccountButton();
        Assertions.assertThat(signIn.isCreateAnAccountErrorAlertDisplayed()).isTrue();
        screenShot.capturePageScreenshot();
    }

    @Test
    public void sendContactUsMessage() {
        topMenu.clickOnContactUsButton();
        contactUs.selectSubject()
                .enterEmail()
                .enterOrder()
                .enterMessage()
                .clickOnSendButton();
        Assertions.assertThat(contactUs.isSuccessMessageDisplayed()).isTrue();
        screenShot.capturePageScreenshot();
    }
}
