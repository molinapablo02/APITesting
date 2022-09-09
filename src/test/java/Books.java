import java.io.File;
import java.net.URISyntaxException;

import org.testng.Assert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Books extends Base{
    
    public void createAndDeleteBook() throws URISyntaxException{

        File bookFile = new File(getClass().getResource("/book.json").toURI());

        Response createResponse = 
        given()
                .body(bookFile)
                .when()
                .post("/books");
        
        String responseID = createResponse.jsonPath().getString("post.book_id");

        //veificar si se puedo crear 
        Assert.assertEquals(createResponse.getStatusCode(), 201);


        Response DeleteResponse =
        given()
                .body("{\n" + 
                               "\t\"book_id\": "+ responseID + "\n" +
                                "}")
                .when()
                .delete("/books");
                                    
        Assert.assertEquals(DeleteResponse.getStatusCode(), 200);
                
}
}                                       