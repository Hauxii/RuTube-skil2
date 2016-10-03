package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

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
    public void addValidUser() throws Exception {
        try{
            User user = new User(1, "Kristinn", "Gudmunds", "kristinng14@ru.is", "KG", "1994-09-27");
            assertEquals(true, stub.addUser(user));
        }
        catch (ServiceException e){
            System.out.println("ServiceException Caught");
        }
    }

    @org.junit.Test(expected = ServiceException.class)
    public void addUserShouldFail() throws Exception {

        User user = new User(0, "Berglind", "Omars", "berglindoma13@ru.is", "Beggz", "1992-09-17");
        assertEquals(false, stub.addUser(user));
    }

    @org.junit.Test
    public void getValidUser() throws Exception {
        assertEquals(0, stub.getUser(0).getUserId());
    }

    @org.junit.Test
    public void getNonExistingUser() throws Exception {
        assertEquals(null, stub.getUser(99));
    }

}