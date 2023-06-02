package techproed.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


public class ReusableMethods {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    //HARD WAIT METHOD
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Alert ACCEPT
    public static void alertAccept() {
        Driver.getDriver().switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        Driver.getDriver().switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        Driver.getDriver().switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow1
    public static void switchToWindow(int sayi) {
        List<String> tumWindowHandles = new ArrayList<String>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(tumWindowHandles.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi) {
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS

    //Visible Wait
    public static void visibleWait(WebElement element, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    //Alert Wait
    public static void alertWait(int sayi) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());

    }

    //Tüm Sayfa ScreenShot
    public static void tumSayfaResmiA() {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/screenshot" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //WebElement ScreenShot
    public static void webElementResmi(WebElement element) {
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/webElementScreenshot" + tarih + ".png";

        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //ExtentReport
    public static void extentReport() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        className = className.replace("test.", "");
        String dosyaYolu = "TestOutput/reports/" + className + "_" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        // Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Team05");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");
    }

    public static ExtentReports getExtentReports() {
        if (extentReports == null) {
            throw new IllegalStateException("ExtentReports oluşturulmamış.");
        }
        return extentReports;
    }

    //WebTable
    public static void printData(int satir, int sutun) {
        WebElement satirSutun = Driver.getDriver().findElement(By.xpath("(//tbody)[1]//tr[" + satir + "]//td[" + sutun + "]"));
        System.out.println(satirSutun.getText());
    }

    //Click Method
    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SendAttributeValue
    public static void sendAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }

    //Faker
    /*
  email, username, password, firsmane,lastname, copon  olarak ( "customerRegesterPage.User_Name_Input.sendKeys(fakerInput("coupon"));" gibi)
  seçim yaptığınız taktirde ilgili konuda random oluşumlar yapacaktır.
     */
    public static String fakerInput(String faker2) {
        Faker faker = new Faker();
        if (faker2 == "email") {
            String fakeEmail = faker.internet().emailAddress();
            return fakeEmail;
        } else if (faker2 == "username") {
            String fakeUsername = faker.name().username();
            return fakeUsername;
        } else if (faker2 == "password") {
            String fakePassword = faker.internet().password();
            return fakePassword;

        } else if (faker2 == "firsname") {
            String fakerFirstName = faker.name().firstName();
            return fakerFirstName;
        } else if (faker2 == "lastname") {

            String fakerLastName = faker.name().lastName();
            return fakerLastName;
        } else if (faker2 == "coupon") {
            String fakerCoupon = faker.code().asin();
            return fakerCoupon;
        } else if (faker2=="biography"){

            String biography;
            String name = faker.name().fullName();
            String job = faker.job().title();
            String company = faker.company().name();
            String country = faker.country().name();
            String quote = faker.shakespeare().hamletQuote();

            biography = name+ " "+ job +"olarak" + company +"'da çalışıyor. "+ country+"'da yaşıyor ve şöyle diyor:"+ quote;


            return biography;

        } else if (faker2=="company") {

            String fakerCompany = faker.company().name();
            return  fakerCompany;
        } else if (faker2=="street") {

            String fakerStreet = faker.address().streetPrefix();
            return fakerStreet;
        } else if (faker2=="towncity") {
            String fakerTownCity = faker.address().cityName();
            return fakerTownCity;
        } else if (faker2=="zipcode") {

            String fakerZipcode = faker.address().zipCodeByState("ZIP CODE");
            return fakerZipcode;

        } else {

            String fakePhoneNumber = faker.phoneNumber().phoneNumber();
            return fakePhoneNumber;

        }


    }

    public static void tumSayfaResmiC(String testCaseName) {
        String callingClassName = Thread.currentThread().getStackTrace()[2].getClassName();
        callingClassName = callingClassName.substring(callingClassName.lastIndexOf('.') + 1);
        String tarih = new SimpleDateFormat("HH:mm_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot/"+ callingClassName + "_" + testCaseName + "_" + tarih + ".png";
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void uploadFilePath (String filePath){
        try {
            ReusableMethods.bekle(3);
//            Dosyayi bulmak icin kullanilir
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
//            ROBOT CLASS MASAUSTU UYGULAMARI ILE ILETISIME GECMEK ICIN KULLANILIT
            Robot robot = new Robot();
//          CONTROL TUSUNA BAS
            robot.keyPress(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
//            V TUSUNA BAS
            robot.keyPress(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            //releasing ctrl+v
            robot.keyRelease(KeyEvent.VK_CONTROL);
            ReusableMethods.bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            ReusableMethods.bekle(3);
            System.out.println("YAPISTIRMA ISLEMI : PASSED");
            //pressing enter
            ReusableMethods.bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            //releasing enter
            robot.keyRelease(KeyEvent.VK_ENTER);
            ReusableMethods.bekle(3);
            System.out.println("DOSYA YUKLENDI.");
        } catch (Exception e) {
        }
    }

//    public static void sendKeysColor(String  sendColor){
//
//        Random random = new Random();
//        int randomSayi= random.nextInt();
//        VendorAddProductLocates vendorAddProductLocates =new VendorAddProductLocates();
//        Driver.getDriver().switchTo().alert().sendKeys(sendColor+randomSayi);
//
//
//    }
//
//    public static void sendKeysSize(String sendSize ){
//
//        Random random = new Random();
//        int randomSayi= random.nextInt();
//        VendorAddProductLocates vendorAddProductLocates=new VendorAddProductLocates();
//        Driver.getDriver().switchTo().alert().sendKeys(sendSize+randomSayi);
//
//    }


}
