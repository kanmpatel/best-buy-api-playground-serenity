package bestbuy.apiplaygroundinfo.stores;

import bestbuy.bestbuySteps.StoreInfo.StoreSteps;
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
public class StoresCurdTest extends TestBase {

    static String name = "VB & son's" + TestUtils.getRandomValue();
    static String type = "Cash & carry";
    static String address = "Tooting";
    static String address2 = "london";
    static String city = "London";
    static String state = "South East";
    static String zip = "1234656";
    static int lat = 123456;
    static int lng = 123;
    static String hours = "24Hours";
    static int storeId;
    public ValidatableResponse response;

    @Steps
    StoreSteps storeSteps;

    @Title("This is Created The New Store")
    @Test
    public void test001(){
        response = storeSteps.CreateStoreRecord(name,type,address,address2,city,state,zip,lat,lng,hours);
        response.log().all().
                statusCode(201);
        storeId= response.extract().path("id");
    }
    @Title("This is get Store List by ID")
    @Test
    public void test002(){
        response = storeSteps.verfiyStoreList(storeId);
        response.body("name",equalTo(name));

    }
    @Title("This is Update The Store By ID")
    @Test
    public void test003(){
        name = name + "_updatedName";
        response = storeSteps.updateStoreRecord(storeId,name,type,address);
        response.log().all()
                .statusCode(200);
        response = storeSteps.verfiyStoreList(storeId);
        response.body("name",equalTo(name));
    }
    @Title("This is Delete The Store By ID")
    @Test
    public void test004(){
        response = storeSteps.deleteStoreRecord(storeId);
        response.log().all()
                .statusCode(200);

        response = storeSteps.verfiyStoreList(storeId);
        response.log().all()
                .statusCode(404);

    }
}
