package testsuite;

import javafx.scene.layout.Priority;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pombase.BasePage;
import utils.ExcelDataProvider;

public class ProductPage extends BasePage {

    SignIn signInObj;
    StoreLocator storeLocatorObj;
    cart cartObj;
    SearchPage searchObj;
    Wishlist wishlistObj;
    ExcelDataProvider excelDataProviderObj;
    Register registerObj;
    Checkout checkoutObj;
    screenShots screenShotobj;
    
    @BeforeClass
    public void browserSetup() {
        //System.setProperty("webdriver.chrome.driver", "D:\\Automation_suite\\src\\test\\java\\drivers\\chromedriver.exe");
       // driver = new ChromeDriver();
       // driver.manage().deleteAllCookies();
      //  driver.get("https://www.homehardware.ca/");
      //  driver.manage().window().maximize();

        storeLocatorObj = new StoreLocator();
        signInObj = new SignIn();
        cartObj = new cart();
        searchObj = new SearchPage();
        wishlistObj = new Wishlist();
        excelDataProviderObj=new ExcelDataProvider();
        registerObj=new Register();
        checkoutObj=new Checkout();
        screenShotobj=new screenShots();
        

    }
    @BeforeTest
    public void setupTest()
    {
        String projectPath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\test\\java\\drivers\\chromedriver.exe");

        driver=new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.homehardware.ca");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
    }

    @Test(priority = 1,enabled = false,dataProvider = "signIn")
    public void login(String username,String password ) throws Exception {
        signInObj.setSignInLink();
        signInObj.enterEmail(username);
        signInObj.enterPassword(password);
        signInObj.clickSignInButton();
        screenShotobj.captureScreenshot();
        
    }

    @DataProvider(name = "signIn")
        public Object[][] getData(){
        //String excelPath="E:\\HH_Automation_suite\\src\\test\\java\\excel\\data.xlsx";
    	 String projectPath=System.getProperty("user.dir");
         String excelPath=projectPath+"\\src\\test\\java\\excel\\data.xlsx";
        Object data[][]= excelDataProviderObj.testData(excelPath,"Sheet1");
        return data;
    }

    @Test(priority = 2,enabled = false,dataProvider = "register")
    public void login(String fname,String lname,String email,String pass,String confirmpass) throws InterruptedException {
       registerObj.clickRegister();
       registerObj.clickStore();
       storeLocatorObj.enterPostalCode("N5L1C2");
       storeLocatorObj.clickFindButton();
       Thread.sleep(5000);
       storeLocatorObj.clickStore();
       Thread.sleep(2000);
       registerObj.userDetails(fname,lname,email,pass,confirmpass);

    }

    @DataProvider(name = "register")
    public Object[][] getDataRegister(){
       	 String projectPath=System.getProperty("user.dir");
         String excelPath=projectPath+"\\src\\test\\java\\excel\\data.xlsx";
         Object data[][]= excelDataProviderObj.testData(excelPath,"Sheet2");
        return data;
    }


    /*@Test(priority = 1,enabled = false)
    public void signIn() throws InterruptedException {
        signInObj.setSignInLink();
        signInObj.enterEmail("");
        signInObj.enterPassword("");
        signInObj.clickSignInButton();
        boolean flag = signInObj.checkSignIn();

            Assert.assertEquals(true, flag,"Sign In Failed.");

    }
*/
    @Test(priority = 3,dataProvider = "GuestUser",enabled = true)
    public void GuestUser(String postalCode, String productCode,String FirstPersonFirstName,String FirstPersonLastName,String FirstPersonEmail,String SecondPersonFirstName,String SecondPersonLastName,String SecondPersonEmail,String CCNumber,String CCName, String month,String year,String SecurityCode,String FirstName,String LastName,String AddressLine1,String AddressLine2,String City,String Province,String PostalCode,String PhoneNumber,String aeroplannumber,String lastname,String note) throws Exception {
        storeLocatorObj.clickStoreLink();
        storeLocatorObj.enterPostalCode(postalCode);
        storeLocatorObj.clickFindButton();
        Thread.sleep(5000);
        storeLocatorObj.clickStore();
        Thread.sleep(3000);
        cartObj.enterQuery(productCode);
        cartObj.setSubmit();
        searchObj.clickfacet();
        Thread.sleep(4000);
        cartObj.clickProduct();
        Thread.sleep(4000);
        cartObj.addingToCart();
        cartObj.clickOnViewCart();
        cartObj.clickGuestCheckout();
        checkoutObj.firstPickupPersonInfo(FirstPersonFirstName,FirstPersonLastName,FirstPersonEmail);
        checkoutObj.secondPickupPersonInfo(SecondPersonFirstName,SecondPersonLastName,SecondPersonEmail);
        checkoutObj.clickContinue();
        Thread.sleep(3000);
        checkoutObj.paymentInformation(CCNumber,CCName, month, year,SecurityCode, FirstName, LastName,AddressLine1, AddressLine2, City, Province, PostalCode, PhoneNumber);
        checkoutObj.aeroplan(aeroplannumber,lastname,note);
       // checkoutObj.placeorder(); 
        Thread.sleep(3000);
        screenShotobj.captureScreenshot();
        //driver.manage().deleteAllCookies();
       // driver.get("https://www.homehardware.ca");
        

    }

    @DataProvider(name = "GuestUser")
    public Object[][] GuestUser(){
    	 String projectPath=System.getProperty("user.dir");
         String excelPath=projectPath+"\\src\\test\\java\\excel\\data.xlsx";
         Object data[][]= excelDataProviderObj.testData(excelPath,"Sheet3");

        return data;
    }


    @Test(priority = 1,enabled = false,dataProvider = "addingToCart")
    public void addingToCart() throws InterruptedException {
        storeLocatorObj.clickStoreLink();
       // storeLocatorObj.enterPostalCode();
        storeLocatorObj.clickFindButton();
        storeLocatorObj.clickStore();


    }

    @Test(priority = 3, enabled = false)
    public void addToCartProduct(String productCode) throws InterruptedException {
        cartObj.enterQuery(productCode);
        cartObj.setSubmit();
        cartObj.clickProduct();
        cartObj.addingToCart();
        cartObj.clickOnViewCart();

    }

    @Test(priority = 4,enabled = false)
    public void addToWishlist() {
        wishlistObj.setWishlistIcon();

    }

    @Test(priority = 5,enabled = false)
    public void checkSearch() throws InterruptedException {
        cartObj.enterQuery("apron");
        cartObj.setSubmit();
        searchObj.clickQuickview();



    }

  /* @AfterTest
    public void closeBrowser() {
        driver.quit();
    }*/
}

