Feature: US002_TechproEducation_Testi

  Scenario: TC01_TechproEducation_Sayfasi_Testi
    Given kullanici_techpro_sayfasina_gider
    Then cikan_reklam_kapatilir
    And arama_kutusunda_qa_aratir
    And sayfa_basliginin_qa_icerdigini_test_eder
    And sayfayi_kapatir