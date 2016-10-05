package is.ru.honn.rutube.reader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */
public abstract class AbstractReader implements Reader{
    private ClientRequest cr;
    protected String URI;
    protected ReadHandler readHandler;

    public AbstractReader(){
        this.cr = new ClientRequest();
    }

    public Object read() throws ReaderException {
        if(!URI.equals("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650") || URI == null){
            throw new ReaderException("URI is wrong");
        }

        if(readHandler == null){
            throw new ReaderException("ReadHandler has not been set");
        }
        return parse(cr.getRequest(URI));
    }

    public abstract Object parse(String content);

    public void setURI(String URI){
        this.URI = URI;
    }

    public void setReadHandler(ReadHandler readHandler){
        this.readHandler = readHandler;
    }

}
