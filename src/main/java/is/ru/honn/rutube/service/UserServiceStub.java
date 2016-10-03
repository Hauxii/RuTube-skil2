package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 29.9.2016.
 */
public class UserServiceStub implements UserService{

    private List<User> _users = new ArrayList<>();

    public boolean addUser(User user) throws ServiceException {
        for(User u : _users){
            if(u.getUserId() == user.getUserId()){
                throw new ServiceException();
            }
        }
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
}
