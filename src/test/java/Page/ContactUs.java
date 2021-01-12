package Page;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

public class ContactUs extends PageObject{

    public  ContactUs(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(css = "div.alert")
    private  WebElement errorAlert;

    @FindBy(id = "id_contact")
    private  WebElement subjectSelect;

    @FindBy(id = "email")
    private  WebElement emailInput;

    @FindBy(id = "id_order")
    private  WebElement orderInput;

    @FindBy(id = "message")
    private  WebElement messageTextarea;

    @FindBy(css = "p.alert-success")
    private  WebElement successAlert;

    public ContactUs clickOnSendButton() {
        sendButton.click();
        return this;
    }

    public WebElement getErrorAlert() {
        return errorAlert;
    }

    public  boolean isErrorAlertDisplayed() {
        return getErrorAlert().isDisplayed();
    }

    public ContactUs selectSubject() {
        new Select(subjectSelect).selectByIndex(1);
        return this;
    }

    public ContactUs enterEmail() {
        emailInput.sendKeys("test@test.com");
        return this;
    }

    public ContactUs enterOrder() {
        orderInput.sendKeys("1234567890");
        return this;
    }

    public ContactUs enterMessage() {
        messageTextarea.sendKeys("Message");
        return this;
    }

    public boolean isSuccessMessageDisplayed() {
        return successAlert.isDisplayed();
    }
}
