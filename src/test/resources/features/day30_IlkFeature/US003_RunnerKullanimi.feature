@All
Feature: US003_Amazon_Sayfasinda_Urun_Aratma
  @gr3
  Scenario: TC01_Amazon_Sayfasinda_Selenium_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_Selenium_aratir
    And sayfayi_kapatir

  @gr2
  Scenario: TC02_Amazon_Sayfasinda_Java_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_Java_aratir
    And sayfayi_kapatir

  @gr1
  Scenario: TC02_Amazon_Sayfasinda_sql_Aratma
    Given kullanici_amazon_sayfasina_gider
    And  arama_kutusunda_sql_aratir
    And  sayfayi_kapatir