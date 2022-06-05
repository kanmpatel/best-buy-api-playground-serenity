package bestbuy.apiplaygroundinfo.utitlies;

import bestbuy.bestbuySteps.utitlitesinfo.UtilitiesSteps;
import bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.hasKey;

@RunWith(SerenityRunner.class)
public class UtilitesCurdTest extends TestBase {

    public ValidatableResponse response;

    @Steps
    UtilitiesSteps utilitiesSteps;

    @Title("This is get Utilites List And Verify version")
    @Test
    public void test001(){
        response = utilitiesSteps.getAllVersionList();
        response.log().all().statusCode(200);
        response.body("",hasKey("version"));
    }

    @Title("This is get Utilites List And Verify uptime")
    @Test
    public void test002(){
        response = utilitiesSteps.getAllHealhList();
        response.log().all().statusCode(200);
        response.body("",hasKey("uptime"));
    }

}
