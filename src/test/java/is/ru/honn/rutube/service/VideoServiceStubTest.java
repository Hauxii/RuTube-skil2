package is.ru.honn.rutube.service;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.domain.Video;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Lenny on 3.10.2016.
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

    @Test
    public void getVideoShouldFail() throws Exception {
       assertEquals(null, videoServiceStub.getVideo(100));
    }

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

    @org.junit.Test(expected = ServiceException.class)
    public void addInvalidVideoVideoExists() throws Exception {
        Video newvideo = new Video(0,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>());
        assertEquals(false, videoServiceStub.addVideo(newvideo, 0));
    }

    @org.junit.Test(expected = ServiceException.class)
    public void addInvalidVideoUserNonExists() throws Exception {
        Video newvideo = new Video(1,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>());
        assertEquals(false, videoServiceStub.addVideo(newvideo, 10));
    }

}