package v2.music;
public class Unpitched {
  String displayStep;
  int displayOctave;
  public Unpitched() {
    this.displayStep = null;
    this.displayOctave = -1;
  }
  public Unpitched(int octave, String displayStep) {
    this.displayOctave = displayOctave;
    this.displayStep = displayStep;
  }
  public int getDisplayOctave() {
    return this.displayOctave;
  }
  public String getDisplayStep() {
    return this.displayStep;
  }
}
