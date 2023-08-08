Feature: US002_TechproEducation_Testi
  Background: Kullanici_TechproEducation_Sayfasina_Gider
    Given kullanici_"techproed_Url"_sayfasina_gider
  #https://techproeducation.com yerine .properties dosyasındaki key'de kullanılabilir
  #Eğer .properties dosyasındaki key(url)'i kullanmak istersek, stepDefinition class'ımızda parametre
  #istenen yere ConfigReader.getProperty(Key) methodu ile giriş yapmalıyız

  Scenario: TC01_TechproEducation_Sayfasi_Testi
    Then cikan_reklam_kapatilir
    When kullanici 2 saniye bekler
    And kullanici_tum_sayfanin_resmini_alir
    And arama_kutusunda_qa_aratir
    Then kullanici 2 saniye bekler
    And sayfa_basliginin_qa_icerdigini_test_eder
    When kullanici_tum_sayfanin_resmini_alir
    And sayfayi_kapatir

  Scenario: TC002_TechproEducation_Sayfasi_Testi
    And cikan_reklam_kapatilir
    And kullanici 2 saniye bekler
    And searchboxda_"developer"_aratir
    And kullanici 3 saniye bekler
    And sayfa_basliginin_"developer"_icerdigini_test_eder
    When kullanici_tum_sayfanin_resmini_alir
    And sayfayi_kapatir