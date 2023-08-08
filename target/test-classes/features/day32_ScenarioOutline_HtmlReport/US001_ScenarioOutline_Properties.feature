Feature: Google_Search

  Background: Kullanici_Google_Anasayfasina_Gider
    Given kullanici_"googleUrl"_sayfasina_gider

 #Scenario  Outline: TestNG deki @DataProvider mantigiyla calisir.
 #Birden fazla veriyi tek seferde feature fileden kullanmamiza yardimci olur
  Scenario Outline: Google_Aramalari
    * kullanici googleda "<aranacakKelime>" aratacaktir
    * basligin "<aranacakKelime>" icerdigini dogrulayacaktir
    * sayfayi_kapatir
    Examples:
      | aranacakKelime |
      | arac1          |
      | arac2          |
      | arac3          |
      | arac4          |
      | arac5          |