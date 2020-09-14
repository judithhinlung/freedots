package v2.music.format;
public class PrintStyle {
  Position position;
  Font font;
  String color = null;
  public PrintStyle() {
    this.position = null;
    this.font = null;
    this.color = null;
  }
  public void setPosition(Position position) {
    this.position = position;
  }
  public void setFont(Font font) {
    this.font = font;
  }
  public void setColor(String color) {
    this.color = color;
  }
}
