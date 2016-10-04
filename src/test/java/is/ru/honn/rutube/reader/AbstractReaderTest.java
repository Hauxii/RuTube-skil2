package is.ru.honn.rutube.reader;

import org.jboss.resteasy.core.ExceptionAdapter;

import static org.junit.Assert.*;

/**
 * Created by Lenny on 3.10.2016.
 */
public class AbstractReaderTest {

    UserReader userReader;

    @org.junit.Before
    public void setUp(){
        userReader = new UserReader(new VideoReader());
    }

    @org.junit.Test (expected = ReaderException.class)
    public void readWithoutReadHandler() throws Exception {
        userReader.setURI("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650");
        userReader.read();
    }

    @org.junit.Test (expected = ReaderException.class)
    public void readWithoutCorrectURI() throws Exception {
        userReader.setURI("NOT MOCKAROO LINK");
        userReader.setReadHandler(new ReadHandler() {
            @Override
            public void read(int count, Object object) {

            }
        });
        userReader.read();
    }

    @org.junit.Test
    public void factoryRead() throws Exception{
        ReaderFactory factory = new ReaderFactory();
        Reader reader = factory.getReader("userReader");

        //reader.setURI("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650");
        reader.setReadHandler(new ReadHandler() {
            @Override
            public void read(int count, Object object) {

            }
        });

        try {
            reader.read();
        }catch (ReaderException e){
            System.out.println("WTF is borked!");
        }

    }

    @org.junit.Test
    public void linesReadMatchFile() throws Exception {

    }


}