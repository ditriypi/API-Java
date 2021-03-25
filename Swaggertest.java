package API;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Swaggertest {

    @Test
    public void createUser() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setEmail("dmitro@gmail.com");
        user.setFirstName("Dima");
        user.setLastName("Bort");
        user.setPassword("1234dima");
        user.setPhone("880055535");
        user.setUsername("dmitriyuxdf");
        user.setUserStatus(2);
        UserMethod usermehod = new UserMethod(user);
        usermehod.createUser();



    }

    @Test
    public void findUser() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setEmail("dmitro@gmail.com");
        user.setFirstName("Dima");
        user.setLastName("Bort");
        user.setPassword("1234dima");
        user.setPhone("880055535");
        user.setUsername("dmitriyuxdf");
        user.setUserStatus(2);
        UserMethod usermehod = new UserMethod(user);
        usermehod.createUser();
        usermehod.findUser("dmitriyuxdf");

    }

    @Test()
    public void updateUser() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setEmail("dmitro@gmail.com");
        user.setFirstName("Dima");
        user.setLastName("Bort");
        user.setPassword("1234dima");
        user.setPhone("880055535");
        user.setUsername("dmitriyuxdf");
        user.setUserStatus(2);
        UserMethod usermehod = new UserMethod(user);
        usermehod.createUser();
        usermehod.findUser("dmitriyuxdf");
        usermehod.updateName("oldjerker");
        usermehod.findUser("ol");
        usermehod.findUser("dmitriyuxdf");
        //Assert.assertNotEquals();
    }
    @Test
    public void deleteUser() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setEmail("dmitro@gmail.com");
        user.setFirstName("Dima");
        user.setLastName("Bort");
        user.setPassword("1234dima");
        user.setPhone("880055535");
        user.setUsername("dmitriyuxdf");
        user.setUserStatus(2);
        UserMethod usermehod = new UserMethod(user);
        usermehod.createUser();
        usermehod.deleteUser("dmitriyuxdf");
      //  usermehod.findUser("dmitriyuxdf");

    }

}