package v2.music;
public class Metronome extends MeasureElement {
  Measure measure;
  String beatUnit;
  int perMinute;
  public Metronome(Measure measure, String beatUnit, int perMinute)throws IllegalArgumentException {
    super(measure);
    String[] availableTypes = new String[]{"1024th", "512th", "256th", "128th", "64th", "32nd", "16th", "eighth", "quarter", "half", "whole", "breve", "long", "maxima"};
    if (!Utils.contains(beatUnit, availableTypes)) {
       throw new IllegalArgumentException("Invalid beat unit: " + beatUnit);
    }
    this.beatUnit = beatUnit;
    this.perMinute = perMinute;
  }
  public String getBeatUnit() {
    return this.beatUnit;
  }
  public int getPerMinute() {
    return this.perMinute;
  }

  Note metronomeNote;
  public Note getMetronomeNote() { 
    return this.metronomeNote;
  }
  public void setMetronomeNote(Note note) {
                                         this.metronomeNote = note;
  }

  String metronomeRelation;
  public String getMetronomeRelation() {
    return this.metronomeRelation;
  }
  public void setMetronomeRelation(String relation) {
    this.metronomeRelation = relation;
  }
}  
