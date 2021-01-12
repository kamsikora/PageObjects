package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignIn extends PageObject{

    public  SignIn(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy(id = "create_account_error")
    private WebElement createAnAccountError;

    public void clickOnCreateAnAccountButton() {
        createAnAccountButton.click();
    }

    public boolean isCreateAnAccountErrorAlertDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(createAnAccountError));
        return createAnAccountError.isDisplayed();
    }
}
