package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pombase.BasePage;

public class Register extends BasePage {
    public Register()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Register")
    WebElement Register;
    @FindBy(className="select-preferred-store")
    WebElement changePreferredStore;
    @FindBy(id = "firstname")
    WebElement firstName;
    @FindBy(id = "lastname")
    WebElement lastname;
    @FindBy(id = "emailAddress")
    WebElement emailAddress;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "confirmPassword")
    WebElement confirmPass;
    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement createAc;

    public void clickRegister()
    {
        Register.click();
    }

    public void clickStore()
    {
        changePreferredStore.click();
    }

    public void userDetails(String fname,String lname,String email,String pass,String confirmpass)
    {
        firstName.sendKeys(fname);
        lastname.sendKeys(lname);
        emailAddress.sendKeys(email);
        password.sendKeys(pass);
        confirmPass.sendKeys(confirmpass);
        createAc.click();
    }
}

