package v2.music;
public class Unpitched {
  int displayStep;
  int displayOctave;
  public Unpitched() {
    this.displayStep = 0;
    this.displayOctave = 0;
  }
  public Unpitched(int octave, int displayStep) {
    this.displayOctave = displayOctave;
    this.displayStep = displayStep;
  }
  public int getDisplayOctave() {
    return this.displayOctave;
  }
  public int getDisplayStep() {
    return this.displayStep;
  }
}
