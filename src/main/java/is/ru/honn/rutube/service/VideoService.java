package is.ru.honn.rutube.service;

import java.util.List;
import is.ru.honn.rutube.domain.Video;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */
public interface VideoService
{
    Video getVideo(int videoId);
    List<Video> getVideosByUser(int userId);
    boolean addVideo(Video video, int userId) throws ServiceException;
}