package API;

import static io.restassured.RestAssured.given;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public  class UserRequestFactory {


    private String  response;
    private int id ;
    private ObjectMapper mapper = new ObjectMapper();
    private RequestSpecification requestSpec;




    UserRequestFactory(User ob) throws JsonProcessingException {


        response = toJsonFormat(ob);
        requestSpec =  new RequestSpecBuilder()
        .setBaseUri("https://petstore.swagger.io/v2")
        .setBasePath("/user")
        .setContentType(ContentType.JSON)
        .log(LogDetail.BODY).build();

    }
    private String  toJsonFormat(Object ob) throws JsonProcessingException {
        return mapper.writeValueAsString(ob);
    }

    public void createUser() throws JsonProcessingException {
        given(requestSpec).body(response).post();

    }


    public void findUser(String name) {
        given(requestSpec).
                get(name).then().log().all().assertThat().statusCode(200);

    }



    public void updateUser(User ob) throws JsonProcessingException {

        String req = toJsonFormat(ob);
        id = ob.getId();
        given(requestSpec).
                 body(req).put(String.valueOf(id)).
                then().assertThat().statusCode(200).log().all();

    }

    public void deleteUser(String name){
        given(requestSpec).
                delete(name).then().assertThat().statusCode(200);

    }


}
