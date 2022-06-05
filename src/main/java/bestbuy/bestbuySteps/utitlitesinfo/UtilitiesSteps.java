package bestbuy.bestbuySteps.utitlitesinfo;

import bestbuy.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UtilitiesSteps {

    @Step("This is get ALL list of Version")
    public ValidatableResponse getAllVersionList(){
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_VERSION)
                .then();
    }

    @Step("This is get ALL list of Version")
    public ValidatableResponse getAllHealhList(){
        return SerenityRest.given()
                .when()
                .get(EndPoints.GET_ALL_HEALTHCHECK)
                .then();
    }


}
