package v2.music.format;
public class PrintStyle {
  Position position = null;
  Font font = null;
  String color = null;
    public PrintStyle(Position position) {
    this.position = position;
  }
  public PrintStyle(Position position, Font font) {
    this.position = position;
    this.font = font;
  }
  public PrintStyle(Position position, Font font, String color) {
    this.position = position;
    this.font = font;
    this.color = color;
  }
  public Font setFont(Font font) {
    this.font = font;
  }
  public void setColor(String color) {
    this.color = color;
  }
}
