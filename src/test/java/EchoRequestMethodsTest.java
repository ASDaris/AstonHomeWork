
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EchoRequestMethodsTest {

    @Test
    public void GetRequestTest() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .and().body("args.foo1", equalTo("bar1"))
                .and().body("args.foo2", equalTo("bar2"));
    }
    @Test
    public void PostRequestRawTextTest() {
        String rawText = "This is a test";
        given()
                .baseUri("https://postman-echo.com")
                .body(rawText)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .and().body("data", equalTo(rawText));
    }
    @Test
    public void PostRequestFormDataTest() {
        Map<String, String> formData = new HashMap<>();
        formData.put("foo1", "bar1");
        formData.put("foo2", "bar2");
        given()
                .baseUri("https://postman-echo.com")
                .contentType(ContentType.JSON)
                .body(formData)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .and().body("data.foo1", equalTo("bar1"))
                .and().body("data.foo2", equalTo("bar2"));
    }

    @Test
    public void PutRequestTest() {
        String rawText = "This is a test";
        given()
                .baseUri("https://postman-echo.com")
                .body(rawText)
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .and().body("data", equalTo(rawText));
    }

    @Test
    public void PatchRequestTest() {
        String rawText = "This is a test";
        given()
                .baseUri("https://postman-echo.com")
                .body(rawText)
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .and().body("data", equalTo(rawText));
    }

    @Test
    public void DeleteRequestTest() {
        String rawText = "This is a test";
        given()
        .baseUri("https://postman-echo.com")
                .body(rawText)
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .and().body("data", equalTo(rawText));
    }
}


