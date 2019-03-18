/*
 * Cart page
 */

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pombase.BasePage;

public class cart extends BasePage {
    public cart()
    {
        PageFactory.initElements(driver,this);

    }

    @FindBy(id="search-input")
    WebElement serchField;

    @FindBy(id = "search_submit")
    WebElement submit;

    @FindBy(linkText = "11 Pocket Leather Carpenters Waist Apron")
    WebElement product;

    @FindBy(id = "add-to-cart")
    WebElement addtocart;

    @FindBy(id = "view-cart")
    WebElement viewcart;

    @FindBy(id = "guest-checkout")
    WebElement CheckoutbuttonGuest;

    @FindBy(id = "cart-checkout")
    WebElement GuestCheckout;





    public void enterQuery (String productCode) {
        serchField.sendKeys(productCode);
    }

    public void setSubmit() throws InterruptedException {
        submit.click();
        Thread.sleep(2000);
    }

    public void clickProduct() throws InterruptedException {
        product.click();
        Thread.sleep(5000);
    }

    public void addingToCart() throws InterruptedException {
        addtocart.click();
        Thread.sleep(2000);
    }

    public void clickOnViewCart()
    {
        viewcart.click();
    }

    public void clickGuestCheckout()
    {
        CheckoutbuttonGuest.click();
        GuestCheckout.click();
    }

}
