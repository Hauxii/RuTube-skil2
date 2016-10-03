package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 29.9.2016.
 */
public class VideoServiceStub implements VideoService {

    List<Video> _videos = new ArrayList<>();

    public Video getVideo(int videoId){
        for (Video vid : _videos){
            if(vid.getVideoId() == videoId){
                return vid;
            }
        }
        return null;
    }

    public List<Video> getVideosbyUser(int userId){
        List<Video> videosByUser = new ArrayList<>();
        for(Video vid : _videos){
            //find video with userId
        }
        return videosByUser;
    }

    public boolean addVideo(Video video, int userId) throws ServiceException{
        //Check if user exists
        for (Video vid : _videos){
            if(vid.getVideoId() == video.getVideoId()){
                throw new ServiceException();
            }
        }
        return _videos.add(video);
    }
}
