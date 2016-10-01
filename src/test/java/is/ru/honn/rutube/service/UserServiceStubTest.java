package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lenny on 1.10.2016.
 */
public class UserServiceStubTest {
    UserServiceStub stub;

    @org.junit.Before
    public void setUp(){
        stub = new UserServiceStub();
        User user = new User(0, "Haukur", "Ingi", "haukura14@ru.is", "Fuckboii", "1991-11-03");
        try{
            stub.addUser(user);
        }
        catch (ServiceException e){
            System.out.println("SETUP FAILED");
        }
    }

    @org.junit.Test
    public void addUser() throws Exception {
        try{
            User user = new User(0, "Kristinn", "Gudmunds", "kristinng14@ru.is", "KG", "1994-09-27");
            assertEquals(true, stub.addUser(user));
        }
        catch (ServiceException e){
            System.out.println("ServiceException Caught");
        }
    }

    @org.junit.Test
    public void getUser() throws Exception {
        assertEquals(0, stub.getUser(0).getUserId());
    }

    @org.junit.Test
    public void getUsers() throws Exception {

    }

}