package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * Junit tests for VideoService
 */
public class VideoServiceStubTest {
    VideoServiceStub videoServiceStub;
    UserServiceStub userServiceStub;
    
    @Before
    public void setUp() throws Exception {
        userServiceStub = new UserServiceStub();
        User user = new User(0, "Haukur", "Ingi", "haukura14@ru.is", "Hauxii", "1991-11-03");
        userServiceStub.getUsers().add(user);

        videoServiceStub = new VideoServiceStub(userServiceStub);
        Video newvideo = new Video(0,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>());
        videoServiceStub.addVideo(newvideo, 0);
    }

    /**
     * This test checks if getting a video that does not exist fails. It should return null.
     * @throws Exception if getVideo does not return null
     */
    @Test
    public void getVideoShouldFail() throws Exception {
       assertEquals(null, videoServiceStub.getVideo(100));
    }

    /**
     * This test creates a new valid video and adds it to the video Service. The addVideo function should return true if the add was successful
     * @throws ServiceException if addVideo is not successful
     */
    @Test
    public void addValidVideo() throws Exception {
        try{
            Video newvideo = new Video(1,"testvideo2", "some bull2", "www.something.com2", "AVI2", new ArrayList<>());
            assertEquals(true, videoServiceStub.addVideo(newvideo, 0));
        }
        catch(ServiceException ex){
            System.out.println("ServiceException Caughtaaa");
        }
    }

    /**
     * This test tries to add a video with an already assigned videoID. AddVideo should return false.
     * @throws ServiceException if addVideo does not return false
     */
    @org.junit.Test(expected = ServiceException.class)
    public void addInvalidVideoVideoExists() throws Exception {
        Video newvideo = new Video(0,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>());
        assertEquals(false, videoServiceStub.addVideo(newvideo, 0));
    }

    /**
     * This test tries to add a valid video but with an invalid user. addVideo should return false
     * @throws ServiceException if addVideo does not return false
     */
    @org.junit.Test(expected = ServiceException.class)
    public void addInvalidVideoUserNonExists() throws Exception {
        Video newvideo = new Video(1,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>());
        assertEquals(false, videoServiceStub.addVideo(newvideo, 10));
    }

}