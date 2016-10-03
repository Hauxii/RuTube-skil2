package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 29.9.2016.
 */
public class VideoServiceStub {

    Video getVideo(int videoId){
        return new Video(1, "bla","desc", "src", "type", new ArrayList<>());
    }
    List<Video> getVideosbyUser(int userId){
        return new ArrayList<>();
    }
    int addVideo(Video video, int userId) throws ServiceException{
        return 1;
    }
}
