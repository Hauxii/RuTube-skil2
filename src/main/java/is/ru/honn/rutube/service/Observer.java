package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;

/**
 * Created by Berglind on 10/4/2016.
 */
public interface Observer {
    void addObserver(Observer observer);
    void notifyObservers(User user);
}
