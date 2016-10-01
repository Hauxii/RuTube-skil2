package is.ru.honn.rutube.service;

import java.util.List;
import is.ru.honn.rutube.domain.User;

/**
 * Created by Lenny on 29.9.2016.
 */
public interface UserService
{
    boolean addUser(User user) throws ServiceException;
    User getUser(int userId);
    List<User> getUsers();
}