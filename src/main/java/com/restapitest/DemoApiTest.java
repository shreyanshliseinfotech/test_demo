package com.restapitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class DemoApiTest {

    @Test
    public void testGet() {
        Response response = RestAssured.get("https://swapi.dev/api/people");

        System.out.println(response.asString());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }



//    @Test
//    public void test1() {
//
//        given().
//                get("https://reqres.in/api/users?page=2").
//                then().
//                statusCode(200).
//                body("data.id[0]", equalTo(7));
//
//    }
//
//    @Test
//    public void testFirstName() {
//
//        given().get("https://reqres.in/api/users?page=2").then().
//                statusCode(200).
//                body("data.id[1]", equalTo(8)).
//                body("data.first_name", hasItems("Michael","Lindsay")).
//                log().all();
//
//    }
//
//    @Test
//    public void testPost() {
//
//        JSONObject request = new JSONObject();
//        request.put("name", "shrey");
//        request.put("job", "BE");
//
//        System.out.println(request);
//        System.out.println(request.toString());
//
//        given().
//                body(request.toJSONString()).
//                when().
//                post("https://reqres.in/api/users").
//                then().statusCode(201);
//
//    }
//
//    @Test
//    public void testPut() {
//
//        JSONObject request = new JSONObject();
//        request.put("name", "anil");
//        request.put("job", "CSE");
//
//        System.out.println(request);
//        System.out.println(request.toString());
//
//        given().
//                body(request.toJSONString()).
//                when().
//                put("https://reqres.in/api/users/2").
//                then().statusCode(200);
//
//    }
//
//    @Test
//    public void testPatch() {
//
//        JSONObject request = new JSONObject();
//        request.put("name", "anil");
//        request.put("job", "CSE");
//
//        System.out.println(request);
//        System.out.println(request.toString());
//
//        given().
//                body(request.toJSONString()).
//                when().
//                patch("https://reqres.in/api/users").
//                then().statusCode(200);
//
//    }
//
//    @Test
//    public void testDelete() {
//
//        JSONObject request = new JSONObject();
//        given().
//                body(request.toJSONString()).
//                when().
//                delete("https://reqres.in/api/users/2").
//                then().statusCode(204).
//                log().all();
//
//    }
}
