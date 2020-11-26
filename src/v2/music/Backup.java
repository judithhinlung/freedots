package v2.music;
import freedots.math.Fraction;
public class Backup extends MeasureElement {
  Measure measure;
  Fraction duration;
  public Backup(Measure measure, Fraction duration) {
    super(measure);
    this.duration = duration;
  }
  public Fraction getDuration() {
    return this.duration;
  }
}
