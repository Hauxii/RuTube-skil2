package is.ru.honn.rutube.reader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * A class that handles a request from a client
 */
public class ClientRequest
{
  public ClientRequest()
  {
  }

  /**
   * Gets request from user
   * @param url The url to request from
   * @return The content requested
   */
  public String getRequest(String url)
  {
    Client client = ClientBuilder.newClient();
    Response response = client.target(url).request().get();

    String result = response.readEntity(String.class);
    client.close();

    return result;
  }

  /**
   * Gets content from a file
   * @param fileName
   * @return The content of the file
   * @throws is.ru.honn.rutube.reader.ReaderException
   */
  public String getFileContent(String fileName) throws is.ru.honn.rutube.reader.ReaderException
  {
    StringBuilder content = new StringBuilder();
    try
    {
      java.io.FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      String line;
      while((line = bufferedReader.readLine()) != null)
      {
        content.append(line);
      }
      bufferedReader.close();
    }
    catch(FileNotFoundException ex)
    {
      String msg = "Unable to open file '" + fileName + "'";
      throw new ReaderException(msg, ex);
    }
    catch(IOException ex)
    {
      String msg = "Error reading file '" + fileName + "'";
      throw new ReaderException(msg, ex);
    }
    return content.toString();
  }

}
