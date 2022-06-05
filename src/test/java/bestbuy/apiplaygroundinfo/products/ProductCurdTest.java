package bestbuy.apiplaygroundinfo.products;

import bestbuy.bestbuySteps.ProductInfo.ProductSteps;
import bestbuy.testbase.TestBase;
import bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

@RunWith(SerenityRunner.class)
public class ProductCurdTest extends TestBase {

    static String name = "Laptop" + TestUtils.getRandomValue();
    static String type = "Lenovo" + TestUtils.getRandomValue();
    static int price = 45000;
    static int shipping = 2;
    static String upc = "Any";
    static String description = "HighQuality";
    static String manufacturer = "2018";
    static String model = "215365";
    static String url = "http://laptopword.com";
    static String image = "lenovo.com";
    static int productId;
    public ValidatableResponse response;

    @Steps
    ProductSteps productSteps;

    @Title("This is Created The New Product")
    @Test
    public void test001(){
        response = productSteps.CreateProductRecord(name,type,price,shipping,upc,description,manufacturer,model,url,image);
        response.log().all().
                statusCode(201);
        productId = response.extract().path("id");
    }
    @Title("This is get Product List by ID")
    @Test
    public void test002(){
        HashMap<String,?> productList= productSteps.verfiyProductList(productId);
        //response = productSteps.verfiyProductList(productId);
        //response.body("name",equalTo(name));
        Assert.assertThat(productList,hasValue(name));
    }
    @Title("This is Update The Product By ID")
    @Test
    public void test003(){
        name = name + "_updatedName";
        response = productSteps.updateProductRecord(productId,name,type,price,shipping);
        response.log().all()
                .statusCode(200);
        HashMap<String,?> productList= productSteps.verfiyProductList(productId);
        Assert.assertThat(productList,hasValue(name));
    }
    @Title("This is Delete The Product By ID")
    @Test
    public void test004(){
        response = productSteps.deleteProductRecord(productId);
        response.log().all()
                .statusCode(200);

        response = productSteps.getProductRecordById(productId);
        response.log().all()
                .statusCode(404);

    }
}
