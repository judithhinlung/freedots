package v2.music;
import v2.music.*;
public class Pitch {
  int octave, alter;
  String step;
  public Pitch(final int octave, final String step, final int alter) {
    this.octave = octave;
    this.step = step;
    this.alter = alter;
  }
  public String getStep() {
    return this.step;
  }
  public int getAlter() {
    return this.alter;
  }
  public int getOctave() {
    return this.octave;
  }
}
