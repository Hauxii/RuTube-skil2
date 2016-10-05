package is.ru.honn.rutube.domain;
/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO for user information, getters and setters for attributes
 */
public class User {


  int userId;
  String firstName;
  String lastName;
  String email;
  String displayName;
  LocalDate birthDate;
  List<Video> videos;

  public User(int userId, String firstName, String lastName, String email, String displayName, String birthDate) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.displayName = displayName;
    this.birthDate = LocalDate.parse(birthDate);
    videos = new ArrayList<>();

  }
  public void setVideos(List<Video> videos){
    this.videos = videos;
  }

  public int getUserId() {
    return userId;
  }

  public List<Video> getVideos() {
    return videos;
  }

  public String getUserName(){
    return firstName + " " + lastName;
  }

  public String getDisplayName(){
    return displayName;
  }
}
