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
@CucumberOptions(plugin = {"pretty",
        "html:src/test/resources/htmlReport/cucumberHooks.html",
        "json:src/test/resources/htmlReport/cucumber.json",
        "junit:src/test/resources/htmlReport/cucumber.xml",
        "rerun:TestOutput/failed_scenario.txt"},

         //rerun-->fail olan scenariolari belirtilen yoldaki txt dosya icinde gosterir
        //plugin parametresi ile pretty ifadesi kullanilirsa konsolda scenario'lar ile bilgi gosterir
        //yeni rapor almak istegimde bir onceki raporun uzerine yazmamasi icin uzantısını degistirmek lazım(cucumbertc03.html)
        features = "./src/test/resources/features"
        , glue = {"techproed/stepDefinitions"},//Bu parametre ile kodlarimizi yazdigimiz stepDefinition
        //class'nın packege'ını beliritiriz
        tags = "@phone",
        dryRun = false, //dryRun=false Test adimlarini kontrol eder ve browser'i calistirir
        //dryRun=True Test adimlarini sadece kontrol eder
        //default olarak da false'tur
        monochrome = true//pretty ifadesinden sonra monochrome = true kullanırsak senerio adımlarını tekrenk olark siyah gösterir
        //monochrome = false kullanırsak renkli gösterir
        //default false
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
