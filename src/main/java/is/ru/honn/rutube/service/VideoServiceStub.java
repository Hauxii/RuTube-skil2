package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 29.9.2016.
 */
public class VideoServiceStub implements VideoService {

    UserServiceStub userServiceStub;

    VideoServiceStub(UserServiceStub userServiceStub){
        this.userServiceStub = userServiceStub;
    }

    public Video getVideo(int videoId){
        for (User user : userServiceStub.getUsers()){
            for (Video video : user.getVideos()){
                if(video.getVideoId() == videoId){
                    return video;
                }
            }
        }
        return null;
    }

    public List<Video> getVideosByUser(int userId){
        for(User user : userServiceStub.getUsers()){
            if(user.getUserId() == userId){
                return user.getVideos();
            }
        }
        return null;
    }

    public boolean addVideo(Video video, int userId) throws ServiceException{

        //Check if user or video with given ID exists
        if(getVideosByUser(userId) == null || getVideo(video.getVideoId()) != null){
            throw new ServiceException();
        }

        return getVideosByUser(userId).add(video);
    }
}
