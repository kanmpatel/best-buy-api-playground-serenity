package bestbuy.apiplaygroundinfo.categories;

import bestbuy.bestbuySteps.categoriesinfo.CategoriesSteps;
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
public class CategoriesCurdTest extends TestBase {

    static String name = "cash & carry" + TestUtils.getRandomValue();
    static String id = "ABC" + TestUtils.getRandomValue();
    static String categoriesId;
    public ValidatableResponse response;

    @Steps
    CategoriesSteps categoriesSteps;

    @Title("This is Created The New Categories")
    @Test
    public void test001(){
        response = categoriesSteps.CreateCategoriesRecord(name,id);
        response.log().all().
                statusCode(201);
        categoriesId= response.extract().path("id");
    }
    @Title("This is get Product List by ID")
    @Test
    public void test002(){
        response = categoriesSteps.verfiyCategoriesList(categoriesId);
        response.body("name",equalTo(name));

    }
    @Title("This is Update The Categories By ID")
    @Test
    public void test003(){
        name = name + "_updatedName";
        response = categoriesSteps.updateCategoriesRecord(categoriesId,name);
        response.log().all()
                .statusCode(200);
        response = categoriesSteps.verfiyCategoriesList(categoriesId);
        response.body("name",equalTo(name));
    }
    @Title("This is Delete The Categories By ID")
    @Test
    public void test004(){
        response = categoriesSteps.deleteCategoriesRecord(categoriesId);
        response.log().all()
                .statusCode(200);

        response = categoriesSteps.verfiyCategoriesList(categoriesId);
        response.log().all()
                .statusCode(404);

    }
}
