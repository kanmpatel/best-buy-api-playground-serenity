package bestbuy.bestbuySteps.categoriesinfo;

import bestbuy.constants.EndPoints;
import bestbuy.model.CategoriesPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CategoriesSteps {

    @Step("This is Create Categories with name : {0}")
    public ValidatableResponse CreateCategoriesRecord(String name,String id){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .post(EndPoints.GET_ALL_CATEGORIES)
                .then();
    }

    @Step("This is get Categories List By ID : {0}")
    public ValidatableResponse verfiyCategoriesList(String categoriesId){
        return SerenityRest.given()
                .pathParam("categoriesID",categoriesId)
                .when()
                .get(EndPoints.GET_SINGLE_CATEGORIES)
                .then();


    }

    @Step("This is Update Categories By Id : {0},name : {1}")
    public ValidatableResponse updateCategoriesRecord(String categoriesId, String name){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("categoriesID",categoriesId)
                .body(categoriesPojo)
                .when()
                .patch(EndPoints.UPDATE_CATEGORIES_BY_ID)
                .then();
    }

    @Step("This is Delete Categories By ID : {0}")
    public ValidatableResponse deleteCategoriesRecord(String categoriesId){
        return SerenityRest.given()
                .pathParam("categoriesID",categoriesId)
                .delete(EndPoints.DELETE_CATEGORIES_BY_ID)
                .then();
    }

}
