package com.resrapitest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.*;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class UserTest {

    @Test
    public void getAllUsersTest() {

        Response response = given()
                .accept(ContentType.JSON)
                .when()
                .request(Method.GET, "https://reqres.in/api/users").then()
                .extract().response();

        List<Page> list = new ArrayList<Page>();

        Page pageList = response.as(Page.class);
        list.add(pageList);
        System.out.println("pageList :" + list.toString());

        JsonPath path = response.jsonPath();
        List<HashMap<String, Object>> columns = path.getList("data");

        for (int i = 0; i < columns.size(); i++) {
            System.out.println("data : "+columns.get(i).get("id")+"  "+
                    columns.get(i).get("email")+"  "+
                    columns.get(i).get("first_name")+"  "+
                    columns.get(i).get("last_name")+"  "+
                    columns.get(i).get("avatar")
            );
            System.out.println();
        }
    }


    @Test
    public void userCreate() {

        final String json = "{\"name\": \"morpheus\", \"job\": \"leader\"}";

        Response response = given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .extract().response();

        System.out.println("=== " + response.getBody().prettyPrint());

        SingleUser singlrUser = response.as(SingleUser.class);

        System.out.println("singlrUser :" + singlrUser);

        assertThat(singlrUser.getName(), is("morpheus"));
        assertThat(singlrUser.getName(), equalTo("morpheus"));

        assertThat(singlrUser.getJob(), is("leader"));
        assertThat(singlrUser.getJob(), equalTo("leader"));
    }


    @Test
    public void getSinglrUserById() throws IOException {

        String json_dir = "src/main/java/com/restapitest/SingleUserJson.json";
        System.out.println(json_dir);

        ObjectMapper mapper = new ObjectMapper();
        SingleUser model = mapper.readValue(new File(json_dir), SingleUser.class);

        assertThat(model.getName(), is("morpheus"));
        assertThat(model.getName(), equalTo("morpheus"));

        assertThat(model.getJob(), is("leader"));
        assertThat(model.getJob(), equalTo("leader"));
    }

    @Test
    public void putUserCreate() {

        final String json = "{\"name\": \"morpheus\", \"job\": \"zion resident\"}";

        Response response = given()
                .contentType("application/json")
                .body(json)
                .when()
                .put("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("zion resident"))
                .extract().response();

        System.out.println("=== " + response.getBody().prettyPrint());

        SingleUser singlrUser = response.as(SingleUser.class);

        System.out.println("singlrUser :" + singlrUser);

        assertThat(singlrUser.getName(), is("morpheus"));
        assertThat(singlrUser.getName(), equalTo("morpheus"));

        assertThat(singlrUser.getJob(), is("zion resident"));
        assertThat(singlrUser.getJob(), equalTo("zion resident"));

        assertThat(singlrUser.getUpdatedAt(), is(singlrUser.getUpdatedAt()));
        assertThat(singlrUser.getUpdatedAt(), equalTo(singlrUser.getUpdatedAt()));
    }

    @Test
    public void userDelete() {
        Response response = given()
                .when()
                .delete("https://reqres.in/api/users")
                .then()
                .statusCode(204)
                .extract().response();

        assertThat(response.getStatusCode(), is(204));
    }

    @Test
    public void testRegisterSuccessful() {

        final String json = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";

        Response response = given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();

        System.out.println("=== " + response.getBody().prettyPrint());
    }

    @Test
    public void testLRegisterUnsuccessful() {
        final String json = "{\"email\": \"sydney@fife\"}";

        Response response = given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .assertThat()
                .body("error", equalTo("Missing password"))
                .extract().response();

        System.out.println("=== " + response.getBody().prettyPrint());

        String error = "Missing password";

        assertThat(error, equalTo("Missing password"));
    }

    @Test
    public void testLoginSuccessful() {

        final String json = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}";

        Response response = given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"))
                .extract().response();

        System.out.println("=== " + response.getBody().prettyPrint());

    }

    @Test
    public void testLoginUnsuccessful() {
        final String json = "{\"email\": \"peter@klaven\"}";

        Response response = given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .statusCode(400)
                .assertThat()
                .body("error", equalTo("Missing password"))
                .extract().response();

        System.out.println("=== " + response.getBody().prettyPrint());

        String error = "Missing password";

        assertThat(error, equalTo("Missing password"));
    }
}