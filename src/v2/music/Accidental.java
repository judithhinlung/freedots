package v2.music;
public class Accidental {
  String type;
  public Accidental(String type) throws IllegalArgumentException{
    if (!Utils.contains(type, validTypes)) {
      throw new IllegalArgumentException("Unsupported type: " + type);
    }
    this.type = type;
  }
  public String getAccidental() {
    return this.type;
  }
  private String[] validTypes = new String[]{"sharp", "natural", "flat", "double-sharp", "sharp-sharp", "flat-flat", "natural-sharp", "natural-flat", "quarter-flat", "quarter-sharp", "three-quarters-flat", "three-quarters-sharp", "sharp-down", "sharp-up", "natural-down", "natural-up", "flat-down", "flat-up", "double-sharp-down", "double-sharp-up", "flat-flat-down", "flat-flat-up", "arrow-down", "arrow-up", "triple-sharp", "triple-flat", "slash-quarter-sharp", "slash-sharp", "slash-flat", "double-slash-flat", "sharp-1", "sharp-2", "sharp-3", "sharp-5", "flat-1", "flat-2", "flat-3", "flat-4", "sori", "koron"};
}
