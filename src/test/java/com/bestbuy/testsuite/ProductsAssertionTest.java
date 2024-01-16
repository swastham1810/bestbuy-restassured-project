package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * 11. Verify the if the total is equal to 51957
 * 12. Verify the if the stores of limit is equal to 10
 * 13. Check the single ‘Name’ in the Array list (Duracell - AAA Batteries (4-Pack))
 * 14. Check the multiple ‘Names’ in the ArrayList (Duracell - AA 1.5V CopperTop Batteries (4-
 * Pack), Duracell - AA Batteries (8-Pack), Energizer - MAX Batteries AA (4-Pack))
 * 15. Verify the productId=150115 inside categories of the third name is “Household Batteries”
 * 16. Verify the categories second name = “Housewares” of productID = 333179
 * 17. Verify the price = 4.99 of forth product
 * 18. Verify the Product name = Duracell - D Batteries (4-Pack) of 6th product
 * 19. Verify the ProductId = 333179 for the 9th product
 * 20. Verify the prodctId = 346575 have 5 categories
 */
public class ProductsAssertionTest extends TestBase {
    static ValidatableResponse response;
    @BeforeClass
    public static void start(){
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }
    //1. Verify the if the total is equal to 51975
    @Test
    public void test001(){
        response.body("total", equalTo(51975));
    }
    //2. Verify the if the stores of limit is equal to 10
    @Test
    public void test002(){
        response.body("limit", equalTo(10));
    }
    //3. Check the single ‘Name’ in the Array list (Duracell - AAA Batteries (4-Pack))
    @Test
    public void test003(){
        response.body("data.name", hasItem("Duracell - AAA Batteries (4-Pack)"));
    }
    //4. Check the multiple ‘Names’ in the ArrayList (Duracell - AA 1.5V CopperTop Batteries (4-
    //Pack), Duracell - AA Batteries (8-Pack), Energizer - MAX Batteries AA (4-Pack))
    @Test
    public void test004(){
        response.body("data.name", hasItems("Duracell - AA 1.5V CopperTop Batteries (4-Pack)",
                "Duracell - AA Batteries (8-Pack)",
                "Energizer - MAX Batteries AA (4-Pack)"));
    }
    //5. Verify the productId=150115 inside categories of the third name is “Household Batteries”
    @Test
    public void test005(){
        response.body("data[3].categories[2].name", equalTo("Household Batteries"));
    }
    //6. Verify the categories second name = “Housewares” of productID = 333179
    @Test
    public void test006(){
        response.body("data[8].categories[1].name", equalTo("Housewares"));
    }
    //7. Verify the price = 4.99 of forth product
    @Test
    public void test007(){
        response.body("data[3].price", equalTo(4.99f));
    }
    //8. Verify the Product name = Duracell - D Batteries (4-Pack) of 6th product
    @Test
    public void test008(){
        response.body("data[5].name", equalTo("Duracell - D Batteries (4-Pack)"));
    }
    //9. Verify the ProductId = 333179 for the 9th product
    @Test
    public void test009(){
        response.body("data[8].id", equalTo(333179));
    }
    //10. Verify the prodctId = 346575 have 5 categories
    @Test
    public void test0010(){
        response.body("data.find{it.id == 346575}.categories.size()", equalTo(5));
    }
}
