Feature: US001_Amazon_Sayfasinda_Urun_Aratma
  #Classlarimizda kullandigimiz @Before gibi burda da her scenario'dan once Background: yapisi calisir
  Background: Kullanici_Amazon_Sayfasina_Gider
    Given kullanici_amazon_sayfasina_gider
  #Feature file'da birden fazla urun aratmak icin her urun icin yeni bir method olusturmak gerekir
  #Dolasıyla stepdefinition class'da cok fazla method olusturmus oluruz
  #Tek bir parametreli method olusturup bunun ustesinden gelebiliriz
  #Bunun icin feature file'da aratmak istedigim metni " " tırnak icinde yazarsak stepDefinition class'da bize
  #parametreli method olusturur. Boylece bu methodu kullanarak istedigimiz kadar metin aratabiliriz

  Scenario: TC01_Amazon_Sayfasinda_Selenium_Aratma
    Then arama_kutusunda_"Selenium"_aratir
    And kullanici 3 saniye bekler

Scenario: TC02_Amazon_Sayfasinda_Githup_Aratma
    Then arama_kutusunda_"githup"_aratir
    And kullanici 5 saniye bekler

Scenario: TC03_Amazon_Sayfasinda_Samsung_Aratma
    Then arama_kutusunda_"samsung"_aratir
    And  kullanici 2 saniye bekler


  Scenario: TC04_Amazon_Sayfasinda_Nokia_Aratma
    Then arama_kutusunda_"nokia"_aratir
    And kullanici 2 saniye bekler
    And sayfayi_kapatir

