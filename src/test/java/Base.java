import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Base {
    @BeforeClass
    public void setUpRestAsured(){
        RestAssured.baseURI = "http://qa-library-dev.herokuapp.com";
        RestAssured.basePath = "/api/";
        RequestSpecification requestSpecification = new RequestSpecBuilder()
            .addHeader("ContentType", ContentType.JSON.toString())
            .addHeader("Accept", ContentType.JSON.toString())
            .build();
        RestAssured.requestSpecification = requestSpecification; 
    }
    
}