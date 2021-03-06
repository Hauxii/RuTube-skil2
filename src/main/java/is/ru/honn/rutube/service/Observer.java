package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * The interface for observer implementation
 * is used to be notified when changes to data is applied
 */
public interface Observer {
    void addObserver(Observer observer);
    void notifyObservers(User user);
}
