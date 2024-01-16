package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * 21. Extract the limit
 * 22. Extract the total
 * 23. Extract the name of 5th product
 * 24. Extract the names of all the products
 * 25. Extract the productId of all the products
 * 26. Print the size of the data list
 * 27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
 * Pack)
 * 28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
 * Pack)
 * 29. Get all the categories of 8th products
 * 30. Get categories of the store where product id = 150115
 * 31. Get all the descriptions of all the products
 * 32. Get id of all the all categories of all the products
 * 33. Find the product names Where type = HardGood
 * 34. Find the Total number of categories for the product where product name = Duracell - AA
 * 1.5V CopperTop Batteries (4-Pack)
 * 35. Find the createdAt for all products whose price < 5.49
 * 36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
 * Pack)”
 * 37. Find the manufacturer of all the products
 * 38. Find the imge of products whose manufacturer is = Energizer
 * 39. Find the createdAt for all categories products whose price > 5.99
 * 40. Find the uri of all the products
 */
public class ProductsExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void start() {
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The limit is: " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is: " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 3. Extract the name of 5th product
    @Test
    public void test003() {
        String productName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The 5th products name is: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 4. Extract the names of all the products
    @Test
    public void test004() {
        List<String> allProductsNames = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the name of products are: " + allProductsNames);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 5. Extract the productId of all the products
    @Test
    public void test005() {
        List<Integer> allProductsIds = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the products Ids are: " + allProductsIds);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 6. Print the size of the data list
    @Test
    public void test006() {
        List<HashMap<String, ?>> dataListSize = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data list of the size is: " + dataListSize.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // * 7. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test007() {
        List<HashMap<String, ?>> productsValue = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all the value of the products where product name = Energizer - MAX Batteries AA (4-Pack)" + productsValue);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 8. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test008() {
        List<String> modelProduct = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)" + modelProduct);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 9. Get all the categories of 8th products
    @Test
    public void test009() {
        List<HashMap<String, ?>> categories = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all the categories of 8th product " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 10. Get categories of the store where product id = 150115
    @Test
    public void test0010() {
        List<HashMap<String, ?>> productId = response.extract().path("data.findAll{it.id == 150115}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All categories of the store where product id = 150115:  " + productId);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 11. Get all the descriptions of all the products
    @Test
    public void test0011() {
        List<String> description = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The descriptions of all the products : " + description);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 12. Get id of all the all categories of all the products
    @Test
    public void test0012() {
        List<Integer> categoriesId = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get id of all the all categories of all the products : " + categoriesId);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 13. Find the product names Where type = HardGood
    @Test
    public void test0013() {
        List<String> productName = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store names Where state = ND : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 14. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test0014() {
        List<HashMap<String, ?>> numberOfCategories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack) : " + numberOfCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 15. Find the createdAt for all products whose price < 5.49
    @Test
    public void test0015() {
        List<HashMap<String, ?>> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 16. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4 Pack)”
    @Test
    public void test0016() {
        List<HashMap<String, ?>> productName = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all categories Where product name = “Energizer - MAX Batteries AA (4 Pack)” : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 17. Find the manufacturer of all the products
    @Test
    public void test0017() {
        List<String> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Zip of all the store are : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 18. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test0018() {
        List<String> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of products whose manufacturer is 'Energizer' : " + image);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 19. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test0019() {
        List<String> createdAt = response.extract().path("data.findAll{it.price > 5.99}.categories.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeservices details of the service name = Magnolia Home Theater : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 20. Find the uri of all the products
    @Test
    public void test0020() {
        List<Double> urlOfStore = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The url of all the stores : " + urlOfStore);
        System.out.println("------------------End of Test---------------------------");
    }
}
