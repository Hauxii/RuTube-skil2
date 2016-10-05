package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * Implements videoservice for testing purposes
 */
public class VideoServiceStub implements VideoService {

    UserServiceStub userServiceStub;

    /**
     * Constructor which sets the user reader
     * @param userServiceStub The user service to be set
     */
    VideoServiceStub(UserServiceStub userServiceStub){
        this.userServiceStub = userServiceStub;
    }

    /**
     * Gets a video based on given video id
     * @param videoId The id of the video to get
     * @return The video, null if not found
     */
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

    /**
     * Gets a list of videos from a specific user
     * @param userId The id of the user
     * @return The list of videos, null if user doesn't exist
     */
    public List<Video> getVideosByUser(int userId){
        for(User user : userServiceStub.getUsers()){
            if(user.getUserId() == userId){
                return user.getVideos();
            }
        }
        return null;
    }

    /**
     * Adds a video to the list of videos
     * throws ServiceException if video is invalid
     * @param video The video to be added
     * @param userId The user id of the owner
     * @return true if video is valid and got added
     * @throws ServiceException
     */
    public boolean addVideo(Video video, int userId) throws ServiceException{

        //Check if user or video with given ID exists
        if(getVideosByUser(userId) == null || getVideo(video.getVideoId()) != null){
            throw new ServiceException();
        }

        return getVideosByUser(userId).add(video);
    }
}
