package v2.music;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import freedots.math.Fraction;
public class Measure {
  Part part;
  private int number;
  public Measure(Part part, int number) {
    this.part = part;
    this.number = number;
    createStaves();
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
  Fraction duration;
  public Fraction getDuration() {
    return this.duration;
  }
  ArrayList<Fraction> getDurationsList() {
    ArrayList<Fraction> durations = new ArrayList<Fraction>();
    for (int i = 0; i < staves.size(); i++) {
      Staff staff = staves.get(i);
      HashMap<Integer, Voice> voices = staff.getVoices();
      for (Map.Entry<Integer, Voice> entry : voices.entrySet()) {
        Voice voice = entry.getValue();
        for (int j = 0; j < voice.getElements().size(); j++) {
          MeasureElement element = voice.getElements().get(j);
          Fraction duration = element.getDuration();
          if (element instanceof Note) {
            Note note = (Note)element;
            if (note.getTimeModification() != null) {
              TimeModification tm = note.getTimeModification();
              int normal = tm.getNormalNotes();
              int actual = tm.getActualNotes();
              duration = duration.multiply(new Fraction(normal, actual));
            }
          }
          durations.add(duration);
        }
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
  ArrayList<Staff> staves = new ArrayList<Staff>();
  public void createStaves() {
    int numStaves = part.getStaves();
    for (int i = 0; i < numStaves; i++) {
      staves.add(new Staff(i+1));
    }
  }
  public ArrayList<Staff> getStaves() {
    return this.staves;
  }

  ArrayList<MeasureElement> elements = new ArrayList<MeasureElement>();
  public ArrayList<MeasureElement> getElements() {
    return this.elements;
  }
  public void addElement(MeasureElement element) {
    element.setMoment(this.offset);
    if ((element instanceof Note) || (element instanceof Chord)) {
      int staffNumber = element.getStaff();
      int voiceNumber = element.getVoice();
      Staff staff = getStaff(staffNumber);
      if (!staff.hasVoice(voiceNumber)) {
        staff.addVoice(new Voice(voiceNumber));
      }
      Voice voice = staff.getVoice(voiceNumber);
      voice.addElement(element);
      offset.add(element.getDuration());
    }
    else if (element instanceof Backup) {
      offset.subtract(element.getDuration());
    }
    else if (element instanceof Forward) {
      offset.add(element.getDuration());
    }
    else {
      element.setMoment(this.offset);
      elements.add(element);
    }
  }
  public void addBackupElement(Backup backup) {
    backup.setMoment(this.offset);
    elements.add(backup);
    offset.subtract(backup.getDuration());
  }
  public void addForwardElement(Forward forward) {
    forward.setMoment(this.offset);
    elements.add(forward);
    offset.add(forward.getDuration());
  }
  public boolean isCompleteMeasure() {
    return this.offset.equals(this.getTime());
  }
  public Staff getStaff(int staffNumber) {
    for (int i = 0; i < staves.size(); i++) {
      Staff staff = staves.get(i);
      if (staves.get(i).getNumber() == staffNumber) {
        return staff;
      }
    }
    return null;
  }
  public void sortNotesOntoStaves() {
    // TODO: Place measure elements onto individual staves, staves are created by parts
  }
  public void sortIntoVoices() {
    // TODO: Sort elements onto voices, number of voices created on staves, done by part
  }
}
