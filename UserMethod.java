package API;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;

public  class UserMethod {



    private final String baseURI = "https://petstore.swagger.io/v2";
    private String createuserpath = "/user";
    private String body;
    private String ID ;




    UserMethod(User ob) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        body = mapper.writeValueAsString(ob);



    }

    public void createUser() throws JsonProcessingException {
        given().
                baseUri(baseURI).body(body).basePath(createuserpath).
                contentType(ContentType.JSON).when().post().then().assertThat().statusCode(200).log().all();
    }


    public void findUser(String name) {
        given().
                baseUri(baseURI).basePath("/user/" + name).
                get().then().log().all().assertThat().statusCode(200).body("username", equalTo(name));
    }



    public void updateName(String name) throws JsonProcessingException {
        User ob = new User();
        ObjectMapper maprer = new ObjectMapper();
        ob.setId(1);
        ob.setEmail("oleg@gmail.com");
        ob.setFirstName("Oleg");
        ob.setLastName("Ivanov");
        ob.setPassword("1234ivanov");
        ob.setPhone("880055535");
        ob.setUserStatus(8);
        ob.setUsername("ol");


        String req = maprer.writeValueAsString(ob);
        given().
                contentType(ContentType.JSON).body(req).put("https://petstore.swagger.io/v2/user/dmitriyuxdf").
                then().assertThat().statusCode(200).log().all();

    }


}
