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
    VideoServiceStub stub;
    UserServiceStub userstub;
    @Before
    public void setUp() throws Exception {
        stub = new VideoServiceStub();
        userstub = new UserServiceStub();
    }

    @Test
    public void getVideoShouldFail() throws Exception {
       assertEquals(null,stub.getVideo(100));
    }

    @Test
    public void addValidVideo() throws Exception {
        try{
            User user = new User(0,"Berglind","omars", "berglindoma13","berglind", "170992");
            userstub.addUser(user);
            Video newvideo = new Video(0,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>());
            assertEquals(true,stub.addVideo(newvideo, user.getUserId()));
        }
        catch(ServiceException ex){
            System.out.println("ServiceException Caught");
        }
    }

    @org.junit.Test(expected = ServiceException.class)
    public void addInvalidVideo() throws Exception {
        Video newvideo = new Video(0,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>());
        assertEquals(false,stub.addVideo(newvideo, 10));
    }

}