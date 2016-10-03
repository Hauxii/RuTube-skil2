package is.ru.honn.rutube.domain;

import java.util.List;


public class Video {

  int videoId;
  String title;
  String description;
  String source;
  String videoType;
  List<String> tags;
  int userId;

  public Video(int videoId, String title, String description, String source, String videoType, List<String> tags, int userId) {
    this.videoId = videoId;
    this.title = title;
    this.description = description;
    this.source = source;
    this.videoType = videoType;
    this.tags = tags;
    this.userId = userId;
  }

  public void addTag(String tag){
    tags.add(tag);
  }

  public int getVideoId() {
    return videoId;
  }

  public int getUserId() {
    return userId;
  }
}

