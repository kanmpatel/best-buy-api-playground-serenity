package bestbuy.bestbuySteps.servicesInfo;

import bestbuy.constants.EndPoints;
import bestbuy.model.ServicesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ServiecesSteps {

    @Step("This is Create Store with name : {0}")
    public ValidatableResponse CreateServicesRecord(String name){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(servicesPojo)
                .when()
                .post(EndPoints.GET_ALL_SERVICES)
                .then();
    }

    @Step("This is get Store List By ID : {0}")
    public ValidatableResponse verfiyServicesList(int servicesId){
        return SerenityRest.given()
                .pathParam("servicesID",servicesId)
                .when()
                .get(EndPoints.GET_SINGLE_SERVICES)
                .then();


    }

    @Step("This is Update Store By Id : {0},name : {1}")
    public ValidatableResponse updateServicesRecord(int servicesId, String name){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("servicesID",servicesId)
                .body(servicesPojo)
                .when()
                .patch(EndPoints.UPDATE_SERVICES_BY_ID)
                .then();
    }

    @Step("This is Delete Store By ID : {0}")
    public ValidatableResponse deleteServicesRecord(int servicesId){
        return SerenityRest.given()
                .pathParam("servicesID",servicesId)
                .delete(EndPoints.DELETE_SERVICES_BY_ID)
                .then();
    }

}
