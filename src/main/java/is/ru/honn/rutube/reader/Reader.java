package is.ru.honn.rutube.reader;

/**
 * Created by Berglind on 10/3/2016.
 */
public interface Reader {
    Object read() throws ReaderException;
    Object parse(String content);
    void setURI(String URI);
    void setReadHandler(ReadHandler readHandler);

}
