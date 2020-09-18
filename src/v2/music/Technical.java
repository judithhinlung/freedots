package v2.music;
/** Miscellaneous technical indication symbols for performance
*/
public class Technical {
  String type; 
  public Technical(String type) throws IllegalArgumentException {
    if (!Utils.contains(type, validTypes)) {
      throw new IllegalArgumentException("Unknown technical indication: " + type);
    }
    this.type = type;
  }

  public String getType() {
    return this.type;
  }
  private String[] validTypes = new String[]{"upBow", "downBow", "openString", "thumbPosition", "doubleTongue", "tripleTongue", "stopped", "snapPizzicato", "tap", "heel", "toe", "fingernails", "open", "halfMuted", "golpe"};
}
