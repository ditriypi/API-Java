package API;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {



    @Test
    public void createUser() throws JsonProcessingException {
        User user = new User();
        user.setId(1);
        user.setEmail("dmitro@gmail.com");
        user.setFirstName("Dima");
        user.setLastName("Bort");
        user.setPassword("1234dima");
        user.setPhone("880055535");
        user.setUsername("dmitro");
        user.setUserStatus(2);
        UserRequestFactory  usermehod = new UserRequestFactory(user);
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
        user.setUsername("dmitro");
        user.setUserStatus(2);
        UserRequestFactory usermethod  = new UserRequestFactory (user);
        usermethod.createUser();
        usermethod.findUser("dmitro");

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
        user.setUsername("dmitro");
        user.setUserStatus(2);
        UserRequestFactory  usermethod = new  UserRequestFactory(user);
        usermethod.createUser();
        usermethod.findUser("dmitro");
        user.setEmail("Imdon@fmail.com");
        usermethod.updateUser(user);
        Assert.assertEquals(user.getEmail(),"Imdon@fmail.com");
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
        user.setUsername("dmitro");
        user.setUserStatus(2);
        UserRequestFactory usermethod = new UserRequestFactory(user);
        usermethod.createUser();
        usermethod.deleteUser("dmitro");


    }

}