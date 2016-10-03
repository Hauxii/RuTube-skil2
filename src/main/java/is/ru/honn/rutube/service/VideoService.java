package is.ru.honn.rutube.service;

import java.util.List;
import is.ru.honn.rutube.domain.Video;

/**
 * Created by Lenny on 29.9.2016.
 */
public interface VideoService
{
    Video getVideo(int videoId);
    List<Video> getVideosbyUser(int userId);
    boolean addVideo(Video video) throws ServiceException;
}