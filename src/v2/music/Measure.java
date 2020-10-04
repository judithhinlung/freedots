package v2.music;
import java.util.ArrayList;
import freedots.math.Fraction;
public class Measure {
  Part part;
  private int number;
  KeySignature keySignature = null;
  TimeSignature timeSignature = null;
  Fraction offset = Fraction.ZERO;
  ArrayList<MeasureElement> elements = new ArrayList<MeasureElement>();
  public Measure(Part part, int number) {
    this.part = part;
    this.number = number;
  }
  public Part getPart() {
    return this.part;
  }
  public int getNumber() {
    return this.number;
  }
  public KeySignature getKey() {
    if (this.keySignature == null) {
      return part.getCurrentKey(this.number);
    }
    return this.keySignature;
  }
  public void setKey(KeySignature key) {
    this.keySignature = key;
  }
  public TimeSignature getTime() {
    if (this.timeSignature == null) {
      return part.getCurrentTime(this.number);
    }
    return this.timeSignature;
  }
  public void setTime(TimeSignature time) {
    this.timeSignature = time;
  }
  private boolean printMeasureNumber = true;
  public void setPrintMeasureNumber(boolean printMeasureNumber) {
    this.printMeasureNumber = printMeasureNumber;
  }
  private boolean isWholeMeasureRest = false;
  public void setWholeMeasureRest(boolean wholeMeasureRest) {
    this.isWholeMeasureRest = wholeMeasureRest;
  }
  public Fraction getOffset() {
    return this.offset;
  }
  public void addElement(MeasureElement element) {
    elements.add(element);
    offset.add(element.getMoment());
               }
}
