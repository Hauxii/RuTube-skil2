package is.ru.honn.rutube.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Berglind on 10/3/2016.
 */
public class ReaderFactory {
    ApplicationContext context;

    public ReaderFactory() {
        context = new ClassPathXmlApplicationContext("reader.xml");
    }

    public Reader getReader(String reader){
        return (Reader)context.getBean(reader);
    }
}
