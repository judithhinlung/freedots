package v2.music;
public class TextDirection extends MeasureElement {
  Measure measure;
  String text;
  public TextDirection(Measure measure, String text) {
    super(measure);
    this.text = text;    this.text = text;
  }
  public String getText() {
    return this.text;
  }
}
