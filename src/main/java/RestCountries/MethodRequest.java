package RestCountries;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MethodRequest {
    Response response;
    //send request based on given inpot of name
    public Response  getResponse(String name){
        RestAssured.baseURI="https://restcountries.eu";
        response= RestAssured.given().pathParam("countryName",name)
                .get("/rest/v2/capital/{countryName}")
                .then().extract().response();
        return response;
    }

    //send request based on given input of code
    public Response getResponse2(int code){
        RestAssured.baseURI="https://restcountries.eu";
        response= RestAssured.given().pathParam("countryCode",code)
                .get("/rest/v2/callingcode/{countryCode}")
                .then().extract().response();
        return response;

    }
}
