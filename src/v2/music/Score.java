package v2.music;
import java.util.ArrayList;
public class Score {
  String workNumber;
  public String getWorkNumber() {
    return this.workNumber;
  }
  public void setWorkNumber(String workNumber) {
    this.workNumber = workNumber;
  }
  String workTitle;
  public String getWorkTitle() {
    return this.workTitle;
  }
  public void setWorkTitle(String workTitle) {
    this.workTitle = workTitle;
  }
  String opus;
  public String getOpus() {
    return this.opus;
  }
  public void setOpus(String opus) {
    this.opus = opus;
  }
  String movementNumber;
  public String getMovementNumber() {
    return this.movementNumber;
  }
  public void setMovementNumber(String movementNumber) {
    this.movementNumber = movementNumber;
  }
  String movementTitle;
  public String getMovementTitle() {
    return this.movementTitle;
  }
  public void setMovementTitle(String movementTitle) {
    this.movementTitle = movementTitle;
  }
  String composer;
  public String getComposer() {
    return this.composer;
  }
  public void setComposer(String composer) {
    this.composer = composer;
  }
  String lyricist;
  public String getLyricist() {
    return this.lyricist;
  }
  public void setLyricist(String lyricist) {
    this.lyricist = lyricist;
  }
  String rights;
  public String getRights() {
    return this.rights;
  }
  public void addRights(String rights) {
    StringBuilder s = new StringBuilder();
    String originalRights = this.rights;
    s.append(originalRights);
    s.append(rights);
    this.rights = s.toString();
  }
  String encodingDate;
  public String getEncodingDate() {
    return this.encodingDate;
  }
  public void setEncodingDate(String date) {
    this.encodingDate = date;
  }
  String encoder;
  public String getEncoder() {return this.encoder;
  }
  public void setEncoder(String encoder) {
    this.encoder = encoder;
  }
  String encodingSoftware;
  public String getEncodingSoftware() {
    return this.encodingSoftware;
  }
  public void setEncodingSoftware(String software) {
    this.encodingSoftware = software;
  }
  ArrayList parts;
  public ArrayList getParts() {
    return this.parts;
  }
  public void addPart(Part part) {
    this.parts.add(part);
  }
}
