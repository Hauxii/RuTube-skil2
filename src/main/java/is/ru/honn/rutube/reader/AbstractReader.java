package is.ru.honn.rutube.reader;

/**
 * Created by Berglind on 10/3/2016.
 */
public abstract class AbstractReader implements Reader{
    public AbstractReader(){}

    public Object read(){return new Object();}
    public abstract Object parse(String content);
    public void setURI(String URI){}
    public void setReadHandler(ReadHandler readHandler){}

}
