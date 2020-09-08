package v2.music;
public class Rest extends Unpitched {
  boolean isMeasureRest = false;
  public Rest() {
    super();
  }
  public boolean getIsMeasureRest() {
    return this.isMeasureRest;
  }
  public void setIsMeasureRest(boolean isMeasureRest) {
    this.isMeasureRest = isMeasureRest;
  }
}

