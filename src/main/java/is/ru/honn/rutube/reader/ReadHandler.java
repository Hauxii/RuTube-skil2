package is.ru.honn.rutube.reader;


/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */
public interface ReadHandler
{
    void read(int count, Object object);
}