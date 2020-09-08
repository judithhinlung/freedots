package v2.music;
public class Unpitched {
    int displayStep, displayOctave;
    public Unpitched() {
    this.displayStep = -1;
    this.displayOctave = -1;
  }
  public int getDisplayStep() {
    return this.displayStep;
  }
 
  public void setDisplayStep(int step) {
    this.displayStep = step;
  }
  public int getDisplayOctave() {
    return this.displayOctave;
  }
  public void setDisplayOctave(int octave) {
    this.displayOctave = octave;
  }
}
