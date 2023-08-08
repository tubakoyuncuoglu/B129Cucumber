Feature: US002_TechproEducation_Testi_Hooks
@hooks
  Scenario: TC01_TechproEducation_Sayfasi_Testi
    Given kullanici_"techproed_Url"_sayfasina_gider
    And cikan_reklam_kapatilir
    And kullanici 2 saniye bekler
    And searchboxda_"developer"_aratir
    And kullanici 3 saniye bekler
    And sayfa_basliginin_"QA"_icerdigini_test_eder
    When kullanici_tum_sayfanin_resmini_alir
    And sayfayi_kapatir