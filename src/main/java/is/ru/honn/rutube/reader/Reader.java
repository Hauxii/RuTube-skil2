package is.ru.honn.rutube.reader;

/**
 * Created by Berglind on 10/3/2016.
 */
public interface Reader {
    public Object read();
    public Object parse(String content);
    public void setURI(String URI);
    //public void setReadHandler(ReadHandler readHandler);

}
