package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pombase.BasePage;

public class SignIn extends BasePage {
    public SignIn(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = ".//*[@id='signInLink']")
    WebElement signInLink;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Sign In')]")
    WebElement signInButton;

    @FindBy(className = "mz-utilitynav-link mz-user-firstname")
    WebElement userId;

    @FindBy(xpath = "//*[@id=\"mz-logged-in-notice\"]/a[2]")
    WebElement checkSignOutLink;



    public void setSignInLink(){
        signInLink.click();
    }

    public void enterEmail(String username)
    {
      email.sendKeys(username);

    }

    public void enterPassword(String pass)
    {
        password.sendKeys(pass);
    }

    public void clickSignInButton() throws InterruptedException {
        Thread.sleep(2000);
        signInButton.click();
    }

    public boolean checkSignIn(){
        boolean flag=checkSignOutLink.isDisplayed();
        return flag;
    }



}
