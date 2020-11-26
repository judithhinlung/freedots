package v2.music;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Part {
  private String partId;
  public Part(String id) {
    this.partId = id;
  }
  public String getId() {
    return this.partId;
  }
  private String partName;
  public String getName() {
    return this.partName;
  }
  public void setName(String partName) {
    this.partName = partName;
  }
  String partAbbreviation;
  public String getAbbreviation() {
    return this.partAbbreviation;
  }
  public void setAbbreviation(String abbreviation) {
    this.partAbbreviation = abbreviation;
  }
  ArrayList<Instrument> instruments;
  public ArrayList<Instrument> getInstruments() {
    return this.instruments;
  }
  public Instrument getInstrument(String id) {
    for (int i = 0; i < instruments.size(); i++) {
      Instrument current = instruments.get(i);
      if (current.getId().equals(id)) {
        return current;
      }
    }
    return null;
  }
  public void addInstrument(Instrument instrument) {
    this.instruments.add(instrument);
  }
  HashMap<Integer, KeySignature> keysMap = new HashMap<Integer, KeySignature>();
  public KeySignature getCurrentKey(int measureNumber) {
    KeySignature currentKey = null;
    for (Map.Entry<Integer, KeySignature> entry : keysMap.entrySet()) {
      int key = entry.getKey();
      if (key > measureNumber) {
        break;
      }
      currentKey = keysMap.get(key);
    }
    return currentKey;
  }
  public void addKeySignature(int measureNumber, KeySignature key) {
    keysMap.put(measureNumber, key);
  }
  HashMap<Integer, TimeSignature> timesMap = new HashMap<Integer, TimeSignature>();
  public TimeSignature getCurrentTime(int measureNumber) {
    TimeSignature currentTime = null;
    for (Map.Entry<Integer, TimeSignature> entry : timesMap.entrySet()) {
      int key = entry.getKey();
      if (key > measureNumber) {
        break;
      }
      currentTime = timesMap.get(key);
    }
    return currentTime;
  }
  public void addTimeSignature(int measureNumber, TimeSignature time) {
    timesMap.put(measureNumber, time);
  }
  HashMap<Integer, Integer> divisionsMap = new HashMap<Integer, Integer>();
  public int getCurrentDivisions(int measureNumber) {
    int currentDivisions = 0;
    for (Map.Entry<Integer, Integer> entry : divisionsMap.entrySet()) {
      int key = entry.getKey();
      if (key > measureNumber) {
        break;
      }
      currentDivisions = divisionsMap.get(key);
    }
    return currentDivisions;
  }
  public void addDivisions(int measureNumber, int divisions) {
    divisionsMap.put(measureNumber, divisions);
  }
  int staves = 1;
  public int getStaves() {
    return this.staves;
  }
  public void setStaves(int staves) {
    this.staves = staves;
  }
  ArrayList<Clef> clefs = new ArrayList<Clef>();
  public ArrayList<Clef> getClefs() {
    return this.clefs;
  }
  public void addClef(Clef clef) {
    clefs.add(clef);
  }

  ArrayList<Measure> measures = new ArrayList<Measure>();
  public Measure getMeasure(int num) {
    for (int i = 0; i < this.measures.size(); i++) {
      Measure current =  measures.get(i);
      if (current.getNumber() == num) {
        return current;
      }
    }
    return null;
  }
  public void addMeasure(Measure measure) {
    if (measure.keySignature != null) {
      this.addKeySignature(measure.getNumber(), measure.getKey());
    }
    if (measure.timeSignature != null) {
      this.addTimeSignature(measure.getNumber(), measure.getTime());
    }
    if (measure.divisions != 0) {
      this.addDivisions(measure.getNumber(), measure.divisions);
    }
    measures.add(measure);
  }
}
