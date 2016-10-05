package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * Implements Userservice for testing purposes
 */
public class UserServiceStub implements UserService{

    private List<User> _users;
    private List<Observer> observers;

    /**
     * Constructor which instantiates lists of users and obsevers
     */
    UserServiceStub(){
        this._users = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Adds a user to the list of users
     * throws ServiceException if user to be added is invalid
     * @param user The user to be added
     * @return true if user is valid and got added
     * @throws ServiceException
     */
    public boolean addUser(User user) throws ServiceException {
        for(User u : _users){
            if(u.getUserId() == user.getUserId()){
                throw new ServiceException();
            }
        }
        notifyObservers(user);
        return _users.add(user);
    }

    /**
     * Gets a user from the list based on a given user id
     * @param userId The id of a user
     * @return The user if found, null otherwise
     */
    public User getUser(int userId){
        for(int i = 0; i < _users.size(); i++){
            if (_users.get(i).getUserId() == userId){
                return _users.get(i);
            }
        }
        return null;
    }

    /**
     * Gets the list of users
     * @return The list of users
     */
    public List<User> getUsers(){
        return _users;
    }

    /**
     * Adds an observer to the list of observers
     * @param observer The observer to be added
     */
    public void addObserver(Observer observer){observers.add(observer);}

    /**
     * Notifies all observers that a user has been added
     * @param user The user added
     */
    public void notifyObservers(User user){
        for(Observer observer : observers){
            System.out.println("User ID: " + user.getUserId()+ " " + "Full name of user: " + " " + user.getUserName() + " " + "Display Name: " + user.getDisplayName());
        }
    }

}

