package API;

import API.Pet;
import API.PetRequestFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PetTest {
    @Test
    public void createPet() throws JsonProcessingException {
        Pet pet = new Pet();
        pet.setCategoryid(1);
        pet.setId(2);
        pet.setCategoryname("Dima");
        pet.setName("Oleg");
        pet.setStatus("available");
        pet.setTags(null);
        pet.setPhotoUrls(null);
        PetRequestFactory petRequestFactory = new PetRequestFactory(pet);
        petRequestFactory.createPet();

    }
    @Test
    public void findPet() throws JsonProcessingException {
        Pet pet = new Pet();
        pet.setCategoryid(1);
        pet.setId(2);
        pet.setCategoryname("Dima");
        pet.setName("Oleg");
        pet.setStatus("available");
        pet.setTags(null);
        pet.setPhotoUrls(null);
        PetRequestFactory petRequestFactory = new PetRequestFactory(pet);
        petRequestFactory.createPet();
        petRequestFactory.findPet(2);

    }
    @Test
    public void updateData() throws JsonProcessingException {
        Pet pet = new Pet();
        pet.setCategoryid(1);
        pet.setId(2);
        pet.setCategoryname("Dima");
        pet.setName("Oleg");
        pet.setStatus("available");
        pet.setTags(null);
        pet.setPhotoUrls(null);
        PetRequestFactory petRequestFactory = new PetRequestFactory(pet);
        petRequestFactory.updateFomData(2,"Oleg","sold");

    }
    @Test
    public void updatePet() throws JsonProcessingException {
        Pet pet = new Pet();
        pet.setCategoryid(1);
        pet.setId(2);
        pet.setCategoryname("Dima");
        pet.setName("Oleg");
        pet.setStatus("available");
        pet.setTags(null);
        pet.setPhotoUrls(null);
        PetRequestFactory petRequestFactory = new PetRequestFactory(pet);
        petRequestFactory.createPet();
        pet.setCategoryname("Anton");
        petRequestFactory.updateExistingPet(pet);
        Assert.assertEquals(pet.getCategoryname(),"Anton");
    }
    @Test
    public void deletePet() throws JsonProcessingException {
        Pet pet = new Pet();
        pet.setCategoryid(1);
        pet.setId(2);
        pet.setCategoryname("Dima");
        pet.setName("Oleg");
        pet.setStatus("available");
        pet.setTags(null);
        pet.setPhotoUrls(null);
        PetRequestFactory petRequestFactory = new PetRequestFactory(pet);
        petRequestFactory.createPet();
        petRequestFactory.deletePet(2);
    }
}//
