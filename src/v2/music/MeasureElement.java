package v2.music;
import freedots.math.Fraction;
public interface MeasureElement {
  public Measure getMeasure();
  public Fraction getMoment();
  public int getStaff();
  public int getVoice();
}
