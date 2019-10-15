package RestAPIBasics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static  io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class basics {

    public static void main(String[] args){
        RestAssured.baseURI="https://maps.googleapis.com";

        given().
                param("location","-33.8670522,151.1957362").
                param("radius","500").
                param("key","AIzaSyD40CTIGu1dWI9idyCGc7jgi3FrsGlizOI").
                when().
                get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].name",equalTo("Sydney")).and().
                body("result[0].plcae_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"));
    }
}
