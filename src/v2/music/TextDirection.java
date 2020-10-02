package v2.music;
public class TextDirection implements Event {
  private String text;
  private Part part;
  public TextDirection(String text, Part part) {
    this.text = text;
    this.part = part;
  }
  public String getText() {
    return this.text;
  }
  public Part getPart() {
    return this.part;
  }
}
