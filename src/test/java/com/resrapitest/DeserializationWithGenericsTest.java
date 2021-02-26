package com.resrapitest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapitest.PeoplePojo;
import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DeserializationWithGenericsTest {

    @Test
    public void test_people() throws IOException {

        String json_dir = "src/main/java/com/restapitest/people.json";
        System.out.println(json_dir);

        ObjectMapper mapper = new ObjectMapper();
        PeoplePojo model = mapper.readValue(new File(json_dir), PeoplePojo.class);

        String url = "https://swapi.dev/api/people/1";

        PeoplePojo people = RestAssured
                .given().get(url).as(PeoplePojo.class);
        System.out.println("People ====== "+ people.toString());
    }

    @Test
    public void test_film() throws Exception {

//        String json_dir = "src/main/java/com/restapitest/film.json";
//        System.out.println(json_dir);

        String json_dir = "src/main/java/com/restapitest/Demo.json";
        System.out.println(json_dir);

        JSONObject root = new JSONObject(json_dir);

        JSONObject plants = root.getJSONObject("defaultOption");

        for(int i = 0; i < plants.length(); i++) {
            // the JSON data
            JSONObject jsonPlant = plants.getJSONObject(String.valueOf(i));

            String genus = jsonPlant.getString("genus");

            System.out.println("=== "+ genus);

        }

    }

//        FilmPojo film = RestAssured
//                .given().get(url).as(FilmPojo.class);
//        System.out.println("====== "+ film.toString());

}
// json to xml
//		Response response = RestAssured
//				.given()
//				.get(url)
//				.then().extract().response();
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getBody().prettyPrint());
// =================================
//	private ChannelOrderResponse placeOrderOne(String channelOrderRedId, String body) throws JSONException, JsonProcessingException {
//		ChannelOrderResponse channelOrderResponse = given()
//				.header("Content-Type", ContentType.XML)
//				.header("Accept", ContentType.XML)
//				.when().body(body)
//				.request(Method.PUT, "/channels/" + WALMART + "/orders/" + channelOrderRedId).as(ChannelOrderResponse.class);
//
//		JSONObject json = new JSONObject(channelOrderResponse);
//		String xml = XML.toString(json);
//		ObjectMapper jsonMapper = new ObjectMapper();
//		ChannelOrderResponse node = jsonMapper.readValue(xml, ChannelOrderResponse.class);
//
//		return channelOrderResponse;
//	}
// =================================

//    Response response = given()
//            .contentType(ContentType.XML)
//            .accept(ContentType.JSON)
//            .when()
//            .request(Method.GET, "http://vsvc1570-01.mpcsandbox.test.ostk.com:26360/pricingDetails?optionId=19846224").then()
//            .extract().response();
//
//    String responseString = response.asString();
//		System.out.println(response.asString());
//
//                JSONObject jsonObject = new JSONObject(responseString);
//
//                JSONObject settings = jsonObject.getJSONObject("12326879");
////		settings.getString("");

// =================================
//        JSONObject jsonData = jsonObject.getJSONObject("channelOrderResponseDto");
//        System.out.println("===== "+ jsonData);
//        JSONObject jsonData1 = jsonData.getJSONObject("shippingLevel");
//        System.out.println("=====11 "+ jsonData1);
//        JSONObject jsonData2 = jsonData1.getJSONObject("lines");
//        System.out.println("=====22 "+ jsonData2);


//        String data = jsonObject.get("channelOrderResponseDto").toString();