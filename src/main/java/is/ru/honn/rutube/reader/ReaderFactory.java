package is.ru.honn.rutube.reader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Berglind on 10/3/2016.
 */
@Configuration
public class ReaderFactory {
    ApplicationContext context = new ClassPathXmlApplicationContext("/reader.xml");

    @Bean
    public Object getReader(String reader){
        return context.getBean(reader);
    }
}
