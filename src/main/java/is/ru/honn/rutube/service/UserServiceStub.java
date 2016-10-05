package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */
public class UserServiceStub implements UserService{

    private List<User> _users;
    private List<Observer> observers;

    UserServiceStub(){
        this._users = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public boolean addUser(User user) throws ServiceException {
        for(User u : _users){
            if(u.getUserId() == user.getUserId()){
                throw new ServiceException();
            }
        }
        notifyObservers(user);
        return _users.add(user);
    }

    public User getUser(int userId){
        for(int i = 0; i < _users.size(); i++){
            if (_users.get(i).getUserId() == userId){
                return _users.get(i);
            }
        }
        return null;
    }

    public List<User> getUsers(){
        return _users;
    }

    public void addObserver(Observer observer){observers.add(observer);}

    public void notifyObservers(User user){
        for(Observer observer : observers){
            System.out.println("User ID: " + user.getUserId()+ " " + "Full name of user: " + " " + user.getUserName() + " " + "Display Name: " + user.getDisplayName());
        }
    }

}

