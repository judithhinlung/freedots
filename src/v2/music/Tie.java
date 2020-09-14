package v2.music;
/** A container to represent a tie.
*/
import java.util.ArrayList;
public class Tie {
    /** @param tieTypes holds the tie type entities found in a note */
  ArrayList<String> types;
  public Tie(String type) {
    this.types = new ArrayList<String>();
    if (!isValid(type)) {
      throw new IllegalArgumentException("Invalid tie type");
    }
    this.types.add(type);
  }
  private boolean isValid(String type) {
    return Utils.contains(type, validTypes);
  }
  public void add(String type) throws IllegalArgumentException {
      if (!isValid(type)) {
      throw new IllegalArgumentException("Invalid tie type");
    }
    this.types.add(type);
	 }
  public ArrayList<String> getTypes() {
    return this.types;
  }
  private String[] validTypes = new String[]{"start", "stop"};    
}
