Feature: US002_TechproEducation_Testi
  @gr1
  Scenario: TC01_TechproEducation_Sayfasi_Testi
    Given kullanici_techpro_sayfasina_gider
    Then cikan_reklam_kapatilir
    And arama_kutusunda_QA_aratir
    And sayfa_basliginin_QA_icerdigini_test_eder
    And sayfayi_kapatir