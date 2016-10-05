package is.ru.honn.rutube.service;

import java.util.List;
import is.ru.honn.rutube.domain.User;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */
public interface UserService extends Observer
{
    boolean addUser(User user) throws ServiceException;
    User getUser(int userId);
    List<User> getUsers();

}