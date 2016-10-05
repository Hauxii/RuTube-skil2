package is.ru.honn.rutube.reader;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * Abstract reader that with helper methods and a read method to read URI
 */
public abstract class AbstractReader implements Reader{
    private ClientRequest cr;
    protected String URI;
    protected ReadHandler readHandler;

    public AbstractReader(){
        this.cr = new ClientRequest();
    }

    /**
     * Gets content from URI and parses it
     * @return List of users and their videos
     * @throws ReaderException
     */
    public Object read() throws ReaderException {
        if(!URI.equals("http://mockaroo.com/f13b8200/download?count=1&key=e79a3650") || URI == null){
            throw new ReaderException("URI is wrong");
        }

        if(readHandler == null){
            throw new ReaderException("ReadHandler has not been set");
        }
        return parse(cr.getRequest(URI));
    }

    /**
     * 
     * @param URI
     */
    public void setURI(String URI){
        this.URI = URI;
    }

    public void setReadHandler(ReadHandler readHandler){
        this.readHandler = readHandler;
    }

    /**
     *
     * @param jParent Json parent containing an integer field.
     * @param name name of the integer field
     * @return int value of the json int in the jParent object.
     */
    protected int getInt(JSONObject jParent, String name)
    {
        if(jParent == null)
            return 0;
        Long value = (Long)jParent.get(name);
        if(value == null)
            return 0;
        return value.intValue();
    }

}
