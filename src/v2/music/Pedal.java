package v2.music;
public class Pedal  {
  String type;
  Part part;
  public Pedal(String type, Part part) throws IllegalArgumentException {
    if (!Utils.contains(type, validTypes)) {
      throw new IllegalArgumentException("Invalid pedal type: " + type);
    }
    this.type = type;
    this.part = part;
  }
  public String getType() {
    return this.type;
  }
  public Part getPart() {
    return this.part;
  }
  private String[] validTypes = new String[]{"start", "stop", "sostenuto", "continue", "change"};
}
