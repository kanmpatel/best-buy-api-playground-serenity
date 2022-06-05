package bestbuy.bestbuySteps.StoreInfo;

import bestbuy.constants.EndPoints;
import bestbuy.model.StorePojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StoreSteps {

    @Step("This is Create Store with name : {0},type: {1}, address: " +
            "{2}, address2: {3} and city: {4},state: {5}, zip: \" +\n" +
            "            \"{6}, lat: {7} and lng: {8},hours : {9}")
    public ValidatableResponse CreateStoreRecord(String name, String type, String address, String address2, String city, String state,
                                                   String zip, int lat, int lng, String hours){
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);
        storePojo.setAddress2(address2);
        storePojo.setCity(city);
        storePojo.setState(state);
        storePojo.setZip(zip);
        storePojo.setLat(lat);
        storePojo.setLng(lng);
        storePojo.setHours(hours);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post(EndPoints.GET_ALL_STORES)
                .then();
    }

    @Step("This is get Store List By ID : {0}")
    public ValidatableResponse verfiyStoreList(int storeId){
        return SerenityRest.given()
                .pathParam("storesID",storeId)
                .when()
                .get(EndPoints.GET_SINGLE_STORES)
                .then();


    }

    @Step("This is Update Store By Id : {0},name : {1}")
    public ValidatableResponse updateStoreRecord(int storeId, String name, String type, String address){
        StorePojo storePojo = new StorePojo();
        storePojo.setName(name);
        storePojo.setType(type);
        storePojo.setAddress(address);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("storesID",storeId)
                .body(storePojo)
                .when()
                .patch(EndPoints.UPDATE_STORES_BY_ID)
                .then();
    }

    @Step("This is Delete Store By ID : {0}")
    public ValidatableResponse deleteStoreRecord(int storeId){
        return SerenityRest.given()
                .pathParam("storesID",storeId)
                .delete(EndPoints.DELETE_STORES_BY_ID)
                .then();
    }

}
