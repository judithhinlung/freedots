package v2.music;
import java.util.ArrayList;
import freedots.math.Fraction;


public class Voice {
  int number;
  int staffNumber;
  ArrayList<MeasureElement> elements;
  Fraction offset = Fraction.ZERO;
  public Voice(int number) {
    this.number = number;
    this.elements = new ArrayList<MeasureElement>();
  }
  public Voice(int number, int staffNumber) {
    this.number = number;
    this.staffNumber = staffNumber;
    this.elements = new ArrayList<MeasureElement>();
  }
  public int getNumber() {
    return this.number;
  }
  public int getStaffNumber() {
    return this.staffNumber;
  }
  public ArrayList<MeasureElement> getElements() {
    return this.elements;
  }
  public void addElement(MeasureElement element) {
    if ((element instanceof Note) || (element instanceof Chord)) {
      this.elements.add(element);
      this.offset.add(element.getDuration());
    }
  }
}
