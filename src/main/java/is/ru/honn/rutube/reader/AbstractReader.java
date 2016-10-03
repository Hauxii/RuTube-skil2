package is.ru.honn.rutube.reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Berglind on 10/3/2016.
 */
public abstract class AbstractReader implements Reader{
    public AbstractReader(){}
    private ClientRequest cr = new ClientRequest();
    private String uri;
    protected ReadHandler readHandler = new TestReader();


    public Object read(){
        return parse(cr.getRequest(uri));
    }

    public abstract Object parse(String content);

    public void setURI(String URI){
        this.uri = URI;
    }

    public void setReadHandler(ReadHandler readHandler){
        this.readHandler = readHandler;
    }

}
