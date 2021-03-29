package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


public class   OrderRequestFactory {
    private RequestSpecification requestSpec;
    private ObjectMapper mapper = new ObjectMapper();
    private  String request;


    OrderRequestFactory(Order ob) throws JsonProcessingException {
        request =  toJsonFormat(ob);
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setBasePath("/store/order/")
                .setContentType(ContentType.JSON)
                .log(LogDetail.BODY).build();
    }
    private String  toJsonFormat(Object ob) throws JsonProcessingException {
        return mapper.writeValueAsString(ob);

    }
    public void placeOrder(){
        given(requestSpec).body(request).post().then().
                assertThat().statusCode(200);
    }

    public void findOrderByid(Integer id){
        given(requestSpec).get(String.valueOf(id)).
                then().assertThat().statusCode(200).log().all();

    }
    public void deleteOrderByid(Integer id){
        given(requestSpec).delete(String.valueOf(id)).
                then().assertThat().statusCode(200);
    }






}
