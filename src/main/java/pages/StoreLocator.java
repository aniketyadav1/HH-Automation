package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pombase.BasePage;

public class StoreLocator extends BasePage {
    public StoreLocator(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText = "Select Store")
    WebElement StoreLLink;

    @FindBy(id = "postalCode")
    WebElement postalcode;

    @FindBy(id = "findStore")
    WebElement findButton;

    @FindBy(xpath ="//*[@id=\"10136\"]/div[1]/button")
    WebElement myStore;

    @FindBy(xpath = ".//*[@id='storecollapse']/span")
    WebElement checkStore;

    @FindBy(xpath = ".//*[@id='content-loading']/img")
    WebElement loadingElement;

    public void clickStoreLink () throws InterruptedException {
        Thread.sleep(4000);
        StoreLLink.click();
    }

    public void enterPostalCode(String postalCode) throws InterruptedException {

        postalcode.sendKeys(postalCode);
        Thread.sleep(2000);
    }

    public void clickFindButton() throws InterruptedException {
        findButton.click();
        Thread.sleep(4000);
    }

    public void clickStore() throws InterruptedException {
            Thread.sleep(4000);
            myStore.click();
    }

    public boolean checkStore()
    {

        boolean flag= checkStore.isDisplayed();
        return flag;
    }
}
