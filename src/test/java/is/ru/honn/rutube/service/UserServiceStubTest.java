package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * Junit tests for User service
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

    /**
     * This test adds a user that is made sure is valid. addUser returns true if the user was successfully added.
     * @throws ServiceException if the user was not successfully added.
     */
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

    /**
     * This test adds an invalid user and expects addUser to throw a service exception.
     * @throws ServiceException if addUser was unsuccessful
     */
    @org.junit.Test(expected = ServiceException.class)
    public void addUserShouldFail() throws Exception {

        User user = new User(0, "Berglind", "Omars", "berglindoma13@ru.is", "Beggz", "1992-09-17");
        stub.addUser(user);
    }

    /**
     * This test checks if the user set up in the before function returns the correct UserID.
     * @throws Exception if UserID is not correct
     */
    @org.junit.Test
    public void getValidUser() throws Exception {
        assertEquals(0, stub.getUser(0).getUserId());
    }

    /**
     * This test checks if getting a non existing user will return null as it should.
     * @throws Exception if it does not return null
     */
    @org.junit.Test
    public void getNonExistingUser() throws Exception {
        assertEquals(null, stub.getUser(99));
    }

    /**
     * This test adds a observer and then adds a user. When the new user is added, the observer should be notified and the user info printed out.
     */
    @org.junit.Test
    public void testObserver()throws Exception{

        try{
            stub.addObserver(stub);
            User user = new User(2, "Someone", "Someonesdottir", "someone@ru.is", "SM", "1993-12-12");
            stub.addUser(user);
        }
        catch(ServiceException ex){
            System.out.println("Service Exception caught");
        }

    }

}