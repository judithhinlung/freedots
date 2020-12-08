package v2.music;
public class Rest extends Unpitched {
  int displayOctave;
  int displayStep;
  boolean isMeasureRest = false;
  public Rest() {
    super();
  }
  public Rest(int displayOctave, int displayStep) {
    super(displayOctave, displayStep);
  }
  public boolean getIsMeasureRest() {
    return this.isMeasureRest;
  }
  public void setIsMeasureRest(boolean isMeasureRest) {
    this.isMeasureRest = isMeasureRest;
  }
}

