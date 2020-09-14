package v2.music.format;
public class Position {
  double defaultX;
  double defaultY;
  double relativeX;
  double relativeY;
  public Position(double defaultX, double defaultY) {
    this.defaultX = defaultX;
    this.defaultY = defaultY;
  }
  public void setRelativeX(double relativeX) {
    this.relativeX = relativeX;
  }
  public void setRelativeY(double relativeY) {
    this.relativeY = relativeY;
  }
}
