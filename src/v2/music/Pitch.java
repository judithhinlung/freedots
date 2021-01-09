package v2.music;
import v2.music.*;
/** Class for the note properties of pitch, unpitched, and rest 
 */
public class Pitch {
  String type;
  int octave = -1;
  int step = -1;
  int alter = 0;
  public Pitch(String type, final int octave, final int step, final int alter) {
    String[] availableTypes = new String[]{"p", "u", "r"};
    if (!Utils.contains(type, availableTypes)) {
      throw new IllegalArgumentException("Invalid pitch type: " + type);
    }
    this.type = type;
    this.octave = octave;
    this.step = step;
    this.alter = alter;
  }
  public Pitch(String type, final int octave, final int step) {
    String[] availableTypes = new String[]{"p", "u", "r"};
    if (!Utils.contains(type, availableTypes)) {
      throw new IllegalArgumentException("Invalid pitch type: " + type);
    }
    this.type = type;
    this.octave = octave;
    this.step = step;
  }
  public Pitch(String type) throws IllegalArgumentException {
    String[] availableTypes = new String[]{"p", "u", "r"};
    if (!Utils.contains(type, availableTypes)) {
      throw new IllegalArgumentException("Invalid pitch type: " + type);
    }
  }
  public String getType() {
    return this.type;
  }
  public int getStep() {
    return this.step;
  }
  public int getAlter() {
    return this.alter;
  }
  public int getOctave() {
    return this.octave;
  }
  boolean isMeasureRest = false;
  public boolean getIsMeasureRest() {
    return this.isMeasureRest;
  }
  public void setIsMeasureRest(Boolean isMeasureRest) {
    if (this.type.equals("r")) {
      this.isMeasureRest = isMeasureRest;
    }
  }
}
