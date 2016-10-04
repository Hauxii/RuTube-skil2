package is.ru.honn.rutube.process;

import is.ru.honn.rutube.reader.ReadHandler;
import is.ru.honn.rutube.reader.Reader;
import is.ru.honn.rutube.reader.ReaderException;
import is.ru.honn.rutube.reader.ReaderFactory;
import is.ru.honn.rutube.service.UserService;
import is.ruframework.process.RuAbstractProcess;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Lenny on 4.10.2016.
 */
public class UserImportProcess  extends RuAbstractProcess{

    UserService userService;

    @Override
    public void beforeProcess() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("app.xml");
        userService = (UserService)applicationContext.getBean("userService");
        //TODO msgsource
    }

    @Override
    public void startProcess() {
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.getReader("userReader");

        reader.setReadHandler(new ReadHandler() {
            @Override
            public void read(int count, Object object) {

            }
        });

        try {
            reader.read();
        }
        catch (ReaderException e){
            System.out.println("ReaderException caught");
        }
    }

    @Override
    public void afterProcess() {
        super.afterProcess();
    }
}
