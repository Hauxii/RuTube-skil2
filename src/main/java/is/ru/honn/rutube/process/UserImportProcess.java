package is.ru.honn.rutube.process;

import is.ru.honn.rutube.domain.User;
import is.ru.honn.rutube.reader.ReadHandler;
import is.ru.honn.rutube.reader.Reader;
import is.ru.honn.rutube.reader.ReaderException;
import is.ru.honn.rutube.reader.ReaderFactory;
import is.ru.honn.rutube.service.Observer;
import is.ru.honn.rutube.service.UserService;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * Extends RuAbstractProcess from the RuFramework which has the main function
 */
public class UserImportProcess  extends RuAbstractProcess{

    UserService userService;
    MessageSource messageSource;
    Reader reader;

    /**
     * Method which runs before a process and sets up needed data
     */
    @Override
    public void beforeProcess() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app.xml");

        messageSource = (MessageSource)applicationContext.getBean("messageSource");
        System.out.println(messageSource.getMessage("processbefore", new Object[]{this.getClass().getName()}, new Locale("en")));
        System.out.println(messageSource.getMessage("processbefore", new Object[]{this.getClass().getName()}, new Locale("is")));

        ReaderFactory readerFactory = new ReaderFactory();
        reader = readerFactory.getReader("userReader");
        reader.setReadHandler(new ReadHandler() {
            @Override
            public void read(int count, Object object) {

            }
        });
        userService = (UserService)applicationContext.getBean("userService");
    }

    /**
     * Method which starts the process
     */
    @Override
    public void startProcess() {
        System.out.println(messageSource.getMessage("processstart", new Object[]{this.getClass().getName()}, new Locale("en")));
        System.out.println(messageSource.getMessage("processstart", new Object[]{this.getClass().getName()}, new Locale("is")));

        try {
            reader.read();
        } catch (ReaderException e) {
            System.out.println("ReaderException caught");
        }
    }

    /**
     * Method which runs after a process
     */
    @Override
    public void afterProcess() {
        System.out.println(messageSource.getMessage("processstartdone", new Object[]{this.getClass().getName()}, new Locale("en")));
        System.out.println(messageSource.getMessage("processstartdone", new Object[]{this.getClass().getName()}, new Locale("is")));
    }
}
