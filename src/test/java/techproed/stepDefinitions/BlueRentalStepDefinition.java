package techproed.stepDefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import techproed.pages.BlueRentalPage;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.util.Map;

public class BlueRentalStepDefinition {
    BlueRentalPage blueRentalPage;
    @Then("Verilen_kullanici_ile_login_olunur")
    public void verilen_kullanici_ile_login_olunur(DataTable data) {
        blueRentalPage=new BlueRentalPage();
        blueRentalPage.loginButton.click();
        ReusableMethods.bekle(2);
        blueRentalPage.emailBox.sendKeys(data.row(1).get(0), Keys.TAB,data.row(1).get(1),Keys.ENTER);
        ReusableMethods.bekle(3);
        Assert.assertEquals(blueRentalPage.userDropDown.getText(),"Sam Walker");
        Driver.getDriver().navigate().back();//logout işlemi yerine navigate().back() methodu ile çözdük
        ReusableMethods.bekle(3);
        blueRentalPage.emailBox.sendKeys(data.row(2).get(0), Keys.TAB,data.row(2).get(1),Keys.ENTER);
        ReusableMethods.bekle(3);
        Assert.assertEquals(blueRentalPage.userDropDown.getText(),"Kate Brown");
        ReusableMethods.bekle(5);

    }

    @Then("Verilen_kullanicilar_ile_login_olunur")
    public void verilen_kullanicilar_ile_login_olunur(DataTable data) {
        blueRentalPage = new BlueRentalPage();
        System.out.println(data.asMaps());//Map'lerden oluşan bir list oluşturur
        //[{email=sam.walker@bluerentalcars.com, password=c!fas_art}, {email=kate.brown@bluerentalcars.com, password=tad1$Fas}]
        //Feature file'daki oluşturmuş olduğumuz tabloğu map olarak listeler.
        //Başlığı key olarak alır altındaki verileri value olarak alır
        for (Map<String,String> w:data.asMaps()) {
            blueRentalPage.loginButton.click();
            blueRentalPage.emailBox.sendKeys(w.get("emailAdress"),Keys.TAB,w.get("password"),Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.logOut.click();
            ReusableMethods.bekle(2);
            blueRentalPage.OK.click();
        }

    }

    @And("kullanici_exceldeki_{string}_sayfasindaki_kullanici_bilgileri_ile_login_olur")
    public void kullanici_exceldeki__sayfasindaki_kullanici_bilgileri_ile_login_olur(String sayfaAdi) {
        blueRentalPage=new BlueRentalPage();
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/mysmoketestdata.xlsx",sayfaAdi);
        for (int i = 1; i <=excelUtils.rowCount() ; i++) {
            String email = excelUtils.getCellData(i,0);
            String password = excelUtils.getCellData(i,1);
            blueRentalPage.loginButton.click();
            ReusableMethods.bekle(2);
            blueRentalPage.emailBox.sendKeys(email,Keys.TAB,password,Keys.ENTER);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.profile.click();
            ReusableMethods.bekle(2);
            Assert.assertEquals(blueRentalPage.verifyEmail.getText(),email);
            ReusableMethods.bekle(2);
            blueRentalPage.userDropDown.click();
            ReusableMethods.bekle(2);
            blueRentalPage.logOut.click();
            ReusableMethods.bekle(2);
            blueRentalPage.OK.click();

        }

    }

    @Given("kullanici_blueRentACarUrl_sayfasina_gider_exceldeki_verilerle_login_olur")
    public void kullanici_bluerentacarurl_sayfasina_gider_exceldeki_verilerle_login_olur() {
        System.out.println("BlueRentalPage Sayfasına Gidildi Exceldeki Veriler ile login olundu");
    }
}