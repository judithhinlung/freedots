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
  public void addWorkTitle(String workTitle) {
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
  public void setMovementTitle() {
    this.movementTitle = movementTitle;
  }
  ArrayList parts;
  public ArrayList getParts() {
    return this.parts;
  }
  public void addPart(Part part) {
    this.parts.add(part);
  }
}
