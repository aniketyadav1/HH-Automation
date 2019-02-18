package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pombase.BasePage;

public class Checkout extends BasePage {

    public Checkout()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "checkout-attribute-firstPersonFirstName")
    WebElement firstPersonFirstName;

    @FindBy(id = "checkout-attribute-firstPersonLastName")
    WebElement firstPersonLastName;

    @FindBy(id = "checkout-attribute-firstPersonEmail")
    WebElement firstPersonEmail;

    @FindBy(xpath = "//*[@id=\"instore-pickup-info\"]/div[1]/div[2]/div[5]/div[1]/label")
    WebElement clickCheckboxFor2ndPerson;

    @FindBy(id = "checkout-attribute-secondPersonFirstName")
    WebElement secondPersonFirstName;

    @FindBy(id = "checkout-attribute-secondPersonLastName")
    WebElement secondPersonLastName;

    @FindBy(id = "checkout-attribute-secondPersonEmail")
    WebElement secondPersonEmail;

    @FindBy(xpath ="//*[@id=\"instore-pickup-info\"]/div[2]/button")
    WebElement continuePickup;

    @FindBy(id = "mz-payment-credit-card-number")
    WebElement CreditcardNumber;

    @FindBy(id = "mz-payment-credit-card-name")
    WebElement CreditCardName;

    @FindBy(id = "mz-payment-expiration-month")
    WebElement CreditCardMonth;

    @FindBy(xpath="//*[@id=\"step-payment-info\"]/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/select")
    WebElement CreditCardYear;

    @FindBy(id = "mz-payment-security-code")
    WebElement securityCode;

    @FindBy(id = "firstname-")
    WebElement firstName;

    @FindBy(id = "lastname-")
    WebElement lastName;

    @FindBy(id = "address-line-1-")
    WebElement addressLine1;

    @FindBy(id = "address-line-2-")
    WebElement addressLine2;

    @FindBy(id = "city-")
    WebElement city;

    @FindBy(id = "stateOrProvinceCA-")
    WebElement province;

    @FindBy(id = "postal-code-")
    WebElement postalCode;

    @FindBy(id = "phonenumber-")
    WebElement phoneNumber;

    @FindBy(xpath="//*[@id=\"aeroplanSection\"]/div[1]/div/label")
    WebElement clickCheckbox;
    
    @FindBy(name="checkoutAeroplanNumberInput")
    WebElement fillaeroplanno;
    
    @FindBy(name="checkoutAeroplanLastNameInput")
    WebElement filllastname;
      
    @FindBy(xpath="//*[@id=\"step-payment-info\"]/div/div[5]/button")
    WebElement ClickonContinue;
    
    @FindBy(xpath="//*[@id=\"checkoutCommentsLink\"]/span")
    WebElement ordernote;
    
    @FindBy(id="checkoutOrderComments")
    WebElement fillordernote;

    @FindBy(xpath="//*[@id=\"step-payment-info\"]/div/div[5]/button")
    WebElement continuePaymentMethod;
    
    @FindBy(xpath="//*[@id=\"step-review\"]/div/div[3]/button")
    WebElement placeorder;

    public void firstPickupPersonInfo(String FirstPersonFirstName,String FirstPersonLastName,String FirstPersonEmail)
    {
        firstPersonFirstName.sendKeys(FirstPersonFirstName);
        firstPersonLastName.sendKeys(FirstPersonLastName);
        firstPersonEmail.sendKeys(FirstPersonEmail);

    }

    public void secondPickupPersonInfo(String SecondPersonFirstName,String SecondPersonLastName,String SecondPersonEmail)
    {
        clickCheckboxFor2ndPerson.click();
        secondPersonFirstName.sendKeys(SecondPersonFirstName);
        secondPersonLastName.sendKeys(SecondPersonLastName);
        secondPersonEmail.sendKeys(SecondPersonEmail);
    }

    public void clickContinue()
    {
        continuePickup.click();
    }

    public void paymentInformation(String CCNumber,String CCName,String month,String year,String SecurityCode,String FirstName,String LastName,String AddressLine1,String AddressLine2,String City,String Province,String PostalCode,String PhoneNumber)
    {
        CreditcardNumber.sendKeys(CCNumber);
        CreditCardName.sendKeys(CCName);
        CreditCardMonth.sendKeys(month);
        CreditCardYear.sendKeys(year);
        securityCode.sendKeys(SecurityCode);
        firstName.sendKeys(FirstName);
        lastName.sendKeys(LastName);
        addressLine1.sendKeys(AddressLine1);
        addressLine2.sendKeys(AddressLine2);
        city.sendKeys(City);
        province.sendKeys(Province);
        postalCode.sendKeys(PostalCode);
        phoneNumber.sendKeys(PhoneNumber);
        
        
    }
    
    public void aeroplan(String aeroplannumber,String lastname,String note) throws InterruptedException
    {
    	clickCheckbox.click();
    	fillaeroplanno.sendKeys(aeroplannumber);
    	filllastname.sendKeys(lastname);
    	continuePaymentMethod.click();
    	Thread.sleep(2000);
    	ordernote.click();
    	fillordernote.sendKeys(note);
    	
    }
    
  /*  public void placeorder()
    {
    	placeorder.click();
    }*/
    
   }
