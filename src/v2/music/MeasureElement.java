package v2.music;
import freedots.math.AbstractFraction;
import freedots.math.Fraction;
public class MeasureElement {
  Measure measure;
  public MeasureElement(Measure measure) {
    this.measure = measure;
  }
  public Measure getMeasure() {
    return this.measure;
  }
  public Fraction getMoment() {
    return this.moment;
  }
  Fraction moment;
  public void setMoment(Fraction moment) {
    this.moment = moment;
  }
  /** @param staff  The staff the measure element belongs to
   * Measure elements with staff = 0 affects all staves in the measure.
   */
  int staff = 0;
  public int getStaff() {
    return this.staff;
  }
  public void setStaff(int staff) {
    this.staff = staff;
  }
  /** @param voice  The voice this measure element belongs to
   * Measure elements with voice = 0 affects all voices on the staff
   */
  int voice = 0;
  public int getVoice() {
    return this.voice;
  }
  public void setVoice(int voice) {
    this.voice = voice;
  }
}
