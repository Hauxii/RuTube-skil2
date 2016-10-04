package is.ru.honn.rutube.reader;

import org.jboss.resteasy.core.ExceptionAdapter;

import static org.junit.Assert.*;

/**
 * Created by Lenny on 3.10.2016.
 */
public class AbstractReaderTest {

    AbstractReader abstractReader;

    @org.junit.Before
    public void setUp(){
        abstractReader = new AbstractReader() {
            @Override
            public Object parse(String content) {
                return null;
            }
        };
    }

    @org.junit.Test (expected = ReaderException.class)
    public void readWithoutReadHandler() throws Exception {
        abstractReader.setURI("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650");
        abstractReader.read();
    }

    @org.junit.Test (expected = ReaderException.class)
    public void readWithoutCorrectURI() throws Exception {
        abstractReader.setURI("NOT MOCKAROO LINK");
        abstractReader.setReadHandler(new ReadHandler() {
            @Override
            public void read(int count, Object object) {

            }
        });
        abstractReader.read();
    }

    @org.junit.Test
    public void factoryRead() throws Exception{
        ReaderFactory factory = new ReaderFactory();
        Reader reader = factory.getReader("userReader");

        reader.setURI("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650");
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