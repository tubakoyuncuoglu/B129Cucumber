Feature: US001_Amazon_Sayfasinda_Urun_Aratma
  Scenario: TC01_Amazon_Sayfasinda_Selenium_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_Selenium_aratir
    And sayfayi_kapatir


  Scenario: TC02_Amazon_Sayfasinda_Java_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_Java_aratir
    And sayfayi_kapatir

  Scenario: TC02_Amazon_Sayfasinda_SQL_Aratma
      Given kullanici_amazon_sayfasina_gider
      And  arama_kutusunda_sql_aratir
      And  sayfayi_kapatir