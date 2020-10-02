package v2.music;
import java.util.ArrayList;
public class Measure {
  private int number;
  ArrayList<Staff> staves = new ArrayList<Staff>();
  KeySignature keySignature = null;
  TimeSignature timeSignature = null;
  public Measure(int number) {
    this.number = number;
    staves.add(new Staff(1));
  }
  public Measure(int number, int numStaves) {
    this.number = number;
    for (int i = 1; i <= numStaves; i++) {
      staves.add(new Staff(i));
    }
  }
  private boolean printMeasureNumber = true;
  public void setPrintMeasureNumber(boolean printMeasureNumber) {
    this.printMeasureNumber = printMeasureNumber;
  }
  private boolean isWholeMeasureRest = false;
  public void setWholeMeasureRest(boolean wholeMeasureRest) {
    this.isWholeMeasureRest = wholeMeasureRest;
  }
  // TODO: Create a Event class to hold music elements in time
}
