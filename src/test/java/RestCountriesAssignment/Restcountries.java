package RestCountriesAssignment;

import RestCountries.MethodRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Restcountries {
 Response response;
   MethodRequest req;
   @BeforeMethod
   public void setUP(){
       req=new MethodRequest();
   }

   // @Test
    public void responseOnCountryName(){
        response=req.getResponse("tallinn");
        response.then().log().all();
   }

    @Test
    public void responseOnCountryCode(){
        response=req.getResponse2(372);
        response.then().log().all();

    }
}
