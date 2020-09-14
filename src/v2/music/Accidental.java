package v2.music;
public class Accidental {
  private String val;
  public Accidental(String val) throws IllegalArgumentException{
      if (!Utils.contains(val, validValues)) {
      throw new IllegalArgumentException("Unsupported type: " + val);
    }
    this.val = val;
  }
  public String getAccidental() {
    return this.val;
  }
  private String[] validValues = new String[]{"sharp", "natural", "flat", "double-sharp", "sharp-sharp", "flat-flat", "natural-sharp", "natural-flat", "quarter-flat", "quarter-sharp", "three-quarters-flat", "three-quarters-sharp", "sharp-down", "sharp-up", "natural-down", "natural-up", "flat-down", "flat-up", "double-sharp-down", "double-sharp-up", "flat-flat-down", "flat-flat-up", "arrow-down", "arrow-up", "triple-sharp", "triple-flat", "slash-quarter-sharp", "slash-sharp", "slash-flat", "double-slash-flat", "sharp-1", "sharp-2", "sharp-3", "sharp-5", "flat-1", "flat-2", "flat-3", "flat-4", "sori", "koron"};
}
