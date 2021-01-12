package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends PageObject {

    public TopMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "contact-link")
    private WebElement contactUsButton;

    @FindBy(css = "a.login")
    private WebElement signInButton;

    public ContactUs clickOnContactUsButton() {
        contactUsButton.click();
        return new ContactUs(driver);
    }

    public SignIn clickOnSignInButton() {
        signInButton.click();
        return new SignIn(driver);
    }
}
