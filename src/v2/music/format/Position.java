package v2.music.format;
public class Position {
  int defaultX;
  int defaultY;
  int relativeX;
  int relativeY;
  public Position(int defaultX, int defaultY) {
    this.defaultX = defaultX;
    this.defaultY = defaultY;
  }
  public void setRelativeX(int relativeX) {
    this.relativeX = relativeX;
  }
  public void setRelativeY(int relativeY) {
    this.relativeY = relativeY;
  }
}
