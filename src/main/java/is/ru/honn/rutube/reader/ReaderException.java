package is.ru.honn.rutube.reader;
/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */

/**
 * Is thrown if error occurs while reading content and parsing
 */
public class ReaderException extends Exception
{
  public ReaderException()
  {
    super();
  }

  public ReaderException(String message)
  {
    super(message);
  }

  public ReaderException(String message, Throwable cause)
  {
    super(message, cause);
  }
}

