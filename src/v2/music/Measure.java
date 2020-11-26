package v2.music;
import java.util.ArrayList;
import freedots.math.Fraction;
public class Measure {
  Part part;
  private int number;
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
  
  KeySignature keySignature = null;
  public KeySignature getKey() {
    if (this.keySignature == null) {
      return this.part.getCurrentKey(this.number);
    }
    return this.keySignature;
  }
  public void setKey(KeySignature key) {
    this.keySignature = key;
    this.part.addKeySignature(this.number, key);
  }

  TimeSignature timeSignature = null;
  public TimeSignature getTime() {
    if (this.timeSignature == null) {
      return this.part.getCurrentTime(this.number);
    }
    return this.timeSignature;
  }
  public void setTime(TimeSignature time) {
    this.timeSignature = time;
    this.part.addTimeSignature(this.number, time);
  }

  int divisions = 1;
  public int getDivisions() {
    if (this.divisions == 0) {
    return part.getCurrentDivisions(this.number);
    }
    return this.divisions;
  }
  public void setDivisions(int divisions) {
    this.divisions = divisions;
  }

  /** Returns a list of note durations for a measure.
   */
  public ArrayList<Fraction> getDurationsList() {
    ArrayList<MeasureElement> elements = this.getElements();
    ArrayList<Fraction> durations = new ArrayList<Fraction>();
    for (int i = 0; i < elements.size(); i++) {
      MeasureElement element = elements.get(i);
      if (element instanceof Note) {
        Note note = (Note)element;
        Fraction duration = note.getDuration();
        if (note.getTimeModification() != null) {
          TimeModification tm = note.getTimeModification();
           int normal = tm.getNormalNotes();
          int actual = tm.getActualNotes();
          duration = duration.multiply(new Fraction(normal, actual));
        }
        durations.add(duration);
      }
    }
    return durations;
  }

  /** Calculate the number of divisions per quarter note based on
   * note durations in a measure
   * Used to convert score to MusicXML
  */
  public int calculateDivisions() {
    ArrayList<Fraction> durations = getDurationsList();
    int divisions = 1;
    for (int i = 0; i < durations.size(); i++) {
      Fraction current = new Fraction(1, divisions);
      Fraction next = durations.get(i).multiply(new Fraction(4, 1));
      divisions = current.getLeastCommonMultiple(next);
    }
    return divisions;
  }
  private boolean printMeasureNumber = true;
  public void setPrintMeasureNumber(boolean printMeasureNumber) {
    this.printMeasureNumber = printMeasureNumber;
  }
  private boolean isWholeMeasureRest = false;
  public void setWholeMeasureRest(boolean wholeMeasureRest) {
    this.isWholeMeasureRest = wholeMeasureRest;
  }

  Fraction offset = Fraction.ZERO;
  public Fraction getOffset() {
    return this.offset;
  }

  ArrayList<MeasureElement> elements = new ArrayList<MeasureElement>();
  public ArrayList<MeasureElement> getElements() {
    return this.elements;
  }
  public void addElement(MeasureElement element) {
    element.setMoment(this.offset);
    elements.add(element);
  }
  public void addBackupElement(Backup backup) {
    backup.setMoment(this.offset);
    elements.add(backup);
  }
  public void addForwardElement(Forward forward) {
    forward.setMoment(this.offset);
    elements.add(forward);
  }
  public void addNote(Note note) {
    note.setMoment(this.offset);
    elements.add(note);
    this.offset.add(note.getDuration());
  }
  public void removeNote(Note note) {
    elements.remove(note);
    this.offset.subtract(note.getDuration());
  }
  public void addChord(Chord chord) {
    chord.setMoment(this.offset);
    elements.add(chord);
    this.offset.add(chord.getDuration());
  }
  public ArrayList<MeasureElement> getElementsAt(Fraction moment) {
    if (moment.compareTo(0) < 0) {
      throw new IllegalArgumentException("Negative offset");
    }
    final ArrayList<MeasureElement> elements = new ArrayList<MeasureElement>();
    for (int i = 0; i < elements.size(); i++) {
      MeasureElement element = elements.get(i);
      if (element.getMoment().compareTo(moment) < 0) continue;
      if (element.getMoment().equals(moment))
        elements.add(element);
      else
        break;
    }
    return elements;
  }
  public boolean isCompleteMeasure() {
    return this.offset.equals(this.getTime());
  }
}
