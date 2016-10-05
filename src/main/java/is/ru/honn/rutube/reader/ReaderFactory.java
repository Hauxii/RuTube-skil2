package is.ru.honn.rutube.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * A factory which gets the correct reader and message source from reader.xml
 */
public class ReaderFactory {
    ApplicationContext context;

    /**
     * Constructor which sets the application context from reader.xml
     */
    public ReaderFactory() {
        context = new ClassPathXmlApplicationContext("reader.xml");
    }

    /**
     * Gets the type of a reader from reader.xml
     * @param reader The name of the reader type
     * @return A reader
     */
    public Reader getReader(String reader){
        return (Reader)context.getBean(reader);
    }
}
