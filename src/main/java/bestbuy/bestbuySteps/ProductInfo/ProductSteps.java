package bestbuy.bestbuySteps.ProductInfo;

import bestbuy.constants.EndPoints;
import bestbuy.model.ProductPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class ProductSteps {

    @Step("This is Create Product with name : {0},lastName: {1}, price: " +
            "{2}, shipping: {3} and upc: {4},description: {5}, manufacturer: \" +\n" +
            "            \"{6}, model: {7} and url: {8},image : {9}")
    public ValidatableResponse CreateProductRecord(String name, String type, int price, int shipping, String upc, String description,
                                                   String manufacturer, String model, String url, String image){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(productPojo)
                .when()
                .post(EndPoints.GET_ALL_PRODUCTS)
                .then();
    }

    @Step("This is get Product List By ID : {0}")
    public HashMap<String,?> verfiyProductList(int productId){
        return SerenityRest.given()
                .pathParam("productID",productId)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT)
                .then()
                .extract()
                .path("");

    }

    @Step("This is Update Product By Id : {0},name : {1}")
    public ValidatableResponse updateProductRecord(int productId, String name, String type, int price, int shipping){
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("productID",productId)
                .body(productPojo)
                .when()
                .patch(EndPoints.UPDATE_PRODUCT_BY_ID)
                .then();
    }

    @Step("This is Delete Product By ID : {0}")
    public ValidatableResponse deleteProductRecord(int productId){
        return SerenityRest.given()
                .pathParam("productID",productId)
                .delete(EndPoints.DELETE_PRODUCT_BY_ID)
                .then();
    }

    @Step("This is Get Product By Id : {0}")
    public ValidatableResponse getProductRecordById(int productId){
        return SerenityRest.given()
                .pathParam("productID",productId)
                .when()
                .get(EndPoints.GET_SINGLE_PRODUCT)
                .then();
    }
}
