package v2.music;
/** A container to represent a graphic note type.
 */
public class Type {
  private String type;
  public Type(String type) throws IllegalArgumentException {
    if (!isValidType(type)) {
      throw new IllegalArgumentException("Invalid note type: " + type);
    }
    this.type = type;
  }
  private boolean isValidType(String type) {
    return Utils.contains(type, availableTypes);
  }
    public String getType() {
	return this.type;
    }
  private String[] availableTypes = new String[]{"1024th", "512th", "256th", "128th", "64th", "32nd", "16th", "eighth", "quarter", "half", "whole", "breve", "long", "maxima"};
}
