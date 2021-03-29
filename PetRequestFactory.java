package API;

import API.Pet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetRequestFactory {
    private final RequestSpecification requestSpec;
    private String response;
    private Pet petobject;
    private final ObjectMapper mapper = new ObjectMapper();


    private int id;
    private String name;
    private String status;


    PetRequestFactory(Pet ob) throws JsonProcessingException {

        response = toJsonFormat(ob);
        petobject = ob;

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON).log(LogDetail.BODY).build();
    }


    private String toJsonFormat(Object ob) throws JsonProcessingException {
        return mapper.writeValueAsString(ob);

    }


    public String formData() throws JsonProcessingException {
        petobject.setId(id);
        petobject.setName(name);
        petobject.setStatus(status);
        return toJsonFormat(petobject);

    }


    public void createPet() {
        given(requestSpec).body(response).post().
                then().assertThat().statusCode(200);

    }


    public void updateExistingPet(Object pet) throws JsonProcessingException {
        String resBody = toJsonFormat(pet);

        given(requestSpec).body(resBody).post().
                then().assertThat().statusCode(200);

    }


    public void updateFomData(int id, String name, String status) throws JsonProcessingException {
        this.id = id;
        this.name = name;
        this.status = status;

        given(requestSpec).body(formData()).post().
                then().statusCode(200);

    }


    public void findPet(Integer id) {
        given(requestSpec).get(String.valueOf(id)).
                then().assertThat().statusCode(200).log().all();


    }

    public void deletePet(Integer id) {
        given(requestSpec).delete(String.valueOf(id)).
                then().assertThat().statusCode(200);
    }
}