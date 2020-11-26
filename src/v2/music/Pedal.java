package v2.music;
public class Pedal extends MeasureElement {
  Measure measure;
  String type;
  public Pedal(Measure measure, String type) throws IllegalArgumentException {
    super(measure);
    if (!Utils.contains(type, validTypes)) {
      throw new IllegalArgumentException("Invalid pedal type: " + type);
    }
    this.type = type;
  }
  public String getType() {
    return this.type;
  }
  private String[] validTypes = new String[]{"start", "stop", "sostenuto", "continue", "change"};
}
