package is.ru.honn.rutube.service;

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
    
    @Before
    public void setUp() throws Exception {
        stub = new VideoServiceStub();
    }

    @Test
    public void getVideoShouldFail() throws Exception {
       assertEquals(null,stub.getVideo(100));
    }

    @Test
    public void addValidVideo() throws Exception {
        try{
            Video newvideo = new Video(0,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>(), 0);
            assertEquals(true,stub.addVideo(newvideo));
        }
        catch(ServiceException ex){
            System.out.println("ServiceException Caught");
        }
    }

    @org.junit.Test(expected = ServiceException.class)
    public void addInvalidVideo() throws Exception {
        Video newvideo = new Video(0,"testvideo", "some bull", "www.something.com", "AVI", new ArrayList<>(), 10);
        assertEquals(false,stub.addVideo(newvideo));
    }

}