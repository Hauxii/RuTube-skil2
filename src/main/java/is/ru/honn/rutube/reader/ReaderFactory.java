package is.ru.honn.rutube.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
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
