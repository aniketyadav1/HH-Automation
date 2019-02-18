package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pombase.BasePage;

public class Wishlist extends BasePage {

    public Wishlist()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"page-wrapper\"]/nav/div/ul/li[2]/a/img")
    WebElement wishlistIcon;

    public void setWishlistIcon() {
        wishlistIcon.click();
    }
}
