package techproed.runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/*
Runner class; testNG deki .xml file larda belirttiğimiz class'ları,packageları veya methodları nasıl
çalıştırıyorsak, Cucumber frameworkundede Runner class'ındaki tags parametresi ile belirttiğimiz
senaryoyu çalıştırabiliriz
 */
//Cucumber ile JUnit'in entegre olmasını saglayan test calıstırıcı notasyondur
@RunWith(Cucumber.class)

//Seneryoların nerede ve nasıl çalışacağı, hangi raporu kullanacağıyla alakalı seçenekleri ayarlarız
@CucumberOptions(plugin = {"pretty"}, //plugin parametresi ile pretty ifadesi kullanilirsa konsolda scenario'lar ile bilgi gosterir
        features = "src/test/resources/features/day30_IlkFeature"
        ,glue ={"techproed/stepDefinitions"},//Bu parametre ile kodlarimizi yazdigimiz stepDefinition
                                                           //class'nın packege'ını beliritiriz
       tags = "@ilk",
        dryRun =false, //dryRun=false Test adimlarini kontrol eder ve browser'i calistirir
                      //dryRun=True Test adimlarini sadece kontrol eder
                      //default olarak da false'tur
         monochrome = false
)


//and ile belirttigimiz iki "@gr" yi alabiliriz
//or ile "@gr" yanina farkli bir sart belirtsek de calistirabiliriz.
/*
features ===> features'ların olduğu packega'ın yolunu ver(ContentRoot)
glue ====> stepDefinition'ların olduğu packega'ın yolunu ver(Source Root)
tags ====> çalıştırmak istediğin grubu yaz
 */

public class Runner {


}
