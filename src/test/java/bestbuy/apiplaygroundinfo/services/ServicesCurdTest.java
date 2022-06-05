package bestbuy.apiplaygroundinfo.services;

import bestbuy.bestbuySteps.servicesInfo.ServiecesSteps;
import bestbuy.testbase.TestBase;
import bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class ServicesCurdTest extends TestBase {

    static String name = "VB & son's" + TestUtils.getRandomValue();
    static int servicesId;
    public ValidatableResponse response;

    @Steps
    ServiecesSteps serviecesSteps;

    @Title("This is Created The New Services")
    @Test
    public void test001(){
        response = serviecesSteps.CreateServicesRecord(name);
        response.log().all().
                statusCode(201);
        servicesId= response.extract().path("id");
    }
    @Title("This is get Services List by ID")
    @Test
    public void test002(){
        response = serviecesSteps.verfiyServicesList(servicesId);
        response.body("name",equalTo(name));

    }
    @Title("This is Update The Services By ID")
    @Test
    public void test003(){
        name = name + "_updatedName";
        response = serviecesSteps.updateServicesRecord(servicesId,name);
        response.log().all()
                .statusCode(200);
        response = serviecesSteps.verfiyServicesList(servicesId);
        response.body("name",equalTo(name));
    }
    @Title("This is Delete The Services By ID")
    @Test
    public void test004(){
        response = serviecesSteps.deleteServicesRecord(servicesId);
        response.log().all()
                .statusCode(200);

        response = serviecesSteps.verfiyServicesList(servicesId);
        response.log().all()
                .statusCode(404);

    }
}
