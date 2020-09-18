package v2.music;
/**
* A figured bass element takes its position from the first regular note.
* Figures are ordered from top to bottom.
*/
public class FiguredBass {
/**
* @param duration  optional, indicates changes of figures under the note
* @param number  figure number 
* @param prefix preceding the figure number
* @param Suffix  value following the figured number, valid suffixes include all 
* valid prefix and suffix symbols.
*/
  String prefix;
  int number;
  String suffix;
  public FiguredBass(String prefix, int number, String suffix) throws IllegalArgumentException {
    if (Utils.contains(prefix, validPrefixes)) {
      throw new IllegalArgumentException("Invalid figured bass prefix: " + prefix);
    }
    if (!(Utils.contains(suffix, validPrefixes)) || (Utils.contains(suffix, validSuffixes))) {
      throw new IllegalArgumentException("Invalid figured bass suffix: " + suffix);
    }
    this.number = number;
    this.prefix = prefix;
    this.suffix = suffix;
  }
  public FiguredBass(int number) {
    this.number = number;
  }
  public void addPrefix(String prefix) throws IllegalArgumentException {
    if (Utils.contains(prefix, validPrefixes)) {
      throw new IllegalArgumentException("Invalid figured bass prefix: " + prefix);
    }
    this.prefix = prefix;
  }
  public void addSuffix(String suffix) throws IllegalArgumentException {
    if (!(Utils.contains(suffix, validPrefixes)) || (Utils.contains(suffix, validSuffixes))) {
      throw new IllegalArgumentException("Invalid figured bass suffix: " + suffix);
    }
    this.suffix = suffix;
  }
  public String getPrefix() {
    return this.prefix;
  }
  public int getNumber() {
    return this.number;
  }
  public String getSuffix() {
    return this.suffix;
  }
  private String[] validPrefixes = new String[]{"plus", "sharp", "flat", "natural", "double-sharp", "flat-flat", "sharp-sharp"};
  private String[] validSuffixes = new String[]{"slash", "backslash", "vertical"};
}
