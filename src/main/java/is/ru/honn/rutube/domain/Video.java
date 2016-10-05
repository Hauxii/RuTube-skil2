package is.ru.honn.rutube.domain;
/**
 * Created by Lenny on 4.10.2016.
 * @author Haukur Ingi Ágústsson and Berglind Ómarsdóttir
 * @date 29.09.16
 */
import java.util.List;

/**
 * POJO for video information, getters for atttributes
 */
public class Video {

  int videoId;
  String title;
  String description;
  String source;
  String videoType;
  List<String> tags;

  public Video(int videoId, String title, String description, String source, String videoType, List<String> tags) {
    this.videoId = videoId;
    this.title = title;
    this.description = description;
    this.source = source;
    this.videoType = videoType;
    this.tags = tags;
  }

  public void addTag(String tag){
    tags.add(tag);
  }

  public int getVideoId() {
    return videoId;
  }
}

