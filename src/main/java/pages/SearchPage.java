package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pombase.BasePage;

public class SearchPage extends BasePage {

    public SearchPage()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"tenant-brand-desc\"]/ul/li[5]/div/label")
    WebElement clickFacet;


    @FindBy(className = "quickview-button")
    WebElement quickview;

    public void clickfacet()
    {
        clickFacet.click();
    }

    public void clickQuickview()
    {
        Actions action= new Actions(driver);
        action.moveToElement(quickview).build().perform();
    }

}
